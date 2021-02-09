package com.hexmeet.base;

import com.alibaba.fastjson.JSONObject;
import com.hexmeet.appiumendpoint.AndroidAppiumEndpoint;
import org.apache.commons.io.FileUtils;

import java.io.File;

public class JsonConfigSingleton {

    private static JsonConfigSingleton instance;

    private JsonConfigSingleton(){

    }

    public JsonConfigSingleton getInstance(){
        if( instance == null)
            instance = new JsonConfigSingleton();

        return instance;
    }

    public static JSONObject getJsonObjectFromJsonConfig(){
        JSONObject jsonObject = new JSONObject();
        try {
            File file = new File(AndroidAppiumEndpoint.class.getClassLoader().getResource("config.json").getPath());
            String content = FileUtils.readFileToString(file, "UTF-8");
             jsonObject = JSONObject.parseObject(content);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonObject;
    }
}
