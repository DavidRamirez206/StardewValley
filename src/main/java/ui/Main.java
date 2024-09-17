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
            controller.updateStation();
            int option;
            
            System.out.println("----------------------------------------------------------------------");
            System.out.println("----------------------------------------------------------------------");
            menuBySeason();
            System.out.println("----------------------------------------------------------------------");
            System.out.println("----------------------------------------------------------------------");
            System.out.println("\nWelcome to Stardew Valley. Select an option\n");
            System.out.println("\nPress 'Enter' to show the menu based on the current season...");
            in.nextLine();  // Wait for user input to show the next menu
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
                case 4:
                    sortingChest();
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
        System.out.println("Exiting the program. Goodbye!");
    }

    // Method to show the menu based on the current season
    public void menuBySeason() {
        switch (controller.currentSeason()) {
            case 1:
                showSpringMenu();
                showYearRoundCrops();
                break;
            case 2:
                showSummerMenu();
                showYearRoundCrops();
                break;
            case 3:
                showFallMenu();
                showYearRoundCrops();
                break;
            case 4:
                showWinterMenu();
                showYearRoundCrops();
                break;
            default:
                break;
        }
    }

    // Methods to show the menus for each season
    private void showSpringMenu() {
        System.out.println("\n-----------------------------\nMenu of Spring Crops:\n-----------------------------");
        System.out.println("1. Garlic\n2. Blue Allium\n3. Unmilled Rice\n4. Parsnip");
    }

    private void showSummerMenu() {
        System.out.println("\n-----------------------------\nMenu of Summer Crops:\n-----------------------------");
        System.out.println("1. Poppy\n2. Blueberry\n3. Starfruit\n4. Hot Pepper");
    }

    private void showFallMenu() {
        System.out.println("\n-----------------------------\nMenu of Fall Crops:\n-----------------------------");
        System.out.println("1. Artichoke\n2. Amaranth\n3. Sweet Gem Berry\n4. Eggplant");
    }

    private void showWinterMenu() {
        System.out.println("\n-----------------------------\nMenu of Winter Crops:\n-----------------------------");
        System.out.println("1. Winter Melon");

    }

    public void showYearRoundCrops(){
        System.out.println("\n-----------------------------\nMenu of Year-Round Crops:\n-----------------------------");
        System.out.println("1. Ancient Fruit\n2. Fiber Plant\n3. Qi Fruit");
    }

    public void createChest(){
        String typeChest = "GENERAL";
        System.out.println("Enter the chest number, please. Example: 01, 02, 03, etc...");
        String chestNumber = in.nextLine();
        System.out.println("is it a general chest? \n1. YES \n2. NO");
        int type = in.nextInt();
        in.nextLine();
        if(type == 2){
            System.out.println("Ok. This chest will only accept crops of the same type. " +
                                "Please, enter the name of the crop. You can see the names in the home menu");
            typeChest = in.nextLine();
        }
        controller.createChest(chestNumber, typeChest);

        System.out.println("Chest created correctly");
    }

    public void addStackToChest(){
        System.out.println("Enter the chestNumber, please");
        String chestNumber = in.nextLine();

        System.out.println("Enter the ID to Stack, please. Example: 01, 02, 03, etc...");
        String idStack = in.nextLine();

        System.out.println(controller.createStackToChest(chestNumber, idStack));
    }

    //

    public void addCropToStack(){
        System.out.println("Enter the chestNumber, please");
        String chestNumber = in.nextLine();

        System.out.println("\nIF THIS IS NOT THE FIRST TIME YOU ARE ADDING A CROP TO THE SELECTED STACK, PLEASE REMEMBER THAT THEY MUST BE OF THE SAME CROP TYPE.\n");

        System.out.println("Enter the ID to Stack, please");
        String idStack = in.nextLine();

        System.out.println("Enter the crop's name. U can see it in the previus menu");
        String cropName = in.nextLine();

        System.out.println("Is it a crop of any season? In case you say 'NO', the system will consider the crop as part of the current season." +
                            "\n\n1. YES \n2. NO");
        int seasonOption = in.nextInt();
        in.nextLine();

        if (seasonOption == 1) {
            seasonOption = 5;
        } else {
            seasonOption = controller.currentSeason();
        }

        System.out.println("Enter the growth time, pls");
        int growthTime = in.nextInt();
        in.nextLine();


        System.out.println(controller.addCropToStack(chestNumber, idStack, cropName, seasonOption, growthTime));
    }

    public void sortingChest(){
        System.out.println("How do you want to organize the chests? \n1. Name of crops \n2. Type of cultivation \n3. Days of growth");
        int sortOption = in.nextInt();
        in.nextLine();
        controller.sortingChest(sortOption);
        System.out.println("Chest sorted correctly");
    }

    public void testCase(){
        controller.createChest("01", "ajo");
        System.out.println(controller.createStackToChest("01", "01"));
        System.out.println(controller.addCropToStack("01", "01", "ajo", 1, 12));
        System.out.println(controller.addCropToStack("01", "01", "Garlic", 1, 28));
        controller.createChest("02","...");
        controller.createChest("03", "...");
        controller.createChest("04", "...");
    }
}
