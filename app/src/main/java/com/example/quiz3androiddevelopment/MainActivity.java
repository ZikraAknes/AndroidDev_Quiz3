package com.example.quiz3androiddevelopment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class MainActivity extends AppCompatActivity {

    public interface Service {
        @GET("photos")
        Call<List<SongData>> getData();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycleView);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Service requestUser = retrofit.create(Service.class);

        requestUser.getData().enqueue(new Callback<List<SongData>>() {
            @Override
            public void onResponse(Call<List<SongData>> call, Response<List<SongData>> response) {
                recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                recyclerView.setAdapter(new MyAdapter(MainActivity.this, response.body()));
            }

            @Override
            public void onFailure(Call<List<SongData>> call, Throwable t) {

            }
        });

    }
}