package com.example.dbpandroidfinal.Activities;

import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.dbpandroidfinal.API.RetrofitClientInstance;
import com.example.dbpandroidfinal.API.ServiceAPI;
import com.example.dbpandroidfinal.Modelos.Citas;
import com.example.dbpandroidfinal.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OftalActivity extends AppCompatActivity {

    private EditText addPacienteOftal;
    private EditText addFechaOftal;
    private Button btnCitaOftal;

    private ServiceAPI serviceAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oftal);

        addPacienteOftal = findViewById(R.id.addPacienteOftal);
        addFechaOftal = findViewById(R.id.addFechaOftal);
        btnCitaOftal =findViewById(R.id.btnCitaOftal);
        serviceAPI = RetrofitClientInstance.getRetrofitInstance().create(ServiceAPI.class);

        btnCitaOftal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String paciente = addPacienteOftal.getText().toString();
                String fecha = addFechaOftal.getText().toString();

                Citas cita = new Citas(paciente, fecha);

                Call<Citas> call = serviceAPI.agregarCita(cita);
                call.enqueue(new Callback<Citas>() {
                    @Override
                    public void onResponse(Call<Citas> call, Response<Citas> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(OftalActivity.this, "Cita agregada correctamente", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(OftalActivity.this, "Error al agregar la cita", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Citas> call, Throwable t) {
                        Toast.makeText(OftalActivity.this, "Error en la llamada", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }
}