package unica;

import validaciones.ValidaLibrary;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class NavegadorWeb {
    public static void main(String[] args) {
        String sRutaProceso = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe";

        ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
        exec.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                // Creacion de proceso
                String inputTeclado = ValidaLibrary.leer("Introduce la url: ");
                ProcessBuilder pb = new ProcessBuilder(sRutaProceso, inputTeclado);

                try {
                    // Lanzamos el proceso
                    Process pruses = pb.start();

                    // Obtenemos estado de ejecucion
                    int iRetorno = pruses.waitFor();

                    System.out.println("La ejecucion del proceso " + sRutaProceso + " devuelve " + iRetorno);
                }catch (IOException e) {
                    System.out.println("Error IO: " + e.getMessage());
                    System.exit(-1);
                }catch (InterruptedException e) {
                    System.out.println("Error IE: " + e.getMessage());
                }
            }
        }, 0, 10, TimeUnit.SECONDS);

    }
}
