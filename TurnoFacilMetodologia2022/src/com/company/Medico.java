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
    private ArrayList<Turno> listaTurnos = new ArrayList<>();

    public void agregarHorario(int dia,LocalTime inicio,LocalTime fin,int duracionTurno){
       Horario horario = new Horario(inicio,fin,duracionTurno);
       horarios[dia].add(horario);
    }

    // dado una fecha busca en el dia de la semana los horarios y busca si ese horario en esa fecha esta libre en caso de estar libre lo agrega
    // a la lista que contiene las horas de inicio de los turno libres en dicha fecha
    public ArrayList<LocalTime> TurnosDisponibles(LocalDate dia){
        ArrayList<LocalTime> turnosDisponibles = new ArrayList<>();
        for(Horario horario:horarios[dia.getDayOfWeek().getValue()]){//recorre la lista horarios de un dia
            for(LocalTime i = horario.getHoraInic();i.isBefore(horario.getHoraFin());i.plusMinutes(horario.getDuracion())) {//recorre todos los horarios de inicio posibles
                boolean libre = true;//        ----8   8:30 9 9:30     -> 29/05  si hay turno con fecha() -> si  que hora? esta ocupada?
                for (Turno turno : listaTurnos) {//recorre la lista de todos los turnos del medico
                    if (turno.getFecha().isEqual(dia) && i.equals(turno.getHoraInicio())) {//pregunta si existe otro turno con misma fecha y horario
                        libre = false;
                    }
                }
                if (libre) {
                    turnosDisponibles.add(i);
                }/*agrega la hora de inicio del posible turno */
            }
        }
        return turnosDisponibles;
    }

    public ArrayList<Turno> listarTurnos(){
        return listaTurnos;
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
