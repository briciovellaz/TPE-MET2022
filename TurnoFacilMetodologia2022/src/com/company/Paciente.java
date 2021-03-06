package com.company;

import java.util.ArrayList;
import java.util.List;
import com.company.filters.Filter;

public class Paciente {
    private ArrayList<Turno> turnos = new ArrayList<>();
    private int DNI;
    private String nombre,apellido,obraSocial;
    
    Paciente(int DNI,String nombre,String apellido,String obraSocial){
        this.DNI = DNI;
        this.nombre =nombre;
        this.apellido = apellido;
        this.obraSocial = obraSocial;
    }

    public int getDNI() {
        return DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarTurno(Turno turno){ turnos.add(turno); }

    public ArrayList<Turno> listarTurnos(){
        return new ArrayList<>(turnos);
    }

    public void borrarTurno(int index){
        turnos.remove(index);
    }

    public Turno getTurno(int index){return turnos.get(index);}

    public void cancelarTurno(Turno t){
        int i;
        for(i=0; i<turnos.size(); i++){
            if(t.equals(turnos.get(i))){
                borrarTurno(i);
            }
        }
    }
}
