/**
 * 
 */
package org.abc.credit.exception;

import org.apache.commons.lang3.exception.ContextedException;
import org.apache.commons.lang3.exception.ExceptionContext;

/**
 * @author vinays
 * An exception class to deal with validation errors in the creditHistory service
 */
public class CreditHistoryValidationException extends ContextedException {
private static final long serialVersionUID = 1201397014138248283L;

    /**
     * Default constructor
     */
	public CreditHistoryValidationException() {
	}

    /**
     * A constructor with exception message.
     * @param msg exception message.
     */
    public CreditHistoryValidationException(Exception e) {
    	super(e);
    }
    
    /**
     * A constructor with exception message.
     * @param msg exception message.
     */
    public CreditHistoryValidationException(String msg) {
        super(msg);
    }
    

    /**
     * A constructor with message and root cause of the exception.
     * 
     * @param msg exception message.
     * @param e Throwable object.
     */
    public CreditHistoryValidationException(String msg, Throwable e) {
        super(msg,e);
    }
    
   
    /**
     * @param msg
     * @param e
     * @param context
     */
    public CreditHistoryValidationException(String msg, Throwable e,ExceptionContext context) {
        super(msg,e,context);
    }
    
    /**
     * @param name
     * @param value
     */
    public CreditHistoryValidationException addContextValue(String name, Object value){
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
