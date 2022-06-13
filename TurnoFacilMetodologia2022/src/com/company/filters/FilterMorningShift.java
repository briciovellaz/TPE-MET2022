package com.company.filters;

import com.company.Medico;

public class FilterMorningShift extends Filter {

    private int fin_maniana;

    public FilterMorningShift(int hora){
        this.fin_maniana = hora;
    }
    @Override
    public boolean evaluar(Medico m/* , int dia */) {
       // return m.getHorario(dia).getHoraFin().isBefore(fin_maniana);

        return true; //borrar, es solo para que compile
    }
}
