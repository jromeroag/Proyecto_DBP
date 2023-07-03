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

public class GeneralActivity extends AppCompatActivity {
    private AutoCompleteTextView ACTDoctorGeneral;
    private EditText addPacienteGeneral;
    private EditText addFechaGeneral;
    private Button btnCitaGeneral;
    private ServiceAPI serviceAPI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general);
        addPacienteGeneral = findViewById(R.id.addPacienteGeneral);
        addFechaGeneral = findViewById(R.id.addFechaGeneral);
        btnCitaGeneral = findViewById(R.id.btnCitaGeneral);
        serviceAPI = RetrofitClientInstance.getRetrofitInstance().create(ServiceAPI.class);

        btnCitaGeneral.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String paciente = addPacienteGeneral.getText().toString();
                String fecha = addFechaGeneral.getText().toString();

                Citas cita = new Citas(paciente, fecha);

                Call<Citas> call = serviceAPI.agregarCita(cita);
                call.enqueue(new Callback<Citas>() {
                    @Override
                    public void onResponse(Call<Citas> call, Response<Citas> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(GeneralActivity.this, "Cita agregada correctamente", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(GeneralActivity.this, "Error al agregar la cita", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Citas> call, Throwable t) {
                        Toast.makeText(GeneralActivity.this, "Error en la llamada", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }
}