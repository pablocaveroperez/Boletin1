import java.util.Random;

public class Aleatorios {
    public static int generadorAleatorios() {
        Random r = new Random();
        int iNum = r.nextInt(10+1);
        return iNum;
    }
}
