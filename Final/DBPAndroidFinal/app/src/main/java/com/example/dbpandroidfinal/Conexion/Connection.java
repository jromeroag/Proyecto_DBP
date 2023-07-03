package com.example.dbpandroidfinal.Conexion;


import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Connection {
    private static final String URL = "http://mirandap-001-site1.itempurl.com/api/";
    private static Retrofit retrofit = null;

    public static Retrofit getConnection()
    {
        if(retrofit == null)
        {
            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

            retrofit = new Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
