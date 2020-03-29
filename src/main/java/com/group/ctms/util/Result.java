package com.group.ctms.util;

import java.util.List;

/**
 * Created by zcy-fover on 2016/11/2.
 * 包装处理结果
 */
public class Result {
    private String message;
    private boolean success;
    private List dataList;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List getDataList() {
        return dataList;
    }

    public void setDataList(List dataList) {
        this.dataList = dataList;
    }

    @Override
    public String toString() {
        return "Result{" +
                "message='" + message + '\'' +
                ", success=" + success +
                ", dataList=" + dataList +
                '}';
    }
}
