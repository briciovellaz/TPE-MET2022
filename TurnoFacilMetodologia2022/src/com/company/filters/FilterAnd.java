package com.company.filters;

import com.company.Medico;

public class FilterAnd extends Filter {
    private Filter f1;
    private Filter f2;

    public FilterAnd (Filter f1, Filter f2){
        this.f1 = f1;
        this.f2 = f2;
    }

    public boolean evaluar(Object o) {
        return (f1.evaluar(o) && f2.evaluar(o));
    }
}
