package unico;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Consola {
    public static void main(String[] args) throws IOException, InterruptedException {
        String OS = System.getProperty("os.name");
        System.out.println("El Sistema operativo es " + OS);

        final String FILE_NAME = args[0];
        File archivo = new File(FILE_NAME);
        List<String> jvmArgs = new ArrayList<>();
        List<String> argsM = new ArrayList<>();
        argsM.add(FILE_NAME);
        Process p;


        if (archivo.exists() && archivo.isFile())
            p = JavaProcess.exec(MostrarArchivo.class, jvmArgs, argsM);
        else if (archivo.exists() && archivo.isDirectory()){
            p = JavaProcess.exec(ListarDirectorio.class, jvmArgs, argsM);
        }else
            System.out.println("El fichero o directorio introducido no existe");
    }
}
