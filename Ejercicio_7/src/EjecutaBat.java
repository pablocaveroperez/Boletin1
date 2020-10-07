import java.io.IOException;

public class EjecutaBat {
    public static void main(String[] args) throws IOException {
        Runtime.getRuntime().exec("cmd /c start \"\" ejecuta.bat");
    }
}
