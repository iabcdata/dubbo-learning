package io.iabc.common.exception;

/**
 * @author <a href="mailto:heshucheng@gmail.com">shuchen</a>
 *         Created on 21:50 2016年06月27日.
 */
public class InvalidArgumentsException extends IabcException {

    private static final long serialVersionUID = 4978129989232239234L;

    public InvalidArgumentsException() {
        super();
    }

    public InvalidArgumentsException(String message, Throwable cause, boolean enableSuppression,
                                     boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public InvalidArgumentsException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidArgumentsException(String message) {
        super(message);
    }

    public InvalidArgumentsException(Throwable cause) {
        super(cause);
    }
}
