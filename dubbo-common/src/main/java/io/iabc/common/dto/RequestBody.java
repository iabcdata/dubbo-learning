package io.iabc.common.dto;

import javax.validation.constraints.NotNull;

import io.iabc.common.dto.base.BaseDto;

/**
 * @author <a href="mailto:heshucheng@gmail.com">shuchen</a>
 *         Created on 14:41 2016年06月24日.
 */
public class RequestBody<Request> extends BaseDto {

    private static final long serialVersionUID = -8632229895823592825L;
    @NotNull
    private Long openid;
    @NotNull
    private Request request;

    public RequestBody() {
    }

    public RequestBody(Long openid) {
        this.openid = openid;
    }

    public RequestBody(Long openid, Request result) {
        this.openid = openid;
        this.request = result;
    }

    public Long getOpenid() {
        return openid;
    }

    public void setOpenid(Long openid) {
        this.openid = openid;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

}
