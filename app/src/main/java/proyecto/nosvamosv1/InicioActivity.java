package proyecto.nosvamosv1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import proyecto.nosvamosv1.Models.Auto;
import proyecto.nosvamosv1.Models.Usuario;
import proyecto.nosvamosv1.Models.Viajes;
import proyecto.nosvamosv1.userApi.userServices;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InicioActivity extends AppCompatActivity {
    private Button btnPublicar, btnReservar, btnPrueba;
    private static final String TAG="inicio";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        btnPublicar= (Button) findViewById(R.id.btnPublicar);
        btnReservar= (Button) findViewById(R.id.btnReservar);

        listarViajes();
    }

    private void listarViajes(){
        btnReservar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(InicioActivity.this,ViajesActivity.class);
                startActivity(intent);
            }
        });
    }
}
