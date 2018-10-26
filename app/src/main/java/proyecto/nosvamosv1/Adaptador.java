package proyecto.nosvamosv1;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import proyecto.nosvamosv1.Models.Viajes;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolderDatos> {

    List<Viajes> listaViajes;

    public Adaptador(List<Viajes> listaViajes) {
        this.listaViajes = listaViajes;
    }

    @Override
    public ViewHolderDatos onCreateViewHolder(ViewGroup parent, int i) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_viajeslist,null,false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos viewHolderDatos, int i) {
        viewHolderDatos.idOrigen.setText("Origen: "+listaViajes.get(i).getOrigen());
        viewHolderDatos.idFecha.setText("Fecha: "+listaViajes.get(i).getFecha());
        viewHolderDatos.idDestino.setText("Destino:"+listaViajes.get(i).getDestino());
        viewHolderDatos.idCupos.setText("Cupos: "+listaViajes.get(i).getNroAsientosViaje());
    }

    @Override
    public int getItemCount() {
        return listaViajes.size();
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
        TextView idOrigen,idFecha,idDestino,idCupos;
        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            idOrigen=(TextView) itemView.findViewById(R.id.idOrigen);
            idFecha=(TextView) itemView.findViewById(R.id.idFecha);
            idDestino=(TextView) itemView.findViewById(R.id.idDestino);
            idCupos=(TextView) itemView.findViewById(R.id.idCupos);
        }

    }
}
