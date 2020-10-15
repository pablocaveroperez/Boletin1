import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CmdExecuter {
    public static void main(String[] args) throws IOException {
        List<String> jvmArgs = new ArrayList<>();
        List<String> argsM = new ArrayList<>();

        try {
            JavaProcess.exec(EjecutaBat.class, jvmArgs, argsM);
        }catch (InterruptedException e) {
            System.err.println("Error IE: " + e.getMessage());
        }
    }
}
