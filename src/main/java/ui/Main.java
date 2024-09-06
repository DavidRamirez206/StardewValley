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

        while (!mySwitch) {
            
            int option;

            System.out.println("----------------------------------------------------------------------");
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
                    System.out.println("----------------------------------------------------------------------");
                    System.out.println("\nPress 'Enter' to show the menu based on the current season...");
                    in.nextLine();  // Wait for user input to show the next menu
                    menuBySeason();

                    
                    addCropToStack();
                    break;
                case 11:
                    testCase();
                    break;
                case 12:
                    exitProgram();
                    break;
                default:
                    break;
            }
        }
    }

    // Method to exit the program
    private void exitProgram() {
        mySwitch = true;  // Set to true to exit the loop
        controller.stopThread();  // Stop the season change thread
        System.out.println("Exiting the program. Goodbye!");
    }

    // Method to show the menu based on the current season
    public void menuBySeason() {
        switch (controller.currentSeason()) {
            case 1:
                showSpringMenu();
                break;
            case 2:
                showSummerMenu();
                break;
            case 3:
                showFallMenu();
                break;
            case 4:
                showWinterMenu();
                break;
            case 5:
                showYearRoundCrops();
                break;
            default:
                break;
        }
    }

    // Methods to show the menus for each season
    private void showSpringMenu() {
        System.out.println("Menu of Spring Crops:");
        System.out.println("1. Garlic\n2. Blue Allium\n3. Unmilled Rice\n4. Parsnip");
    }

    private void showSummerMenu() {
        System.out.println("Menu of Summer Crops:");
        System.out.println("1. Poppy\n2. Blueberry\n3. Starfruit\n4. Hot Pepper");
    }

    private void showFallMenu() {
        System.out.println("Menu of Fall Crops:");
        System.out.println("1. Artichoke\n2. Amaranth\n3. Sweet Gem Berry\n4. Eggplant");
    }

    private void showWinterMenu() {
        System.out.println("Menu of Winter Crops:");
        System.out.println("1. Winter Melon");

    }

    public void showYearRoundCrops(){
        System.out.println("Menu of Year-Round Crops:");
        System.out.println("1. Ancient Fruit\n2. Fiber Plant\n3. Qi Fruit");
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
