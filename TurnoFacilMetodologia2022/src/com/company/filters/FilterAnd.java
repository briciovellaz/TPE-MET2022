package com.company.filters;

import com.company.Medico;

public class FilterAnd extends Filter {
    private Filter f1;
    private Filter f2;

    public FilterAnd (Filter f1, Filter f2){
        this.f1 = f1;
        this.f2 = f2;
    }

    @Override
    public boolean evaluar(Medico m) {
        return (f1.evaluar(m) && f2.evaluar(m));
    }
}
