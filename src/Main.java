import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Restaraunt manager = new Restaraunt();

        while (true) {

            System.out.println("1 Add");
            System.out.println("2 Show");
            System.out.println("3 Update");
            System.out.println("4 Delete");
            System.out.println("5 Save");
            System.out.println("6 Load");
            System.out.println("0 Exit");

            System.out.print("Choose: ");
            int choice = input.nextInt();

            if (choice == 1) {

                System.out.print("ID: ");
                int id = input.nextInt();
                input.nextLine();

                if (manager.findDish(id) != null) {
                    System.out.println("ID exists");
                    continue;
                }

                System.out.print("Name: ");
                String name = input.nextLine();

                if (name.equals("")) {
                    System.out.println("Name is empty");
                    continue;
                }

                System.out.print("Price: ");
                double price = input.nextDouble();
                input.nextLine();

                if (price <= 0) {
                    System.out.println("Wrong price");
                    continue;
                }

                System.out.print("Description: ");
                String desc = input.nextLine();

                if (desc.equals("")) {
                    System.out.println("Description is empty");
                    continue;
                }

                System.out.println("1 Normal Dish");
                System.out.println("2 Vip Dish");
                int type = input.nextInt();
                input.nextLine();

                if (type == 1) {
                    manager.addDish(new Dish(id, name, price, desc));
                } else {
                    manager.addDish(new VipDish(id, name, price, desc));
                }

                System.out.println("Added");

            }

            else if (choice == 2) {
                manager.showMenu();
            }

            else if (choice == 3) {

                System.out.print("ID: ");
                int id = input.nextInt();
                input.nextLine();

                Dish d = manager.findDish(id);

                if (d != null) {
                    System.out.print("New price: ");
                    d.setPrice(input.nextDouble());
                    input.nextLine();

                    System.out.print("New desc: ");
                    d.setDescription(input.nextLine());

                    System.out.println("Updated");
                } else {
                    System.out.println("Not found");
                }
            }

            else if (choice == 4) {
                System.out.print("ID: ");
                int id = input.nextInt();
                manager.deleteDish(id);
            }

            else if (choice == 5) {
                manager.saveToFile();
            }

            else if (choice == 6) {
                manager.loadFromFile();
            }

            else if (choice == 0) {
                break;
            }
        }
    }
}