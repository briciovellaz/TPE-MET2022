package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InterfaceProfesional {

    public static void main(String[] args) {
        Institucion inst = new Institucion();
        Scanner sn = new Scanner(System.in),teclado= new Scanner(System.in),sn2 = new Scanner(System.in);
        boolean passvalida,salir = false;
        int opcion,doc,index,tries = 0;


        String contrasenia;


        while (!salir) {

            System.out.println("1. MEDICO");
            System.out.println("2. SECRETARIA");
            System.out.println("3. Salir");

            try {

                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        do {
                            System.out.println("INGRESE SU DOCUMENTO");
                            doc = sn2.nextInt();
                            index = inst.buscarPosMeadico(doc);
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
                                passvalida = inst.validatePassMedic(contrasenia,index);
                                tries ++;
                                if (!passvalida) {
                                    System.out.println("LA CONTRASEÑA ES INCORRECTA");
                                }
                            }
                            while(tries < 3 && !passvalida);

                        }
                        break;
                    case 2:
                        System.out.println("INGRESE SU DOCUMENTO");
                        break;
                    case 3:
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
