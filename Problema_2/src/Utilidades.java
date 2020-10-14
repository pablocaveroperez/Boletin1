import validaciones.ValidaLibrary;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Utilidades {
    public static void main(String[] args) throws IOException, InterruptedException {
        String valor1 = ValidaLibrary.leer("Introduce el primer parametro: ");
        String valor2 = ValidaLibrary.leer("¿Quiere introducir un segundo parametro?(0-NO | 1-SI) ");
        List<String> jvmArgs = new ArrayList<>();
        List<String> argsM = new ArrayList<>();
        Process process;

        if (valor2.equals("1")) {
            valor2 = ValidaLibrary.leer("Introduce el segundo parametro: ");
            argsM.add(valor1);
            argsM.add(valor2);
            process = JavaProcess.exec(CompararArchivos.class, jvmArgs, argsM);
        }
    }
}
