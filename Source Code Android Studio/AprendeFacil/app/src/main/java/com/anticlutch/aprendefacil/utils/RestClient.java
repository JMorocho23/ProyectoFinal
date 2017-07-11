package com.anticlutch.aprendefacil.utils;

import android.util.Pair;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anticlutch on 6/19/2017.
 */

public class RestClient {
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public enum RequestMethod
    {
        GET,
        POST
    }

    //private ArrayList<NameValuePair> params;
    private List<Pair<String, String>> params;
    //private ArrayList <NameValuePair> headers;
    private List<Pair<String, String>> headers;

    private int responseCode;

    private String url;
    private String message;
    private String response;
    private String data;

    public String getResponse() {
        return response;
    }

    public String getErrorMessage() {
        return message;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public RestClient(String url)
    {
        this.url = url;
        params = new ArrayList<>();
        headers = new ArrayList<>();
    }

    public void AddParam(String name, String value)
    {
        params.add(new Pair<>(name, value));
    }

    public void AddHeader(String name, String value)
    {
        headers.add(new Pair<>(name, value));
    }

    public void Execute(RequestMethod method) throws Exception
    {
        switch(method) {
            case GET:
            {
                //add parameters
                String combinedParams = "";
                if(!params.isEmpty()){
                    combinedParams += "?";
                    for(Pair<String, String> p : params)
                    {
                        String paramString = p.first + "=" + URLEncoder.encode(p.second,"UTF-8");
                        if(combinedParams.length() > 1)
                        {
                            combinedParams  +=  "&" + paramString;
                        }
                        else
                        {
                            combinedParams += paramString;
                        }
                    }
                }

                HttpGet request = new HttpGet(url + combinedParams);

                //add headers
                for(Pair<String, String> h : headers)
                {
                    request.addHeader(h.first, h.second);
                }

                executeRequest(request);
                break;
            }
            case POST:
            {
                HttpPost request = new HttpPost(url);

                //add headers
                for(Pair<String, String> h : headers)
                {
                    request.addHeader(h.first, h.second);
                }

                if(!params.isEmpty()){
                    StringEntity entity = new StringEntity(params.get(0).second);
                    request.setEntity(entity);
                    //request.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
                }

                if(data != null){
                    StringEntity entity = new StringEntity(data);
                    request.setEntity(entity);
                    //request.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
                }


                executeRequest(request);
                break;
            }
        }
    }

    private void executeRequest(HttpUriRequest request)
    {
        HttpClient client = new DefaultHttpClient();

        HttpResponse httpResponse;

        try {

            httpResponse = client.execute(request);
            responseCode = httpResponse.getStatusLine().getStatusCode();
            message = httpResponse.getStatusLine().getReasonPhrase();

            HttpEntity entity = httpResponse.getEntity();

            if (entity != null) {

                InputStream instream = entity.getContent();
                response = convertStreamToString(instream);

                // Closing the input stream will trigger connection release
                instream.close();
            }

        } catch (ClientProtocolException e)  {
            client.getConnectionManager().shutdown();
            e.printStackTrace();
        } catch (IOException e) {
            client.getConnectionManager().shutdown();
            e.printStackTrace();
        }
    }

    private static String convertStreamToString(InputStream is) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
