package com.company;

import java.util.List;

public class Institucion {
    private List<Medico> medicos;
    private List<Secretaria> secretarias;
    private Responsable responsable;

    public Institucion(){}
    public boolean validatePassMedic (String password, int index){
        return medicos.get(index).validarContrasenia(password);
    }
    public int buscarPosMeadico(int dni){
        for(int i = 0;i<medicos.size();i++){
            if (medicos.get(i).validarDNI(dni))
                return i;
        }
        return -1;
    }
    public int buscarPosSecretaria(int dni){
        for(int i = 0;i<secretarias.size();i++){
            if (secretarias.get(i).validarDNI(dni))
                return i;
        }
        return -1;
    }
}
