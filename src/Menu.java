import java.util.Scanner;

/**
 * Created by alex on 09/04/2017.
 */
public class Menu {
    //Instance Variables
    Scanner keyboard = new Scanner(System.in);
    Bank bank = new Bank();
    boolean exit;

    public static void main(String[] args ) {
        Menu menu = new Menu();
        menu.runMenu();
    }

    public void runMenu() {
        printHeader();
        while(!exit) {
            printMenu();
            int choice = getInput();
            performAction(choice);
        }
    }



    private void printHeader() {
        System.out.println("--------------------------------");
        System.out.println("            Welcome             ");
        System.out.println("          Awesome Bank App      ");
        System.out.println("--------------------------------");
    }

    private void printMenu() {
        System.out.println("Please make a selection:");
        System.out.println("1)Create a new account");
        System.out.println("2)Make a deposit");
        System.out.println("3)Make a widthdrawal");
        System.out.println("4)List account ballance");
        System.out.println("0)Exit");
    }



    private int getInput() {
        int choice = -1;

        do {
            System.out.print("Enter your choice: ");
            try  {
                choice = Integer.parseInt(keyboard.nextLine());
            }
            catch(NumberFormatException e) {
                System.out.println("Invalid selection. Numbers only please.");
            }
            if(choice < 0 || choice > 4) {
                System.out.println("Choice outside if range. Please chose  again.");
            }
        }while(choice < 0 || choice > 4);
        return choice;
    }


    private void performAction(int choice) {
        switch(choice) {
            case 0:
                System.out.println("Thanks you for using our application.");
                System.exit(0);
                break;
            case 1:
                // Create a new account
                break;
            case 2:
                // Make a deposit
                break;
            case 3:
                // Make a widthdrawal
                break;
            case 4:
                // List account ballance
                break;
                default:
                    System.out.println("Unknow error has occuered");
        }
    }

}
