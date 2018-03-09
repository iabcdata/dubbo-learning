package io.iabc.dubbo.democ.share.service;

/**
 * @author <a href="mailto:heshucheng@gmail.com">shuchen</a>
 *         Created on 14:01 2016年08月03日.
 */
public interface EchoService {

    /**
     * 无参数状态校验接口(示例:curl -X GET -H "Content-Type: application/json" http://{IP}:{PORT}/demob/echo/status)
     *
     * @return
     */
    String status();

    /**
     * 无参数状态校验接口(示例:curl -X GET -H "Content-Type: application/json" http://{IP}:{PORT}/demob/echo/hello?name=xxx)
     *
     * @return
     */
    String hello(String name);

}