import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CompararArchivos {
    public static void main(String[] args) {
        Path path1 = Paths.get(args[0]);
        Path path2 = Paths.get(args[1]);
        String content1 = null;
        String content2 = null;
        try {
            // Lee los ficheros de la ruta dada por el usuario
            List<String> lines1 = Files.readAllLines(path1, StandardCharsets.UTF_8);
            content1 = String.join(System.lineSeparator(), lines1);

            List<String> lines2 = Files.readAllLines(path2, StandardCharsets.UTF_8);
            content2 = String.join(System.lineSeparator(), lines2);
        } catch (IOException e) {
            System.err.println("Error IO: " + e.getMessage());;
        }

        assert content1 != null;
        if (content1.equals(content2))
            System.out.println("Los do archisvo sons insguale.");
        else
            System.out.println("Los do archisvo no sons insguale.");
    }
}
