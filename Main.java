import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Display menu
            System.out.println("1 - Insert a number");
            System.out.println("2 - Remove a number");
            System.out.println("3 - Search for a number");
            System.out.println("4 - Print tree");
            System.out.println("0 - Exit");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();

            if (option == 1) { // Insert
                System.out.println("Enter the number to insert: ");
                tree.insert(scanner.nextInt());
            } else if (option == 2) { // Remove
                System.out.println("Enter the number to remove: ");
                tree.remove(scanner.nextInt());
            } else if (option == 3) { // Search
                System.out.println("Enter the number to search: ");
                int number = scanner.nextInt();
                System.out.println(tree.search(number));
            } else if (option == 4) { // Print
                AVLTree.printTree(tree.getRoot(), "");
            } else if (option == 0) { // Exit
                scanner.close();
                break;
            } else {
                System.out.println("Invalid option");
            }
        }
    }
}