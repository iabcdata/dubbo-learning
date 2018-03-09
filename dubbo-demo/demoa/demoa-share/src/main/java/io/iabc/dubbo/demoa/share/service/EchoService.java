package io.iabc.dubbo.demoa.share.service;

/**
 * TODO
 *
 * @author <a href="mailto:h@heyx.net">shuchen</a>
 * @version V1.0
 * @since 2018-01-25 00:43
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
