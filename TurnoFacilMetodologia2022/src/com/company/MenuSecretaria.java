package com.company;

import com.company.filters.FilterByShift;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuSecretaria extends MenuProfesional {
    private Secretaria secretaria;
    private Scanner teclado= new Scanner(System.in);

    public MenuSecretaria(Secretaria secretaria){
        super(secretaria.getInstitucion());
        this.secretaria = secretaria;
    }

    @Override
    protected void otrasOpciones() {
        System.out.println("Secretaria no tiene otras opciones disponibles");
    }

    @Override
    public void menu() {
        int index = 0;
        System.out.println("Bienvenido " + secretaria.getNombre());
        boolean salir = false;
        while (!salir) {
            System.out.println("----elija la opcion----");
            System.out.println("1-cargar turno");
            System.out.println("2-cancelar turno");
            System.out.println("3- ver turnos filtrando");
            System.out.println("4-asignar franja horaria a un medico");
            System.out.println("5-listar medicos a cargo");
            System.out.println("6-reasignar turnos");
            System.out.println("7-salir");

            int opcion = teclado.nextInt();
            switch (opcion) {
                case 1: {//funciona
                    System.out.println("---cargar turno---");
                    int DNIPaciente, DNIMedico;
                    Medico medico;
                    Paciente paciente;
                    //solicita DNI paciente y consulta si existe
                    do {
                        System.out.println("ingrese DNI del paciente o 0 para volver al menu");
                        DNIPaciente = teclado.nextInt();
                        if (DNIPaciente == 0) {
                            break;
                        }
                        index = institucion.buscarPosPaciente(DNIPaciente);
                        if (index == -1) {
                            System.out.println("el DNI de paciente no existe");
                        }
                    } while (index == -1);
                    if (DNIPaciente == 0) {
                        break;
                    }
                    paciente = institucion.getPaciente(index);
                    //solicita DNI medico y consulta si existe
                    do {
                        System.out.println("ingrese DNI del medico o 0 para volver al menu");
                        DNIMedico = teclado.nextInt();
                        if (DNIMedico == 0) {
                            break;
                        }
                        index = institucion.buscarPosMedico(DNIMedico);
                        if (index == -1) {
                            System.out.println("el DNI del medico no existe");
                        }
                    } while (index == -1);
                    if (DNIMedico == 0) {
                        break;
                    }
                    medico = (Medico) institucion.getProfesional(index, 1);
                    System.out.println("DNI medico y paciente correctos");

                    //fecha
                    System.out.println("ingrese el dia del turno");
                    int dia = teclado.nextInt();
                    while (dia < 1 || dia > 31) {
                        System.out.println("ingrese una dia valido");
                        dia = teclado.nextInt();
                    }
                    System.out.println("ingrese el mes del turno");
                    int mes = teclado.nextInt();
                    while (mes < 1 || mes > 12) {
                        System.out.println("ingrese un mes valido");
                        mes = teclado.nextInt();
                    }
                    System.out.println("ingrese el año del turno");
                    int año = teclado.nextInt();
                    while (año < LocalDate.now().getYear()) {
                        System.out.println("ingrese un año valido");
                        año = teclado.nextInt();
                    }
                    LocalDate fecha = LocalDate.of(año, mes, dia);
                    System.out.println("turnos disponibles del dia" + fecha);
                    int j = 0;
                    ArrayList<LocalTime> disponibles = medico.TurnosDisponibles(fecha);
                    for (LocalTime inicDisponible : disponibles) {
                        System.out.println(j + ": " + inicDisponible);
                        j++;
                    }
                    //inicio hora
                    System.out.println("ingrese el numero del horario que desee");
                    int numero = teclado.nextInt();

                    LocalTime timeInicio = disponibles.get(numero);


                    //el constructor de turno se agrega a si mismo  a la lista de turnos de medico y paciente
                    Turno turno = new Turno(paciente, medico, fecha, timeInicio);

                    System.out.println("turno de paciente " + turno.getPaciente().getDNI() + " con el medico " + turno.getMedico().getDNI() + " el dia " + turno.getFecha() + " " + turno.getHoraInicio() + " fue agregado correctamente");

                    System.out.println("presione una tecla para continuar");
                    teclado.next();
                    break;
                }
                case 2: {//hacer
                    System.out.println("---cancelar un turno---");
                    int k = 0;
                    Paciente paciente;
                    int DNIPaciente;
                    do {
                        System.out.println("ingrese DNI del paciente o 0 para volver al menu");
                        DNIPaciente = teclado.nextInt();
                        if (DNIPaciente == 0) {
                            break;
                        }
                        index = institucion.buscarPosPaciente(DNIPaciente);
                        if (index == -1) {
                            System.out.println("el DNI de paciente no existe");
                        }
                    } while (index == -1);
                    if (DNIPaciente == 0) {
                        break;
                    }
                    paciente = institucion.getPaciente(index);
                    for (Turno turno : paciente.listarTurnos()) {
                        System.out.println(k + turno.getFecha().toString() + turno.getHoraInicio().toString() + "medico" + turno.getMedico().getDNI());
                        k++;
                    }
                    System.out.println("ingrese numero de turno a cancelar");
                    int numero = teclado.nextInt();
                    paciente.borrarTurno(numero);

                    System.out.println("presione una tecla para continuar");
                    teclado.next();
                    break;
                }
                case 3: {//hacer   llamar a la funcion listar turnos de  MenuSecretaria

                    System.out.println("---ver turnos filtrando---");
                    System.out.println("ingrese dia para listar sus turnos");
                    int numero = teclado.nextInt();
                    System.out.println("ingrese horario para listar sus turnos");
                    int horario = teclado.nextInt();
                    for (Turno t : secretaria.listarTurnos(horario, new FilterByShift("mañana",7,12))) {
                        System.out.println(t.getFecha().toString() + " " + t.getHoraInicio().toString() + "  Medico: " + t.getMedico().getNombre() + " DNI " + t.getMedico().getDNI());
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
                        DNIMedico = teclado.nextInt();
                        if (DNIMedico == 0) {
                            break;
                        }
                        index = institucion.buscarPosMedico(DNIMedico);
                        if (index == -1) {
                            System.out.println("el DNI del medico no existe");
                        } else {
                            medico = (Medico) institucion.getProfesional(index, 1);
                            System.out.println("medico seleccionado: " + medico.getDNI() + " " + medico.getMatricula() + " " + medico.getNombre() + " " + medico.getEspecialidad());
                        }
                    } while (index == -1);
                    if (DNIMedico == 0) {
                        break;
                    }
                    //fecha
                    System.out.println("ingrese el dia de la semana, 0=lunes");
                    int dia = teclado.nextInt();

                    System.out.println("ingrese la duracion de los turnos en ese horario");
                    int duracion = teclado.nextInt();

                    //inicio hora
                    System.out.println("ingrese la hora de inicio");
                    int horaInicio = teclado.nextInt();
                    System.out.println("ingrese los minutos de la hora de inicio");
                    int minutosInicio = teclado.nextInt();
                    LocalTime timeInicio = LocalTime.of(horaInicio, minutosInicio);
                    //hora fin
                    System.out.println("ingrese la hora de fin");
                    int horaFin = teclado.nextInt();
                    System.out.println("ingrese los minutos de la hora de fin");
                    int minutosFin = teclado.nextInt();
                    LocalTime timeFin = LocalTime.of(horaFin, horaInicio);
                    medico.agregarHorario(dia, timeInicio, timeFin, duracion);

                    System.out.println("horario cargado a " + medico.getNombre() + " con DNI " + medico.getDNI() + " correctamente");

                    System.out.println("presione una tecla para continuar");
                    teclado.next();
                    break;
                }
                case 5: {//funciona correctamente
                    System.out.println("---lista de medicos a cargo---");
                    System.out.println("DNI,matricula,nombre,obras sociales que atiende");
                    for (Medico medico : secretaria.getMedicos()) {
                        System.out.println(medico.getDNI() + " " + medico.getMatricula() + " " + medico.getNombre() + "" + medico.getEspecialidad() + " " + medico.getObrasSociales());
                    }

                    System.out.println("presione una tecla para continuar");
                    teclado.next();
                    break;
                }
                case 6: {//hacer
                    System.out.println("---reasignar turno---");
                    Paciente paciente;
                    int DNIPaciente;
                    do {
                        System.out.println("ingrese DNI del paciente o 0 para volver al menu");
                        DNIPaciente = teclado.nextInt();
                        if (DNIPaciente == 0) {
                            break;
                        }
                        index = institucion.buscarPosPaciente(DNIPaciente);
                        if (index == -1) {
                            System.out.println("el DNI de paciente no existe");
                        }
                    } while (index == -1);
                    if (DNIPaciente == 0) {
                        break;
                    }
                    paciente = institucion.getPaciente(index);
                    int k = 0;
                    for (Turno turno : paciente.listarTurnos()) {
                        System.out.println(k + turno.getFecha().toString() + turno.getHoraInicio().toString() + "medico" + turno.getMedico().getDNI());
                        k++;
                    }
                    System.out.println("ingrese numero de turno a reasignar");
                    int numero = teclado.nextInt();
                    Turno turnoAMod = paciente.getTurno(numero);
                    System.out.println("ingrese el nuevo dia del turno");
                    int dia = teclado.nextInt();
                    while (dia < 1 || dia > 31) {
                        System.out.println("ingrese un dia valido");
                        dia = teclado.nextInt();
                    }
                    System.out.println("ingrese el nuevo mes del turno");
                    int mes = teclado.nextInt();
                    while (mes < 1 || mes > 12) {
                        System.out.println("ingrese un mes valido");
                        mes = teclado.nextInt();
                    }
                    System.out.println("ingrese el nuevo año del turno");
                    int año = teclado.nextInt();
                    while (año < LocalDate.now().getYear()) {
                        System.out.println("ingrese un año valido");
                        año = teclado.nextInt();
                    }
                    LocalDate fecha = LocalDate.of(año, mes, dia);
                    System.out.println("turnos disponibles del dia" + fecha);
                    int j = 0;
                    ArrayList<LocalTime> disponibles = turnoAMod.getMedico().TurnosDisponibles(fecha);
                    for (LocalTime inicDisponible : disponibles) {
                        System.out.println(j + ": " + inicDisponible);
                        j++;
                    }
                    //inicio hora
                    System.out.println("ingrese el numero del horario que desee");
                    numero = teclado.nextInt();

                    LocalTime timeInicio = disponibles.get(numero);

                    Turno turnoNuevo = new Turno(paciente, paciente.listarTurnos().get(numero).getMedico(), fecha, timeInicio);

                    secretaria.reasignarTurno(paciente.listarTurnos().get(numero), turnoNuevo);


                    System.out.println("presione una tecla para continuar");
                    teclado.next();
                    break;
                }
                case 7: {//funciona correctamente
                    System.out.println("sesion finalizada");
                    salir = true;
                    break;
                }
                default:
                    System.out.println("opcion invalida, ingrese una opcion valida");
            }
        }

    }
}
