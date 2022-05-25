package com.company;

import java.time.LocalDate;
import java.time.LocalTime;

public class Turno{
    private Paciente paciente;
    private Medico medico;
    private LocalDate fecha;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    public boolean estaLibre(){
        return (paciente == null);
    }

    public Turno(Paciente paciente, Medico medico, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin) {
        this.paciente = paciente;
        this.medico = medico;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
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

    public LocalTime getHoraFin() {
        return horaFin;
    }
}
