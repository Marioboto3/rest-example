package edu.upc.dsa.models;

import java.util.ArrayList;
import java.util.List;

public class AutorTO {
    String nombre;
    String apellido;
    int dni;
    List<String> list;

    public AutorTO(String nombre, String apellido, int dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.list=new ArrayList<>();

    }
    public AutorTO(){
        this.list=new ArrayList<>();
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
    public int getsize(){return this.list.size();}
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
