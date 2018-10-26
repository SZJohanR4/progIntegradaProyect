package proyecto.nosvamosv1.userApi;

import java.util.List;

import proyecto.nosvamosv1.Models.Auto;
import proyecto.nosvamosv1.Models.Usuario;
import proyecto.nosvamosv1.Models.Viajes;
import retrofit2.Call;
import retrofit2.http.GET;

public interface userServices {

    @GET("usuariosList/")
    Call<List<Usuario>> getAuthetification();

    @GET("Viajeslist/")
    Call<List<Viajes>> getViajesList();

    @GET("autosList/")
    Call<List<Auto>> getAutosList();
}
