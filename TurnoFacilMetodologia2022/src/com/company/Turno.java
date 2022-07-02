package com.company;

import java.time.LocalDate;
import java.time.LocalTime;

public class Turno{
    private Paciente paciente;
    private Medico medico;
    private LocalDate fecha;
    private LocalTime horaInicio;
    //private LocalTime horaFin;
    private int duracion;
    public boolean estaLibre(){
        return (paciente == null);
    }

    //constructor de turno y se agrega a paciente y medico
    public Turno(Paciente paciente, Medico medico, LocalDate fecha, LocalTime horaInicio) {
        this.paciente = paciente;
        this.medico = medico;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        //this.horaFin = horaFin;
        paciente.agregarTurno(this);
        medico.agregarTurno(this);
    }

    public void liberarTurno(){//falta borrar el turno de la lista de turnos del paciente
        this.paciente=null;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    /*public LocalTime getHoraFin() {
        return horaFin;
        //
    }*/

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Override
    public boolean equals(Object obj) {
        try{
            return (   this.getMedico().equals(((Turno)obj).getMedico())
                    && this.getFecha().equals(((Turno)obj).getFecha())
                    && this.getHoraInicio().equals(((Turno)obj).getHoraInicio())
                    //&& this.getHoraFin().equals(((Turno)obj).getHoraFin())
                    && this.getPaciente().equals(((Turno)obj).getPaciente())  );
        }
        catch (Exception e){
            return false;
        }
    }
}
