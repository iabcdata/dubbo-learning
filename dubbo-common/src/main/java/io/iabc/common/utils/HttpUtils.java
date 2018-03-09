package io.iabc.common.utils;

import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.iabc.common.exception.HttpException;

/**
 * @author <a href="mailto:heshucheng@gmail.com">shuchen</a>
 * Created on 21:37 2016年06月27日.
 */
public class HttpUtils {
    private static Logger logger = LoggerFactory.getLogger(HttpUtils.class);

    private final static int SOCK_TIMEOUT = 5000;
    private final static int CONN_TIMEOUT = 5000;
    private final static RequestConfig config = RequestConfig.custom().setSocketTimeout(SOCK_TIMEOUT)
        .setConnectTimeout(CONN_TIMEOUT).build();

    /**
     * post a 'form like' data to http server with given url
     *
     * @param url       http url
     * @param paramsMap key:value form data
     * @return Response{code,body}
     * @throws HttpException wrap any exception to HttpException :IOException
     *                       SocketException
     */
    public static Response post(String url, Map<String, String> paramsMap) throws HttpException {

        CloseableHttpClient client = HttpClients.createDefault();

        HttpPost method = new HttpPost(url);
        //        method.setHeader("Content-Type","application/json");
        method.setConfig(config);

        List<NameValuePair> nvps = new ArrayList<NameValuePair>(paramsMap.size());
        Set<String> keySet = paramsMap.keySet();
        for (String key : keySet) {
            nvps.add(new BasicNameValuePair(key, paramsMap.get(key)));
        }

        try {
            method.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
            HttpResponse response = client.execute(method);

            Response result = wrapResponse(response);

            return result;
        } catch (Exception e) {
            logger.error("#http client post error with reason : {}", e.getMessage());
            throw new HttpException(e);
        } finally {
            method.releaseConnection();
            try {
                client.close();
            } catch (IOException e) {
                logger.error("#http client close post connection error with reason : {}#", e.getMessage());
            }
        }
    }

    /**
     * Post json entity to http server with given url
     *
     * @param url  http url
     * @param json json format data
     * @return Response{code,body}
     * @throws HttpException wrap any exception to HttpException eg:IOException
     *                       SocketException
     */
    public static Response post(String url, String json) throws HttpException {
        HttpPost method = new HttpPost(url);
        CloseableHttpClient client = HttpClients.createDefault();
        try {
            StringEntity entity = new StringEntity(json, "utf-8");
            entity.setContentType("application/json");
            method.setEntity(entity);

            HttpResponse response = client.execute(method);

            Response result = wrapResponse(response);

            return result;
        } catch (Exception e) {
            logger.error("http post request error with reason : {}", e.getMessage());
            throw new HttpException(e);
        } finally {
            method.releaseConnection();
            try {
                client.close();
            } catch (IOException e) {
                logger.error("close http  connection  with reason : {}", e.getMessage());
            }
        }
    }

    /**
     * do http get without parameters
     *
     * @param url http url
     * @return Response{code,body}
     * @throws HttpException wrap any exception to HttpException eg:IOException
     *                       SocketException
     */
    public static Response get(String url) throws HttpException {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet method = new HttpGet(url);
        try {
            HttpResponse response = client.execute(method);
            return wrapResponse(response);
        } catch (Exception e) {
            logger.error("http get request error with reason : {}", e.getMessage());
            throw new HttpException(e);
        } finally {
            method.releaseConnection();
            try {
                client.close();
            } catch (IOException e) {
                logger.error("close http  connection  with reason : {}", e.getMessage());
            }
        }
    }

    /**
     * append current timestamp to url with give name
     *
     * @param url           http url
     * @param timestampName parameter name
     * @return string
     */
    public static String appendTimestamp(String url, String timestampName) {
        if (url.endsWith("/")) {
            return url;
        }
        if (url.contains("?")) {
            url += "&" + timestampName + "=" + System.currentTimeMillis();
        } else {
            url += "?" + timestampName + "=" + System.currentTimeMillis();
        }
        return url;
    }

    private static Response wrapResponse(HttpResponse response) throws IOException {
        int code = response.getStatusLine().getStatusCode();
        String body = EntityUtils.toString(response.getEntity());
        return new Response(code, body);
    }

    public static class Response {
        public Response(int code, String content) {
            this.code = code;
            this.content = content;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        int code;
        String content;

        @Override
        public String toString() {
            return JSON.toJSONString(this);
        }
    }
}
