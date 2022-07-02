package com.company;

import java.time.LocalDate;
import java.time.LocalTime;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //creo y completo institucion
        Institucion inst = new Institucion();
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
        inst.agregar(new Paciente(12345678,"Abel","Pintos","yoTecuido"));
        inst.agregar(Emedico);
        Emedico = new Medico("Pepe Argento","admin",50123125,"pediatra","3536","---","---","---","---",-1,inst);
        Emedico.agregarHorario(0,LocalTime.of(14,0),LocalTime.of(19,0),20);
        Emedico.agregarHorario(1,LocalTime.of(14,0),LocalTime.of(19,0),20);
        Emedico.agregarHorario(2,LocalTime.of(14,0),LocalTime.of(19,0),20);
        Emedico.agregarHorario(3,LocalTime.of(14,0),LocalTime.of(19,0),20);
        Emedico.agregarHorario(4,LocalTime.of(14,0),LocalTime.of(19,0),20);
        Emedico.agregarHorario(5,LocalTime.of(14,0),LocalTime.of(19,0),20);
        Emedico.agregarHorario(6,LocalTime.of(16,0),LocalTime.of(18,0),30);
        Esecretaria.agregarMedico(Emedico);

        MenuGeneral menu = new MenuGeneral(inst);
        menu.IniciarMenu();

    }
}
