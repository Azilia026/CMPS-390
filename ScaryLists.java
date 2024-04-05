import java.util.Scanner;
public class ScaryLists {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        linked list = new linked();
        list.init();
        Scanner input = new Scanner(System.in);
        System.out.println("Input file name: ");

        list.makeListFromFile(input.nextLine());

        list.buildIndex();

        boolean running;
        int choice;
        list.showlist();

        running=true;
        
        while(running){
            System.out.println("\nWhat would you like to do?");
            System.out.println("1) Display List");
            System.out.println("2) Display List Length");
            System.out.println("3) Insert Node");
            System.out.println("4) Delete Node");
            System.out.println("5) Displey length of a section");
            System.out.println("6) Display section");
            System.out.println("7) End Program\n");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    list.showlist();
                    break; 

                case 2:
                    System.out.println("List length: " + list.getListLength());
                    break;

                case 3:
                    System.out.println("Enter Name: ");
                    input.nextLine();
                    String name = input.nextLine();
                    list.insertOrdered(name);
                    System.out.println();
                    list.showlist();
                    break;

                case 4:
                    System.out.println("Which node would you like to delete?");
                    input.nextLine();
                    try {
                        list.deleteNode(input.nextLine());
                        System.out.println();
                        list.showlist();
                    } 
                    catch (NullPointerException e) {
                        System.out.println("Cannot find node.");
                    }
                    break;

                case 5:
                    System.out.println("Which section length would you like to display? (a-z)");
                    input.nextLine();
                    System.out.println(list.getSectionLength(input.nextLine().toLowerCase().charAt(0)));

                    break;

                case 6:
                    System.out.println("Which section would you like to display? (a-z)");
                    input.nextLine();
                    list.displaySection(input.nextLine().toLowerCase().charAt(0));
                    break;

                case 7:
                    running = false;
                    break;
            
                default:
                    System.out.println("Please enter a valid intager");
                    break;
            }
        }
        System.out.println("Goodbye!");
    }
}
