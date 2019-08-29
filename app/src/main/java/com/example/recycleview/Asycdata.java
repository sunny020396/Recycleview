package com.example.recycleview;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Asycdata extends AsyncTask<String,Integer,String> {

    Context c;
    ProgressDialog progressDialog;

    public Asycdata(Context c) {
        this.c = c;
    }



    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);

        progressDialog.setProgress(values[0]);
    }

    @Override
    protected void onPostExecute(String s) {


        progressDialog.dismiss();
    }

    @Override
    protected String doInBackground(String... strings) {

        publishProgress(1);

        String jsonurl = strings[0];
        String json="";


        publishProgress(2);
        Httphandler sh = new Httphandler();

        json = sh.makeServiceCall(jsonurl);
        System.out.println("This is Json :"+json);


        try {
            JSONObject mainobj = new JSONObject(json);

            JSONArray mainarray = mainobj.getJSONArray("Pokemon");
            int size = mainarray.length();

            publishProgress(size);

        } catch (JSONException e) {
            e.printStackTrace();
        }


        return json;
    }
}