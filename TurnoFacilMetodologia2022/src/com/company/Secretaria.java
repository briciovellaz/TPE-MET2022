package com.company;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Secretaria extends Profesional{
    private ArrayList<Medico> medicos = new ArrayList<Medico>();

    public Secretaria(String nombre, String contrasenia,int dni){
        super(nombre,contrasenia,dni);
    }

    public void addMedico(Medico m){
        medicos.add(m);
    }

    public List<Turno> listarTurnos(){
        List<Turno> salida=new ArrayList<>();
        for(Medico m: medicos){
            for(int i=0;i<=7;i++){
            salida.addAll(m.listarTurnos(i));
            }
        }
        return salida;
    }

    public void cargarHorarios(Medico m, LocalTime horaInicio, LocalTime horaFin,int duracion, int...dias){
        if(medicos.contains(m)){
            int i=0;
            while(i< medicos.size()&&!medicos.get(i).equals(m)){i++;}
            for(int d:dias){
                medicos.get(i).agregarHorario(d,horaInicio,horaFin,duracion);
            }
        }
    }

    public void cargarTurno(Medico m, Turno t){
        int i=0;
        while(i< medicos.size()&&!medicos.get(i).equals(m)){i++;}
        medicos.get(i).agregarTurno(t);
    }

    public void asignarTurno(Paciente paciente, Medico medico, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin){
        cargarTurno(medico, new Turno(paciente, medico, fecha, horaInicio, horaFin));
    }
    /*
    public boolean existeTurno(Turno t){

    }

    public void reasignarTurno(Turno t){
        if(existeTurno(t)){
            cancelarTurno(t);
            asignarTurno();
        }
    } */

    public void cancelarTurno(Turno t){
        t.getMedico().liberarTurno(t);
    }

    public void asignarFranjaHoraria(Medico me ,int dia , LocalTime trabaja_desde , LocalTime trabaja_hasta , int duracion_de_turnos){
        int i=0;
        while( i<medicos.size() && !(me.equals(medicos.get(i)))) {i++;}
        if(i<medicos.size()) {
            me.agregarHorario(dia, trabaja_desde, trabaja_hasta, duracion_de_turnos);
        }
    }

    public ArrayList<Medico> getMedicos() {
        return medicos;
    }
}
