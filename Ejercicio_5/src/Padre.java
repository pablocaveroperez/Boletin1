import validaciones.ValidaLibrary;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Padre {
    public static void main(String[] args) throws InterruptedException, IOException {
        int iNumero = 1;
        List<String> jvmArgs = new ArrayList<>();
        List<String> argsM = new ArrayList<>();

        while (iNumero == 1) {
            Process p = JavaProcess.exec(Hijo.class, jvmArgs, argsM);
            System.out.println("Valor de salida del proceso: " + p.exitValue());
            iNumero = (int) ValidaLibrary.valida("Introduce un 1 para volver a ejecutarlo o un 0 para terminar: ", 0, 1, 1);
        }
    }
}
