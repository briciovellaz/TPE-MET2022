package com.company;

import java.util.List;
import java.util.Scanner;

public class Responsable extends Profesional {
    private Institucion institucion;//insitucion d ela que es responsable

    public Responsable(String nombre, String contrasenia, int dni,String especialidad, String matricula, String domicilio,String curriculum, String descripcion, String email, int nroTel) {
        super(nombre, contrasenia, dni, domicilio,curriculum, descripcion, email, nroTel);
    }

    public void cargarMedico(String nombre, String contrasenia, int dni, String especialidad, String matricula, String domicilio,String curriculum, String descripcion, String email, int nroTel) {
        Medico m = new Medico(nombre,contrasenia,dni, especialidad, matricula, domicilio,curriculum, descripcion, email, nroTel);
    }

    public void cargarSecretaria(String nombre, String contrasenia, int dni,String especialidad, String matricula, String domicilio,String curriculum, String descripcion, String email, int nroTel) {
        Secretaria s = new Secretaria(nombre, contrasenia, dni, especialidad, matricula, domicilio,curriculum, descripcion, email, nroTel);
    }

    public void setInstitucion(Institucion institucion) {
        this.institucion = institucion;
    }

    public void darDeAlta() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("funcion dar de alta a un medico o secretaria");
        //preguntar si desea dar de alta un medico o secretaria
        //pedir dni
        //confirmar
        //dar de alta al medico o secretaria
        int opcion, DNI, index;
        String opcionText;
        System.out.println("ingrese 1 para dar de alta a una secretaria y 2 para dar de alta a un medico");
        opcion = teclado.nextInt();
        if (opcion == 1) {
            opcionText = "de la secretaria";
        } else {
            opcionText = " del medico";
        }
        System.out.println("ingrese el DNi " + opcionText + " que desea dar de alta");
        boolean cancelar = false;
        do {
            System.out.println("ingrese el DNi " + opcionText + " que desea dar de alta o 0 cancelar operacion");
            DNI = teclado.nextInt();
            if (DNI == 0) {
                cancelar = true;
                break;
            }
        } while (!cancelar);
        if (cancelar) {
            System.out.println("funcion cancelada");
            return;

        }
    }

    public void darDeBaja() {
        Scanner teclado = new Scanner(System.in);
        System.out.println("funcion dar de baja");
        //preguntar si desea dar de baja medico o secretaria
        //pedir dni
        //confirmar
        // dar de baja al profesional
        int opcion, DNI, index;
        String opcionText;
        System.out.println("ingrese 1 para dar de baja una secretaria y 2 para dar de baja un medico");
        opcion = teclado.nextInt();
        if (opcion == 1) {
            opcionText = "de la secretatia";
        } else {
            opcionText = " del medico";
        }
        boolean cancelar = false;
        do {
            System.out.println("ingrese el DNi " + opcionText + " que desea dar de baja o 0 cancelar operacion");
            DNI = teclado.nextInt();
            if (DNI == 0) {
                cancelar = true;
                break;
            }
        } while (!cancelar);
        if (cancelar) {
            System.out.println("funcion cancelada");
            return;
        }
        if (opcion == 1) {//dar de baja secretaria
            index = institucion.buscarPosSecretaria(DNI);
            Secretaria secretaria = (Secretaria) institucion.getProfesional(index, 2);
            System.out.println("Desea borrar la secretaria con los datos:");
            System.out.println("dni: " + secretaria.getDNI() + "/n nombre: " + secretaria.getNombre());
            System.out.println("ingrese 1 para confirmar el borrado o 2 para cancelar");
            opcion = teclado.nextInt();
            if (opcion == 1) {
                institucion.darDeBajaMedico(index);
                System.out.println("medico borrado");
                return;
            }
        }
        if (opcion == 2) {// dar de baja medico

        }
    }

    public void modificarDatosMedico(int dni) {
        //preguntar a quien deseo agregar datos, si es secretaria o medico
        //pedir dni
        //confirmar
        //agregar datos nuevos
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;
        String opcionText;

        System.out.println("ingrese 1 para agregar datos a una secretaria y 2 para agregar datos a un medico");
        opcion = teclado.nextInt();
        if (opcion == 1) {
            opcionText = "de la secretatia";
        } else {
            opcionText = " del medico";
        }
        System.out.println("ingrese el DNi " + opcionText + " que desea agregarle datos");

    }

    public void modificarDatosSecretaria() {
        //

    }

    public void asignarMedicosSecretarias() {
        //preguntar a que secretaria deseo asignar a un grupo de medicos
        //pedir dni de secretaria
        //preguntar a cuantos medicos desea asignarles esa secretaria
        //pedir dni de los medicos
        //confirmar
        //asignar secretaria a esos medicos ingresados
        int cantidad = 0, DNI, index, i = 1;
        boolean cancelar = false;
        Scanner teclado = new Scanner(System.in);
        System.out.println("ingrese dni de secretaria");
        DNI = teclado.nextInt();
        if (DNI == 0) {
            cancelar = true;
            //break;
        }
        while (!cancelar) ;
        if (cancelar) {
            System.out.println("funcion cancelada");
            //return;
            System.out.println("ingrese a cuantos medicos desea asignarle la secretaria que se ingreso");
            System.out.println(cantidad);
            while (i > cantidad) {
                System.out.println("ingrese dni de medico");
                DNI = teclado.nextInt();
                if (DNI == 0) {
                    cancelar = true;
                    break;
                }
                index = institucion.buscarPosMeadico(DNI);
                //Secretaria().agregar(medico);
                i++;
            }
        }
    }
}