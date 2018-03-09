package io.iabc.common.exception;

/**
 * @author <a href="mailto:heshucheng@gmail.com">shuchen</a>
 *         Created on 21:39 2016年06月27日.
 */
public class IabcException extends RuntimeException {

    private static final long serialVersionUID = -2922000797026622677L;
    private static final String DEFAULT_MESSAGE = "heyx_exception";

    public IabcException() {
        super(DEFAULT_MESSAGE);
    }

    public IabcException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public IabcException(String message, Throwable cause) {
        super(message, cause);
    }

    public IabcException(String message) {
        super(message);
    }

    public IabcException(Throwable cause) {
        super(DEFAULT_MESSAGE, cause);
    }
}
