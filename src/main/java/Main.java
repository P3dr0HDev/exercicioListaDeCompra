import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static List<Item> itemList = new ArrayList<>();

    public static void main(String[] args) {

    }

    static int lerInteiro(String prompt) {
        while (true) {
            System.out.print(prompt);

            if (!sc.hasNextInt()) {
                System.out.println("*** Erro, digite apenas numeros ***");
                sc.nextLine();
                continue;
            }

            int numero = sc.nextInt();
            sc.nextLine();

            return numero;
        }
    }

}
