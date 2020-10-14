import validaciones.ValidaLibrary;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Principal {
    public static void main(String[] args) {
        String OS = System.getProperty("os.name");


        if (OS.equals("Windows 10")) {
            traductor();
        } else if (OS.equals("Linux")) {
            traductor();
        } else
            System.out.println("Este programa no se puede ejecutar en este equipo");
    }

    private static void traductor() {
        int iTiempoMax;
        List<String> jvmArgs = new ArrayList<>();
        List<String> argsM = new ArrayList<>();
        byte condicionSalida = 0;

        do {
            try {
                iTiempoMax = (int) ValidaLibrary.valida("Introduce el tiempo maximo de ejecucion del proceso: ", 1,100,1);

                Process process = JavaProcess.exec(Traductor.class, jvmArgs, argsM);
                process.waitFor(iTiempoMax,TimeUnit.SECONDS);
                process.destroy();
            } catch (IOException | InterruptedException e) {
                System.err.println("Error IO: " + e.getMessage());
            }
            condicionSalida = (byte) ValidaLibrary.valida("¿Quiere volver a ejecutarlo?(0 - No || 1 - Si)", 0,1,3);
        }while(condicionSalida == 1);
    }
}