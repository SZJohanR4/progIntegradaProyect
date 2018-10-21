package proyecto.nosvamosv1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import proyecto.nosvamosv1.Models.Usuario;
import proyecto.nosvamosv1.Models.UsuarioRespuesta;
import proyecto.nosvamosv1.userApi.userServices;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {
    private Retrofit retrofit;
    private Button btnIngresar;
    private EditText txtNombre, txtPass;
    private Boolean result=false;
    private static final String TAG="Fuimonos";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnIngresar=(Button) findViewById(R.id.btnIngresar);
        txtNombre=(EditText) findViewById(R.id.txtNombre);
        txtPass=(EditText) findViewById(R.id.txtPassword);
        login();



    }

    private void login(){
        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                retrofit =new Retrofit.Builder()
                        .baseUrl("http://192.168.0.6:8080/APIspring/v1/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                userServices auth=retrofit.create(userServices.class);
                Call<List<Usuario>>usuarioRespuestaCall=auth.getAuthetification();

                usuarioRespuestaCall.enqueue(new Callback<List<Usuario>>() {
                    @Override
                    public void onResponse(Call<List<Usuario>> call, Response<List<Usuario>> response) {
                        if(response.isSuccessful()){
                            List<Usuario> usuarioRespuesta=response.body();
                            String nombre=txtNombre.getText().toString();
                            String pass=txtPass.getText().toString();

                            String nombreApi=usuarioRespuesta.get(0).getNombre();
                            String passwordApi=usuarioRespuesta.get(0).getPassword();
                            if(nombreApi.equals(nombre)&& passwordApi.equals(pass)){
                                Log.e(TAG," onResponse: "+response.errorBody());
                                Intent intent = new Intent(LoginActivity.this, InicioActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(LoginActivity.this,"Usuario Invalido",Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                    @Override
                    public void onFailure(Call<List<Usuario>> call, Throwable t) {
                        Log.e(TAG, "onFailure"+ t.getMessage());
                        Toast.makeText(LoginActivity.this,"Error "+t.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }
}
