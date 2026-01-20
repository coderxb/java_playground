/**
 * HttpUtils.java   2016年1月21日 下午7:15:06 by LIXUEBING 
 *
 * Copyright (c) 2010 - 2016 xuebing.Li. All rights reserved.
 * 
 */
package indi.coderxb.easyblog.utils;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpUtils {

    private static final Logger log = LoggerFactory.getLogger(HttpUtils.class);
    /**
     * 默认编码方式
     */
    public static final String DEFAULT_CHARSET = "UTF-8";
    
    public static final String APPLICATION_JSON = "application/json";
    /**
     * 最大连接数
     */
    public final static int MAX_TOTAL_CONNECTIONS = 200;
    /**
     * 获取连接的最大等待时间
     */
    public final static int WAIT_TIMEOUT = 60000;
    /**
     * 每个路由最大连接数
     */
    public final static int MAX_ROUTE_CONNECTIONS = 300;
    /**
     * 连接超时时间
     */
    public final static int CONNECT_TIMEOUT = 10000;
    /**
     * 读取超时时间
     */
    public final static int READ_TIMEOUT = 10000;

    private static PoolingHttpClientConnectionManager connMgr = null;
    private static RequestConfig requestConfig = null;

    static {
        ConnectionSocketFactory plainsf = PlainConnectionSocketFactory.getSocketFactory();
        LayeredConnectionSocketFactory sslsf = SSLConnectionSocketFactory.getSocketFactory();
        Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory> create()
            .register("http", plainsf).register("https", sslsf).build();
        connMgr = new PoolingHttpClientConnectionManager(registry);
        connMgr.setMaxTotal(MAX_TOTAL_CONNECTIONS);
        connMgr.setDefaultMaxPerRoute(connMgr.getMaxTotal());
        connMgr.setDefaultMaxPerRoute(MAX_ROUTE_CONNECTIONS);
        RequestConfig.Builder configBuilder = RequestConfig.custom();
        // 设置连接超时  
        configBuilder.setConnectTimeout(CONNECT_TIMEOUT);
        // 设置读取超时  
        configBuilder.setSocketTimeout(CONNECT_TIMEOUT);
        // 设置从连接池获取连接实例的超时  
        configBuilder.setConnectionRequestTimeout(READ_TIMEOUT);
        requestConfig = configBuilder.build();
    }

    private static CloseableHttpClient getHTTPClient() {
        return HttpClients.custom().setConnectionManager(connMgr).setDefaultRequestConfig(requestConfig)
            .setConnectionManagerShared(true).build();
    }

    private static void setHeader(HttpRequestBase request, Map<String, String> header) {
        if (header == null)
            return;
        Iterator<Map.Entry<String, String>> it = header.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> entry = it.next();
            request.setHeader(entry.getKey(), entry.getValue());
        }
    }

    public static HttpResult doGet(String url) {
        return doGet(url, null);
    }

    public static HttpResult doGet(String url, Map<String, String> header) {
        HttpResult result = new HttpResult();
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        HttpGet request = null;
        try {
            request = new HttpGet(url);
            httpClient = getHTTPClient();
            long start = Calendar.getInstance().getTimeInMillis();
            setHeader(request, header);
            response = httpClient.execute(request);
            long end = Calendar.getInstance().getTimeInMillis();
            long useTime = end - start;
            result = getHTTPResult(response);
            log.info("Request:GET to:{}, timecost={}ms, header={}, response={}", url, useTime, header, result);

            if (result == null) {
                throw new NullPointerException("This request did not return the result");
            }
            return result;
        } catch (ClientProtocolException e) {
            request.abort();
            log.error("Request protocol is wang.", e);
        } catch (IOException e) {
            request.abort();
            log.error("Request[{}] network is error", url, e);
        } finally {
            close(httpClient, response);
        }
        return result;
    }

    public static HttpResult doPost(String url, Map<String, String> header, Map<String, String> formParam) {
        return doPost(url, header, formParam, null);
    }
    
    public static HttpResult doPost(String url, Map<String, String> header, String body) {
        return doPost(url, header, null, body);
    }

    public static HttpResult doPost(String url, Map<String, String> header, Map<String, String> formParam, String body) {
        HttpResult result = new HttpResult();
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        HttpPost request = null;

        try {
            request = new HttpPost(url);
            httpClient = getHTTPClient();
            long start = Calendar.getInstance().getTimeInMillis();
            setHeader(request, header);
            if (formParam != null) {
                List<NameValuePair> nvps = new ArrayList<NameValuePair>();
                Set<String> keySet = formParam.keySet();
                for (String key : keySet) {
                    nvps.add(new BasicNameValuePair(key, formParam.get(key)));
                }
                request.setEntity(new UrlEncodedFormEntity(nvps, DEFAULT_CHARSET));
            }
            StringEntity entity = null;
            if (body != null) {
                entity = new StringEntity(body, DEFAULT_CHARSET);
                entity.setContentEncoding(DEFAULT_CHARSET);
                entity.setContentType(APPLICATION_JSON);
                request.setEntity(entity);
            }
            response = httpClient.execute(request);
            long end = Calendar.getInstance().getTimeInMillis();
            long useTime = end - start;
            result = getHTTPResult(response);
            log.info("Request:POST to:{}, timecost={}ms, header={}, formParam={}, body={} response={}", url, useTime,
                header, formParam, body, result);

            if (result == null) {
                throw new NullPointerException("This request did not return the result");
            }
            return result;
        } catch (IOException e) {
            request.abort();
            log.error("Request[{}] network is error", url, e);
        } finally {
            close(httpClient, response);
        }
        return result;
    }
    
    public static HttpResult doPut(String url, Map<String, String> header, Map<String, String> formParam) {
        return doPut(url, header, formParam, null);
    }

    public static HttpResult doPut(String url, Map<String, String> header, String body) {
        return doPut(url, header, null, body);
    }

    public static HttpResult doPut(String url, Map<String, String> header, Map<String, String> formParam, String body) {
        HttpResult result = new HttpResult();
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        HttpPut request = null;

        try {
            request = new HttpPut(url);
            httpClient = getHTTPClient();
            long start = Calendar.getInstance().getTimeInMillis();
            setHeader(request, header);
            if (formParam != null) {
                List<NameValuePair> nvps = new ArrayList<NameValuePair>();
                Set<String> keySet = formParam.keySet();
                for (String key : keySet) {
                    nvps.add(new BasicNameValuePair(key, formParam.get(key)));
                }
                request.setEntity(new UrlEncodedFormEntity(nvps, DEFAULT_CHARSET));
            }
            StringEntity entity = null;
            if (body != null) {
                entity = new StringEntity(body, DEFAULT_CHARSET);
                entity.setContentEncoding(DEFAULT_CHARSET);
                entity.setContentType(APPLICATION_JSON);
                request.setEntity(entity);
            }
            response = httpClient.execute(request);
            long end = Calendar.getInstance().getTimeInMillis();
            long useTime = end - start;
            result = getHTTPResult(response);
            log.info("Request:PUT to:{}, timecost={}ms, header={}, formParam={}, body={} response={}", url, useTime,
                header, formParam, body, result);

            if (result == null) {
                throw new NullPointerException("This request did not return the result");
            }
            return result;
        } catch (IOException e) {
            request.abort();
            log.error("Request[{}] network is error", url, e);
        } finally {
            close(httpClient, response);
        }
        return result;
    }

    public static HttpResult doDelete(String url) {
        return doDelete(url, null);
    }

    public static HttpResult doDelete(String url, Map<String, String> header) {
        HttpResult result = new HttpResult();
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        HttpDelete request = null;
        try {
            request = new HttpDelete(url);
            httpClient = getHTTPClient();
            long start = Calendar.getInstance().getTimeInMillis();
            setHeader(request, header);
            response = httpClient.execute(request);
            long end = Calendar.getInstance().getTimeInMillis();
            long useTime = end - start;
            result = getHTTPResult(response);
            log.info("Request:DELETE to:{}, timecost={}ms, header={}, response={}", url, useTime, header, result);

            if (result == null) {
                throw new NullPointerException("This request did not return the result");
            }
            return result;
        } catch (ClientProtocolException e) {
            request.abort();
            log.error("Request protocol is wang.", e);
        } catch (IOException e) {
            request.abort();
            log.error("Request[{}] network is error", url, e);
        } finally {
            close(httpClient, response);
        }
        return result;
    }

    private static void close(CloseableHttpClient httpClient, CloseableHttpResponse response) {
        try {
            if (response != null) {
                response.close();
            }
            if (httpClient != null) {
                httpClient.close();
            }
        } catch (IOException e) {
            log.error("close is faild", e);
        }
    }

    private static HttpResult getHTTPResult(CloseableHttpResponse response) {
        if (response == null)
            return null;

        HttpResult result = new HttpResult();
        result.setStatus(response.getStatusLine().getStatusCode());
        HttpEntity entity = response.getEntity();
        if (entity == null)
            return result;

        String respContent = null;
        try {
            respContent = inputStreamToString(entity.getContent());
            result.setMessage(respContent);
            EntityUtils.consume(entity);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private static String inputStreamToString(InputStream inputStream) {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] data = new byte[1024];
        int count = -1;
        try {
            while ((count = inputStream.read(data, 0, 1024)) != -1)
                outStream.write(data, 0, count);
            data = null;
            return new String(outStream.toByteArray(), DEFAULT_CHARSET);
        } catch (IOException e) {
            throw new RuntimeException("parse response content is failed.");
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String convertStreamToString(InputStream inputStream) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder content = new StringBuilder();
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                content.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return content.toString();
    }

}
