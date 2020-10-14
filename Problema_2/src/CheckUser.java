import java.io.IOException;

public class CheckUser {
    public static void main(String[] args) throws IOException {
        String user = args[0];
        String OS = System.getProperty("os.name");
        if (OS.equals("Windows 10")) {
            Runtime.getRuntime().exec("cmd.exe /c > salidaCMD.txt net user " + user + " 2>> ERRORES.DAT");

        }else if (OS.equals("Linux")) {
            Process process = Runtime.getRuntime().exec("grep -c " + user);
        }else {
            System.err.println("Sistema operativo no detectado. Campeon");
        }
    }
}
