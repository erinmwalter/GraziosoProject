import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    private static ArrayList<Dog> dogList = new ArrayList<Dog>();
    private static ArrayList<Monkey> monkeyList = new ArrayList<Monkey>();
    // Instance variables (if needed)
    

    public static void main(String[] args) {
    	String menuSelection = "";
    	Scanner scanner = new Scanner(System.in);
    	
    	//added some defaults to each list for testing purposes
        initializeDogList();
        initializeMonkeyList();
        
        
        while(!menuSelection.equalsIgnoreCase("q")) 
        {
        	displayMenu();
        	menuSelection = scanner.nextLine();
        	if (menuSelection.equals("1"))
        	{
        		intakeNewDog(scanner);
        	}
        	else if(menuSelection.equals("2"))
        	{
        		intakeNewMonkey(scanner);
        	}
        	else if(menuSelection.equals("3")) 
        	{
        		reserveAnimal(scanner);
        	}
        	else if(menuSelection.equals("4")) 
        	{
        		printAnimals("4");
        	}
        	else if(menuSelection.equals("5")) 
        	{
        		printAnimals("5");
        	}
        	else if(menuSelection.equals("6")) 
        	{
        		printAnimals("6");
        	}
        	else if (menuSelection.equalsIgnoreCase("q")) {
        		break;
        	}
        	else 
        	{
        		//input validation, if invalid selection made will display this message
        		//and loop back to menu for another selection
        		System.out.println("Invalid Selection, please choose another option.");
        	}
        	

        }
    }

    // This method prints the menu options
    public static void displayMenu() {
        System.out.println("\n\n");
        System.out.println("\t\t\t\tRescue Animal System Menu");
        System.out.println("[1] Intake a new dog");
        System.out.println("[2] Intake a new monkey");
        System.out.println("[3] Reserve an animal");
        System.out.println("[4] Print a list of all dogs");
        System.out.println("[5] Print a list of all monkeys");
        System.out.println("[6] Print a list of all animals that are not reserved");
        System.out.println("[q] Quit application");
        System.out.println();
        System.out.println("Enter a menu selection");
    }


    // Adds dogs to a list for testing
    //for testing purposes only
    public static void initializeDogList() {
        Dog dog1 = new Dog("Spot", "German Shepherd", "male", "1", "25.6", "05-12-2019", "United States", "intake", false, "United States");
        Dog dog2 = new Dog("Rex", "Great Dane", "male", "3", "35.2", "02-03-2020", "United States", "Phase I", false, "United States");
        Dog dog3 = new Dog("Bella", "Chihuahua", "female", "4", "25.6", "12-12-2019", "Canada", "in service", true, "Canada");
        Dog dog4 = new Dog("Jack", "German Shepherd", "male", "6", "29.6", "12-12-2020", "China", "in service", false, "China");
        

        dogList.add(dog1);
        dogList.add(dog2);
        dogList.add(dog3);
        dogList.add(dog4);
    }


    // Adds monkeys to a list for testing
    //Optional for testing
    public static void initializeMonkeyList() {
    	Monkey monkey1 = new Monkey("Bobby", "Capuchin", "male", "1", "123.5", "12.1", "22.5", "25.6", "05-12-2019", "United States", "intake", false, "United States");
        Monkey monkey2 = new Monkey("Darwin", "Squirrel Monkey", "male", "3", "76.9", "10.2", "21.8", "35.2", "02-03-2020", "United States", "Phase I", false, "United States");
        Monkey monkey3 = new Monkey("Jane", "Marmoset", "female", "4", "25.6", "31.2", "5.4", "21.9", "12-12-2019", "Canada", "in service", true, "Canada");
        Monkey monkey4 = new Monkey("Bobo", "Capuchin", "male", "4", "25.6", "31.2", "5.4", "21.9", "12-12-2019", "China", "in service", false, "China");

        monkeyList.add(monkey1);
        monkeyList.add(monkey2);
        monkeyList.add(monkey3);
        monkeyList.add(monkey4);
    }


    // Complete the intakeNewDog method
    // The input validation to check that the dog is not already in the list
    // is done for you
    public static void intakeNewDog(Scanner scanner) {
        System.out.println("What is the dog's name?");
        String name = scanner.nextLine();
        for(Dog dog: dogList) {
            if(dog.getName().equalsIgnoreCase(name)) {
                System.out.println("\n\nThis dog is already in our system\n\n");
                return; //returns to menu
            }
        }
        System.out.println("What is the dog's breed?");
        String breed = scanner.nextLine();
        System.out.println("What is the dog's gender?");
        String gender = scanner.nextLine();
        System.out.println("What is the dog's age?");
        String age = scanner.nextLine();
        System.out.println("What is the dog's weight?");
        String weight = scanner.nextLine();
        System.out.println("What is dog's aquisition date?");
        String dateAcquired = scanner.nextLine();
        System.out.println("What is the dog's aquisition country?");
        String countryAcquired = scanner.nextLine();
        System.out.println("What is the dog's training status?");
        String trainingStatus = scanner.nextLine();
        System.out.println("Is the dog in service? (y/n)");
        String serviceStatus = scanner.nextLine();
        boolean inService = false;
        if(serviceStatus.equalsIgnoreCase("y")) 
        {
        	inService = true;
        
        }
        else if (serviceStatus.equalsIgnoreCase("n"))
        {
        	inService = false;
        }
        System.out.println("What is the dog's service country?");
        String serviceCountry = scanner.nextLine();	
        
        Dog newDogIntake = new Dog(name, breed, gender, age, weight,
        		dateAcquired, countryAcquired, trainingStatus, inService, serviceCountry);
        dogList.add(newDogIntake);
        

    }


        //this method intakes a new monkey and adds to list
    	//validates that monkey does not already exist in database
    	//and that the species type is allowed
        public static void intakeNewMonkey(Scanner scanner) {
            System.out.println("What is the monkey's name?");
            String name = scanner.nextLine();
            for(Monkey monkey: monkeyList) {
                if(monkey.getName().equalsIgnoreCase(name)) {
                    System.out.println("\n\nThis monkey is already in our system\n\n");
                    return; //returns to menu
                }
            }
            
            //validate species of monkey
            String species = "";
            boolean validSpecies = false;
            do {
            	System.out.println("What is the monkey's species?");
            	species = scanner.nextLine();
            	if (species.equalsIgnoreCase("Capuchin") || species.equalsIgnoreCase("Guenon") ||
            		species.equalsIgnoreCase("Macaque") || species.equalsIgnoreCase("Marmoset") ||
            		species.equalsIgnoreCase("Squirrel Monkey") || species.equalsIgnoreCase("Tamarin")) {
            			validSpecies = true;
            	}
            	else {
            		System.out.println("Invalid Species. Try Again.");
            	}
            } while (!validSpecies);
            
            System.out.println("What is the monkey's gender?");
            String gender = scanner.nextLine();
            System.out.println("What is the monkey's age?");
            String age = scanner.nextLine();
            System.out.println("What is the monkey's weight?");
            String weight = scanner.nextLine();
            System.out.println("What is the monkey's height?");
            String height = scanner.nextLine();
            System.out.println("What is the monkey's tail length?");
            String tail = scanner.nextLine();
            System.out.println("What is the monkey's body length?");
            String bodyLength = scanner.nextLine();
            System.out.println("What is monkey's aquisition date?");
            String dateAcquired = scanner.nextLine();
            System.out.println("What is the monkey's aquisition country?");
            String countryAcquired = scanner.nextLine();
            System.out.println("What is the monkey's training status?");
            String trainingStatus = scanner.nextLine();
            System.out.println("Is the monkey in service? (y/n)");
            String serviceStatus = scanner.nextLine();
            boolean inService = false;
            if(serviceStatus.equalsIgnoreCase("y")) 
            {
            	inService = true;
            
            }
            else if (serviceStatus.equalsIgnoreCase("n"))
            {
            	inService = false;
            }
            System.out.println("What is the monkey's service country?");
            String serviceCountry = scanner.nextLine();	
            
            Monkey newMonkeyIntake = new Monkey(name, species, gender, age, weight, height, tail,
            		bodyLength, dateAcquired, countryAcquired, trainingStatus, inService, serviceCountry);
            monkeyList.add(newMonkeyIntake);
        }

        // method to reserve an animal by type and in-service country.
        public static void reserveAnimal(Scanner scanner) {
        	boolean found = false; 
        	
            System.out.println("Which type of animal would you like to reserve?");
            String animalType = scanner.nextLine();
            
            //validates animal type chosen
            while (!animalType.equalsIgnoreCase("monkey") && !animalType.equalsIgnoreCase("dog")) {
            		System.out.println("Invalid Animal Type. Please Choose Again. ");
            		System.out.println("Which Type of animal would you like to reserve?");
            		animalType = scanner.nextLine();
            }
            //shows user what they have selected
            if (animalType.equalsIgnoreCase("dog")) {
            	System.out.println("Dog selected.");
            }
            else if (animalType.equalsIgnoreCase("monkey")) {
            	System.out.println("Monkey Selected.");
            }
            System.out.println("Which in-service country?");
            String serviceCountry = scanner.nextLine();
            System.out.println("Service Country Selected: " + serviceCountry);
            
            //reserves dog by in service country, only if not already reserved
            if (animalType.equalsIgnoreCase("dog")) {
            	for(Dog dog: dogList) {
                    if(dog.getInServiceLocation().equalsIgnoreCase(serviceCountry) && !dog.getReserved()) {
                        System.out.println(dog.getName() + " reserved.");
                        dog.setReserved(true);
                        found = true;
                        //System.out.println(dog.getReserved()); //test line
                        break; //stops searching and reserves first available
                    }
            	}
                 if (!found) { 
                	 System.out.print("No dogs from " + serviceCountry + " available in system.");
                }
            }
           //reserves monkey by in service country, only if not already reserved
            if (animalType.equalsIgnoreCase("monkey")) {
            	for(Monkey monkey: monkeyList) {
                    if(monkey.getInServiceLocation().equalsIgnoreCase(serviceCountry) && !monkey.getReserved()) {
                        System.out.println(monkey.getName() + " reserved.");
                        monkey.setReserved(true);
                        found = true;
                        //System.out.println(monkey.getReserved()); //test line
                        break; //stops searching and reserves first available
                    }
                }
            	if (!found) {
            		System.out.print("No monkeys from " + serviceCountry + " available in system.");
            	}
            }
            
        }

        
        // method to print animal lists
        // prints animal name, status, acquisition country and if the animal is reserved.
        // dog - prints the list of dogs
        // monkey - prints the list of monkeys
        // available - prints a combined list of all animals that are
        // fully trained ("in service") but not reserved 
        public static void printAnimals(String choice) {
            //prints a list of all dogs
        	if (choice.equalsIgnoreCase("4")) {
        		System.out.println("\n           Current List of Dogs:");
        		System.out.println("------------------------------------------");
        		for (Dog dog: dogList) {
            		System.out.printf("%-14s", "Name: " + dog.getName());
            		System.out.printf("%-3s", "|");
            		System.out.printf("%-17s", "Reserved: " + dog.getReserved());
            		System.out.printf("%-3s", "|");
            		System.out.printf("%-30s", "Training Status: " + dog.getTrainingStatus()); 
            		System.out.printf("%-3s", "|");
            		System.out.printf("%-25s", "Aquisition Country: " + dog.getAcquisitionLocation());
            		System.out.println();
            	}
            }
        	
        	//prints a list of all monkeys
            else if (choice.equalsIgnoreCase("5")) {
            	System.out.println("\n         Current List of Monkeys:");
        		System.out.println("------------------------------------------");
        		for (Monkey monkey: monkeyList) {
            		System.out.printf("%-14s", "Name: " + monkey.getName());
            		System.out.printf("%-3s", "|");
            		System.out.printf("%-17s", "Reserved: " + monkey.getReserved());
            		System.out.printf("%-3s", "|");
            		System.out.printf("%-30s", "Training Status: " + monkey.getTrainingStatus()); 
            		System.out.printf("%-3s", "|");
            		System.out.printf("%-25s", "Aquisition Country: " + monkey.getAcquisitionLocation());
            		System.out.println();
            	}
            
            }
        	
        	//prints a list of all animals that are fully trained and in service but not reserved
            else if (choice.equalsIgnoreCase("6")) {
            	System.out.println();
            	System.out.printf("%46s", "Available Dogs");
            	System.out.println();
            	System.out.printf("%47s", "----------------");
            	System.out.println();
            	for (Dog dog: dogList) {
            		if(!dog.getReserved() && dog.getTrainingStatus().equalsIgnoreCase("in service")) {
            			System.out.printf("%-14s", "Name: " + dog.getName());
            			System.out.printf("%-3s", "|");
            			System.out.printf("%-17s", "Reserved: " + dog.getReserved());
            			System.out.printf("%-3s", "|");
            			System.out.printf("%-30s", "Training Status: " + dog.getTrainingStatus()); 
            			System.out.printf("%-3s", "|");
            			System.out.printf("%-25s", "Aquisition Country: " + dog.getAcquisitionLocation());
            			System.out.println();
            		}
            	}
            	
            	System.out.println();
            	System.out.printf("%48s", "Available Monkeys");
            	System.out.println();
            	System.out.printf("%49s", "-------------------");
            	System.out.println();
            	for (Monkey monkey: monkeyList) {
            		if(!monkey.getReserved() && monkey.getTrainingStatus().equalsIgnoreCase("in service")) {
            			System.out.printf("%-14s", "Name: " + monkey.getName());
            			System.out.printf("%-3s", "|");
            			System.out.printf("%-17s", "Reserved: " + monkey.getReserved());
            			System.out.printf("%-3s", "|");
            			System.out.printf("%-30s", "Training Status: " + monkey.getTrainingStatus()); 
            			System.out.printf("%-3s", "|");
            			System.out.printf("%-25s", "Aquisition Country: " + monkey.getAcquisitionLocation());
            			System.out.println();
            		}
            	}
            }
        	
        		
            

        }
}

