import java.io.IOException;

public class CmdExecuter {
    public static void main(String[] args) throws IOException {
        Runtime.getRuntime().exec("cmd.exe /c > ping ejecuta.bat >> salidaBat.txt 2>> errorBat.txt");
    }
}
