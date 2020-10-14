import validaciones.ValidaLibrary;

import java.io.IOException;
import java.util.concurrent.*;

public class Traductor {


    public static void main(String[] args) throws InterruptedException {
        String OS = System.getProperty("os.name");

        if (OS.equals("Windows 10")) {
            traductor();
        } else if (OS.equals("Linux")) {
            traductor();
        } else
            System.out.println("Este programa no se puede ejecutar en este equipo");
    }

    private static void traductor() {
        int iTiempoMax = (int) ValidaLibrary.valida("Introduce el tiempo maximo de ejecucion del proceso: ", 1,100,1);
        TraducirThread proceso = new TraducirThread();

        proceso.start();

        try {
            Thread.sleep(iTiempoMax);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        proceso.stopRunning();
    }
}

class TraducirThread extends Thread {
    private static String sIdioma1;
    private static String sIdioma2;
    private static String sFrase;

    private volatile boolean flag = true;

    public void stopRunning() {
        flag = false;
    }

    @Override
    public void run() {
        while(flag) {
            traductor();
        }
        System.out.println("Tiempo terminado");
    }

     public void traductor() {
        String sRuta = ValidaLibrary.leer("Introduce la ruta del exe del navegador: ");

        sIdioma1 = ValidaLibrary.leer("Introduce el idioma del que vas a traducir.(Por ejemplo: es = Spanish, en = english)");
        sIdioma2 = ValidaLibrary.leer("Introduce el idioma al que quieres traducir.");
        sFrase = ValidaLibrary.leer("Introduce la frase a traducir: ");
        if (sIdioma1.equals(""))
            sIdioma1 = "es";
        if (sIdioma2.equals(""))
            sIdioma2 = "en";
        if (sFrase.equals(""))
            sFrase = "Pon una frase para traducirla, campeon";
        String EN_TO_SP = "http://translate.google.es/?hl="+sIdioma1+"#auto/"+ sIdioma2 +"/"+sFrase;

        ProcessBuilder pb = new ProcessBuilder(sRuta, EN_TO_SP);
        try {
            // Lanzamos el proceso
            pb.start();
        }catch (IOException e) {
            System.out.println("Error IO: " + e.getMessage());
            System.exit(-1);
        }
    }
}

