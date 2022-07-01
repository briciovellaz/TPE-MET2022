package com.company;

//import sun.util.calendar.BaseCalendar;

import com.company.filters.FilterMorningShift;
import sun.security.x509.OtherName;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InterfaceProfesional {

    public static void main(String[] args) {
        //creo y completo institucion
        Institucion inst = new Institucion();
        Secretaria Esecretaria = new Secretaria("Maria Gimenez ","admin" , 50123123);
        Responsable EResponsable = new Responsable("Luis Miguel","admin",10101010);
        inst.agregar(EResponsable);
        Medico Emedico = new Medico("Juan Carlos","admin",50123124,"odontologo","6578");
        Esecretaria.agregarMedico(Emedico);
        Emedico.agregarHorario(0,LocalTime.of(9,0),LocalTime.of(12,0),20);
        Emedico.agregarHorario(1,LocalTime.of(9,0),LocalTime.of(12,0),20);
        Emedico.agregarHorario(2,LocalTime.of(9,0),LocalTime.of(12,0),20);
        Emedico.agregarHorario(3,LocalTime.of(9,0),LocalTime.of(12,0),20);
        Emedico.agregarHorario(4,LocalTime.of(9,0),LocalTime.of(12,0),20);
        Emedico.agregarHorario(5,LocalTime.of(9,0),LocalTime.of(12,0),20);
        Emedico.agregarHorario(6,LocalTime.of(9,0),LocalTime.of(12,0),20);
        inst.agregar(Esecretaria);
        inst.agregar(new Paciente(12345678,"Abel","Pintos","yoTecuido"));
        inst.agregar(Emedico);
        Emedico = new Medico("Pepe Argento","admin",50123125,"pediatra","3536");
        Emedico.agregarHorario(0,LocalTime.of(14,0),LocalTime.of(19,0),20);
        Emedico.agregarHorario(1,LocalTime.of(14,0),LocalTime.of(19,0),20);
        Emedico.agregarHorario(2,LocalTime.of(14,0),LocalTime.of(19,0),20);
        Emedico.agregarHorario(3,LocalTime.of(14,0),LocalTime.of(19,0),20);
        Emedico.agregarHorario(4,LocalTime.of(14,0),LocalTime.of(19,0),20);
        Emedico.agregarHorario(5,LocalTime.of(14,0),LocalTime.of(19,0),20);
        Emedico.agregarHorario(6,LocalTime.of(16,0),LocalTime.of(18,0),30);
        Esecretaria.agregarMedico(Emedico);


        //variables
        Scanner sn = new Scanner(System.in),teclado= new Scanner(System.in),sn2 = new Scanner(System.in);
        boolean passvalida = false,salir = false;
        int opcion = 0,DNI,index=0,tries = 0;
        Profesional sesionActiva = null;
        String contrasenia;

        /////////lineas para sistema inicio de sesion
        while (!salir) {

            System.out.println("---Bienvenido al sistema de turnoFacil para profesionales de la salud---");
            System.out.println("elija su rol");
            System.out.println("1. MEDICO");
            System.out.println("2. SECRETARIA");
            System.out.println("3. Responsable");
            System.out.println("4. Salir");

            try {

                opcion = sn.nextInt();

                switch (opcion) {
                    case 1://medico
                        do {
                            System.out.println("INGRESE SU DOCUMENTO");
                            DNI = sn2.nextInt();
                            index = inst.buscarPosMeadico(DNI);
                            tries++;
                            if (index == -1) {
                                System.out.println("EL DNI NO SE ENCUENTRA REGISTRADO");
                            }
                        } while (index == -1 && tries < 3);
                        tries = 0;
                        if (index != -1) {
                            do {
                                System.out.println("INGRESE SU CONTRASEÑA");
                                contrasenia = teclado.nextLine();
                                passvalida = inst.validatePass(DNI,contrasenia,index,opcion);
                                tries ++;
                                if (!passvalida) {
                                    System.out.println("LA CONTRASEÑA ES INCORRECTA");
                                }else{
                                    System.out.println("Inicio de sesion correcto, bienvenido");
                                    sesionActiva = inst.getProfesional(index,opcion);
                                    salir = true;
                                    break;
                                }
                            } while(tries < 3 );

                        }
                        break;
                    case 2://secretaria
                        do {
                            System.out.println("INGRESE SU DOCUMENTO");
                            DNI = sn2.nextInt();
                            index = inst.buscarPosSecretaria(DNI);
                            tries++;
                            if (index == -1) {
                                System.out.println("EL DNI NO SE ENCUENTRA REGISTRADO");

                            }
                        } while (index == -1 && tries < 3);
                        tries = 0;
                        if (index != -1) {
                            do {
                                System.out.println("INGRESE SU CONTRASEÑA");
                                contrasenia = teclado.nextLine();
                                passvalida = inst.validatePass(DNI,contrasenia,index,opcion);
                                tries ++;
                                if (!passvalida) {
                                    System.out.println("LA CONTRASEÑA ES INCORRECTA");
                                } else{
                                    System.out.println("Inicio de sesion correcto");
                                    sesionActiva = inst.getProfesional(index,opcion);
                                    salir = true;
                                    break;
                                }
                            } while(tries < 3 );
                        }
                        break;
                    case 3: //responsable
                        //por implementar
                        do {
                            System.out.println("INGRESE SU DOCUMENTO");
                            DNI = sn2.nextInt();
                            tries++;
                            if (!inst.EsDNIResponsable(DNI)) {
                                System.out.println("EL DNI NO SE ENCUENTRA REGISTRADO");
                                index =-1;
                            }else {
                                index = 1;
                            }
                        } while (index == -1 && tries < 3);
                        tries = 0;
                        if (index != -1) {
                            do {
                                System.out.println("INGRESE SU CONTRASEÑA");
                                contrasenia = teclado.nextLine();
                                passvalida = inst.validatePass(DNI,contrasenia,index,opcion);
                                tries ++;
                                if (!passvalida) {
                                    System.out.println("LA CONTRASEÑA ES INCORRECTA");
                                } else{
                                    System.out.println("Inicio de sesion correcto");
                                    sesionActiva = inst.getProfesional(index,opcion);
                                    salir = true;
                                    break;
                                }
                            } while(tries < 3 );
                        }
                        break;
                    case 4 :
                        System.out.println("programa terminado");
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 4");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }

        //menu de responsable
        if(passvalida && opcion == 3){
            System.out.println("Sesion iniciada como responsable");
            System.out.println("Bienvenido " + sesionActiva.getNombre());
        }



        //menu para secretaria si esta logueada correctamente
        if(passvalida && opcion ==2){
            System.out.print("\033[H\033[2J");//limpia consola no del compilador
            System.out.flush();
            System.out.println("Bienvenido " + sesionActiva.getNombre());
            Secretaria secretariaActiva = (Secretaria) sesionActiva;
            salir = false;
            while (!salir){
                System.out.println("----elija la opcion----");
                System.out.println("1-cargar turno");
                System.out.println("2-cancelar turno");
                System.out.println("3- ver turnos filtrando");
                System.out.println("4-asignar franja horaria a un medico");
                System.out.println("5-listar medicos a cargo");
                System.out.println("6-reasignar turnos");
                System.out.println("7-salir");

                opcion = sn2.nextInt();
                switch (opcion){
                    case 1: {//funciona
                        System.out.println("---cargar turno---");
                        int DNIPaciente,DNIMedico;
                        Medico medico;
                        Paciente paciente;
                        //solicita DNI paciente y consulta si existe
                        do {
                            System.out.println("ingrese DNI del paciente o 0 para volver al menu");
                            DNIPaciente = sn2.nextInt();
                            if(DNIPaciente ==0){break;}
                            index = inst.buscarPosPaciente(DNIPaciente);
                            if(index == -1){
                                System.out.println("el DNI de paciente no existe");
                            }
                        } while (index == -1);
                        if(DNIPaciente ==0){break;}
                        paciente = inst.getPaciente(index);
                        //solicita DNI medico y consulta si existe
                        do {
                            System.out.println("ingrese DNI del medico o 0 para volver al menu");
                            DNIMedico = sn2.nextInt();
                            if(DNIMedico ==0){break;}
                            index = inst.buscarPosMeadico(DNIMedico);
                            if(index == -1){
                                System.out.println("el DNI del medico no existe");
                            }
                        } while (index == -1);
                        if(DNIMedico ==0){break;}
                        medico = (Medico) inst.getProfesional(index,1);
                        System.out.println("DNI medico y paciente correctos");

                        //fecha
                        System.out.println("ingrese el dia del turno");
                        int dia = sn2.nextInt();
                        while (dia < 1 || dia > 31)  {
                            System.out.println("ingrese una dia valido");
                            dia = sn2.nextInt();
                            }
                        System.out.println("ingrese el mes del turno");
                        int mes = sn2.nextInt();
                        while (mes < 1 || mes >12)  {
                            System.out.println("ingrese un mes valido");
                            mes = sn2.nextInt();
                            }
                        System.out.println("ingrese el año del turno");
                        int año = sn2.nextInt();
                        while (año < LocalDate.now().getYear())  {
                            System.out.println("ingrese un año valido");
                            año = sn2.nextInt();
                            }
                        LocalDate fecha = LocalDate.of(año,mes,dia);
                        System.out.println("turnos disponibles del dia" + fecha);
                        int j=0;
                        ArrayList<LocalTime> disponibles = medico.TurnosDisponibles(fecha);
                        for(LocalTime inicDisponible :disponibles){
                            System.out.println(j + ": "+inicDisponible);
                            j++;
                        }
                        //inicio hora
                        System.out.println("ingrese el numero del horario que desee");
                        int numero = sn2.nextInt();

                        LocalTime timeInicio = disponibles.get(numero);


                        //el constructor de turno se agrega a si mismo  a la lista de turnos de medico y paciente
                        Turno turno = new Turno(paciente,medico,fecha,timeInicio);

                        System.out.println("turno de paciente " + turno.getPaciente().getDNI() + " con el medico " +turno.getMedico().getDNI() +" el dia "+ turno.getFecha() + " "+ turno.getHoraInicio()  +" fue agregado correctamente");

                        System.out.println("presione una tecla para continuar");
                        teclado.next();
                        break;
                    }
                    case 2: {//hacer
                        System.out.println("---cancelar un turno---");
                        int k =0;
                        Paciente paciente;
                        int DNIPaciente;
                        do {
                            System.out.println("ingrese DNI del paciente o 0 para volver al menu");
                            DNIPaciente = sn2.nextInt();
                            if(DNIPaciente ==0){break;}
                            index = inst.buscarPosPaciente(DNIPaciente);
                            if(index == -1){
                                System.out.println("el DNI de paciente no existe");
                            }
                        } while (index == -1);
                        if(DNIPaciente ==0){break;}
                        paciente = inst.getPaciente(index);
                        for(Turno turno:paciente.listarTurnos()){
                            System.out.println(k + turno.getFecha().toString() + turno.getHoraInicio().toString() +"medico" +turno.getMedico().getDNI());
                            k++;
                        }
                        System.out.println("ingrese numero de turno a cancelar");
                        int numero = sn2.nextInt();
                        paciente.borrarTurno(numero);

                        System.out.println("presione una tecla para continuar");
                        teclado.next();
                        break;}
                    case 3: {//hacer

                        System.out.println("---ver turnos filtrando---");
                        System.out.println("ingrese dia para listar sus turnos");
                        int numero = sn2.nextInt();
                        System.out.println("ingrese horario para listar sus turnos");
                        int horario=sn2.nextInt();
                        for(Turno t:secretariaActiva.listarTurnos(horario,new FilterMorningShift(horario))){
                            System.out.println( t.getFecha().toString() + " " + t.getHoraInicio().toString() +"  Medico: " + t.getMedico().getNombre() + " DNI " +t.getMedico().getDNI() );
                        }

                        System.out.println("presione una tecla para continuar");
                        teclado.next();
                        break;
                    }
                    case 4: { // funciona correctamente pero no tiene chequeo de datos
                        System.out.println("---asignar franja horaria a un medico---");
                        int DNIMedico;
                        Medico medico = null;
                        do {
                            System.out.println("ingrese DNI del medico o 0 para volver al menu");
                            DNIMedico = sn2.nextInt();
                            if(DNIMedico ==0){break;}
                            index = inst.buscarPosMeadico(DNIMedico);
                            if(index == -1){
                                System.out.println("el DNI del medico no existe");
                            }else{
                                medico = (Medico) inst.getProfesional(index,1);
                                System.out.println("medico seleccionado: " + medico.getDNI() +" "+ medico.getMatricula()+" "+ medico.getNombre() +" "+ medico.getEspecialidad() );
                            }
                        } while (index == -1);
                        if(DNIMedico ==0){break;}
                        //fecha
                        System.out.println("ingrese el dia de la semana, 0=lunes");
                        int dia = sn2.nextInt();

                        System.out.println("ingrese la duracion de los turnos en ese horario");
                        int duracion = sn2.nextInt();

                        //inicio hora
                        System.out.println("ingrese la hora de inicio");
                        int horaInicio = sn2.nextInt();
                        System.out.println("ingrese los minutos de la hora de inicio");
                        int minutosInicio = sn2.nextInt();
                        LocalTime timeInicio = LocalTime.of(horaInicio,minutosInicio);
                        //hora fin
                        System.out.println("ingrese la hora de fin");
                        int horaFin = sn2.nextInt();
                        System.out.println("ingrese los minutos de la hora de fin");
                        int minutosFin = sn2.nextInt();
                        LocalTime timeFin = LocalTime.of(horaFin,horaInicio);
                        medico.agregarHorario(dia,timeInicio,timeFin,duracion);

                        System.out.println("horario cargado a "+ medico.getNombre() +" con DNI " + medico.getDNI()+ " correctamente");

                        System.out.println("presione una tecla para continuar");
                        teclado.next();
                        break;
                    }
                    case 5:{//funciona correctamente
                        System.out.println("---lista de medicos a cargo---");
                        System.out.println("DNI,matricula,nombre,obras sociales que atiende");
                        for (Medico medico:secretariaActiva.getMedicos()){
                            System.out.println(medico.getDNI() +" "+ medico.getMatricula() +" " + medico.getNombre() +""+ medico.getEspecialidad() +" "+medico.getObrasSociales());
                        }

                        System.out.println("presione una tecla para continuar");
                        teclado.next();
                        break;
                    }
                    case 6:{//hacer
                        System.out.println("---reasignar turno---");
                        Paciente paciente;
                        int DNIPaciente;
                        do {
                            System.out.println("ingrese DNI del paciente o 0 para volver al menu");
                            DNIPaciente = sn2.nextInt();
                            if(DNIPaciente ==0){break;}
                            index = inst.buscarPosPaciente(DNIPaciente);
                            if(index == -1){
                                System.out.println("el DNI de paciente no existe");
                            }
                        } while (index == -1);
                        if(DNIPaciente ==0){break;}
                        paciente = inst.getPaciente(index);
                        int k =0;
                        for(Turno turno:paciente.listarTurnos()){
                            System.out.println(k + turno.getFecha().toString() + turno.getHoraInicio().toString() +"medico" +turno.getMedico().getDNI());
                            k++;
                        }
                        System.out.println("ingrese numero de turno a reasignar");
                        int numero = sn2.nextInt();
                        Turno turnoAMod = paciente.getTurno(numero);
                        System.out.println("ingrese el nuevo dia del turno");
                        int dia = sn2.nextInt();
                        while (dia < 1 || dia > 31)  {
                            System.out.println("ingrese un dia valido");
                            dia = sn2.nextInt();
                        }
                        System.out.println("ingrese el nuevo mes del turno");
                        int mes = sn2.nextInt();
                        while (mes < 1 || mes >12)  {
                            System.out.println("ingrese un mes valido");
                            mes = sn2.nextInt();
                        }
                        System.out.println("ingrese el nuevo año del turno");
                        int año = sn2.nextInt();
                        while (año < LocalDate.now().getYear())  {
                            System.out.println("ingrese un año valido");
                            año = sn2.nextInt();
                        }
                        LocalDate fecha = LocalDate.of(año,mes,dia);
                        System.out.println("turnos disponibles del dia" + fecha);
                        int j=0;
                        ArrayList<LocalTime> disponibles = turnoAMod.getMedico().TurnosDisponibles(fecha);
                        for(LocalTime inicDisponible :disponibles){
                            System.out.println(j + ": "+inicDisponible);
                            j++;
                        }
                        //inicio hora
                        System.out.println("ingrese el numero del horario que desee");
                        numero = sn2.nextInt();

                        LocalTime timeInicio = disponibles.get(numero);

                        Turno turnoNuevo=new Turno(paciente,paciente.listarTurnos().get(numero).getMedico(),fecha,timeInicio);

                        secretariaActiva.reasignarTurno(paciente.listarTurnos().get(numero),turnoNuevo);


                        System.out.println("presione una tecla para continuar");
                        teclado.next();
                        break;
                    }
                    case 7: {//funciona correctamente
                        System.out.println("sesion finalizada");
                        salir= true;
                        break;
                    }
                    default: System.out.println("opcion invalida, ingrese una opcion valida");
                }

            }
        }
    }
}

