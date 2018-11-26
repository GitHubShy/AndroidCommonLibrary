package com.common.shy.commonutils.http;

import android.support.annotation.IntDef;

import com.common.shy.commonutils.utils.Logger;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * POST请求的四种方式
 * 1:application/x-www-form-urlencoded   提交的数据按照 key1=val1&key2=val2 的方式进行编码
 * 2:multipart/form-data    这种方式一般用来上传文件  也可以上传键值对
 * 3:application/json  上传复杂化json数据
 * 4:text/xml  上传xml
 */
public class HttpRequestManager {

    private static String TAG = "HttpRequestManager";

    public static final int FORM = 1;
    public static final int JSON = 2;
    public static final int FILE = 3;

    @IntDef({FORM, JSON, FILE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface TYPE {
    }


    public static void request(SimpleRequestBean bean) {
        switch (bean.getType()) {
            case FORM:
                postFormRequest(bean.getUrl(), bean.getParameters(),bean.getHeaders());
                break;
            case JSON:
                postJsonRequest(bean.getUrl(), bean.getJson());
                break;
            case FILE:
                postFileRequest(bean.getUrl(), bean.getFile());
                break;
        }
    }

    /**
     * post请求上传json
     *
     * @param url
     * @param json
     */
    public static void postJsonRequest(String url, String json) {
        RequestBody requestBody = FormBody.create(MediaType.parse("application/json; charset=utf-8")
                , json);
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        sendRequest(request);
    }

    /**
     * post请求上传json
     *
     * @param url
     * @param map
     */
    public static void postFormRequest(String url, HashMap<String, String> map, HashMap<String, String> header) {
        FormBody.Builder builder = new FormBody.Builder();
        if (map != null && map.size() > 0) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                builder.add(entry.getKey(), entry.getValue());
            }
        }
        FormBody formBody = builder.build();
        Request.Builder builder1 = new Request.Builder();
        builder1.url(url);
        builder1.post(formBody);
        if (header != null && header.size() > 0) {
            for (Map.Entry<String, String> entry : header.entrySet()) {
                Logger.e("111111111111111","="+entry.getKey());
                builder1.addHeader(entry.getKey(), entry.getValue());
            }
        }
        Request request = builder1.build();
        sendRequest(request);
    }

    /**
     * post请求上传文件
     *
     * @param url
     * @param file
     */
    public static void postFileRequest(String url, File file) {
        MediaType mediaType = MediaType.parse("text/x-markdown; charset=utf-8");
        Request request = new Request.Builder()
                .url(url)
                .post(RequestBody.create(mediaType, file))
                .build();
        sendRequest(request);
    }

    private static void sendRequest(Request request) {
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Logger.e(TAG, "onFailure: " + e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
//                Logger.e(TAG, response.protocol() + " " + response.code() + " " + response.message());
//                Headers headers = response.headers();
//                for (int i = 0; i < headers.size(); i++) {
//                    Logger.e(TAG, headers.name(i) + ":" + headers.value(i));
//                }
                Logger.e(TAG, "onResponse: " + response.body().string());
            }
        });
    }

}
