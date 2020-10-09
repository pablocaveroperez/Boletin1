import java.util.Random;

public class Aleatorios {
    public static void main(String[] args) {
        Random r = new Random();
        int iNum = r.nextInt(10 + 1);
        System.out.println("Numero generado aleatoriamente: " + iNum);
        System.exit(iNum);
    }
}