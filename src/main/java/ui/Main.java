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
            //option variables
            int option;

            System.out.println("Enter the option 1 for a test case \n4) Exit");
            option = in.nextInt();
            in.nextLine();

            switch (option) {
                case 1:
                    testCase();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    mySwitch = true;
                    break;
                default:
                    break;
            }
        }
    }

    public void testCase(){
        controller.createChest("Chest1");
    }
}
