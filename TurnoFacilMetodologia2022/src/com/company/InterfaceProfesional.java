package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InterfaceProfesional {

    public static void main(String[] args) {
        //creo y completo institucion
        Institucion inst = new Institucion();
        inst.agregar(new Secretaria("maria","maria" , 50123123));
        inst.agregar(new Paciente(12345678,"Abel","Pintos","yoTecuido"));
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
            System.out.println("3. Salir");

            try {

                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        do {
                            System.out.println("INGRESE SU DOCUMENTO");
                            DNI = sn2.nextInt();
                            index = inst.buscarPosMeadico(DNI);
                            tries++;
                            if (index == -1) {
                                System.out.println("EL DNI NO SE ENCUENTRA REGISTRADO");
                            }
                        }
                        while (index != -1 && tries < 3);
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
                                }
                            }
                            while(tries < 3 && !passvalida);

                        }
                        break;
                    case 2:
                        do {
                            System.out.println("INGRESE SU DOCUMENTO");
                            DNI = sn2.nextInt();
                            index = inst.buscarPosSecretaria(DNI);
                            System.out.println("index"  + index);
                            tries++;
                            if (index == -1) {
                                System.out.println("EL DNI NO SE ENCUENTRA REGISTRADO");
                                break;
                            }
                        }
                        while (index == -1 && tries < 3);
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
                            }
                            while(tries < 3 && !passvalida);

                        }
                        break;
                    case 3:
                        //por implementar
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 3");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
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
                    case 1: {
                        System.out.println("cargar turno");
                        int DNIPaciente,DNIMedico;
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
                        System.out.println("DNI medico y paciente correctos");
                        break;
                    }//algo
                    case 2: {
                        System.out.println("cancelar un turno");
                        break;}//algo
                    case 3: {
                        System.out.println("ver turnos filtrando");
                        break;
                    }
                    case 4: {
                        System.out.println("asignar franja horaria a un medico");
                        break;
                    }
                    case 5:{//creo que funciona a testear
                        System.out.println("lista de medicos a cargo");
                        System.out.println("DNI,matricula,nombre");
                        for (Medico medico:secretariaActiva.getMedicos()){
                            System.out.println(medico.getDNI() +" "+ medico.getMatricula() +" " + medico.getNombre() +""+ medico.getEspecialidad() +""+medico.getObrasSociales());
                        }
                        break;
                    }
                    case 6:{
                        System.out.println("reasignar turno");
                        break;
                    }
                    case 7: {
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

