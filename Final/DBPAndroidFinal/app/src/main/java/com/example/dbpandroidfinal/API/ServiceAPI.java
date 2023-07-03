package com.example.dbpandroidfinal.API;



import com.example.dbpandroidfinal.Modelos.Citas;
import com.example.dbpandroidfinal.Modelos.Doctor;
import com.example.dbpandroidfinal.Modelos.Usuario;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ServiceAPI {
    @GET("usuario")
    public abstract Call<List<Usuario>> getUsuario();

    @POST("usuario")
    public abstract Call<List<Usuario>> Sendusuario(Usuario user);

   @GET("doctor")
    public abstract Call<List<Doctor>> getDoctores();

    @POST("doctor")
    Call<Doctor> agregarDoctor(@Body Doctor doctor);

    @GET("cita")
    public abstract Call<List<Citas>> getCitas();

    @POST("cita")
    Call<Citas> agregarCita(@Body Citas cita);


}
