public class Hijo {
    public static int return2() throws InterruptedException {
        Thread.sleep(3000);
        int i = 2;
        System.out.println("Proceso Hijo terminado");
        return i;
    }
}
