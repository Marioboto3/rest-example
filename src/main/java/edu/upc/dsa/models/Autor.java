package edu.upc.dsa.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Autor {
    String nombre;
    String apellido;
    int dni;
    List<Track> list;
    int añoNacimiento;

    public Autor(String nombre, String apellido, int dni, int añoNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.list=new ArrayList<>();
        this.añoNacimiento=añoNacimiento;

    }
    public Autor(){
       this.list=new ArrayList<>();
    }

    public void setAñoNacimiento(int añoNacimiento) {
        this.añoNacimiento = añoNacimiento;
    }

    public int getAñoNacimiento() {
        return añoNacimiento;
    }

    public int getSize(){return this.list.size();}

    public List<Track> getList() {
        return list;
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

    public void añadirTrack(Track t){
        this.list.add(t);
    }
}
