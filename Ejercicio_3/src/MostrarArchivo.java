import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class MostrarArchivo {
    public static void main(String[] args) {
        Path path = Paths.get(args[0]);
        String content = null;
        try {
            // Lee los ficheros de la ruta dada por el usuario
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            content = String.join(System.lineSeparator(), lines);
        } catch (IOException e) {
            System.err.println("Error IO: " + e.getMessage());;
        }
        System.out.println(content);
    }
}
