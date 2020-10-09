import validaciones.ValidaLibrary;

import java.io.IOException;

public class Traductor {
    private static String sFrase;
    private static int iTiempoMax;
    private static String sIdioma1 = ValidaLibrary.leer("Introduce el idioma del que vas a traducir.(Por ejemplo: es = Spanish, en = english)");
    private static String sIdioma2 = ValidaLibrary.leer("Introduce el idioma al que quieres traducir.");
    private final String EN_TO_SP = "http://translate.google.es/?hl="+sIdioma1+"#auto/"+ sIdioma2 +"/hello";


    public static void main(String[] args) {
        String OS = System.getProperty("os.name");
        String sRutaAcceso = args[0];
        if (OS.equals("Windows 10"))
            traductorWindows(sRutaAcceso);
        else if (OS.equals("Linux"))
            traductorLinux(sRutaAcceso);
        else
            System.out.println("Este programa no se puede ejecutar en este equipo");
    }

    private static void traductorLinux(String sRuta) {
        int iRetorno = 0;

        sFrase = ValidaLibrary.leer("Introduce la frase a traducir: ");
        ProcessBuilder pb = new ProcessBuilder(sRuta, sFrase);
        try {
            // Lanzamos el proceso
            Process pruses = pb.start();

            // Obtenemos estado de ejecucion
            iRetorno = pruses.waitFor();

            Thread.sleep(10000);
        }catch (IOException e) {
            System.out.println("Error IO: " + e.getMessage());
            System.exit(-1);
        }catch (InterruptedException e) {
            System.out.println("Error IE: " + e.getMessage());
        }
    }

    private static void traductorWindows(String sRuta) {

    }
}
