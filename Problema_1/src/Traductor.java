import validaciones.ValidaLibrary;

import java.io.IOException;

public class Traductor {


    public static void main(String[] args) {
        String sIdioma1;
        String sIdioma2;
        String sFrase;
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
