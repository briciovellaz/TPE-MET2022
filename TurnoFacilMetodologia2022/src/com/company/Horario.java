package com.company;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Horario {
    private LocalTime horaInic,horaFin;
    private int duracion;
    private ArrayList<Turno> turnos = new ArrayList<>();

    Horario(LocalTime horaInic,LocalTime horaFin,int duracion){
        this.horaInic = horaInic;
        this.horaFin = horaFin;
        this.duracion = duracion;
    }

    public LocalTime getHoraInic() {
        return horaInic;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public int getDuracion() {
        return duracion;
    }
    public ArrayList<LocalTime> TurnosDisponibles(LocalDate dia){
        ArrayList<LocalTime> turnosDisponibles = new ArrayList<>();
        for(LocalTime i = horaInic;i.isBefore(horaFin);i.plusMinutes(duracion)) {//recorre todos los horarios de inicio posibles
            boolean libre = true;//        ----8   8:30 9 9:30     -> 29/05  si hay turno con fecha() -> si  que hora? esta ocupada?
            for (Turno turno : turnos) {//recorre la lista de todos los turnos del medico
                if (turno.getFecha().isEqual(dia) && i.equals(turno.getHoraInicio())) {//pregunta si existe otro turno con misma fecha y horario
                    libre = false;
                }
            }
            if (libre) {/*agrega la hora de inicio del posible turno */
                turnosDisponibles.add(i);
            }
        }
        return turnosDisponibles;
    }
    public ArrayList<Turno> listarTurnos(){
        return turnos;
    }//devuelve lista de turnos

    public boolean agregarTurno(Turno turno){ //agrega un turno
        if(turno.getHoraInicio().isBefore(horaFin) && turno.getHoraFin().isAfter(horaInic)){
            turnos.add(turno);

        }
        return false;
    }
}
