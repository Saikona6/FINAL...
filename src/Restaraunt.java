import java.util.ArrayList;
import java.io.*;

public class Restaraunt {
   {
    }
    private ArrayList<Dish> menu = new ArrayList<>();

    public void addDish(Dish dish) {
        menu.add(dish);
    }

    public void showMenu() {
        if (menu.isEmpty()) {
            System.out.println("Menu is empty");
            return;
        }

        for (Dish d : menu) {
            System.out.println(
                    d.getId() + " | " +
                            d.getName() + " | " +
                            d.getPrice() + " | " +
                            d.getDescription()
            );
        }
    }

    public Dish findDish(int id) {
        for (Dish d : menu) {
            if (d.getId() == id) {
                return d;
            }
        }
        return null;
    }

    public void deleteDish(int id) {
        for (int i = 0; i < menu.size(); i++) {
            if (menu.get(i).getId() == id) {
                menu.remove(i);
                System.out.println("Deleted");
                return;
            }
        }
        System.out.println("Not found");
    }

    public void saveToFile() {
        try {
            PrintWriter writer = new PrintWriter("menu.txt");

            for (Dish d : menu) {
                writer.println(
                        d.getId() + "," +
                                d.getName() + "," +
                                d.getPrice() + "," +
                                d.getDescription()
                );
            }

            writer.close();
            System.out.println("Saved");

        } catch (Exception e) {
            System.out.println("Error saving");
        }
    }

    public void loadFromFile() {
        menu.clear();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("menu.txt"));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                double price = Double.parseDouble(data[2]);
                String desc = data[3];

                menu.add(new Dish(id, name, price, desc));
            }

            reader.close();
            System.out.println("Loaded");

        } catch (Exception e) {
            System.out.println("File not found");
        }
    }
}