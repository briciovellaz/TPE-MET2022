package com.company;

import com.company.filters.Filter;

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

    public void borrarTurno(int index){
        turnos.remove(index);
    }
    public int getDuracion() {
        return duracion;
    }
    public ArrayList<LocalTime> TurnosDisponibles(LocalDate dia){
        ArrayList<LocalTime> turnosDisponibles = new ArrayList<>();
        for(LocalTime i = horaInic;i.isBefore(horaFin);i=i.plusMinutes(duracion)) {//recorre todos los horarios de inicio posibles
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
    public ArrayList<Turno> listarTurnos(){return new ArrayList<>(turnos); }//devuelve lista de turnos

         public ArrayList<Turno> listarTurnos(Filter f){
        ArrayList<Turno> salida=new ArrayList<>();
        for(Turno t:turnos){
            if (f.evaluar(t)) {
                salida.add(t);
            }
        }
        return salida;
    }
    public boolean existeTurno(Turno t){
        return turnos.contains(t);

    }
    public boolean agregarTurno(Turno turno){ //agrega un turno
        if(turno.getHoraInicio().isBefore(horaFin) && turno.getHoraInicio().plusMinutes(turno.getDuracion()).isAfter(horaInic)){
            turno.setDuracion(duracion);
            turnos.add(turno);
            return true;
        }
        return false;
    }


    private Turno getTurno(int index){ // rompe encapsulamiento ??
        return turnos.get(index);
    }
    @Override
    public boolean equals(Object o){
        if(        this.getDuracion() == ((Horario)o).getDuracion()
                && this.getHoraFin().equals(((Horario)o).getHoraFin())
                && this.getHoraInic().equals(((Horario)o).getHoraInic()) ){
            int i=0;
            while( i<turnos.size()) {// compara los turnos de este horario con los del otro sean iguales
                if (!this.turnos.get(i).equals(((Horario) o).getTurno(i))) // Los arr deben estar ordenados :: si el turno en la pos i es igual al del otro horario en la misma posicion seran iguales
                    return false;
                i++;
            }
            return true;
        }
        else return false;



    }
}



