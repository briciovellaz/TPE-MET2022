package com.company;

//import sun.util.calendar.BaseCalendar;

import com.company.filters.FilterByShift;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuGeneral {
        //variables
        Scanner sn = new Scanner(System.in),teclado= new Scanner(System.in),sn2 = new Scanner(System.in);
        boolean passvalida = false,salir = false;
        int opcion = 0,DNI,index=0,tries = 0;
        Profesional sesionActiva = null;
        String contrasenia;

        /////////lineas para sistema inicio de sesion
    public void IniciarMenu() {
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
                            System.out.println("INGRESE SU CONTRASEÑA");
                            contrasenia = teclado.nextLine();
                            if (institucion.logIn(contrasenia,DNI,"m") != null) {
                                System.out.println("Inicio de sesion correcto, bienvenido");
                                new MenuMedico((Medico)institucion.logIn(contrasenia,DNI,"m")).menu();
                                salir = true;
                                break;
                            }
                            else {
                                System.out.println("USUARIO Y/O CONTRASEÑA INCORRECTOS");
                                tries++;
                                }
                            } while (tries < 3);
                        break;
                    case 2://secretaria
                            do {
                                System.out.println("INGRESE SU CONTRASEÑA");
                                contrasenia = teclado.nextLine();
                                if (institucion.logIn(contrasenia, DNI, "s") != null){
                                    System.out.println("Inicio de sesion correcto");
                                    new MenuSecretaria((Secretaria)institucion.logIn(contrasenia, DNI, "s")).menu();
                                    salir = true;
                                    break;
                                }
                                else {
                                    System.out.println("USUARIO Y/O CONTRASEÑA INCORRECTOS");
                                    tries++;
                                }

                            } while (tries < 3);

                        break;
                    case 3: { //responsable
                        //por implementar
                        do {
                            System.out.println("INGRESE SU DOCUMENTO");
                            DNI = sn2.nextInt();
                            System.out.println("INGRESE SU CONTRASEÑA");
                            contrasenia = teclado.nextLine();
                            if (institucion.logIn(contrasenia, DNI, "r") != null) {
                                System.out.println("Inicio de sesion correcto");
                                ;
                                new MenuResponsable((Responsable) institucion.logIn(contrasenia, DNI, "r")).menu();
                                salir = true;
                                break;
                            } else {
                                System.out.println("USUARIO Y/O CONTRASEÑA INCORRECTOS");
                                tries++;
                            }
                        } while (tries < 3);
                        break;
                    }
                    case 4:
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
    }
  }


