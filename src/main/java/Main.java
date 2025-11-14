import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static List<Item> itemList = new ArrayList<>();

    public static void main(String[] args) {

    }

    static int optionMenu() {
        System.out.println("""
                +++++++++++++++++++++++++++++++++++++++++++++++++++++
                                ADICIONE SUA MÚSICA
                +++++++++++++++++++++++++++++++++++++++++++++++++++++
                             1- Adicionar produto
                             2- Remover Produto
                             3- Listar Produtos
                             4- 
                             0- sair ==========>
                =====================================================
                """);

        int option = 0;
        while (true) {
            System.out.println("Opção: ");
            if (!sc.hasNextInt()) {
                System.out.println("Erro! Digite apenas números!");
                sc.nextLine();
                continue;

            }
            option = sc.nextInt();
            sc.nextLine();
            break;
        }

        return option;
    }

    static void menu() {
        while(true) {
            int option = optionMenu();

            if (option == 0) {
                System.out.println("Saindo do programa");
                break;
            }

            switch (option) {
                case 1 -> addItem();
                case 2 -> deleteItem();
                case 3 -> listItem();
                case 4 -> checkout();

                default -> {
                    System.out.println("Opção inválida");
                    menu();
                }
            }
        }
    }

    static void addItem() {
        System.out.println("Item: ");
        String name = sc.nextLine();
        System.out.println("Prioridade: ");
        int priority = sc.nextInt();
        System.out.println("Preço: ");
        int price = sc.nextInt();
        sc.nextLine();

        Item item = new Item(name, priority, price);
        itemList.add(item);

        System.out.println("Item adicionad!");
        menu();
    }

    static void listItem() {
        System.out.println("+++++++Lista de Compra +++++++");

        for (int i = 0; i < itemList.size(); i++) {
            Item item = itemList.get(i);
            System.out.printf("""
                    +++++++++++++++++++
                    Quantidade de itens: %d
                    Nome: %s
                    Prioridade: %d
                    Preço: %d
                    +++++++++++++++++++
                    """, itemList.size(), item.getName(), item.getPriority(), item.getPrice());
        }
        menu();
    }

    static void deleteItem() {
        System.out.println("Remover produto\n");
        listItem();

        while (true) {
            System.out.println("Digite o número do produto");
            if (!sc.hasNextInt()) {
                System.out.println("Erro, digite apenas números!\n");
                continue;
            }

            int index = sc.nextInt();
            sc.nextLine();

            if (index >= 0 && index < Main.itemList.size()) {
                System.out.println("Produto removido!");

                break;
            } else {
                System.out.println("ERRO. Produto não existe");
            }
        }
        menu();

    }

    static void checkout(){

    }

    /*static int lerInteiro(String prompt) {
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
    }*/

}
