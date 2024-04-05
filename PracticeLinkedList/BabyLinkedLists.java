import java.util.Scanner;
public class BabyLinkedLists {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        linked list = new linked();
        list.init();
        list.buildSimpleList(10);
        list.showlist();
        boolean running;
        Scanner input = new Scanner(System.in);
        int choice;

        running=true;
        while(running){
            System.out.println("\nWhat would you like to do?");
            System.out.println("1) Add A Node Sequentially");
            System.out.println("2) Add A Node After A Specific Node");
            System.out.println("3) Delete Node");
            System.out.println("4) End Program\n");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter Node Data: ");
                    list.insertOrdered(input.nextInt());
                    System.out.println();
                    list.showlist();
                    break;
                case 2:
                    System.out.println("Which Node Do You Want To Place the new node after? ");
                    int number = input.nextInt();
                    System.out.println("Input New Node Data ");
                    int data = input.nextInt();
                    System.out.println();
                    try {
                        list.insertChaos(number, data);
                        list.showlist();
                    } 
                    catch (NullPointerException e) {
                        System.out.println("Cannot find node.");
                    }

                    break;
                case 3:
                    System.out.println("Which node would you like to delete?");
                    try {
                        list.deleteNode(input.nextInt());
                        System.out.println();
                        list.showlist();
                    } 
                    catch (NullPointerException e) {
                        System.out.println("Cannot find node.");
                    }
                    break;
                case 4:
                    running = false;
                    break;
            
                default:
                    System.out.println("Please enter a valid intager");
                    break;
            }
        }
    }
    
}
