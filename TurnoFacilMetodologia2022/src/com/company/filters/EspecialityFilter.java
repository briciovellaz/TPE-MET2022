package com.company.filters;

import com.company.Medico;

public class EspecialityFilter extends Filter{
    private String especialidad;

    public EspecialityFilter(String s){
        this.especialidad=s;
    }

    @Override
    public boolean evaluar(Medico m) {
        return this.especialidad==m.getEspecialidad();
    }
}
