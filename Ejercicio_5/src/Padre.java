import validaciones.ValidaLibrary;

public class Padre {
    public static void main(String[] args) throws InterruptedException {
        int iNumero = 1;
        while (iNumero == 1) {
            System.out.println(Hijo.return2());
            iNumero = (int) ValidaLibrary.valida("Introduce un 1 para volver a ejecutarlo o un 0 para terminar: ", 0, 1, 1);
        }
    }
}
