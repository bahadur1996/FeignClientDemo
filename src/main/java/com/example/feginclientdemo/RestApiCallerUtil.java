package com.example.feginclientdemo;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import org.json.JSONObject;

import java.net.URLEncoder;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class RestApiCallerUtil 
{
//	private static Logger logger = Logger.getLogger(RestApiCallerUtil.class);
	
	public static HttpResponse serveGetRequest(String url, Map<String, String> requestParams, Map<String, String> requestHeaders) {

        if(Objects.nonNull(requestParams) && requestParams.size() > 0){
            url = url+"?";
            for(Map.Entry<String, String> entry: requestParams.entrySet()){
                try {
                	entry.setValue(URLEncoder.encode(entry.getValue(),"UTF-8"));
                } catch (Exception exception){
                	//logger.info("error: "+exception);
                }
            }
            url = requestParams.entrySet().stream().map(entry -> entry.getKey()+"="+entry.getValue()).collect(Collectors.joining("&",url,""));
        }
        
        HttpClient httpClient= HttpClientBuilder.create().build();
        
        try {
            //logger.info("Rest API is called with url: "+url);
            HttpGet getRequest = new HttpGet(url);
            
            if(Objects.nonNull(requestHeaders) && requestHeaders.size() > 0){
                for(Map.Entry<String, String> entry: requestHeaders.entrySet()){
                    try {
                    	getRequest.setHeader(entry.getKey(), entry.getValue());
                    } catch (Exception exception){
                    	//logger.info("error: "+exception);
                    }
                }
                
            }
            
            HttpResponse response = httpClient.execute(getRequest);
            
            
            return response;
        } catch (Exception exception){
            //logger.info("error: "+exception.getMessage());
            return null;
        }
    }
	
	
	public static HttpResponse servePostRequest(String url, JSONObject requestBody, Map<String, String> requestHeaders) {

        HttpClient httpClient= HttpClientBuilder.create().build();
        
        try {
            //logger.info("Rest API is called with url: "+url);
            HttpPost postRequest = new HttpPost(url);
            
            if(Objects.nonNull(requestHeaders) && requestHeaders.size() > 0){
                for(Map.Entry<String, String> entry: requestHeaders.entrySet()){
                    try {
                    	postRequest.setHeader(entry.getKey(), entry.getValue());
                    } catch (Exception exception){
                    	//logger.info("error: "+exception);
                    }
                }
                
            }
            
            StringEntity payload= new StringEntity(requestBody.toString());
            postRequest.setEntity(payload);
            
            
            HttpResponse response = httpClient.execute(postRequest);
            
            
            return response;
        } catch (Exception exception){
            //logger.info("error: "+exception.getMessage());
            return null;
        }
    }
}
