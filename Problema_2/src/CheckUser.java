import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CheckUser {
    public static void main(String[] args) throws IOException {
        String user = args[0];
        String OS = System.getProperty("os.name");
        if (OS.equals("Windows 10")) {
            Process process = Runtime.getRuntime().exec("cmd.exe /c net user " + user + " 2>> ERRORES.DAT");
            BufferedReader salidaCMD = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String s = salidaCMD.readLine();
            if (s == null) {
                System.err.println("Usuario no encontrado. Error annadido al archivo ERRORES.DAT");
            }
            while (s != null) {
                System.out.println(s);
                s = salidaCMD.readLine();
            }
        }else if (OS.equals("Linux")) {
            Process process = Runtime.getRuntime().exec("grep -c " + user);
            BufferedReader salidaCMD = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String s = salidaCMD.readLine();
            if (s == null) {
                System.err.println("Usuario no encontrado. Error annadido al archivo ERRORES.DAT");
            }
            while (s != null) {
                System.out.println(s);
                s = salidaCMD.readLine();
            }
        }else {
            System.err.println("Sistema operativo no detectado. Campeon");
        }
    }
}
