package edu.upc.dsa.models;

import java.util.ArrayList;
import java.util.List;

public class AutorTO {
    String nombre;
    String apellido;
    int dni;
    int numTracks;
    int añoNacimiento;

    public AutorTO(String nombre, String apellido, int dni, int añoNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.añoNacimiento= añoNacimiento;
    }

    public int getAñoNacimiento() {
        return añoNacimiento;
    }

    public void setNumTracks(int numTracks) {
        this.numTracks = numTracks;
    }

    public void setAñoNacimiento(int añoNacimiento) {
        this.añoNacimiento = añoNacimiento;
    }

    public AutorTO(){}

    public int getSize (){return this.numTracks;}

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
