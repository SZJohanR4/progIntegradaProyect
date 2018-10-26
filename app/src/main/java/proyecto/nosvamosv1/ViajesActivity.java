package proyecto.nosvamosv1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import proyecto.nosvamosv1.Models.Viajes;
import proyecto.nosvamosv1.userApi.userServices;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ViajesActivity extends AppCompatActivity {
    private Retrofit retrofit;
    private ListView list;

    ArrayList<Viajes> listaViajes;
    RecyclerView recyclerView;
    private static final String TAG="viajesList";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viajes);

        recyclerView=(RecyclerView) findViewById(R.id.recyclerId);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        retrofit =new Retrofit.Builder()
                .baseUrl("http://192.168.0.3:8080/APIspring/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        userServices auth=retrofit.create(userServices.class);
        Call<List<Viajes>> usuarioRespuestaCall=auth.getViajesList();
        usuarioRespuestaCall.enqueue(new Callback<List<Viajes>>() {
            @Override
            public void onResponse(Call<List<Viajes>> call, Response<List<Viajes>> response) {
                if(response.isSuccessful() && !response.body().isEmpty()){
                    List<Viajes> listaViajes=response.body();
                    Adaptador adapter = new Adaptador(listaViajes);
                    recyclerView.setAdapter(adapter);

                    Log.e(TAG," onResponsEe: "+response.body().get(0).getDestino());
                }else{
                    Toast.makeText(ViajesActivity.this,"Nadie esta viajando :C",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<Viajes>> call, Throwable t) {
                Log.e(TAG, "onFailure"+ t.getMessage());
                Toast.makeText(ViajesActivity.this,"Error "+t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
