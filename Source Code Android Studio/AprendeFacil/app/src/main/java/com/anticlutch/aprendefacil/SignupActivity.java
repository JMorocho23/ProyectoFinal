package com.anticlutch.aprendefacil;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.view.View;
import android.widget.Toast;
import android.content.Intent;

import com.anticlutch.aprendefacil.utils.RestClient;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Spinner tipoUsuario = (Spinner) findViewById(R.id.tipoUsuario);
        ArrayAdapter spinner_adapter = ArrayAdapter.createFromResource(this, R.array.tipo, android.R.layout.simple_spinner_item);
        spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tipoUsuario.setAdapter(spinner_adapter);
    }

    public void onbuttonSaveClick (View view){

        EditText editemail = (EditText)findViewById(R.id.email);
        String email = editemail.getText().toString();

        EditText editnombreUsuario = (EditText)findViewById(R.id.nombreUsuario);
        String nombreUsuario = editnombreUsuario.getText().toString();

        EditText editpassword = (EditText)findViewById(R.id.password);
        String password = editpassword.getText().toString();

        EditText editnombreApe = (EditText)findViewById(R.id.nombreApe);
        String nombreApe = editnombreApe.getText().toString();

        EditText edittelefono = (EditText)findViewById(R.id.telefono);
        String telefono = edittelefono.getText().toString();

        Spinner edittipoUsuario = (Spinner)findViewById(R.id.tipoUsuario);
        String tipoUsuario = edittipoUsuario.getSelectedItem().toString();

        new Restpost_Signup().execute(new String[]{email,nombreUsuario,password,nombreApe,telefono,tipoUsuario});
    }

    private  class Restpost_Signup extends AsyncTask<String, Void, String>{

        private ProgressDialog dialog;

        @Override
        protected void onPreExecute(){
            dialog= new ProgressDialog(SignupActivity.this);
            this.dialog.setMessage("Pronto seras un usuario de AprendeFacil");
            this.dialog.show();
        }

        @Override
        protected String doInBackground(String... urls){
            String webResponse = "";
            try{
                RestClient client=
                        new RestClient("http://192.168.1.13:8080/ProyectoFinal/faces/webresources/com.uda.model.usuario");
                client.AddHeader("content-type", "application/xml");
                client.setData("<usuario>\n"+
                        "<email>"+urls[0]+"</email>\n"+
                        "<nombreApe>"+urls[3]+"</nombreApe>\n"+
                        "<nombreUsuario>"+urls[1]+"</nombreUsuario>\n"+
                        "<password>"+urls[2]+"</password>\n"+
                        "<telefono>"+urls[4]+"</telefono>\n"+
                        "<tipoUsuario>"+urls[5]+"</tipoUsuario>\n"+
                        "</usuario>\n");
                client.Execute(RestClient.RequestMethod.POST);

                    try {
                        webResponse = client.getResponse();
                    } catch (Exception e) {
                        e.printStackTrace();
                        Toast.makeText(getApplicationContext(), e.getMessage(),
                                Toast.LENGTH_LONG).show();
                    }

            } catch (Exception e) {
                Toast.makeText(getApplicationContext(),
                        "Cannot access the web service" + e.toString(),
                        Toast.LENGTH_LONG).show();
            }
            return webResponse;
            }

            @Override
            protected void onPostExecute(String result) {
                try {
                    if (dialog.isShowing()) {
                        dialog.dismiss();
                    }
                    //Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
                    Toast.makeText(getApplicationContext(), "Bienvenido, a AprendeFacil",
                            Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(SignupActivity.this, LoginActivity.class);
                    startActivity(i);
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(),
                            "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        }
    }

