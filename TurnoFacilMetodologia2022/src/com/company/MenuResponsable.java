package com.company;

import java.util.Scanner;

public class MenuResponsable {


    public void modificarDatos(){
        //preguntar a quien deseo agregar datos, si es secretaria o medico

        //pedir dni
        //confirmar
        //agregar datos nuevos
        Scanner teclado= new Scanner(System.in);
        int opcion =0;
        String opcionText;
        System.out.println("ingrese 1 para agregar datos a una secretaria y 2 para agregar datos a un medico");
        opcion = teclado.nextInt();
        if(opcion == 1){ opcionText = "de la secretatia";}else{ opcionText =" del medico";}
        System.out.println("ingrese el DNi "+opcionText+ " que desea agregarle datos");
        opcion=0;
        switch(opcion){
            case 1:opcionText=""
                    break;
        }


    }
}
