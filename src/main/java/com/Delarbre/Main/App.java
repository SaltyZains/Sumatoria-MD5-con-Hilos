package com.Delarbre.Main;

public class App {

    public static void main(String[] args) throws Exception {
        String file = "src/main/java/com/Delarbre/Archivos/Texto.txt";
        Demonio hilo = new Demonio();
        hilo.ruta(file);
        hilo.run();
    }
}
