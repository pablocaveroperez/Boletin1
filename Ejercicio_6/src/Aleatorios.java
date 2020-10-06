import java.util.Random;

public class Aleatorios {
    public static void main(String[] args) {
        Random r = new Random();
        int iNum = r.nextInt(10 + 1);
        System.out.println("Numero generado aleatoriamente: " + iNum);
        if (iNum > Integer.parseInt(args[0]) || iNum < Integer.parseInt(args[0]))
            System.out.println("El numero aleatorio es diferente a el introducido");
        else
            System.out.println("El numero introducido y el aleatorio son iguales");
    }
}