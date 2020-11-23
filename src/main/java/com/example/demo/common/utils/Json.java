package com.example.demo.common.utils;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import com.google.common.collect.Lists;
import org.springframework.util.StringUtils;

import java.text.DateFormat;
import java.util.*;

public class Json {
    private static final ObjectMapper mapper;
    private static final ObjectMapper strMapper;

    static {
        mapper = new ObjectMapper();
        //属性可访问
        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY)
                //单对象值灵活转换为集合值， 不抛出异常
                .configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true)
                //反序列化时，如果多了其他属性，不抛异常
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                //如果是空对象，不抛异常
                .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
                //取消时间的转换格式， 默认是时间戳，同事需设置时间格式
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                .setDateFormat(DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, Locale.CHINA));

        strMapper = mapper.copy();
        //序列化 带上类型元素
        strMapper.activateDefaultTyping(LaissezFaireSubTypeValidator.instance,
                ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);
    }

    public static <T> String toJson(T obj) {
        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static <T> String toString(T obj){
        try {
            return strMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static <T> Optional<T> getBean(String json, Class<T> clazz){
        if(StringUtils.hasText(json) && clazz != null) {
            try {
                return Optional.of(mapper.readValue(json, clazz));
            } catch (JsonProcessingException e) {
                throw new IllegalArgumentException(e);
            }
        }

        return Optional.empty();
    }

    public static <T> List<T> toList(String json, Class<T> clazz) {
        if(StringUtils.hasText(json) && clazz != null) {
            JavaType type = mapper.getTypeFactory().constructParametricType(ArrayList.class, clazz);
            try {
                return (List<T>)mapper.readValue(json, type);
            } catch (JsonProcessingException e) {
                throw new IllegalArgumentException(e);
            }
        }

        return Lists.newArrayList();
    }
}
