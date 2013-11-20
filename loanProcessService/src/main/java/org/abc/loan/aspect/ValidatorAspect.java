package org.abc.loan.aspect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.jws.WebParam;

import org.abc.loan.exception.LoanProcessingValidationException;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.hibernate.validator.method.MethodConstraintViolation;
import org.hibernate.validator.method.MethodConstraintViolationException;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.RequestParam;

@Aspect
public class ValidatorAspect {
	private static final Logger LOG = Logger.getLogger(ValidatorAspect.class);

	private static final String CONSTANT_NAME = "name";

	private static final String CONSTANT_VALUE = "value";;

	/**
	 * 
	 * Stores method arguments in Thread Local. Arguments that are @Sensitive
	 * 
	 * will not be stored.
	 * 
	 * 
	 * 
	 * @param joinPoint
	 * 
	 * @param e
	 */

	@AfterThrowing(pointcut = "execution(public * *(..)) && @within(org.springframework.validation.annotation.Validated)", throwing = "e")
	public void addErrorstoException(JoinPoint joinPoint, Throwable e)
			throws Throwable {

		Throwable jsfExceptions;

		if (e instanceof MethodConstraintViolationException) {

			// Get Exceptions from method's signature

			MethodSignature signature = (MethodSignature) joinPoint

			.getSignature();

			Class<Throwable>[] exceptionsThrown = signature.getExceptionTypes();

			Map<String, String> argNames = retrieveArgs(joinPoint);

			/*
			 * 
			 * Determine which exception to throw.
			 * 
			 * Take the first that is advertised on the method signature.
			 */

			if (exceptionsThrown.length > 0) {

				try {

					Class<?> throwable = exceptionsThrown[0];

					if (throwable.isInstance(RuntimeException.class))

					{

						throw e;

					} else

					{

						jsfExceptions = exceptionsThrown[0].newInstance();

					}

					// throwable listed does not have a default constructor

				} catch (InstantiationException ie) {

					throw e;

				}

			} else {

				jsfExceptions = new LoanProcessingValidationException();

			}

			// retrieve exception from the method's signature

			MethodConstraintViolationException exception = (MethodConstraintViolationException) e;

			// retrieve set of violations from the exception

			Set<MethodConstraintViolation<?>> parametersViolations = exception

			.getConstraintViolations();

			// If any violations exists, list them in exception

			if (!parametersViolations.isEmpty()) {

				String fieldName;

				for (MethodConstraintViolation violation : parametersViolations) {

					fieldName = violation.getParameterName();

					// if we can match arg0,1.. to parameter names, than do so

					if (argNames.containsKey(violation.getParameterName()))

					{

						fieldName = argNames.get(violation.getParameterName());

					}

					if (jsfExceptions instanceof LoanProcessingValidationException) {

						((LoanProcessingValidationException) jsfExceptions)

						.addContextValue(fieldName,

						violation.getMessage());

					}

				}

				throw jsfExceptions;

			}

		}

	}

	/**
	 * 
	 * Retrieve arguments for the JoinPoint - if parameters are named, save the
	 * names
	 * 
	 * in a map. arg0 - firstName, arg1=lastName, etc ....
	 * 
	 * 
	 * 
	 * @param joinPoint
	 * 
	 * @return Object[]
	 */

	private Map<String, String> retrieveArgs(JoinPoint joinPoint) {

		if (joinPoint.getArgs().length == 0) {

			return null;

		}

		Method method = ((MethodSignature) joinPoint.getSignature())
				.getMethod();

		Annotation[][] paramAnnotations = method.getParameterAnnotations();

		Map<String, String> argNames = new HashMap<String, String>();

		for (int i = 0; i < paramAnnotations.length; i++) {

			String paramName = findParamName(paramAnnotations[i]);

			if (paramName != null) {

				argNames.put("arg" + i, paramName);

			}

		}

		return argNames;

	}

	/**
	 * 
	 * @param annotations
	 *            []
	 * 
	 * @return return name or value if @WebParam and/or @RequestParam is found
	 */

	private String findParamName(Annotation[] annotations) {

		if (annotations != null && annotations.length > 0) {

			for (Annotation annotation : annotations) {

				// if annotation is @WebParam, find name attribute

				if (annotation.annotationType()
						.isAssignableFrom(WebParam.class)) {

					Map<String, Object> values = AnnotationUtils
							.getAnnotationAttributes(annotation, false);

					if (values.containsKey(CONSTANT_NAME))

					{

						return values.get(CONSTANT_NAME).toString();

					}

				}

				// if annotation is @RequestParam, find value attribute

				if (annotation.annotationType().isAssignableFrom(
						RequestParam.class)) {

					Map<String, Object> values = AnnotationUtils
							.getAnnotationAttributes(annotation, false);

					if (values.containsKey(CONSTANT_VALUE))

					{

						return values.get(CONSTANT_VALUE).toString();

					}

				}

			}

		}

		return null;

	}

}
