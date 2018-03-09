package io.iabc.common.dto.base;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.io.Serializable;

/**
 * 传输对象基本类
 *
 * @author <a href="mailto:dingranran@xiaomuzhi.com">dingran</a> Created on
 *         2016年6月14日.
 */
public class BaseDto implements Serializable {

    private static SerializerFeature[] features = {SerializerFeature.WriteNullNumberAsZero, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.NotWriteDefaultValue, SerializerFeature.WriteNullListAsEmpty, SerializerFeature.DisableCircularReferenceDetect};

    @Override
    public String toString() {
        return JSON.toJSONString(this, features);
    }

}
