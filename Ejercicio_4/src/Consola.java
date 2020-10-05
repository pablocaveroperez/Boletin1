import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Consola {
    public static void main(String[] args) {
        String OS = System.getProperty("os.name");
        System.out.println("El Sistema operativo es " + OS);

        final String FILE_NAME = args[0];
        File archivo = new File(FILE_NAME);
        String[] joselito;

        if (archivo.isFile())
            readFileChar(FILE_NAME);
        else if (archivo.isDirectory()){
            joselito = showDirectoryContent(FILE_NAME);
            System.out.println(Arrays.toString(joselito));
        }else
            System.out.println("El fichero o directorio introducido no existe");
    }

    private static String[] showDirectoryContent(String DIRECTORY_NAME) {
        String[] salida;
        File directorio = new File(DIRECTORY_NAME);
        salida = directorio.list();

        return salida;
    }

    private static void readFileChar(String FILE_NAME) {
        try {
            int caracter;
            FileReader fch = new FileReader(FILE_NAME);
            caracter = fch.read();
            while (caracter != -1) {
                System.out.println((char)caracter + "\t" + caracter);
                caracter = fch.read();
            }
            fch.close();
        }catch (FileNotFoundException e) {
            System.err.println("Fichero no encontrado.");
        }catch (IOException e) {
            System.err.println("Error de acceso.");
        }
    }
}
