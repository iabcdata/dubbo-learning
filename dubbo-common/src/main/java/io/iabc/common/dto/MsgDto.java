package io.iabc.common.dto;

import com.alibaba.fastjson.annotation.JSONField;

import io.iabc.common.dto.base.BaseDto;

/**
 * @author <a href="mailto:heshucheng@gmail.com">shuchen</a>
 *         Created on 14:41 2016年06月24日.
 */
public class MsgDto extends BaseDto {

    private static final long serialVersionUID = 564584323932018551L;
    @JSONField(ordinal = 0)
    private String deptName;//部门名称
    @JSONField(ordinal = 1)
    private long deptCode;//部门编码
    @JSONField(ordinal = 2)
    private long deptParent;//上级部门
    @JSONField(ordinal = 3)
    private int deptType;//部门性质
    @JSONField(ordinal = 4)
    private String deptCharger;//部门负责人
    @JSONField(ordinal = 5)
    private String deptTel;//部门电话
    @JSONField(ordinal = 6)
    private String deptAddr;//部门地址
    @JSONField(ordinal = 7)
    private int deptValue;//部门类型
    @JSONField(ordinal = 8)
    private String deptRemark;//备注
    @JSONField(ordinal = 9)
    private long creator;//部门创建者编码
    @JSONField(ordinal = 10)
    private int createTime;//部门创建时间

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public long getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(long deptCode) {
        this.deptCode = deptCode;
    }

    public long getDeptParent() {
        return deptParent;
    }

    public void setDeptParent(long deptParent) {
        this.deptParent = deptParent;
    }

    public int getDeptType() {
        return deptType;
    }

    public void setDeptType(int deptType) {
        this.deptType = deptType;
    }

    public String getDeptCharger() {
        return deptCharger;
    }

    public void setDeptCharger(String deptCharger) {
        this.deptCharger = deptCharger;
    }

    public String getDeptTel() {
        return deptTel;
    }

    public void setDeptTel(String deptTel) {
        this.deptTel = deptTel;
    }

    public String getDeptAddr() {
        return deptAddr;
    }

    public void setDeptAddr(String deptAddr) {
        this.deptAddr = deptAddr;
    }

    public int getDeptValue() {
        return deptValue;
    }

    public void setDeptValue(int deptValue) {
        this.deptValue = deptValue;
    }

    public String getDeptRemark() {
        return deptRemark;
    }

    public void setDeptRemark(String deptRemark) {
        this.deptRemark = deptRemark;
    }

    public long getCreator() {
        return creator;
    }

    public void setCreator(long creator) {
        this.creator = creator;
    }

    public int getCreateTime() {
        return createTime;
    }

    public void setCreateTime(int createTime) {
        this.createTime = createTime;
    }
}
