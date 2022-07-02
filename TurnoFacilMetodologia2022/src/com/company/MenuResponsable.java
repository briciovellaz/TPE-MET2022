package com.company;

import java.util.Scanner;

public class MenuResponsable extends MenuProfesional {
    private Responsable responsable;
    private Scanner teclado = new Scanner(System.in);

    public MenuResponsable(Responsable responsable) {
        super(responsable.getInstitucion());
        this.responsable = responsable;
    }

    @Override
    public void menu() {
        int index = 0;
        System.out.println("Bienvenido " + responsable.getNombre());
        boolean salir = false;
        while (!salir) {
            System.out.println("----Elija la opcion----");
            System.out.println("1-Dar de alta secretaria y/o medico");
            System.out.println("2-Dar de baja secretaria y/o medico");
            System.out.println("3-Modificar datos de secretaria o medico");
            System.out.println("4-Asignar secretaria a un grupo de medicos");
            System.out.println("5-Salir");

            int opcion = teclado.nextInt();
            switch (opcion) {
                case 1: {
                    darDeAlta();
                    System.out.println("Se dio de alta correctamente");
                    break;
                }
                case 2:{
                   darDeBaja();
                   System.out.println("Se dio de baja correctamente");
                   break;
                }
                case 3:{
                    //modificarDatosProfesional();
                    System.out.println("Se modificaron de forma correcta los datos");
                    break;
                }
                case 4:{
                    asignarMedicosSecretarias();
                    System.out.println("Se asigno de forma correcta una secretaria al grupo de medicos");
                    break;
                }
                case 5:{
                    System.out.println("¡Vuelva pronto!");
                    salir = true;
                    break;
                }
            }
        }
    }


    public void modificarDatosResp(){ this.modificarDatosProf(this.responsable) ;}

    public void darDeBaja() {//opcion del menu dar de baja un medico o secretaria
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
            index = institucion.buscarPosMedico(DNI);
            Medico medico = (Medico) institucion.getProfesional(index, 1);
            System.out.println("Desea borrar la secretaria con los datos:");
            System.out.println("dni: " + medico.getDNI() + "/n matricula:" + medico.getMatricula() + "/n nombre: " + medico.getNombre() +"/n especialidad:" +medico.getEspecialidad() +"/n obras Sociales: " + medico.getObrasSociales());
            System.out.println("ingrese 1 para confirmar el borrado o 2 para cancelar");
            opcion = teclado.nextInt();
            if (opcion == 1) {
                institucion.darDeBajaMedico(index);
                System.out.println("medico borrado");
                return;
            }
        }
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
    public void modificarDatosProfesional(Profesional p) {
        //preguntar a quien deseo agregar datos, si es secretaria o medico
        //pedir dni
        //confirmar
        //cosas que se pueden modificar en medico: obra social, medios de contacto y mas
        //cosas que se pueden modificar en secretaria: medios de contacto
        //agregar datos nuevos
        int Dni;
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;
        String opcionText;
        System.out.println("ingrese 1 para agregar datos a una secretaria y 2 para agregar datos a un medico");
        opcion = teclado.nextInt();
        if (opcion == 1) {
            opcionText = "de la secretatia";
        } else {
            opcionText = "del medico";
        }
        System.out.println("ingrese el DNi " + opcionText + " que desea agregarle datos");
        if (opcionText == "del medico") {
            this.modificarDatosProf(p);
            /*int index = 0;
            boolean salir = false;
            while (!salir) {
                System.out.println("----Elija la opcion sobre a que dato quiere modificar o agregar----");
                System.out.println("1-Agregar o modificar obra social");
                System.out.println("2-Agregar un nuevo medio de contacto o modificar el que ya tiene");
                System.out.println("3-Agregar nueva especialidad ");
                System.out.println("5-Salir");
                //  ??revisar si las opciones que se piden estan bien o faltan agregar nuevas
            }*/

        }else {
            if (opcionText == " de la secretaria") {
                this.modificarDatosProf(p);
                /*int index = 0;
                boolean salir2 = false;
                while (!salir2) {
                    System.out.println("----Elija la opcion sobre a que dato quiere modificar o agregar----");
                    System.out.println("1-Agregar un nuevo medio de contacto o modificar el que ya tiene");
                    System.out.println("2-Salir");
                    // revisar si hay que tener en cuenta si le falta alguna opcion a la secretaria

                }*/
            }
        }
    }

    public void asignarMedicosSecretarias() {
        //preguntar a qué secretaria deseo asignar a un grupo de medicos
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
                index = institucion.buscarPosMedico(DNI);
                //Secretaria().agregar(medico);
                i++;
            }
        }
    }
}
