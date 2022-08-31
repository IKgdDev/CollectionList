import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> shopCart = new ArrayList<>();

        while (true) {

            System.out.println("Выберите операцию или введите `end`");
            System.out.println("1. Добавить покупку.");
            System.out.println("2. Показать покупки.");
            System.out.println("3. Удалить покупку.");
            System.out.println("4. Поиск по покупкам.");

            String input = scan.nextLine();

            if ("end".equals(input)) {
                break;
            }

            switch (Integer.parseInt(input)) {
                case 1: {
                    System.out.println("\nКакую покупку хотите добавить?");
                    input = scan.nextLine();
                    shopCart.add(input);
                    System.out.println("Итого в списке покупок:" + shopCart.size() + "\n");
                    break;
                }
                case 2: {
                    shopList(shopCart);
                    break;
                }
                case 3: {
                    shopList(shopCart);
                    System.out.println("Какую покупку хотите удалить? Введите номер или название.");
                    input = scan.nextLine();

                    int index;

                    try {
                        index = Integer.parseInt(input);
                    } catch (NumberFormatException e) {
                        index = shopCart.indexOf(input) + 1;
                    }

                    String remPurchase = shopCart.get(index - 1);
                    shopCart.remove(index - 1);
                    System.out.println("Покупка \"" + remPurchase + "\" удалена.");
                    shopList(shopCart);
                    break;
                }
                case 4: {
                    System.out.println("\nВведите текст для поиска:");
                    input = scan.nextLine().toLowerCase();

                    System.out.println("\nНайдено:");
                    for (int i = 0; i < shopCart.size(); i++) {
                        if (shopCart.get(i).toLowerCase().contains(input)) {
                            System.out.println((i + 1) + ". " + shopCart.get(i));
                        }
                    }
                    System.out.println();
                    break;
                }
                default:
                    System.out.println("Такой операции нет.");
            }
        }
    }

    public static void shopList(List<String> shopCart) {
        System.out.println("\nСписок покупок:");
        for (int i = 0; i < shopCart.size(); i++) {
            System.out.println((i + 1) + ". " + shopCart.get(i));
        }
        System.out.println();
    }
}