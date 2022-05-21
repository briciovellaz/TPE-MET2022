package com.company;

import jdk.internal.util.xml.impl.Pair;

public abstract class Profesional {
    private String nombre,contraseña; //DNI se usara como idenficador de usuario
    private int DNI;
    //consulta DNI si es igual devuelve true
    public boolean validarDNI(int DNI){
        if(DNI == this.DNI){
            return true;
        }
        return false;
    }
    //consulta pass si es igual devuelve true
    public boolean validarContraseña(String Contraseña){
        if(contraseña == this.contraseña){
            return true;
        }
        return false;
    }
}