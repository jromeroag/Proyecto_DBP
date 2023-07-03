package com.example.dbpandroidfinal.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dbpandroidfinal.API.RetrofitClientInstance;
import com.example.dbpandroidfinal.API.ServiceAPI;
import com.example.dbpandroidfinal.Modelos.Usuario;
import com.example.dbpandroidfinal.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrarActivity extends AppCompatActivity {

    private EditText edtRegistrarUsuario;
    private EditText edtRegistrarPassword;
    private Button btnGuardar;
    private Button btnRegresar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        edtRegistrarUsuario = findViewById(R.id.edtRegistrarUsuario);
        edtRegistrarPassword = findViewById(R.id.edtRegistrarPassword);
        btnGuardar = findViewById(R.id.btnGuardar);
        btnRegresar = findViewById(R.id.btnRegresar);


        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegistrarActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                guardarUsuario();
            }
        });

    }

    private void guardarUsuario() {
        String usuario = edtRegistrarUsuario.getText().toString();
        String contraseña = edtRegistrarPassword.getText().toString();

        Usuario nuevoUsuario = new Usuario(usuario, contraseña, "");

        ServiceAPI serviceAPI = RetrofitClientInstance.getRetrofitInstance().create(ServiceAPI.class);
        Call<List<Usuario>> call = serviceAPI.Sendusuario(nuevoUsuario);
        call.enqueue(new Callback<List<Usuario>>() {
            @Override
            public void onResponse(Call<List<Usuario>> call, Response<List<Usuario>> response) {
                if (response.isSuccessful()) {
                    // El usuario se agregó exitosamente
                    Toast.makeText(RegistrarActivity.this, "Usuario agregado", Toast.LENGTH_SHORT).show();
                } else {
                    // Error al agregar el usuario
                    Toast.makeText(RegistrarActivity.this, "Error al agregar el usuario", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Usuario>> call, Throwable t) {
                Toast.makeText(RegistrarActivity.this, "Error en la solicitud", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
