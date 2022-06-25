package budget;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<MenuItem> menuItems;

    public Menu() {
        menuItems = new ArrayList<>();
        populateMenuItems();
    }

    private void populateMenuItems() {
        menuItems.add(new MenuItem(1, "Add income"));
        menuItems.add(new MenuItem(2, "Add purchase"));
        menuItems.add(new MenuItem(3, "Show list of purchases"));
        menuItems.add(new MenuItem(4, "Balance"));
        menuItems.add(new MenuItem(0, "Exit"));
    }

    public void print() {
        System.out.println("Choose your action:");
        for (MenuItem menuItem : menuItems) {
            System.out.printf("%d) %s\n", menuItem.getId(), menuItem.getTitle());
        }
    }
}
