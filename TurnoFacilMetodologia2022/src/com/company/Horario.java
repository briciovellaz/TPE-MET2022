package com.company;

import java.time.LocalTime;

public class Horario {
    private LocalTime horaInic,horaFin;
    private int duracion;

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
}
