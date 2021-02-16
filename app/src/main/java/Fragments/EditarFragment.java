package Fragments;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
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

import com.example.contentprovidercliente.Contacto;
import com.example.contentprovidercliente.MiProveedorContenidoContract;
import com.example.contentprovidercliente.R;

public class EditarFragment extends Fragment {

    EditText txtbuscar, txtnombre, txtpassword, txtemail, txttelefono;
    Button btnbuscar, btneditar, btneliminar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.editar_fragment,container,false);
        txtbuscar = view.findViewById(R.id.txtbuscar);
        txtnombre = view.findViewById(R.id.txtNombre);
        txtpassword = view.findViewById(R.id.txtPassword);
        txtemail = view.findViewById(R.id.txtEmail);
        txttelefono = view.findViewById(R.id.txtTel);
        btnbuscar = view.findViewById(R.id.btnbuscar);
        btneditar = view.findViewById(R.id.btnEditar);
        btneliminar = view.findViewById(R.id.btnEditar);
        btnbuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = txtbuscar.getText().toString();
                Cursor c = getContext().getContentResolver().query(Uri.parse(MiProveedorContenidoContract.Usuarios.CONTENT_URI+id),null, null, null, null);
                while(c.moveToNext())
                {
                    txtnombre.setText(c.getString(1));
                    txtemail.setText(c.getString(2));
                    txtpassword.setText(c.getString(3));
                    txttelefono.setText(c.getString(4));
                }
            }
        });

        return view;
    }

}
