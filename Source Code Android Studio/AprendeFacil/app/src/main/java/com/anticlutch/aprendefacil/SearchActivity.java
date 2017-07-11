package com.anticlutch.aprendefacil;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.anticlutch.aprendefacil.utils.RestClient;

public class SearchActivity extends ListActivity   {

    private List<Map<String,String>> UniversityList = new ArrayList<Map<String,String>>();
    private List<String> UniversityListBasic = new ArrayList<String>();
    private String listResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_search);

        new RESTGET_UniversityListAsyncTask().execute();
    }

    public void onListItemClick(
            ListView parent, View v, int position, long id)
    {
        Toast.makeText(this,
                "You have selected " + UniversityListBasic.get(position),
                Toast.LENGTH_SHORT).show();
    }

    private void initList(){

        try{
            JSONArray jsonMainNode = new JSONArray(listResponse);

            for(int i = 0; i<jsonMainNode.length();i++){
                JSONObject jsonChildNode = jsonMainNode.getJSONObject(i);
                String name = jsonChildNode.optString("nombreCarrera");
                String telefono = jsonChildNode.optString("duracionCarrera");
                String output = name + ": " +telefono;
                UniversityListBasic.add(output);
                UniversityList.add(createUniversitytype("University List", output));
            }
        }
        catch(JSONException e){
            Toast.makeText(getApplicationContext(), "Error"+e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    private HashMap<String, String> createUniversitytype(String name, String description){
        HashMap<String, String> UniList = new HashMap<String, String>();
        UniList.put(name, description);
        return UniList;
    }

    private class RESTGET_UniversityListAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {

        private ProgressDialog dialog;

        @Override
        protected void onPreExecute() {
            dialog = new ProgressDialog(SearchActivity.this);
            this.dialog.setMessage("Aprende Facil esta buscando Universidades...");
            this.dialog.show();
        }

        @Override
        protected String doInBackground(Pair<Context, String>... params) {

            listResponse="";
            try{
                RestClient restget=
                        new RestClient("http://10.17.13.56:8080/ProyectoFinal/faces/webresources/com.uda.model.carrera");
                restget.AddHeader("Accept","application/json");
                restget.Execute(RestClient.RequestMethod.GET);
                listResponse=restget.getResponse();
            }catch(Exception e){
                Toast.makeText(getApplicationContext(), e.getMessage(),
                        Toast.LENGTH_LONG).show();
            }
            return listResponse;
        }

        @Override
        protected void onPostExecute(String result) {
            try {
                initList();
                String[] resultado= Arrays.asList(UniversityListBasic.toArray()).
                        toArray(new String[UniversityListBasic.toArray().length]);
                setListAdapter(new ArrayAdapter<String>(SearchActivity.this,
                        android.R.layout.simple_list_item_1,resultado));
                if (dialog.isShowing()) {
                    dialog.dismiss();
                }
                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(),
                        "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                e.printStackTrace();
            }
        }

    }





}
