package com.company;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //creo y completo institucion
        Institucion inst = new Institucion();
        inicializarIntitucion(inst);

        MenuGeneral menu = new MenuGeneral(inst);
        menu.IniciarMenu();

    }

    private static void  inicializarIntitucion(Institucion inst){
        Secretaria Esecretaria = new Secretaria("Maria Gimenez ","admin" , 50123123,"---","---","---","---","---","---",-1,inst);
        Responsable EResponsable = new Responsable("Luis Miguel","admin",10101010,"---","---","---","---","---","---",-1,inst);
        inst.agregar(EResponsable);
        Medico Emedico = new Medico("Juan Carlos","admin",50123124,"odontologo","6578","---","---","---","---",-1,inst);
        Esecretaria.agregarMedico(Emedico);
        Emedico.agregarHorario(0, LocalTime.of(9,0),LocalTime.of(12,0),20);
        Emedico.agregarHorario(1,LocalTime.of(9,0),LocalTime.of(12,0),20);
        Emedico.agregarHorario(2,LocalTime.of(9,0),LocalTime.of(12,0),20);
        Emedico.agregarHorario(3,LocalTime.of(9,0),LocalTime.of(12,0),20);
        Emedico.agregarHorario(4,LocalTime.of(9,0),LocalTime.of(12,0),20);
        Emedico.agregarHorario(5,LocalTime.of(9,0),LocalTime.of(12,0),20);
        Emedico.agregarHorario(6,LocalTime.of(9,0),LocalTime.of(12,0),20);
        inst.agregar(Esecretaria);
        Paciente paciente = new Paciente(12345000,"Abel","Pintos","yoTecuido");
        Paciente paciente2 = new Paciente(12345001,"Maria","Garcia","yoTecuido");
        Paciente paciente3 = new Paciente(40462573,"Melanie","Pugni","IOMA");
        Paciente paciente4 = new Paciente(43186121,"Noelia","Denk","IOMA");
        Paciente paciente5 = new Paciente(19091027,"Cha","Yanne","PAMI");
        inst.agregar(paciente);
        inst.agregar(Emedico);

        Esecretaria.asignarTurno(paciente,Emedico,LocalDate.of(2009,02,23),LocalTime.of(10,0));
        Esecretaria.asignarTurno(paciente2,Emedico,LocalDate.of(2009,02,23),LocalTime.of(10,0));
        Esecretaria.asignarTurno(paciente2,Emedico,LocalDate.of(2009,02,23),LocalTime.of(10,30));
        Esecretaria.asignarTurno(paciente2,Emedico,LocalDate.of(2009,02,23),LocalTime.of(13,0));
        Esecretaria.asignarTurno(paciente3,Emedico,LocalDate.of(2009,02,23),LocalTime.of(11,0));
        Esecretaria.asignarTurno(paciente4,Emedico,LocalDate.of(2009,02,23),LocalTime.of(9,30));

        Esecretaria.asignarTurno(paciente,Emedico,LocalDate.of(2020,02,23),LocalTime.of(15,0));
        Esecretaria.asignarTurno(paciente2,Emedico,LocalDate.of(2021,02,23),LocalTime.of(17,0));
        Esecretaria.asignarTurno(paciente2,Emedico,LocalDate.of(2022,02,23),LocalTime.of(18,0));
        Esecretaria.asignarTurno(paciente3,Emedico,LocalDate.of(2019,02,23),LocalTime.of(14,0));
        Esecretaria.asignarTurno(paciente4,Emedico,LocalDate.of(2009,02,23),LocalTime.of(19,30));

        Emedico = new Medico("Pepe Argento","admin",50123125,"pediatra","3536","---","---","---","---",-1,inst);
        Emedico.agregarHorario(0,LocalTime.of(14,0),LocalTime.of(19,0),20);
        Emedico.agregarHorario(1,LocalTime.of(14,0),LocalTime.of(19,0),20);
        Emedico.agregarHorario(2,LocalTime.of(14,0),LocalTime.of(19,0),20);
        Emedico.agregarHorario(3,LocalTime.of(14,0),LocalTime.of(19,0),20);
        Emedico.agregarHorario(4,LocalTime.of(14,0),LocalTime.of(19,0),20);
        Emedico.agregarHorario(5,LocalTime.of(14,0),LocalTime.of(19,0),20);
        Emedico.agregarHorario(6,LocalTime.of(16,0),LocalTime.of(18,0),30);
        Esecretaria.agregarMedico(Emedico);

    }
}
