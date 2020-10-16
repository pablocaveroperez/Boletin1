package unico;

import java.io.File;

public class ListarDirectorio {
    public static void main(String[] args) {
        String[] aSalida;
        File directorio = new File(args[0]);
        aSalida = directorio.list();

        for (String imprimir : aSalida) {
            System.out.println(imprimir);
        }
    }
}
