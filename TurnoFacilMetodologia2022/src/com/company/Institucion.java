package com.company;

import java.util.ArrayList;
import java.util.List;

public class Institucion {
    private ArrayList<Paciente> pacientes = new ArrayList<>();
    private List<Medico> medicos = new ArrayList<>();
    private List<Secretaria> secretarias = new ArrayList<>();
    private Responsable responsable;

    public Institucion(){}
    public boolean validatePass(int DNI,String password, int index,int tipo){
        switch (tipo){
            case 1: return medicos.get(index).validarContrasenia(DNI,password);
            case 2: return secretarias.get(index).validarContrasenia(DNI,password);
            case 3: return responsable.validarContrasenia(DNI,password);
            default: return false;
        }
    }
    public int buscarPosPaciente(int dni){
        for(int i = 0;i<pacientes.size();i++){
            if (pacientes.get(i).getDNI() == dni)
                return i;
        }
        return -1;
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

    public void agregar(Secretaria secretaria){
        secretarias.add(secretaria);
    }
    public void agregar(Medico medico){
        medicos.add(medico);
    }
    public void agregar(Paciente paciente){
        pacientes.add(paciente);
    }
    public void agregar(Responsable responsable){
        responsable = responsable;
    }
    public Profesional getProfesional(int index,int tipo) {
        switch (tipo){
            case 1: return medicos.get(index);
            case 2: return secretarias.get(index);
            case 3: return responsable;
            default: return responsable;
        }
    }
}
