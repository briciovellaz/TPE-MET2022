package com.company;

public abstract class Profesional {
    private String nombre,contrasenia; //DNI se usara como idenficador de usuario
    private int DNI;
    //consulta DNI si es igual devuelve true
    public boolean validarDNI(int DNI){
        return (DNI == this.DNI);
    }
    //consulta pass si es igual devuelve true
    public boolean validarContrasenia(int DNI,String contrasenia){
        return contrasenia.equals(this.contrasenia)&& this.DNI == DNI;
    }

    public Profesional(String nombre, String contrasenia, int dni){
        this.nombre=nombre;
        this.contrasenia=contrasenia;
        this.DNI=dni;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDNI() {
        return DNI;
    }
}