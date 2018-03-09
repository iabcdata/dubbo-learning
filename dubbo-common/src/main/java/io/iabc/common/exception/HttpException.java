package io.iabc.common.exception;

/**
 * @author <a href="mailto:heshucheng@gmail.com">shuchen</a>
 *         Created on 21:41 2016年06月27日.
 */
public class HttpException extends IabcException {
    private static final long serialVersionUID = -6786822450354014178L;

    public HttpException(Throwable e) {
        super("http_exception", e);
    }
}
