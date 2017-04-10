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
                createAnAccount();
                break;
            case 2:
                // Make a deposit
                makeADeposit();
                break;
            case 3:
                // Make a widthdrawal
                makeAWithdrawal();
                break;
            case 4:
                // List account ballance
                listBalances();
                break;
                default:
                    System.out.println("Unknow error has occuered");
        }
    }


    private void createAnAccount() {
        String firstName, lastName, ssn, accountType = "";
        double initialDeposit = 0;
        boolean valid = false;
        while(!valid) {
            System.out.println("Please enter an account type(checking/savings)");
            accountType = keyboard.nextLine();
            if (accountType.equalsIgnoreCase("checking") || accountType.equalsIgnoreCase("savings")) {
                valid = true;
            } else {
                System.out.println("Invalid acccount type selected. Please enter checking or savings");
            }
        }

        System.out.println("Please enter your first name: ");
        firstName = keyboard.nextLine();


        System.out.println("Please enter your last name: ");
        lastName = keyboard.nextLine();

        System.out.println("Please enter your social security number: ");
        ssn = keyboard.nextLine();

        valid = false;
        while(!valid) {
            System.out.println("Please enter your intial deposit: ");
            try {
                initialDeposit =  Double.parseDouble(keyboard.nextLine());
            }
            catch(NumberFormatException e) {
                System.out.println("Deposit must be a number.");
            }
            if(accountType.equalsIgnoreCase("checking")) {
                if(initialDeposit < 100) {
                    System.out.println("Checking accounts a minimum of $100 to open ");
                }else {
                    valid = true;
                }
            } else if(accountType.equalsIgnoreCase("savings")) {
                if(initialDeposit < 50) {
                    System.out.println("Checking accounts a minimum of $50 to open");
                }else {
                    valid = true;
                }
            }
        }

        // We can create an account now:
        Account account;
        if (accountType.equalsIgnoreCase("checking")) {
            account = new Checking(initialDeposit);
        }else {
            account  = new Savings(initialDeposit);
        }

        Customer customer = new Customer(firstName, lastName, ssn, account);
        bank.addCustomer(customer);
    }

    private void makeADeposit() {
    }

    private void makeAWithdrawal() {
    }

    private void listBalances() {
    }


}
