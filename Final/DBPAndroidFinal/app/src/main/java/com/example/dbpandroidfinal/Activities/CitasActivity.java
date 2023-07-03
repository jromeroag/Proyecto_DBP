package com.example.dbpandroidfinal.Activities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dbpandroidfinal.API.RetrofitClientInstance;
import com.example.dbpandroidfinal.API.ServiceAPI;
import com.example.dbpandroidfinal.Modelos.Citas;
import com.example.dbpandroidfinal.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CitasActivity extends AppCompatActivity {

    private RecyclerView recyclerCitas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_citas);

        recyclerCitas = findViewById(R.id.recyclerCitas);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerCitas.setLayoutManager(layoutManager);

        obtenerCitas();
    }

    private void obtenerCitas() {
        ServiceAPI serviceAPI = RetrofitClientInstance.getRetrofitInstance().create(ServiceAPI.class);

        Call<List<Citas>> call = serviceAPI.getCitas();
        call.enqueue(new Callback<List<Citas>>() {
            @Override
            public void onResponse(Call<List<Citas>> call, Response<List<Citas>> response) {
                if (response.isSuccessful()) {
                    List<Citas> citasList = response.body();
                    CitasAdapter adapter = new CitasAdapter(citasList);
                    recyclerCitas.setAdapter(adapter);
                } else {
                    // Manejar el error de respuesta
                }
            }

            @Override
            public void onFailure(Call<List<Citas>> call, Throwable t) {
                // Manejar el error de la llamada
            }
        });
    }

    private class CitasViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public CitasViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(android.R.id.text1);
        }

        public void bindData(Citas cita) {
            textView.setText(cita.getDoctor());
        }
    }

    private class CitasAdapter extends RecyclerView.Adapter<CitasViewHolder> {

        private List<Citas> citasList;

        public CitasAdapter(List<Citas> citasList) {
            this.citasList = citasList;
        }

        @NonNull
        @Override
        public CitasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
            return new CitasViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull CitasViewHolder holder, int position) {
            Citas cita = citasList.get(position);
            holder.bindData(cita);
        }

        @Override
        public int getItemCount() {
            return citasList.size();
        }
    }
}
