package com.company;

import jdk.internal.util.xml.impl.Pair;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class Medico extends Profesional{
    private String especialidad;
    private ArrayList<String> obrasSociales;
    private ArrayList<Horario> horarios[] = new ArrayList[7]; // 0 = lunes


    public void agregarHorario(int dia,LocalTime inicio,LocalTime fin,int duracionTurno){
       Horario horario = new Horario(inicio,fin,duracionTurno);
       horarios[dia].add(horario);
    }

    // dado una fecha busca en el dia de la semana los horarios y busca si ese horario en esa fecha esta libre en caso de estar libre lo agrega
    // a la lista que contiene las horas de inicio de los turno libres en dicha fecha
    public ArrayList<LocalTime> TurnosDisponibles(LocalDate dia){
        ArrayList<LocalTime> turnosDisponibles = new ArrayList<>();
        for(Horario horario:horarios[dia.getDayOfWeek().getValue()]){//recorre la lista horarios de un dia
            turnosDisponibles.addAll(horario.TurnosDisponibles(dia));//recupera los turnos disponibles de ese horario en ese dia
        }
        return turnosDisponibles;
    }
    public boolean agregarTurno(Turno turno){
        for(Horario horario : horarios[turno.getFecha().getDayOfWeek().getValue()]){
            if(horario.agregarTurno(turno)){
                return true;
            }
        }
        return false;
    }

    public ArrayList<Turno> listarTurnos(int dia){//lista todos los turnos de un dia
        ArrayList<Turno> turnos = new ArrayList<>();
        for(Horario horario: horarios[dia] ){
            turnos.addAll(horario.listarTurnos());
        }
        return turnos;
    }

    public ArrayList<Horario> listarHorario (int dia){
        return horarios[dia];
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void borrarHorario(int dia, int indice){
        if(dia < 7 && dia > -1 && indice< horarios[dia].size() && indice > -1) {
            horarios[dia].remove(indice);
        }
    }

    public Medico(String nombre, String especialidad, String contrasenia,int dni) {
        super(nombre, contrasenia,dni);
        this.especialidad = especialidad;
    }
}
