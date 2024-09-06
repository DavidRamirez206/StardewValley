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
            
            int option;

            System.out.println("\nWelcome to Stardew Valley. Select an option\n");
            System.out.println("\n 1) Create a chest \n 2) Add a stack to a chest \n 3) Add a crop to a stack");
            System.out.println("\n11) Test case \n12) Exit");
            option = in.nextInt();
            in.nextLine();

            switch (option) {
                case 1:
                    createChest();
                    break;
                case 2:
                    addStackToChest();
                    break;
                case 3:
                    addCropToStack();
                    break;
                case 11:
                    testCase();
                    break;
                case 12:
                    mySwitch = true;
                    break;
                default:
                    break;
            }
        }
    }

    public void createChest(){

    }

    public void addStackToChest(){

    }

    public void addCropToStack(){

    }

    public void searchChest(){
        System.out.println(controller.searchChest("01"));
        System.out.println(controller.chestSize());
    }

    public void testCase(){
        controller.createChest("01");
        controller.createStackToChest("01", "001");
        controller.createChest("02");
        controller.createChest("03");
        controller.createChest("04");
    }
}
