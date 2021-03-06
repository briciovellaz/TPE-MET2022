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

    protected void otrasOpciones() {
        System.out.println("Responsable no tiene otras opciones disponibles");
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
                case 1: { //Funcionando , falta testear
                    darDeAlta();
                    System.out.println("Se dio de alta correctamente");
                    break;
                }
                case 2:{ //Funcionando , falta testear
                   darDeBaja();
                   System.out.println("Se dio de baja correctamente");
                   break;
                }
                case 3:{ ///Le falta un poco
                    modificarDatosProfesional();
                    System.out.println("Se modificaron de forma correcta los datos");
                    break;
                }
                case 4:{
                    asignarMedicosSecretarias();
                    System.out.println("Se asigno de forma correcta una secretaria al grupo de medicos");
                    break;
                }
                case 5:{
                    System.out.println("??Vuelva pronto!");
                    salir = true;
                    break;
                }
            }
        }
    }

        //modifica datos a si mismo no se ve en menu
    public void modificarDatosResp(){ this.modificarDatosProf(this.responsable) ;}


    //funciona correctamente
    private void darDeBaja() {//opcion del menu dar de baja un medico o secretaria
        Scanner teclado = new Scanner(System.in);
        System.out.println("Funcion dar de baja");
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
            if(opcion==1){
                index = institucion.buscarPosSecretaria(DNI); // si no existe dni ==> retorna -1
                System.out.println("index posSEcret" + index);
            }else{
                index = institucion.buscarPosMedico(DNI); //same
            }
            if (DNI == 0 ) {
                cancelar = true;
                break;
            } else {
                if (index != -1) break;
            }
        } while (!cancelar);

        if (cancelar) {
            System.out.println("Funcion cancelada");
        }else {
            if (opcion == 1) {//dar de baja secretaria
                //index = institucion.buscarPosSecretaria(DNI); LO SUBI AL DO{}WHILE();
                Secretaria secretaria = (Secretaria) institucion.getProfesional(index, 2);
                System.out.println("Desea borrar la secretaria con los datos:");
                System.out.println("dni: " + secretaria.getDNI() + "\n nombre: " + secretaria.getNombre());
                System.out.println("ingrese 1 para confirmar el borrado o 2 para cancelar");
                opcion = teclado.nextInt();
                if (opcion == 1) {
                    institucion.darDeBajaSecretaria(DNI);
                    System.out.println("Secretaria borrada con exito");
                }
            } else {
                if (opcion == 2) {// dar de baja medico
                    //index = institucion.buscarPosMedico(DNI); LO SUBI AL DO{}WHILE();
                    Medico medico = (Medico) institucion.getProfesional(index, 1);
                    System.out.println("Desea borrar el medico con los datos:");
                    System.out.println("dni: " + medico.getDNI() + "\n matricula:" + medico.getMatricula() + "\n nombre: " + medico.getNombre() + "\n especialidad:" + medico.getEspecialidad() + "\n obras Sociales: " + medico.getObrasSociales());
                    System.out.println("ingrese 1 para confirmar el borrado o 2 para cancelar");
                    opcion = teclado.nextInt();
                    if (opcion == 1) {
                        institucion.darDeBajaMedico(DNI);
                        System.out.println("Medico borrado con exito");
                    }
                }
            }
        }
    }
    private void darDeAlta() {//funciona correctamente
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
        boolean cancelar = false;
        /*do {
            System.out.println("ingrese el DNi " + opcionText + " que desea dar de alta o 0 cancelar operacion");
            DNI = teclado.nextInt();
            if (DNI == 0) {
                cancelar = true;
                break;
            }
        } while (!cancelar); /// creo que no termina
        */
        ///estaria bueno comprobar que no existe desde antes el DNI
        System.out.println("ingrese el DNi " + opcionText + " que desea dar de alta o 0 cancelar operacion");
        DNI = teclado.nextInt();
        if (DNI == 0)
            cancelar = true;

        if (cancelar) {
            System.out.println("funcion cancelada");
            return;
        }else{
            System.out.println("Ingresar los datos personales del nuevo Recluta :");
            System.out.println("Nombre:  ");
            String nombre=teclado.next();
            System.out.println("Contrasenia: ");
            String contrasenia=teclado.next();
            System.out.println("DNI: ");
            int dni= teclado.nextInt();
            System.out.println("Especialidad:");
            String especialidad=teclado.next();
            System.out.println("Matricula:");
            String matricula=teclado.next();
            System.out.println("Domicilio:");
            String domicilio=teclado.next();
            System.out.println("Curriculum:");
            String curriculum=teclado.next();
            System.out.println("Descripcion:");
            String descripcion=teclado.next();
            System.out.println("E-mail:");
            String mail=teclado.next();
            System.out.println("Numero de Telefono:");
            int nroTel= teclado.nextInt();

            if (opcion == 1) {
                Secretaria s = new Secretaria(nombre,contrasenia,dni,especialidad,matricula,domicilio,curriculum,descripcion,mail,nroTel,institucion);
                institucion.agregar(s);
            } else {
                Medico m=new Medico(nombre,contrasenia,dni,especialidad,matricula,domicilio,curriculum,descripcion,mail,nroTel,institucion);
                institucion.agregar(m);
            }
        }
    }
    private void modificarDatosProfesional() {  //funciona casi todo
        //preguntar a quien deseo agregar datos, si es secretaria o medico
        //pedir dni
        //confirmar
        //cosas que se pueden modificar en medico: obra social, medios de contacto y mas
        //cosas que se pueden modificar en secretaria: medios de contacto
        //agregar datos nuevos
        int index = 0;
        boolean cancel = false;
        int DNI;
        Scanner teclado = new Scanner(System.in);
        int opcion = 0;
        String opcionText;
        do {

            System.out.println("ingrese 1 para modificar datos a una secretaria y 2 para agregar datos a un medico o 0 para salir");
            opcion = teclado.nextInt();
            if (opcion == 0) {
                System.out.println("opcion cancelada");
                return;
            } else if (opcion == 1 || opcion == 2) {
                if (opcion == 1) {
                    opcionText = "de la secretaria";
                } else {
                    opcionText = "del medico";
                }
                break;
            } else {
                System.out.println("ingrese una opcion valida");
            }

        } while (true);

        if (opcion == 2) {
            while (index != -1 && !cancel) {
                System.out.println("ingrese el DNi " + opcionText + " que desea modificar");
                DNI = teclado.nextInt();
                index = institucion.buscarPosMedico(DNI);
                if (index != -1)
                    break;
                System.out.println("El DNI ingresado es incorrecto");
                System.out.println("Intentelo nuevamente (Si desea cancelar la operacion presione 0) ");
                opcion = teclado.nextInt();
                if (opcion == 0)
                    cancel = true;
            }
            if (!cancel && index != -1) {
                Profesional m = (Secretaria) institucion.getProfesional(index, 1);
                this.modificarDatosProf(m);
            } else {
                if (opcion == 1) {
                    //opcion = teclado.nextInt();
                    while (index != -1 && !cancel) {
                        System.out.println("ingrese el DNi " + opcionText + " que desea dar de baja o 0 cancelar operacion");
                        DNI = teclado.nextInt();
                        index = institucion.buscarPosSecretaria(DNI);
                        if (index != -1)
                            break;
                        System.out.println("El DNI ingresado es incorrecto");
                        System.out.println("Intentelo nuevamente (Si desea cancelar la operacion presione 0) ");
                        opcion = teclado.nextInt();
                        if (opcion == 0) {
                            cancel = true;
                            System.out.println("funcion cancelada");
                            return;
                        }
                    }
                    if (!cancel && index != -1) {
                        Profesional p = institucion.getProfesional(index, 2);
                        this.modificarDatosProf(p);
                    }
                }
            }
        }
    }

    private void asignarMedicosSecretarias() {
        //preguntar a qu?? secretaria deseo asignar a un grupo de medicos
        //pedir dni de secretaria
        //preguntar a cuantos medicos desea asignarles esa secretaria
        //pedir dni de los medicos
        //confirmar
        //asignar secretaria a esos medicos ingresados
        int cantidad = 0, DNISecretaria, index, i = 1;
        Secretaria secretaria;
        Scanner teclado = new Scanner(System.in);
        while (true){
            System.out.println("ingrese dni de secretaria o 0 para cancelar");
            DNISecretaria = teclado.nextInt();
            if(DNISecretaria ==0){
                System.out.println("funcion terminada");
                return;
            }else {
                int posSecretaria = institucion.buscarPosSecretaria(DNISecretaria);
                if(posSecretaria==-1){
                    System.out.println("la secretaria no existe/Dni incorrecto");
                }else {//dni correcto
                    secretaria = (Secretaria) institucion.getProfesional(posSecretaria,2);
                    System.out.println("Secretaria Dni: "+ secretaria.getDNI() + " nombre: " + secretaria.getNombre());
                    break;
                }
            }
        }
        while (true){
            System.out.println("ingrese dni de medico o 0 para finalizar asignacion a secretaria");
            int DNIMedico = teclado.nextInt();
            if(DNIMedico ==0){
                System.out.println("funcion terminada");
                return;
            }
            int posMedico = institucion.buscarPosMedico(DNIMedico);
            if(posMedico==-1){
                System.out.println("el medico no existe-Dni incorrecto");
            }else{
                Medico medico = (Medico) institucion.getProfesional(posMedico,1);
                secretaria.agregarMedico(medico);
                System.out.println("medico DNI: " + medico.getDNI() + "nombre: " + medico.getNombre() +" asignado correctamente");
            }
        }
    }
}
