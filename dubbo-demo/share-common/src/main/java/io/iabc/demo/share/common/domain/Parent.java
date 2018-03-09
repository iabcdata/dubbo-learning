package io.iabc.demo.share.common.domain;

import java.io.Serializable;

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
 * @since 2018-01-26 09:55
 */
public class Parent implements Serializable {

    ///////////////////////////// Class Attributes \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    private static final long serialVersionUID = 6383003013022747997L;

    //////////////////////////////// Attributes \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    private Person father;

    private Person mother;

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
     * 获取 {@link #father}
     *
     * @return 返回 {@link #father}
     */
    public Person getFather() {
        return father;
    }

    /**
     * 设置 {@link #father}
     *
     * @param father 新的{@link #father}
     */
    public Parent setFather(Person father) {
        this.father = father;
        return this;
    }

    /**
     * 获取 {@link #mother}
     *
     * @return 返回 {@link #mother}
     */
    public Person getMother() {
        return mother;
    }

    /**
     * 设置 {@link #mother}
     *
     * @param mother 新的{@link #mother}
     */
    public Parent setMother(Person mother) {
        this.mother = mother;
        return this;
    }
}
