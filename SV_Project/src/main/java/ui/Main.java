package ui;
import java.util.Scanner;
import control.Controller;

public class Main {
    //Attributes of the executable class
	private Scanner in;
	private Controller controller;

	private static boolean mySwitch;

	private Main() {
		in = new Scanner(System.in);
		controller = new Controller();
	}

    public static void main(String[] args) {
		Main mainApp = new Main();
		mainApp.run();
	}

    public void run(){
        boolean mySwitch = false;

        while (!mySwitch) {
            //User type option
            int userType;

            //option variables
            int option;

            //UserMenu
            System.out.println("....");
            userType = in.nextInt();
            in.nextLine(); //We clear the buffer

            switch (userType) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    System.out.println("Thank you for using our program");
                    mySwitch = true;
                    System.exit(0);
                    break;
                default:
                    System.out.print("Enter a valid option. Try again.");
                    continue;
            }

            option = in.nextInt();
            in.nextLine();

            if (userType == 2){
                switch (option) {
                    case 1:
                        option = 7;
                        break;
                    case 2:
                        option = 8; 
                        break;
                    case 3:
                        option = 9;
                        break;
                    case 4:
                        option = 10;
                        break; 
                    case 5:
                        option = 11;
                        break;
                    default:
                        System.out.print("Enter a valid option. Try again.");
                        continue;
                }
            }

            switch (option) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    break;
            }
        }
    }
}
