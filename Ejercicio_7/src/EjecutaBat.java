import java.io.IOException;

public class EjecutaBat {
    public static void main(String[] args) throws IOException {
        String OS = System.getProperty("os.name");
        if (OS.equals("Windows 10")){
            Runtime.getRuntime().exec("cmd.exe /c > ping ejecuta.bat >> salidaBat.txt 2>> errorBat.txt");
        }else
            System.out.println("Este programa solo se puede ejecutar en Windows 10");
    }
}
