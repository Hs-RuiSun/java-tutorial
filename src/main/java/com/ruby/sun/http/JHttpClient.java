package com.ruby.sun.http;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class JHttpClient {
    private static Logger logger = LogManager.getLogger(JHttpClient.class);
    
    private static String API_FLIGHT = "http://192.168.1.138:2020/v1/customer/4/aircraft-flight?airline=AIB%2CBGA&dst=LFBO&ori=LFBO&isIntersection=true";
    private static String API_LOGIN = "http://192.168.1.138:2020/v1/auth/login";
    private static String API_FLIGHT_PLAN = "http://localhost:8080/v1/flight-plan";
    
    private static String FLIGHT_PLANE_XML = "C:\\Users\\ruby.sun\\Downloads\\flight-plan.xml";
    
    @Ignore
    @Test
    public void testFlightPlanApi() throws ClientProtocolException, IOException {
        HttpClient client = HttpClientBuilder.create().build();
        
        HttpPost post = new HttpPost(API_LOGIN);
        List<NameValuePair> params = new ArrayList<NameValuePair>(2);
        params.add(new BasicNameValuePair("j_username", "userGFI"));
        params.add(new BasicNameValuePair("j_password", "gfi2015"));
        params.add(new BasicNameValuePair("j_remember", "false"));
        post.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
        HttpResponse response1 = client.execute(post);
        
        List<Header> httpHeaders = Arrays.asList(response1.getAllHeaders());        
        for (Header header : httpHeaders) {
            System.out.println("Headers.. name,value:"+header.getName() + "," + header.getValue());
        }
        
        HttpPost post2 = new HttpPost(API_FLIGHT_PLAN);
        File file =  new File(FLIGHT_PLANE_XML);
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        final Charset charset = null;
        builder.addBinaryBody("file", new FileInputStream(file), ContentType.create("text/xml", charset), file.getName());

        HttpEntity entity = builder.build();
        post2.setEntity(entity);
        
        HttpResponse response = client.execute(post2);
        
        int statusCode = response.getStatusLine().getStatusCode();
        assertEquals(HttpStatus.SC_OK, statusCode);
    }
    
    @Ignore
    @Test
    public void testLogin() throws ClientProtocolException, IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(API_LOGIN);
        
        List<NameValuePair> params = new ArrayList<NameValuePair>(2);
        params.add(new BasicNameValuePair("j_username", "userGFI"));
        params.add(new BasicNameValuePair("j_password", "gfi2015"));
        params.add(new BasicNameValuePair("j_remember", "false"));
        post.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
        
        HttpResponse response = client.execute(post);
        int statusCode = response.getStatusLine().getStatusCode();
        
        assertEquals(HttpStatus.SC_OK, statusCode);
    }
    
    @Test
    public void testGetFlightApi() throws ClientProtocolException, IOException {
        CloseableHttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost(API_LOGIN);
        List<NameValuePair> params = new ArrayList<NameValuePair>(2);
        params.add(new BasicNameValuePair("j_username", "userGFI"));
        params.add(new BasicNameValuePair("j_password", "gfi2015"));
        params.add(new BasicNameValuePair("j_remember", "false"));
        post.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));
        client.execute(post);
        
        /*HttpClientContext context = HttpClientContext.create();
        context.getCookieStore().getCookies().stream().forEach(c -> System.out.println(c.getName()));*/
        
        HttpGet get = new HttpGet(API_FLIGHT);
        HttpResponse response = client.execute(get);
        String responseJSON = EntityUtils.toString(response.getEntity());
    }
    
    @Ignore
    @Test
    public void testAuthenticate() throws ClientProtocolException, IOException {
        CredentialsProvider provider = new BasicCredentialsProvider();
        UsernamePasswordCredentials credentials = new UsernamePasswordCredentials("userGFI", "gfi2015");
        provider.setCredentials(AuthScope.ANY, credentials);
          
        HttpClient client = HttpClientBuilder.create()
          .setDefaultCredentialsProvider(provider)
          .build();
         
        HttpResponse response = client.execute(new HttpGet(API_LOGIN));
        int statusCode = response.getStatusLine().getStatusCode();
          
        assertEquals(HttpStatus.SC_OK, statusCode);
    }
}
