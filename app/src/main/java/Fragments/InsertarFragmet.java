package Fragments;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.contentprovidercliente.MiProveedorContenidoContract;
import com.example.contentprovidercliente.R;

public class InsertarFragmet extends Fragment {

    EditText txtnombre, txtpassword, txtemail, txttelefono;
    Button btnguardar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.insertar_fragmet,container,false);
        txtnombre = view.findViewById(R.id.txtNombre);
        txtpassword = view.findViewById(R.id.txtPassword);
        txtemail = view.findViewById(R.id.txtEmail);
        txttelefono = view.findViewById(R.id.txtTel);
        btnguardar = view.findViewById(R.id.btnGuardar);
        btnguardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = txtnombre.getText().toString();
                String password = txtpassword.getText().toString();
                String email = txtemail.getText().toString();
                String telefono = txttelefono.getText().toString();
                ContentValues cv = new ContentValues();
                cv.put(MiProveedorContenidoContract.Usuarios.NOMBRE,nombre);
                cv.put(MiProveedorContenidoContract.Usuarios.PASS,password);
                cv.put(MiProveedorContenidoContract.Usuarios.EMAIL,email);
                cv.put(MiProveedorContenidoContract.Usuarios.TELEFONO,telefono);
                getContext().getContentResolver().insert(MiProveedorContenidoContract.Usuarios.CONTENT_URI,cv);
                Toast.makeText(getContext(), "Contacto Guardado", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

}
