package io.iabc.dubbo.democ.service.stub;

import com.alibaba.dubbo.config.annotation.Service;

import io.iabc.dubbo.democ.share.service.EchoService;

/**
 * @author <a href="mailto:heshucheng@gmail.com">shuchen</a>
 *         Created on 14:03 2016年08月03日.
 */
@Service(protocol = "dubbo", timeout = 10000)
public class EchoServiceImpl implements EchoService {

    /**
     * 注解可以写在接口中，也可以写在实现中。
     * 注解在接口中:统一管理，但是会增加一些share包依赖
     * 注解在实现中:share依赖更加纯粹，维护成本增加
     */

    @Override
    public String status() {
        System.out.println("c is ok");
        return "c is ok";
    }

    @Override
    public String hello(String name) {
        return "hello " + name + "@c.iabc.io";
    }
}
