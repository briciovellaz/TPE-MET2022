package com.company;

import java.util.ArrayList;

public class Secretaria extends Profesional{
    private ArrayList<Medico> medicos = new ArrayList<Medico>();

    public Secretaria(String nombre, String contrasenia,int dni){
        super(nombre,contrasenia,dni);
    }

    public void addMedico(Medico m){
        medicos.add(m);
    }
}
