package com.vasantv.formpost;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vasant.viswanathan on 10/19/2015.
 */
public class PostTask extends AsyncTask<String,Void,Boolean> {

    private long startTime;
    private long stopTime;
    @Override
    //params[0] - URL
    //params[1], params[2] - message1 and message2
    protected Boolean doInBackground(String... params){
//        Log.d("POSTTASK","INSIDE doInBackground");
        Boolean result_bool = true;

        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(params[0]);

        try{
            List<NameValuePair> nameValuePairList = new ArrayList<NameValuePair>(3);
            nameValuePairList.add(new BasicNameValuePair("id", "01"));
            nameValuePairList.add(new BasicNameValuePair("message1", params[1]));
            nameValuePairList.add(new BasicNameValuePair("message2", params[2]));
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairList));
//            Log.d("POSTTASK","GOING to POST");
            startTime = System.currentTimeMillis();
            HttpResponse response = httpClient.execute(httpPost);
            stopTime = System.currentTimeMillis();
            Log.d("POSTTASK","RESPONSE RECEIVED:: "+response.toString() +":: IN ms:" + (stopTime-startTime));
        }catch(Exception e){
            e.printStackTrace();
        }

        return result_bool;
    }

    @Override
    protected void onPostExecute(Boolean result){
        //do something to display result
    }

}
