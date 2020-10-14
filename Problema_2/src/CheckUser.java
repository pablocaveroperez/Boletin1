import java.io.IOException;

public class CheckUser {
    public static void main(String[] args) throws IOException {
        String user = args[0];
        String OS = System.getProperty("os.name");
        if (OS.equals("Windows 10")) {
            Runtime.getRuntime().exec("cmd.exe /c > ping net user " + user + " 2>> errorBat.txt");

        }else if (OS.equals("Linux")) {
            String[] terminalLinux = new String[] {"/bin/bash", "-c", "cat /etc/passwd", "with", "args"};
            Process proc = new ProcessBuilder(terminalLinux).start();
        }else {
            System.err.println("Sistema operativo no detectado. Campeon");
        }
    }
}
