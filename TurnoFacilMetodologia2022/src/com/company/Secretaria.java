package com.company;

import com.company.filters.Filter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Secretaria extends Profesional{
    private ArrayList<Medico> medicos = new ArrayList<Medico>();

    public Secretaria(String nombre, String contrasenia,int dni,String especialidad, String matricula, String domicilio,String curriculum, String descripcion, String email, int nroTel,Institucion inst){
        super(nombre,contrasenia,dni, domicilio,curriculum, descripcion, email, nroTel,inst);
    }


    public void agregarMedico(Medico m){
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

        public List<Turno> listarTurnos(int dia,Filter f){
        List<Turno> salida=new ArrayList<>();
        for(Medico m: medicos){
            for(int i=0;i<=7;i++){
                salida.addAll(m.listarTurnos(dia,f));
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
    //public void cargarTurno(Medico m, Turno t) ::: les puse el mismo nombre ya que hacen lo mismo
    public boolean asignarTurno(Medico m, Turno t){
        int i=0;
        while(i< medicos.size()&&!medicos.get(i).equals(m)){i++;}
        return medicos.get(i).agregarTurno(t);
    }


    public boolean asignarTurno(Paciente paciente, Medico medico, LocalDate fecha, LocalTime horaInicio){
        return asignarTurno(medico, new Turno(paciente, medico, fecha, horaInicio));
    }

    public boolean existeTurno(Turno t){
        Medico m=t.getMedico();
        int i=0;
        while( i<medicos.size() && !(medicos.get(i).equals(m)) ){i++;} // busco el medico
        if (i<medicos.size())
            return m.existeTurno(t);   // si existia delego al medico
        return false;
    }

    public void reasignarTurno(Turno t,Turno nuevo_turno){//LocalDate fecha,LocalTime hora_inicio,LocalTime hora_fin){
        if(existeTurno(t)){
            cancelarTurno(t);
            asignarTurno(t.getMedico(),nuevo_turno);
        }
    }

    public void cancelarTurno(Turno t){
        t.getPaciente().cancelarTurno(t);
    }

    public void asignarFranjaHoraria(Medico me ,int dia , LocalTime trabaja_desde , LocalTime trabaja_hasta , int duracion_de_turnos){
        int i=0;
        while( i<medicos.size() && !(me.equals(medicos.get(i)))) {i++;}
        if(i<medicos.size()) {
            me.agregarHorario(dia, trabaja_desde, trabaja_hasta, duracion_de_turnos);
        }
    }

    public ArrayList<Medico> getMedicos() {
        return medicos;
    }
}
