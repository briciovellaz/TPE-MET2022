package com.company.filters;

import com.company.Turno;

import java.time.LocalTime;

public class FilterByShift extends Filter{
    private LocalTime inicio_tarde, fin_tarde;
    private String nombre;  //mañana, tarde, noche
    public FilterByShift(String nombre, int hora_inicio, int hora_fin){
        this.nombre = nombre;
        this.inicio_tarde = LocalTime.of(hora_inicio, 0);
        this.fin_tarde = LocalTime.of(hora_fin,59);
    }
    @Override
    public boolean evaluar(Object o) {
        try {
            return ((((Turno)o).getHoraInicio().isAfter(inicio_tarde)) && (((Turno)o).getHoraInicio().plusMinutes(((Turno)o).getDuracion())).isBefore(fin_tarde));
        } catch (Exception e){
            return false;
        }
    }
}
