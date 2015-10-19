package com.vasantv.formpost;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends ActionBarActivity {

    EditText edit_user;
    EditText edit_pass;
    Button btn_submit;
    private static String SERVER_URL = "http://requestb.in/1ev4qqe1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_user = (EditText) findViewById(R.id.editText_username);
        edit_pass = (EditText) findViewById(R.id.editText_password);
        btn_submit = (Button) findViewById(R.id.button_submit);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //call when send button is clicked
    public void send(View v){
        String text1 = edit_user.getText().toString();
        String text2 = edit_pass.getText().toString();

        if(text1.length() == 0)
        {
            edit_user.setText("Please fill text");
            return;
        }
        if(text2.length() == 0){
            edit_pass.setText("Please fill text");
            return;
        }

        //else submit form - now done via AsyncTask
        String[] string_params = new String[3];
        string_params[0] = SERVER_URL;
        string_params[1] = text1;
        string_params[2] = text2;
//        Log.d("MAINACTIVITY","GOING to POST-TASK INSIDE MAIN ACTIVITY");
        new PostTask().execute(string_params);
        /*HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(SERVER_URL);

        try{
            List<NameValuePair> nameValuePairList = new ArrayList<NameValuePair>(3);
            nameValuePairList.add(new BasicNameValuePair("id", "01"));
            nameValuePairList.add(new BasicNameValuePair("message1", text1));
            nameValuePairList.add(new BasicNameValuePair("message2", text2));
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairList));
            httpClient.execute(httpPost);
        }catch(Exception e){
            e.printStackTrace();
        }*/
    }

}
