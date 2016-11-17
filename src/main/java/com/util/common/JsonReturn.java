package com.util.common;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;
import java.util.Map;

/**
 * Created by sniper on 2016/3/26.
 */
public class JsonReturn {
    private Integer code;
    private String msg;
    private List objList = null;
    private Map<String, Object> map = null;

    private JSONObject json = new JSONObject();

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List getObjList() {
        return objList;
    }

    public void setObjList(List objList) {
        this.objList = objList;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public JsonReturn() {
        this.code = -1;
        this.msg = "访问出错！";
    }

    public JsonReturn(Integer code) {
        this.code = code;
    }

    public JsonReturn(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public JsonReturn(Integer code, String msg, List objList) {
        this.code = code;
        this.msg = msg;
        this.objList = objList;
    }

    public JsonReturn(Integer code, String msg, Map map) {
        this.code = code;
        this.msg = msg;
        this.map = map;
    }

    public JsonReturn(Integer code, String msg, List objList, Map map) {
        this.code = code;
        this.msg = msg;
        this.objList = objList;
        this.map = map;
    }

    public String toJson() {
        json.put("code",code);

        if(msg != null) {
            json.put("msg", msg);
        }
        if(objList != null) {
            JSONArray array = new JSONArray();
            array.put(objList);
            json.put("objList",array);
        }
        if(map != null) {

        }

        return json.toString();
    }
}
