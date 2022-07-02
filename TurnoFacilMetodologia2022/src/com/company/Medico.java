package com.company;

//import com.sun.org.apache.xml.internal.resolver.readers.ExtendedXMLCatalogReader;
import com.company.filters.Filter;
import jdk.internal.util.xml.impl.Pair;
//import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class Medico extends Profesional{
    private String especialidad,matricula;
    private ArrayList<String> obrasSociales = new ArrayList<>();
    private ArrayList<Horario> horarios[] = new ArrayList[7]; // 0 = lunes


    public Medico(String nombre,String contraseña,int DNI,String especialidad, String matricula, String domicilio,String curriculum, String descripcion, String email, int nroTel,Institucion inst){
        super(nombre,contraseña,DNI, domicilio,curriculum, descripcion, email, nroTel,inst);
        this.especialidad = especialidad;
        this.matricula = matricula;
        for (int i =0;i<7;i++){
            horarios[i] = new ArrayList<>();
        }
    }

    public Horario getHorario(int dia){
        return horarios[dia].get(dia);
    }
    public void agregarHorario(int dia,LocalTime inicio,LocalTime fin,int duracionTurno){
       Horario horario = new Horario(inicio,fin,duracionTurno);
       horarios[dia].add(horario);
    }

    public ArrayList<String> getObrasSociales() {
        return obrasSociales;
    }

    // dado una fecha busca en el dia de la semana los horarios y busca si ese horario en esa fecha esta libre en caso de estar libre lo agrega
    // a la lista que contiene las horas de inicio de los turno libres en dicha fecha
    public ArrayList<LocalTime> TurnosDisponibles(LocalDate dia){
        ArrayList<LocalTime> turnosDisponibles = new ArrayList<>();
        for(Horario horario:horarios[dia.getDayOfWeek().getValue()-1]){//recorre la lista horarios de un dia
            turnosDisponibles.addAll(horario.TurnosDisponibles(dia));//recupera los turnos disponibles de ese horario en ese dia
        }
        return turnosDisponibles;
    }
    public boolean agregarTurno(Turno turno){
        for(Horario horario : horarios[turno.getFecha().getDayOfWeek().getValue()-1]){
            if(horario.agregarTurno(turno)){
                return true;
            }
        }
        return false;
    }
    public boolean existeTurno(Turno t){
        int horario_dia=t.getFecha().getDayOfWeek().getValue()-1; // dia = (3-1)  == 2 == "miercoles"
        int i =0;
        Horario horario=horarios[horario_dia].get(horario_dia); // recupero el horario en el dia "X" del arr horarios
        return horario.existeTurno(t);
    }
    /*
    public void liberarTurno( Turno t){//el idea no me acepta el @notnull
        if(t!= null) {
            for (Horario horario : horarios[t.getFecha().getDayOfWeek().getValue()]) {
                if ((t.getHoraInicio() == horario.getHoraInic()) && (t.getHoraInicio().plusMinutes(t.getDuracion()) == horario.getHoraFin())) {
                    horario.borrarTurno(t);
                }
            }
        }
    }   */

    public ArrayList<Turno> listarTurnos(int dia){//lista todos los turnos de un dia
        ArrayList<Turno> turnos = new ArrayList<>();
        for(Horario horario: horarios[dia] ){
            turnos.addAll(horario.listarTurnos());
        }
        return turnos;
    }

    public ArrayList<Turno> listarTurnos(int dia, Filter f){//lista todos los turnos de un dia filtrados por franja horaria
        ArrayList<Turno> turnos = new ArrayList<>();
        for(Horario horario: horarios[dia] ){
                turnos.addAll(horario.listarTurnos(f)); //????
            }
        return turnos;
    }

    public ArrayList<Horario> listarHorario (int dia){
        return horarios[dia];
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setMatricula(String matricula){ this.matricula = matricula;}

    public void setObraSocial(String obS){
        if(!obrasSociales.contains(obS))
            this.obrasSociales.add(obS);
    }
    public void setEspecialidad(String esp){ this.especialidad = esp;}
    public String getMatricula() {
        return matricula;
    }

    @Override
    public boolean equals(Object obj) {
        try{
            return this.getMatricula().equals(((Medico)obj).getMatricula());
        }
        catch (Exception e){
            return false;
        }
    }
}
