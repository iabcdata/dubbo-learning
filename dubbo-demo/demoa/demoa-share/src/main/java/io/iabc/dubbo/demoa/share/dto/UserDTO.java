package io.iabc.dubbo.demoa.share.dto;

import java.io.Serializable;

/**
 * TODO
 *
 * @author <a href="mailto:h@heyx.net">shuchen</a>
 * @version V1.0
 * @since 2018-01-18 09:33
 */
public class UserDTO implements Serializable {
    ///////////////////////////// Class Attributes \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    //////////////////////////////// Attributes \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    private Long userId;
    private String name;
    private String email;
    private String mobile;

    /////////////////////////////// Constructors \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    ////////////////////////////// Class Methods \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    ////////////////////////////////// Methods \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    //------------------------ Implements: 

    //------------------------ Overrides:

    //---------------------------- Abstract Methods -----------------------------

    //---------------------------- Utility Methods ------------------------------

    //---------------------------- Property Methods -----------------------------

    /**
     * 获取 {@link #userId}
     *
     * @return 返回 {@link #userId}
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置 {@link #userId}
     *
     * @param userId 新的{@link #userId}
     */
    public UserDTO setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    /**
     * 获取 {@link #name}
     *
     * @return 返回 {@link #name}
     */
    public String getName() {
        return name;
    }

    /**
     * 设置 {@link #name}
     *
     * @param name 新的{@link #name}
     */
    public UserDTO setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * 获取 {@link #email}
     *
     * @return 返回 {@link #email}
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置 {@link #email}
     *
     * @param email 新的{@link #email}
     */
    public UserDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    /**
     * 获取 {@link #mobile}
     *
     * @return 返回 {@link #mobile}
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置 {@link #mobile}
     *
     * @param mobile 新的{@link #mobile}
     */
    public UserDTO setMobile(String mobile) {
        this.mobile = mobile;
        return this;
    }
}
