package io.iabc.common.dto;

import io.iabc.common.constant.ResponseStatus;
import io.iabc.common.dto.base.BaseDto;

/**
 * @author <a href="mailto:heshucheng@gmail.com">shuchen</a>
 * Created on 14:41 2016年06月24日.
 */
public class ResponseBody<Result> extends BaseDto {

    private static final long serialVersionUID = 6946729311823769332L;
    public static String SUCCESS = ResponseStatus.SUCCESS;
    public static String FAILURE = ResponseStatus.FAILURE;
    private String status;
    private Result result;

    public ResponseBody() {
    }

    public ResponseBody(String status) {
        this.status = status;
    }

    public ResponseBody(String status, Result result) {
        this.status = status;
        this.result = result;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String code) {
        this.status = status;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
