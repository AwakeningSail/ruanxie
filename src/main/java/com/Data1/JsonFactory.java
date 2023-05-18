package com.Data1;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.StringUtils;

import java.util.List;

public class JsonFactory<T> {
    String jsonString;
    public String toJsonString(Object object){
        System.out.println(object);
        String x= JSON.toJSONString(object);
        x= StringUtils.replace(x,"\\","");
        System.out.println(x);
        return x;
    }

    public String convertListToJsonString(List<?> list) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(list));
        return mapper.writeValueAsString(list);
    }

    public JsonFactory(){}
    JsonFactory(T t){
        jsonString=toJsonString(t);
    }

    @Override
    public String toString() {
        return jsonString;
    }
}
