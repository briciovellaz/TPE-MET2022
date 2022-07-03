package com.company;

import java.util.Scanner;

public abstract class MenuProfesional {
    protected Institucion institucion;

    public MenuProfesional(Institucion institucion){
        this.institucion = institucion;
    }
    public abstract void menu();

    protected abstract void otrasOpciones();

    public boolean modificarDatosProf(Profesional p) {
        //pedir dni
        //confirmar
        //agregar datos nuevos
        Scanner sn = new Scanner(System.in);
        int opcion = 0;
        System.out.print("\033[H\033[2J");//limpia consola no del compilador
        System.out.flush();
        System.out.println("----Perfil----");


        boolean salir = false;
        while (!salir) {
            System.out.println("----Elija la opcion que desea modificar----");
            System.out.println("1-Modificar nombre");
            System.out.println("2-Modificar contraseña");
            System.out.println("3-Modificar domicilio");
            System.out.println("4-Agregar datos al curriculum");
            System.out.println("5-Modificar descripcion Personal");
            System.out.println("6-Modificar email");
            System.out.println("7-Modificar numero de telefono");
            System.out.println("8-Otras opciones "); //para modificar datos especificos de medico/secretaria/responsable
            System.out.println("9-salir");

            opcion = sn.nextInt();

            switch (opcion) {
                case 1: {
                    System.out.println("1-Modificar nombre");
                    System.out.println("Ingrese el nuevo nombre");
                    String nuevoNombre;
                    nuevoNombre = sn.next();
                    p.setNombre(nuevoNombre);
                    System.out.println("Se ah modificaco el nombre con exito \n");
                    break;
                }
                case 2: {
                    System.out.println("2-Modificar contraseña");
                    System.out.println("Ingrese la nueva contraseña");
                    String nuevaContra;
                    nuevaContra = sn.next();
                    p.modificarContrasenia(nuevaContra);
                    System.out.println("Se ah modificaco la contraseña con exito ");
                    break;
                }
                case 3: {
                    System.out.println("3-Modificar domicilio");
                    System.out.println("Ingrese el nuevo domicilio");
                    String nuevoDom = sn.next();
                    p.setDomicilio(nuevoDom);
                    break;
                }
                case 4: {
                    System.out.println("4-Agregar datos al curriculum");
                    System.out.println("Ingrese el nuevo dato del curriculum");
                    String nuevoCur = sn.next();
                    p.setCurriculum(nuevoCur);
                    break;
                }
                case 5: {
                    System.out.println("5-Modificar descripcion Personal");
                    System.out.println("Ingrese el nuevo dato pertenciente a la inf personal");
                    String nuevoDatoPer = sn.next();
                    p.setDescripcionPersonal(nuevoDatoPer);
                    break;
                }
                case 6:{
                    System.out.println("6-Modificar email");
                    System.out.println("Ingrese el nuevo email");
                    String nuevoEmail = sn.next();
                    p.setEmail(nuevoEmail);
                    break;
                }
                case 7: {
                    System.out.println("7-Modificar numero de telefono");
                    System.out.println("Ingrese el nuevo numero de telefono");
                    int nuevoNumTel = sn.nextInt();
                    p.setNroTelefono(nuevoNumTel);
                    break;
                }
                case 8: {
                    System.out.println("Otras opciones");
                    otrasOpciones();
                    return true;

                }
                case 9: {
                    System.out.println("Fin modificaciones");
                    salir = true;
                    break;
                }
            }
        }
        return false;
    }
}
