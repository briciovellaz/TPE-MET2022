package com.company.filters;

import com.company.Turno;
import java.time.LocalTime;

public class FilterMorningShift extends Filter {

    private LocalTime fin_maniana;

    public FilterMorningShift(int hora){
        this.fin_maniana = LocalTime.of(hora,0);
    }

    @Override
    public boolean evaluar(Object o) {
        try {
            return ((Turno)o).getHoraInicio().isBefore(fin_maniana);
        } catch (Exception e){
            return false;
        }
    }
}
