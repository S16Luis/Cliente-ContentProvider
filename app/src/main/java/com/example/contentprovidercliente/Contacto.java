package com.example.contentprovidercliente;

public class Contacto {
    private String id;
    private String nombre;
    private String password;
    private String email;
    private String telefono;

    public Contacto(){}

    public Contacto(String id, String nombre, String password, String email, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.password = password;
        this.email = email;
        this.telefono = telefono;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
