package com.example.dbpandroidfinal.Activities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dbpandroidfinal.API.RetrofitClientInstance;
import com.example.dbpandroidfinal.API.ServiceAPI;
import com.example.dbpandroidfinal.Modelos.Doctor;
import com.example.dbpandroidfinal.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DoctoresActivity extends AppCompatActivity {

    private EditText addNombreDoctor;
    private EditText addApellidoDoctor;
    private EditText addEspecialidadDoctor;
    private RecyclerView recyclerDoctores;
    private List<Doctor> doctores;
    private LinearLayoutManager layoutManager;
    private Button btnAgregarDoctor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctores);

        addNombreDoctor = findViewById(R.id.addNombreDoctor);
        addApellidoDoctor = findViewById(R.id.addApellidoDoctor);
        addEspecialidadDoctor = findViewById(R.id.addEspecialidadDoctor);
        recyclerDoctores = findViewById(R.id.RecyclerDoctores);
        btnAgregarDoctor = findViewById(R.id.btnAgregarDoctor);
        layoutManager = new LinearLayoutManager(this);
        recyclerDoctores.setLayoutManager(layoutManager);

        doctores = new ArrayList<>();

        obtenerDoctores();

        btnAgregarDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregarDoctor();
            }
        });
    }

    private void obtenerDoctores() {
        ServiceAPI serviceAPI = RetrofitClientInstance.getRetrofitInstance().create(ServiceAPI.class);
        Call<List<Doctor>> call = serviceAPI.getDoctores();
        call.enqueue(new Callback<List<Doctor>>() {
            @Override
            public void onResponse(Call<List<Doctor>> call, Response<List<Doctor>> response) {
                if (response.isSuccessful()) {
                    List<Doctor> doctoresResponse = response.body();
                    if (doctoresResponse != null) {
                        doctores.clear();
                        doctores.addAll(doctoresResponse);
                        recyclerDoctores.getAdapter().notifyDataSetChanged();
                    }
                } else {
                    Toast.makeText(DoctoresActivity.this, "Error al obtener los doctores", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Doctor>> call, Throwable t) {
                Toast.makeText(DoctoresActivity.this, "Error en la solicitud", Toast.LENGTH_SHORT).show();
            }
        });

        RecyclerView.Adapter adapter = new RecyclerView.Adapter() {
            @NonNull
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View itemView = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
                return new DoctorViewHolder(itemView);
            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
                Doctor doctor = doctores.get(position);

                DoctorViewHolder doctorViewHolder = (DoctorViewHolder) holder;
                String doctorData = "Nombre: " + doctor.getNomdoc() + "\n" +
                        "Especialidad: " + doctor.getEspdoc() + "\n" +
                        "Celular: " + doctor.getCeldoc() + "\n" +
                        "ID: " + doctor.getIddoc();
                doctorViewHolder.textView.setText(doctorData);
            }

            @Override
            public int getItemCount() {
                return doctores.size();
            }
        };

        recyclerDoctores.setAdapter(adapter);
    }

    private void agregarDoctor() {
        String nombre = addNombreDoctor.getText().toString();
        String apellido = addApellidoDoctor.getText().toString();
        String especialidad = addEspecialidadDoctor.getText().toString();

        // Validar los campos ingresados (opcional)

        // Crear el objeto Doctor con los datos ingresados
        Doctor nuevoDoctor = new Doctor(0, nombre, apellido, especialidad, 0);

        // Enviar el nuevo doctor a la API para agregarlo
        ServiceAPI serviceAPI = RetrofitClientInstance.getRetrofitInstance().create(ServiceAPI.class);
        Call<Doctor> call = serviceAPI.agregarDoctor(nuevoDoctor);
        call.enqueue(new Callback<Doctor>() {
            @Override
            public void onResponse(Call<Doctor> call, Response<Doctor> response) {
                if (response.isSuccessful()) {
                    Doctor doctorAgregado = response.body();
                    if (doctorAgregado != null) {
                        doctores.add(doctorAgregado);
                        recyclerDoctores.getAdapter().notifyItemInserted(doctores.size() - 1);
                        addNombreDoctor.setText("");
                        addApellidoDoctor.setText("");
                        addEspecialidadDoctor.setText("");
                        Toast.makeText(DoctoresActivity.this, "Doctor agregado correctamente", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(DoctoresActivity.this, "Error al agregar el doctor", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Doctor> call, Throwable t) {
                Toast.makeText(DoctoresActivity.this, "Error en la solicitud", Toast.LENGTH_SHORT).show();
            }
        });
    }

    class DoctorViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        DoctorViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(android.R.id.text1);
        }
    }
}
