package com.company;

import java.time.LocalDate;
import java.time.LocalTime;

public class Turno {
    private Paciente paciente;
    private Medico medico;
    private LocalDate fecha;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    public boolean estaLibre(){
        return (paciente == null);
    }
}
