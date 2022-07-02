package com.company;

import java.util.Scanner;

public class Responsable extends Profesional {
    //private Institucion institucion;//insitucion de la que es responsable

    public Responsable(String nombre, String contrasenia, int dni,String especialidad, String matricula, String domicilio,String curriculum, String descripcion, String email, int nroTel,Institucion inst) {
        super(nombre, contrasenia, dni, domicilio,curriculum, descripcion, email, nroTel,inst);
    }

    public void cargarMedico(String nombre, String contrasenia, int dni, String especialidad, String matricula, String domicilio,String curriculum, String descripcion, String email, int nroTel,Institucion inst) {
        Medico m = new Medico(nombre,contrasenia,dni, especialidad, matricula, domicilio,curriculum, descripcion, email, nroTel,inst);
    }

    public void cargarSecretaria(String nombre, String contrasenia, int dni,String especialidad, String matricula, String domicilio,String curriculum, String descripcion, String email, int nroTel,Institucion inst) {
        Secretaria s = new Secretaria(nombre, contrasenia, dni, especialidad, matricula, domicilio,curriculum, descripcion, email, nroTel,inst);
    }





}