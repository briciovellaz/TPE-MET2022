package com.company;

import com.company.filters.FilterByShift;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuMedico extends MenuProfesional {
    private Medico medico;

    public MenuMedico(Medico medico){
        super(medico.getInstitucion());
        this.medico = medico;
    }

    @Override
    protected void otrasOpciones() {
        modificarDatosMed();
    }

    @Override
    public void menu() {
        boolean salir = false;
        while (!salir) {
            System.out.println("Bienvenido Medico " + medico.getNombre());
            System.out.println("Ingrese la opcion que desea realizar");
            System.out.println("1-Listar Turnos");
            System.out.println("2-Modificar Datos");
            System.out.println("3-Salir");
            Scanner teclado = new Scanner(System.in);
            int opcion = teclado.nextInt();
            switch (opcion) {
                case 1: {
                    listarTunros();
                    break;
                }
                case 2: {
                    modificarDatosMed();
                    break;
                }
                case 3: {
                    System.out.println("Vuelva pronto!!");
                    salir = true;
                    break;
                }
            }
        }
    }

    public void listarTunros(){
        System.out.println("---ver turnos filtrando por---");
        System.out.println("1-Horario");
        System.out.println("2-Rango de Dias");
        System.out.println("3-Volver al menu anterior");
        Scanner teclado = new Scanner(System.in);
        int opcion = teclado.nextInt();
        switch(opcion){
            case 1:{
                System.out.println("---Elija una de las opciones a Continuacion---");
                System.out.println("1:Maniana (00:00 to 12:00)");
                System.out.println("2:Tarde   (12:00 to 23:59 )");
                int opcion2=teclado.nextInt();

                System.out.println("ingrese dia para listar sus turnos, tenga en cuanta que:");
                System.out.println("0->lunes");
                System.out.println("1->martes");
                System.out.println("2->miercoles");
                System.out.println("3->jueves");
                System.out.println("4->viernes");
                System.out.println("5->sabado");
                System.out.println("6->domingo");

                int diaNumero = teclado.nextInt();

                switch(opcion2) {
                    case 1: {
                        //for (Turno t : medico.listarTurnos(diaNumero, new FilterByShift("Maniana", 0, 12))) {
                        for(Turno t : medico.listarTurnos(diaNumero, new FilterByShift("Maniana", 0, 12))){
                            System.out.println(t.getFecha().toString() + " " + t.getHoraInicio().toString()
                                    + "  Paciente: " + t.getPaciente().getNombre() + " DNI " + t.getPaciente().getDNI());
                        }
                        break;
                    }
                    case 2: {
                        for (Turno t : medico.listarTurnos(diaNumero, new FilterByShift("Tarde", 13, 23)))
                            System.out.println(t.getFecha().toString() + " " + t.getHoraInicio().toString()
                                    + "  Paciente: " + t.getPaciente().getNombre() + " DNI " + t.getPaciente().getDNI());
                        break;
                    }
                }
                break;
            }
            case 2:{
                System.out.println("---Elija el rango de dias---");
                System.out.println("Ingrese el dia de inicio");
                int inicio = teclado.nextInt();
                System.out.println("Ingrese el dia de fin");
                int fin = teclado.nextInt();

                break;
            }
            case 3:{
                break;
            }
        }

    }
    public void modificarDatosMed() {
        boolean salir = false;
        while (!salir) {
            if (this.modificarDatosProf(this.medico)) { // si es true desea modificar otras opciones

                Scanner teclado = new Scanner(System.in);
                int opcion = 0;
                String opcionText;

                System.out.println("----Elija la opcion que desea modificar----");
                System.out.println("1-Modificar Matricula");
                System.out.println("2-Modificar Especialidad");
                System.out.println("3-Modificar Obra Social");
                System.out.println("4-Salir del Menu");

                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1: {
                        System.out.println("1-Modificar Matricula");
                        System.out.println("Ingrese la nueva matricula");
                        String nuevaMat = teclado.nextLine();
                        medico.setMatricula(nuevaMat);
                        break;
                    }
                    case 2: {
                        System.out.println("2-Modificar Especialidad");
                        System.out.println("Ingrese la nueva Especialidad");
                        String nuevaEsp = teclado.nextLine();
                        medico.setEspecialidad(nuevaEsp);
                        break;
                    }
                    case 3: {
                        System.out.println("3-Modificar Obra Social");
                        System.out.println("Ingrese la nueva Obra Social");
                        String nuevaOS = teclado.nextLine();
                        medico.setObraSocial(nuevaOS);
                        break;
                    }
                    case 4:
                        System.out.println("Vuelva pronto!!");
                        salir = true;
                        break;
                }
            }
        }
    }
}
