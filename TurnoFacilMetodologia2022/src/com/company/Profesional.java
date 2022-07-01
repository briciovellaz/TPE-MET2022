package com.company;

public abstract class Profesional {
    private String nombre,contrasenia; //DNI se usara como idenficador de usuario
    private int DNI;
    private String domicilio;
    private String especialidad;
    private String descripcionPersonal;
    private String email;
    private int nroTelefono
    //consulta DNI si es igual devuelve true
    public boolean validarDNI(int DNI){
        return (DNI == this.DNI);
    }
    //consulta pass si es igual devuelve true
    public boolean validarContrasenia(int DNI,String contrasenia){
        return contrasenia.equals(this.contrasenia)&& this.DNI == DNI;
    }

    public Profesional(String nombre, String contrasenia, int dni, String domicilio, String especialidad, String des, String mail, int nro){
        this.nombre=nombre;
        this.contrasenia=contrasenia;
        this.DNI=dni;
        this.domicilio = domicilio;
        this.especialidad = especialidad;
        this.descripcionPersonal = des;
        this.email = mail;
        this.nroTelefono = nro;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDNI() {
        return DNI;
    }

    public String getDomicilio() { return domicilio;}

    public String getEspecialidad() { return especialidad;}

    public String getDescripcionPersonal(){ return descripcionPersonal;}

    public String getEmail(){ return email;}

    public int getNroTelefono() { return nroTelefono;}
}