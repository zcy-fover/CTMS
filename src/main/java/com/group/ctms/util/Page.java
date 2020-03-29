package com.group.ctms.util;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Created by zcy-fover on 2016/11/18.
 * 对分页的基本数据进行一个简单的封装
 */
@SuppressWarnings("unused")
public class Page<T> {

    private int pageNo = 1;//页码，默认是第一页
    private int pageSize = 2;//每页显示的记录数，默认是2
    private int totalRecord;//总记录数
    private int totalPage;//总页数
    private List<T> results;//对应的当前页记录
    private String queryString;// 保存查询信息
    private Map<Object, Object> params = new HashMap<>();//其他的参数我们把它分装成一个Map对象

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
        //在设置总页数的时候计算出对应的总页数，在下面的三目运算中加法拥有更高的优先级，所以最后可以不加括号。
        int totalPage = totalRecord%pageSize==0 ? totalRecord/pageSize : totalRecord/pageSize + 1;
        this.setTotalPage(totalPage);
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    public String getQueryString() {
        return queryString;
    }

    public void setQueryString(String queryString) {
        this.queryString = queryString;
    }

    public Map<Object, Object> getParams() {
        return params;
    }

    public void setParams(Map<Object, Object> params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", totalRecord=" + totalRecord +
                ", totalPage=" + totalPage +
                ", results=" + results +
                ", queryString='" + queryString + '\'' +
                ", params=" + params +
                '}';
    }
}