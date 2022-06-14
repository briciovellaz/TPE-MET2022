package com.company.filters;

import com.company.Medico;

public class EspecialityFilter extends Filter {
    private String especialidad;

    public EspecialityFilter(String s){
        this.especialidad=s;
    }

    @Override
    public boolean evaluar(Object m) {
        try{
        return this.especialidad.equals(((Medico)m).getEspecialidad());
        } catch (Exception e){
            return false;
        }
    }
}
