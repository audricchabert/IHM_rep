package achabert.vaisseau;

import android.content.Entity;
import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by achabert on 18/12/2015.
 */
public class GetTask extends AsyncTask<String,Void,String> {

    private Exception exception;

    protected String doInBackground(String... url) {
        HttpClient client = new DefaultHttpClient();
        //HttpGet request = new HttpGet("10.212.121.225:8000");
        HttpGet request = new HttpGet("http://www.google.com");
        // replace with your url

        HttpResponse response;
        try {
            response = client.execute(request);

            if(response.getStatusLine().getStatusCode() == 200){
                HttpEntity entity = response.getEntity();
                return EntityUtils.toString(response.getEntity());
            }else{

            }

            //debug


            //return response.toString();
            Log.d("Response of GET request", response.toString());
            InputStream is = response.getEntity().getContent();
            return is.toString();

        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



        return "error";
    }

    protected void onPostExecute(String feed) {
        // TODO: check this.exception
        // TODO: do something with the feed
    }
}