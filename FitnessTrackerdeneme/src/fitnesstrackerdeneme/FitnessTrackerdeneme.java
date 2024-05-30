package fitnesstrackerdeneme;

import java.util.InputMismatchException;
import java.util.Scanner;



public class FitnessTrackerdeneme {

    public static void main(String[] args) {
        try {
            System.out.println("Did you pay me something?");
            Scanner scan = new Scanner(System.in);
            String response = scan.nextLine().toLowerCase();

            if ("yes".equals(response)) {
                PremiumUser premiumUser1 = new PremiumUser();
                Date date = new Date(premiumUser1);
                premiumUser1.login();
                System.out.println(date.displayDateTime());
            } else if ("no".equals(response)) {
                 //CommonUser commonUser1 = new CommonUser();
                 //commonUser1.login();
                CommonUser commonUser1 = new CommonUser("male", "furkan", "sarıbal", 90, 175, 32, 50, 72);
                // Composition composition = new Composition(commonUser1);
                // composition.print();
                Date date1 = new Date(commonUser1);

                commonUser1.loginWithObject();
                System.out.println(date1.displayDateTime());
                // PremiumUser premiumUser = new PremiumUser("male", "eren", "sahan", 70, 180, 32, 50, 72);
                // premiumUser.loginWithObject();
            } else {
                System.out.println("Invalid response. Please answer 'yes' or 'no'.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Input error: " + e.getMessage());
        } catch (Exception e) {
            // General exception catch to handle any unexypected errors
            System.out.println("An error occurred: " + e.getMessage());
        }
        
        }
           
       
      
        
       
        
        
        
    }
        


