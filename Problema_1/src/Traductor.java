import validaciones.ValidaLibrary;

import java.io.IOException;
import java.util.concurrent.*;

public class Traductor {
    private static int iTiempoMax = (int) ValidaLibrary.valida("Introduce el tiempo maximo de ejecucion del proceso: ", 1,10,1);
    private static String sIdioma1 = ValidaLibrary.leer("Introduce el idioma del que vas a traducir.(Por ejemplo: es = Spanish, en = english)");
    private static String sIdioma2 = ValidaLibrary.leer("Introduce el idioma al que quieres traducir.");
    private static String sFrase = ValidaLibrary.leer("Introduce la frase a traducir: ");

    public static void main(String[] args) throws InterruptedException {
        String OS = System.getProperty("os.name");
        String sRutaAcceso = args[0];



        if (OS.equals("Windows 10")) {
            traductor(sRutaAcceso);
        }else if (OS.equals("Linux")) {
            traductor(sRutaAcceso);            //        <-- your job
        }else
            System.out.println("Este programa no se puede ejecutar en este equipo");
    }

    private static void traductor(String sRuta) {
        byte bSalidaBucle = 0;
        do {
            ExecutorService executor = Executors.newFixedThreadPool(4);

            Future<?> future = executor.submit(new Runnable() {
                @Override
                public void run() {
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

                    ProcessBuilder pb = new ProcessBuilder(sRuta, EN_TO_SP);            //        <-- your job
                    try {
                        // Lanzamos el proceso
                        pb.start();
                    }catch (IOException e) {
                        System.out.println("Error IO: " + e.getMessage());
                        System.exit(-1);
                    }

                }

            });

            try {
                future.get(iTiempoMax, TimeUnit.SECONDS);  //     <-- wait 8 seconds to finish
            } catch (InterruptedException e) {    //     <-- possible error cases
                System.out.println("job was interrupted");
            } catch (ExecutionException e) {
                System.out.println("caught exception: " + e.getCause());
            } catch (TimeoutException e) {
                future.cancel(true);              //     <-- interrupt the job
                System.out.println("timeout");
            }
            bSalidaBucle = (byte) ValidaLibrary.valida("Introduce un 0 para terminar o un 1 para volver a ejecutarlo", 0, 1, 3);
            iTiempoMax = (int) ValidaLibrary.valida("Introduce el tiempo maximo de ejecucion del proceso: ", 1,10,1);

        }while (bSalidaBucle == 1);

    }
}
