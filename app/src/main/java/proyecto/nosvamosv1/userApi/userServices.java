package proyecto.nosvamosv1.userApi;

import java.util.List;

import proyecto.nosvamosv1.Models.Usuario;
import proyecto.nosvamosv1.Models.UsuarioRespuesta;
import retrofit2.Call;
import retrofit2.http.GET;

public interface userServices {

    @GET("usuariosList/")
    Call<List<Usuario>> getAuthetification();
}
