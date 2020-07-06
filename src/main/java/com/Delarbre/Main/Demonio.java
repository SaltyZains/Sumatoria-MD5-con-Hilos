package com.Delarbre.Main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Time;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Demonio implements Runnable{

    private String ruta;
    private String valorConstante = "c23540401f9b03148cec7301bf34900e";
    private String valorMD5;
    private boolean bandera = true;
    Scanner sc = new Scanner(System.in);
    private int seleccion;
    MD5 archivo = new MD5();

    @Override
    public void run() {
        try {
            while (bandera){
                valorMD5 = archivo.convertirPathArchivo(ruta);
                System.out.println("El archivo en la ruta: " + ruta + " \nTiene un valor de: " + valorMD5);
                if (valorConstante.equals(valorMD5)) {
                    System.out.println("El archivo sigue igual");
                }else {
                    System.out.println("El archivo fue modificado, desea mantener esa modificacion? \n1) Si \n2)No");
                    seleccion = sc.nextInt();
                    if (seleccion == 1){
                        System.out.println("El nuevo valor MD5 del archivo es: " + valorMD5);
                        valorConstante = valorMD5;
                    }else{
                        bandera = false;
                    }
                }
                TimeUnit.SECONDS.sleep(3);
                System.out.println("");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void ruta(String ruta){
        this.ruta = ruta;
        this.valorMD5 = ruta;
    }

}
