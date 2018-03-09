package io.iabc.dubbo.demoa.service.stub;

import com.alibaba.dubbo.config.annotation.Service;

import io.iabc.dubbo.demoa.share.service.EchoService;

/**
 * TODO
 *
 * @author <a href="mailto:h@heyx.net">shuchen</a>
 * @version V1.0
 * @since 2018-01-25 00:44
 */
@Service(protocol = "dubbo", timeout = 10000)
public class EchoServiceImpl implements EchoService {
    ///////////////////////////// Class Attributes \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    //////////////////////////////// Attributes \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    /////////////////////////////// Constructors \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    ////////////////////////////// Class Methods \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    ////////////////////////////////// Methods \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    //------------------------ Implements: 

    @Override
    public String status() {
        System.out.println("a is ok");
        return "a is ok";
    }

    @Override
    public String hello(String name) {
        return "hello " + name + "@a.iabc.io";
    }

    //------------------------ Overrides:

    //---------------------------- Abstract Methods -----------------------------

    //---------------------------- Utility Methods ------------------------------

    //---------------------------- Property Methods -----------------------------
}
