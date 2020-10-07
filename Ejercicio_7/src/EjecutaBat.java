import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class EjecutaBat {
    public static void main(String[] args) throws IOException {
        String OS = System.getProperty("os.name");
        if (OS.equals("Windows 10")){
            ejecutarBat();
        }else
            System.out.println("Este programa solo se puede ejecutar en Windows 10");
    }

    private static void ejecutarBat() throws IOException {
        final String FILE_SALIDA = "salidaBat.txt";
        final String FILE_ERROR = "errorBat.txt";
        Process process = Runtime.getRuntime().exec("cmd /c start \"\" ejecuta.bat");

        BufferedReader salidaCMD = new BufferedReader(new InputStreamReader(process.getInputStream()));

        BufferedReader salidaERROR = new BufferedReader(new InputStreamReader(process.getErrorStream()));

        // LEER LA SALIDA DE LA CONSOLA
        String sCMD = null;
        String salida = "";
        while ((sCMD = salidaCMD.readLine()) != null) {
            salida += sCMD;
        }
        escribirArchivo(FILE_SALIDA, salida);

        // LEER LOS ERRORES DE LA CONSOLA
        String sERROR = null;
        salida = "";
        while ((sERROR = salidaERROR.readLine()) != null) {
            salida += sERROR;
        }
        escribirArchivo(FILE_ERROR, salida);
    }

    private static void escribirArchivo(String FILE_NAME, String sTexto) {
        try {
            FileWriter fchEscribir = new FileWriter(FILE_NAME);

            fchEscribir.write(sTexto);

            fchEscribir.close();
        } catch (IOException e) {
            System.err.println("Error IO: " + e.getMessage());
        }
    }
}
