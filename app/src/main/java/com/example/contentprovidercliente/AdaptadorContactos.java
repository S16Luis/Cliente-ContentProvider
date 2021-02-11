package com.example.contentprovidercliente;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorContactos extends RecyclerView.Adapter<AdaptadorContactos.ViewHolder> implements View.OnClickListener {

    ArrayList<Contacto> model;
    LayoutInflater inflater;
    private View.OnClickListener listener;

    public AdaptadorContactos(Context context, ArrayList<Contacto> list){
        this.inflater=LayoutInflater.from(context);
        this.model = list;
    }

    @NonNull
    @Override
    public AdaptadorContactos.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.contactos_lista,parent,false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorContactos.ViewHolder holder, int position) {
        String id = model.get(position).getId();
        String nombre = model.get(position).getNombre();
        String email = model.get(position).getEmail();
        String telefono = model.get(position).getTelefono();
        holder.id.setText(id);
        holder.nombre.setText(nombre);
        holder.email.setText(email);
        holder.telefono.setText(telefono);
    }

    @Override
    public int getItemCount() {
        return model.size();
    }

    @Override
    public void onClick(View view) {
        if(listener !=null)
        {
            listener.onClick(view);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView id, nombre, email, telefono;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.tvclave);
            nombre = itemView.findViewById(R.id.tvnombre);
            email = itemView.findViewById(R.id.tvemail);
            telefono = itemView.findViewById(R.id.tvtelefono);
        }
    }
}
