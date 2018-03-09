package io.iabc.demo.share.common.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * TODO
 *
 * @author <a href="mailto:h@iabc.io">shuchen</a>
 * @author <a href="mailto:h@heyx.net">shuchen</a>
 * @version V1.0
 * @since 2018-01-25 20:58
 */
public class Person implements Serializable {
    ///////////////////////////// Class Attributes \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
    private static final long serialVersionUID = 2864846536506066376L;

    //////////////////////////////// Attributes \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\

    private int age;

    private float weight;

    private Gender gender;

    private String name;

    private Parent parent;

    private Set<Person> brothers;

    private List<Person> friends;

    private Map<String, List<Person>> friendGroup;

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

    //---------------------------- Abstract Methods -----------------------------

    //---------------------------- Utility Methods ------------------------------

    //---------------------------- Property Methods -----------------------------

    /**
     * 获取 {@link #serialVersionUID}
     *
     * @return 返回 {@link #serialVersionUID}
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * 获取 {@link #age}
     *
     * @return 返回 {@link #age}
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置 {@link #age}
     *
     * @param age 新的{@link #age}
     */
    public Person setAge(int age) {
        this.age = age;
        return this;
    }

    /**
     * 获取 {@link #weight}
     *
     * @return 返回 {@link #weight}
     */
    public float getWeight() {
        return weight;
    }

    /**
     * 设置 {@link #weight}
     *
     * @param weight 新的{@link #weight}
     */
    public Person setWeight(float weight) {
        this.weight = weight;
        return this;
    }

    /**
     * 获取 {@link #gender}
     *
     * @return 返回 {@link #gender}
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * 设置 {@link #gender}
     *
     * @param gender 新的{@link #gender}
     */
    public Person setGender(Gender gender) {
        this.gender = gender;
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
    public Person setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * 获取 {@link #parent}
     *
     * @return 返回 {@link #parent}
     */
    public Parent getParent() {
        return parent;
    }

    /**
     * 设置 {@link #parent}
     *
     * @param parent 新的{@link #parent}
     */
    public Person setParent(Parent parent) {
        this.parent = parent;
        return this;
    }

    /**
     * 获取 {@link #brothers}
     *
     * @return 返回 {@link #brothers}
     */
    public Set<Person> getBrothers() {
        return brothers;
    }

    /**
     * 设置 {@link #brothers}
     *
     * @param brothers 新的{@link #brothers}
     */
    public Person setBrothers(Set<Person> brothers) {
        this.brothers = brothers;
        return this;
    }

    /**
     * 获取 {@link #friends}
     *
     * @return 返回 {@link #friends}
     */
    public List<Person> getFriends() {
        return friends;
    }

    /**
     * 设置 {@link #friends}
     *
     * @param friends 新的{@link #friends}
     */
    public Person setFriends(List<Person> friends) {
        this.friends = friends;
        return this;
    }

    /**
     * 获取 {@link #friendGroup}
     *
     * @return 返回 {@link #friendGroup}
     */
    public Map<String, List<Person>> getFriendGroup() {
        return friendGroup;
    }

    /**
     * 设置 {@link #friendGroup}
     *
     * @param friendGroup 新的{@link #friendGroup}
     */
    public Person setFriendGroup(Map<String, List<Person>> friendGroup) {
        this.friendGroup = friendGroup;
        return this;
    }
}
