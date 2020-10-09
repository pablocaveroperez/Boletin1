import validaciones.ValidaLibrary;

import java.io.IOException;

public class Traductor {
    public static void main(String[] args) {
        String OS = System.getProperty("os.name");
        String sRutaAcceso = args[0];
        if (OS.equals("Windows 10"))
            traductor(sRutaAcceso);
        else if (OS.equals("Linux"))
            traductor(sRutaAcceso);
        else
            System.out.println("Este programa no se puede ejecutar en este equipo");
    }

    private static void traductor(String sRuta) {
        byte bSalidaBucle = 0;
        do {
            int iTiempoMax;
            String sIdioma1 = ValidaLibrary.leer("Introduce el idioma del que vas a traducir.(Por ejemplo: es = Spanish, en = english)");
            String sIdioma2 = ValidaLibrary.leer("Introduce el idioma al que quieres traducir.");
            String sFrase = ValidaLibrary.leer("Introduce la frase a traducir: ");
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
            bSalidaBucle = (byte) ValidaLibrary.valida("Introduce un 0 para terminar o un 1 para volver a ejecutarlo", 0, 1, 3);
        }while (bSalidaBucle == 1);

    }
}
