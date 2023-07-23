import java.util.Scanner;
import classes.product;

public class java_project {
    public static void main(String[] args) {
        product p = new product();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\033[H\033[2J");// clearscreen
            System.out.println(
                    "        1. Add Product \n        2. Delete Product \n        3. Search Product\n        4. Modify Product\n        5. Show Product\n        6. Exit");
            System.out.print("Enter Your Choise :: ");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    System.out.print("Enter Name :: ");
                    String name = sc.next();
                    System.out.print("Enter Quantity :: ");
                    int q = sc.nextInt();
                    System.out.print("Enter Id  :: ");
                    int id = sc.nextInt();
                    System.out.print("Enter Price  :: ");
                    int price = sc.nextInt();
                    p.add(name, q, id, price);
                    break;
                case 2:
                    System.out.print("Enter Name :: ");
                    name = sc.next();
                    System.out.print("Enter Quantity :: ");
                    q = sc.nextInt();
                    try {
                        p.delete(name, q);
                    } catch (Exception e) {

                    }
                    break;
                case 3:
                    System.out.print("Enter Name :: ");
                    name = sc.next();
                    try {
                        p.search(name);
                        sc.next();
                    } catch (Exception e) {

                    }
                    break;
                case 4:
                    System.out.print("Enter Name :: ");
                    name = sc.next();
                    try {
                        p.update(name);
                        sc.next();
                    } catch (Exception e) {

                    }
                    break;
                case 5:
                    try {
                        p.show();
                        sc.next();
                    } catch (Exception e) {

                    }
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Enter valid Choise ");
                    sc.next();
            }
        }
    }
}