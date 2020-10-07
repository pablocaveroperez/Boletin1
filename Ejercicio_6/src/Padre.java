import validaciones.ValidaLibrary;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Padre {
    public static void main(String[] args) throws IOException, InterruptedException {
        int iSalir = 1;
        int iNum;

        List<String> jvmArgs = new ArrayList<>();
        List<String> argsM = new ArrayList<>();

        while(iSalir == 1) {
            iNum = (int) ValidaLibrary.valida("Introduce un numero del 0 al 10: ", 0, 10, 1);
            argsM.add(0, String.valueOf(iNum));
            Process p = JavaProcess.exec(Aleatorios.class, jvmArgs, argsM);
            iSalir = (int) ValidaLibrary.valida("Introduce un 1 para volver a ejecutarlo o un 0 para terminar: ", 0, 1, 1);
        }
    }
}
