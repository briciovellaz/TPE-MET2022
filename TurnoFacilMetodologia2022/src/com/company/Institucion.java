package com.company;

import java.util.ArrayList;
import java.util.List;

public class Institucion {
    private ArrayList<Paciente> pacientes = new ArrayList<>();
    private List<Medico> medicos = new ArrayList<>();
    private List<Secretaria> secretarias = new ArrayList<>();
    private Responsable responsable;

    public Institucion() {
    }

    public Profesional validatePass(int DNI, String password, int index, int tipo) {
        switch (tipo) {
            case 1:
                if (index !=-1 && medicos.get(index).validarContrasenia(DNI, password))
                    return medicos.get(index);
                else return null;
            case 2:
                if (index !=-1 && secretarias.get(index).validarContrasenia(DNI, password))
                    return secretarias.get(index);
                else return null;
            case 3:
                if (index !=-1 && responsable.validarContrasenia(DNI, password))
                    return responsable;
                else return null;
            default:
                return null;
        }
    }

    public int buscarPosPaciente(int dni) {
        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i).getDNI() == dni)
                return i;
        }
        return -1;
    }

    public int buscarPosMedico(int dni) {
        for (int i = 0; i < medicos.size(); i++) {
            if (medicos.get(i).validarDNI(dni))
                return i;
        }
        return -1;
    }

    public int buscarPosSecretaria(int dni) {
        for (int i = 0; i < secretarias.size(); i++) {
            if (secretarias.get(i).validarDNI(dni))
                return i;
        }
        return -1;
    }

    public void darDeBajaMedico(int dni) {
        int index = buscarPosMedico(dni);
        if (index < medicos.size()){
            medicos.remove(index);
        }
    }

    public void darDeBajaSecretaria(int dni) {
        int index = buscarPosSecretaria(dni);
        if (index < secretarias.size() && index!=-1) {
           secretarias.remove(index);
        }
    }

    public boolean EsDNIResponsable(int DNI) {
        return (responsable.getDNI() == DNI);
    }

    public void agregar(Secretaria secretaria) {
        secretarias.add(secretaria);
    }

    public void agregar(Medico medico) {
        medicos.add(medico);
    }

    public void agregar(Paciente paciente) {
        pacientes.add(paciente);
    }

    public void agregar(Responsable responsable) {
        this.responsable = responsable;
    }

    public Profesional getProfesional(int index, int tipo) {
        switch (tipo) {
            case 1:
                return medicos.get(index);
            case 2:
                return secretarias.get(index);
            case 3:
                return responsable;
            default:
                return responsable;
        }
    }

    public Paciente getPaciente(int index) {
        return pacientes.get(index);
    }

    public Medico getMedico(int index){ return  medicos.get(index);}

    public Profesional logIn(String password, int dni, String s) {
        if (s.equals("m"))
            return validatePass(dni, password, this.buscarPosMedico(dni), 1);
        if (s.equals("s"))
            return validatePass(dni, password, this.buscarPosSecretaria(dni), 2);
        if (s.equals("r"))
            return validatePass(dni, password, 0, 3);
        return null;
    }

}
