package unica;

import validaciones.ValidaLibrary;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class NavegadorWeb {
    public static void main(String[] args) {
        String OS = System.getProperty("os.name");
        final String RUTA_NAVEGADOR = args[0];
        if (OS.equals("Windows 10"))
            navegadorWebWindows(RUTA_NAVEGADOR);
        else if (OS.equals("Linux"))
            navegadorWebLinux(RUTA_NAVEGADOR);
        else
            System.out.println("Esta aplicacion no esta disponible para este sistema operativo");
    }

    private static void navegadorWebLinux(String RUTA_NAVEGADOR) {
        String sRutaProceso = RUTA_NAVEGADOR;


        int iRetorno = 0;
        do {
            String inputTeclado = ValidaLibrary.leer("Introduce la url: ");
            ProcessBuilder pb = new ProcessBuilder(sRutaProceso, inputTeclado);
            try {
                // Lanzamos el proceso
                Process pruses = pb.start();

                // Obtenemos estado de ejecucion
                iRetorno = pruses.waitFor();

                System.out.println("La ejecucion del proceso " + sRutaProceso + " devuelve " + iRetorno);
                Thread.sleep(10000);
            }catch (IOException e) {
                System.out.println("Error IO: " + e.getMessage());
                System.exit(-1);
            }catch (InterruptedException e) {
                System.out.println("Error IE: " + e.getMessage());
            }

        }while (iRetorno == 0);
    }

    private static void navegadorWebWindows(String RUTA_NAVEGADOR) {
        String sRutaProceso = RUTA_NAVEGADOR;


        int iRetorno = 0;
        do {
            String inputTeclado = ValidaLibrary.leer("Introduce la url: ");
            ProcessBuilder pb = new ProcessBuilder(sRutaProceso, inputTeclado);
            try {
            // Lanzamos el proceso
            Process pruses = pb.start();

            // Obtenemos estado de ejecucion
            iRetorno = pruses.waitFor();

            System.out.println("La ejecucion del proceso " + sRutaProceso + " devuelve " + iRetorno);
            Thread.sleep(10000);
            }catch (IOException e) {
                System.out.println("Error IO: " + e.getMessage());
                System.exit(-1);
            }catch (InterruptedException e) {
                System.out.println("Error IE: " + e.getMessage());
            }
        }while (iRetorno == 0);

    }
}
