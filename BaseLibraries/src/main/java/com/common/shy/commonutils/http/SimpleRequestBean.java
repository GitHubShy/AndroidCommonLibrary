package com.common.shy.commonutils.http;

import java.io.File;
import java.util.HashMap;

public class SimpleRequestBean {

    private int type;

    private String url;
    private String json;
    private long time;
    private HashMap<String, String> parameters;
    private HashMap<String, String> headers;
    private File file;

    public SimpleRequestBean(int type, String url) {
        this.type = type;
        this.url = url;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public HashMap<String, String> getParameters() {
        return parameters;
    }

    public void setParameters(HashMap<String, String> parameters) {
        this.parameters = parameters;
    }

    public HashMap<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(HashMap<String, String> headers) {
        this.headers = headers;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public static class RequestBuilder {

        private SimpleRequestBean mSimpleRequestBean;

        public RequestBuilder(@HttpRequestManager.TYPE int type, String url) {
            mSimpleRequestBean = new SimpleRequestBean(type, url);
        }

        public RequestBuilder setTime(long time) {
            mSimpleRequestBean.setTime(time);
            return this;
        }

        public RequestBuilder setJson(String json) {
            mSimpleRequestBean.setJson(json);
            return this;
        }

        public RequestBuilder setParameters(HashMap<String, String> parameters) {
            mSimpleRequestBean.setParameters(parameters);
            return this;
        }

        public RequestBuilder setHeaders(HashMap<String, String> headers) {
            mSimpleRequestBean.setHeaders(headers);
            return this;
        }

        public RequestBuilder setFile(File file) {
            mSimpleRequestBean.setFile(file);
            return this;
        }

        public SimpleRequestBean build() {
            return mSimpleRequestBean;
        }
    }

}
