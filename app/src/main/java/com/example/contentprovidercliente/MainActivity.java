package com.example.contentprovidercliente;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import Fragments.ContactosFragment;
import Fragments.MainFragment;

import static com.example.contentprovidercliente.R.id.container;
import static com.example.contentprovidercliente.R.id.iniciofragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Toolbar toolbar;
    NavigationView navigationView;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container,new MainFragment());
        fragmentTransaction.commit();



        /*Cursor c = getContentResolver().query(com.example.contentprovidercliente.MiProveedorContenidoContract.Usuarios.CONTENT_URI,null,null,null,null);
        while(c.moveToNext())
        {
            Log.d("MiCPU",c.getInt(0)+"-"+c.getString(2));
        }

        ContentValues cv = new ContentValues();
        cv.put(MiProveedorContenidoContract.Usuarios.NOMBRE,"José Luis");
        cv.put(MiProveedorContenidoContract.Usuarios.PASS,"123");
        cv.put(MiProveedorContenidoContract.Usuarios.EMAIL,"jos@fasdf");
        cv.put(MiProveedorContenidoContract.Usuarios.TELEFONO,"54543");

        Uri uri= getContentResolver().insert(MiProveedorContenidoContract.Usuarios.CONTENT_URI,cv);
        Log.d("MiCPU",uri.toString());*/
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);
        if(item.getItemId()==R.id.inicio)
        {
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container,new MainFragment());
            fragmentTransaction.commit();
        }
        if(item.getItemId()==R.id.mostrar)
        {
            fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container,new ContactosFragment());
            fragmentTransaction.commit();
        }
        return false;
    }
}