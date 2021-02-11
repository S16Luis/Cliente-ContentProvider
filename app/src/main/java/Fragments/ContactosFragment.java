package Fragments;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contentprovidercliente.AdaptadorContactos;
import com.example.contentprovidercliente.Contacto;
import com.example.contentprovidercliente.R;

import java.util.ArrayList;

public class ContactosFragment extends Fragment {

    AdaptadorContactos adaptadorContactos;
    RecyclerView recyclerView;
    ArrayList<Contacto> lista;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.contactos_fragment,container,false);
        recyclerView = view.findViewById(R.id.reciclerview);
        lista = new ArrayList<>();
        cargarlista();
        mostrardatos();
        return view;
    }

    public void cargarlista(){
        Cursor c = getContext().getContentResolver().query(com.example.contentprovidercliente.MiProveedorContenidoContract.Usuarios.CONTENT_URI,null,null,null,null);
        while(c.moveToNext())
        {
           lista.add(new Contacto(c.getString(0),c.getString(1),c.getString(2),c.getString(3),c.getString(4)));
        }
    }

    public void mostrardatos(){
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adaptadorContactos = new AdaptadorContactos(getContext(),lista);
        recyclerView.setAdapter(adaptadorContactos);
        adaptadorContactos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = lista.get(recyclerView.getChildAdapterPosition(view)).getNombre();
                Toast.makeText(getContext(), "Selecciono: "+nombre, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
