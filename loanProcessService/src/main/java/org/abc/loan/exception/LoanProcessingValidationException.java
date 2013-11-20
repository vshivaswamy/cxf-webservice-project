/**
 * 
 */
package org.abc.loan.exception;

import org.apache.commons.lang3.exception.ContextedException;
import org.apache.commons.lang3.exception.ExceptionContext;

/**
 * @author root
 *
 */
public class LoanProcessingValidationException extends ContextedException {
private static final long serialVersionUID = 1201397014138248283L;

    /**
     * Default constructor
     */
	public LoanProcessingValidationException() {
	}

    /**
     * A constructor with exception message.
     * @param msg exception message.
     */
    public LoanProcessingValidationException(Exception e) {
    	super(e);
    }
    
    /**
     * A constructor with exception message.
     * @param msg exception message.
     */
    public LoanProcessingValidationException(String msg) {
        super(msg);
    }
    

    /**
     * A constructor with message and root cause of the exception.
     * 
     * @param msg exception message.
     * @param e Throwable object.
     */
    public LoanProcessingValidationException(String msg, Throwable e) {
        super(msg,e);
    }
    
   
    /**
     * @param msg
     * @param e
     * @param context
     */
    public LoanProcessingValidationException(String msg, Throwable e,ExceptionContext context) {
        super(msg,e,context);
    }
    
    /**
     * @param name
     * @param value
     */
    public LoanProcessingValidationException addContextValue(String name, Object value){
    	super.addContextValue(name, value);
    	return this;
    }

    /**
     * Sets the cause of the exception. 
     * @param e Throwable object.
     */
    public void setCause(Throwable e) {
        this.initCause(e);
    }

}
