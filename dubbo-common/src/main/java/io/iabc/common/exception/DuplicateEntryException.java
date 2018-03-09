package io.iabc.common.exception;

/**
 * 数据重复插入异常
 * @author <a href="mailto:dingranran@xiaomuzhi.com">dingran</a>
 *         Created on 16:30 2016年07月01日.
 */
public class DuplicateEntryException extends IabcException {
    private static final long serialVersionUID = 7445153500360096639L;

    public DuplicateEntryException() {
        super();
    }

    public DuplicateEntryException(String message, Throwable cause, boolean enableSuppression,
                                   boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public DuplicateEntryException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicateEntryException(String message) {
        super(message);
    }

    public DuplicateEntryException(Throwable cause) {
        super(cause);
    }
}
