package com.company;

public class Responsable extends Profesional{

    public Responsable(String nombre,String contrasenia,int dni){
        super(nombre,contrasenia,dni);
    }

    public void cargarMedico(String nombre,String especialidad,String contrasenia,int dni,String matricula){
        Medico m=new Medico(nombre,especialidad,contrasenia,dni,matricula);
    }

    public void cargarSecretaria(String nombre, String contrasenia,int dni){
        Secretaria s=new Secretaria(nombre, contrasenia,dni);
    }
}
