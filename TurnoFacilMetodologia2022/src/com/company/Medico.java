package com.company;

import jdk.internal.util.xml.impl.Pair;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Map;

public class Medico extends Profesional{
    private String especialidad;
    private ArrayList<String> obrasSociales;
    private ArrayList<LocalTime> semana[] = new ArrayList[7]; // 0 = lunes
    private ArrayList<Turno> listaTurnos = new ArrayList<>();

    public void agregarHorario(int dia,LocalTime inicio,LocalTime fin){
       semana[dia].add(inicio);
       semana[dia].add(fin);
    }
    public ArrayList<LocalTime> listarHorario (int dia){
        return semana[dia];
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void borrarHorario(int dia, int indice){
        semana[dia].remove(indice);
    }

    public Medico(String nombre, String especialidad, String contrasenia,int dni) {
        super(nombre, contrasenia,dni);
        this.especialidad = especialidad;
    }
}
