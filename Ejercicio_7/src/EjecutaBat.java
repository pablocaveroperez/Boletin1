import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EjecutaBat {
    public static void main(String[] args) throws IOException, InterruptedException {
        String OS = System.getProperty("os.name");

        if (OS.equals("Windows 10")){
            List<String> jvmArgs = new ArrayList<>();
            List<String> argsM = new ArrayList<>();
            JavaProcess.exec(CmdExecuter.class, jvmArgs, argsM);
        }else
            System.out.println("Este programa solo se puede ejecutar en Windows 10");
    }
}
