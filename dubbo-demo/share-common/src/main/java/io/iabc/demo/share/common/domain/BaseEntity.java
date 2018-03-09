package io.iabc.demo.share.common.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * TODO
 *
 * @author <a href="mailto:h@iabc.io">shuchen</a>
 * @author <a href="mailto:h@heyx.net">shuchen</a>
 * @version V1.0
 * @since 2018-01-25 20:49
 */
public class BaseEntity {
    ///////////////////////////// Class Attributes \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    //////////////////////////////// Attributes \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    protected Integer id;
    protected Integer created;
    protected Integer updated;
    protected int isDeleted;

    /////////////////////////////// Constructors \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    ////////////////////////////// Class Methods \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    ////////////////////////////////// Methods \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    //------------------------ Implements: 

    //------------------------ Overrides:

    @Override
    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj, false);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this, false);
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
    //---------------------------- Abstract Methods -----------------------------

    //---------------------------- Utility Methods ------------------------------

    //---------------------------- Property Methods -----------------------------

    /**
     * 获取 {@link #id}
     *
     * @return 返回 {@link #id}
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置 {@link #id}
     *
     * @param id 新的{@link #id}
     */
    public BaseEntity setId(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * 获取 {@link #created}
     *
     * @return 返回 {@link #created}
     */
    public Integer getCreated() {
        return created;
    }

    /**
     * 设置 {@link #created}
     *
     * @param created 新的{@link #created}
     */
    public BaseEntity setCreated(Integer created) {
        this.created = created;
        return this;
    }

    /**
     * 获取 {@link #updated}
     *
     * @return 返回 {@link #updated}
     */
    public Integer getUpdated() {
        return updated;
    }

    /**
     * 设置 {@link #updated}
     *
     * @param updated 新的{@link #updated}
     */
    public BaseEntity setUpdated(Integer updated) {
        this.updated = updated;
        return this;
    }

    /**
     * 获取 {@link #isDeleted}
     *
     * @return 返回 {@link #isDeleted}
     */
    public int getIsDeleted() {
        return isDeleted;
    }

    /**
     * 设置 {@link #isDeleted}
     *
     * @param isDeleted 新的{@link #isDeleted}
     */
    public BaseEntity setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
        return this;
    }
}
