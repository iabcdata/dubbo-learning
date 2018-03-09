package io.iabc.dubbo.demoa.share.dto;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

import javax.ws.rs.CookieParam;

/**
 * TODO
 *
 * @author <a href="mailto:h@iabc.io">shuchen</a>
 * @author <a href="mailto:h@heyx.net">shuchen</a>
 * @version V1.0
 * @since 2018-03-05 10:26
 */
public class CookiesDTO implements Serializable {
    ///////////////////////////// Class Attributes \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    private static final long serialVersionUID = -2899993496274365009L;

    //////////////////////////////// Attributes \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    @CookieParam("_gi___")
    private String _gi___;
    @CookieParam("_gp___")
    private String _gp___;

    /////////////////////////////// Constructors \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    ////////////////////////////// Class Methods \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    ////////////////////////////////// Methods \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    //------------------------ Implements: 

    //------------------------ Overrides:

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    //---------------------------- Abstract Methods -----------------------------

    //---------------------------- Utility Methods ------------------------------

    //---------------------------- Property Methods -----------------------------

    /**
     * 获取 {@link #_gi___}
     *
     * @return 返回 {@link #_gi___}
     */
    public String get_gi___() {
        return _gi___;
    }

    /**
     * 获取 {@link #_gp___}
     *
     * @return 返回 {@link #_gp___}
     */
    public String get_gp___() {
        return _gp___;
    }
}
