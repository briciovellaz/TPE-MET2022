package com.company.filters;

import com.company.Medico;

public class FilterNot extends Filter {
    private Filter f1;

    public FilterNot(Filter f1) {
        this.f1 = f1;
    }

    @Override
    public boolean evaluar(Medico C) {
        return (!f1.evaluar(C));
    }
}
