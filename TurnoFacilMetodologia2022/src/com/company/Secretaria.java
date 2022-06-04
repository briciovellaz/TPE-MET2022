package com.company;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Secretaria extends Profesional{
    private ArrayList<Medico> medicos = new ArrayList<Medico>();

    public Secretaria(String nombre, String contrasenia,int dni){
        super(nombre,contrasenia,dni);
    }

    public void addMedico(Medico m){
        medicos.add(m);
    }

    public List<Turno> listarTurnos(){
        List<Turno> salida=new ArrayList<>();
        for(Medico m: medicos){
            for(int i=0;i<=7;i++){
            salida.addAll(m.listarTurnos(i));
            }
        }
        return salida;
    }

    public void cargarHorarios(Medico m, LocalTime horaInicio, LocalTime horaFin,int duracion, int...dias){
        if(medicos.contains(m)){
            int i=0;
            while(i< medicos.size()&&!medicos.get(i).equals(m)){i++;}
            for(int d:dias){
                medicos.get(i).agregarHorario(d,horaInicio,horaFin,duracion);
            }
        }
    }
}
