package com.example.dbpandroidfinal.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dbpandroidfinal.Conexion.Connection;
import com.example.dbpandroidfinal.API.ServiceAPI;
import com.example.dbpandroidfinal.Modelos.Usuario;
import com.example.dbpandroidfinal.R;

import java.util.List;
import java.util.Optional;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText edtUsuario;
    private EditText edtPassword;
    private Button btnLogin;
    private Button btnRegistrar;
    private ServiceAPI service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtUsuario = findViewById(R.id.edtRegistrarUsuario);
        edtPassword = findViewById(R.id.edtRegistrarPassword);
        btnLogin = findViewById(R.id.btnGuardar);
        btnRegistrar = findViewById(R.id.btnRegresar);
        service = Connection.getConnection().create(ServiceAPI.class);


        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegistrarActivity.class);
                startActivity(intent);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = edtUsuario.getText().toString();
                String password = edtPassword.getText().toString();
                Call<List<Usuario>> call = service.getUsuario();
                call.enqueue(new Callback<List<Usuario>>() {
                    @Override
                    public void onResponse(Call<List<Usuario>> call, Response<List<Usuario>> response) {
                        List<Usuario> Usu = response.body();
                        Optional<Usuario> Usua = Usu.stream().filter(a->a.getNomusu().equals(user)&& a.getClausu().equals(password)).findFirst();
                        if (Usua.isPresent()){
                            startActivity( new Intent( LoginActivity.this, HomeActivity.class));
                            finish();
                        }
                        else {
                            Toast.makeText(LoginActivity.this, "Datos Incorrectos", Toast.LENGTH_SHORT).show();

                        }
                    }

                    @Override
                    public void onFailure(Call<List<Usuario>> call, Throwable t) {

                        Log.i("LOG_ERROR_RETROFIT",""+t.getMessage());


                    }
                });

            }
        });
    }
}