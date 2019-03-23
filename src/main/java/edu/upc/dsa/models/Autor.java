package edu.upc.dsa.models;

import java.util.HashMap;
import java.util.List;

public class Autor {
    String nombre;
    String apellido;
    int dni;
    HashMap<String,Track> list;

    public Autor(String nombre, String apellido, int dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }
    public Autor(){
       this.list=new HashMap<String, Track>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }
}
