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
            Process p = JavaProcess.exec(Aleatorios.class, jvmArgs, argsM);
            int iAleatorio = p.exitValue();
            if (iNum > iAleatorio || iNum < iAleatorio)
                System.out.println("El numero aleatorio es diferente a el introducido");
            else
                System.out.println("El numero introducido y el aleatorio son iguales");
            iSalir = (int) ValidaLibrary.valida("Introduce un 1 para volver a ejecutarlo o un 0 para terminar: ", 0, 1, 1);
        }
    }
}
