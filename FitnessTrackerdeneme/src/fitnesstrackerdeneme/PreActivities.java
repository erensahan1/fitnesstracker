
package fitnesstrackerdeneme;
import java.util.Scanner;


public class PreActivities extends Activities{
   
    
             
          public class Yoga implements CalorieCalculator{
              double minute;
              double PerCal=3.5;
       
              public void start(){
                  System.out.println("How many minutes did you do Yoga?");
                  Scanner scan=new Scanner(System.in);
                  minute=scan.nextDouble();
                  
                  
                 
              }

        @Override
        public double CaloriesBurned() {
            return minute*PerCal;
            
        }
              
        }
          public class Plates implements CalorieCalculator{
              double minute;
              double PerCal=6.5;
              public void start(){
                  System.out.println("How many minutes did you do Plates?");
                  Scanner scan=new Scanner(System.in);
                  minute=scan.nextDouble();
                  
              }

        @Override
        public double CaloriesBurned() {
            return minute*PerCal;
        }
        
              
              
          }
          public class Swimming implements CalorieCalculator{
              double minute;
              double PerCal=10;
               public void start(){
                  System.out.println("How many minutes did you do Swimming?");
                  Scanner scan=new Scanner(System.in);
                  minute=scan.nextDouble();
                
              }

        @Override
        public double CaloriesBurned() {
            return minute*PerCal;
        }
              
          }
    
          
         
    
    @Override
     public void attendActivities(){
        boolean continueActivities = true;
        Scanner scan = new Scanner(System.in);

        while (continueActivities) {
            System.out.println("Which activities do you want to attend? \n 1-Fitness \n 2-Yoga \n 3-Plates \n 4-Swimming");
            int choice = scan.nextInt();
            switch (choice) {
                case 1 -> {
                    Fitness fitness = new Fitness();
                    fitness.Choice();
                    
                    totalCalory+=fitness.totalCalory;
                    
                    System.out.println("Calories Burned: "+totalCalory);
                    
                    
                }
                case 2 -> {
                    Yoga yoga = new Yoga();
                    yoga.start();
                    
                    totalCalory+= yoga.CaloriesBurned();
                    System.out.println("Calories Burned: " + totalCalory);
                    
                }
                case 3 -> {
                    Plates plates = new Plates();
                    plates.start();
                    
                    totalCalory+= plates.CaloriesBurned();
                    System.out.println("Calories Burned: " + totalCalory);
                    
                }
                case 4 -> {
                    Swimming swimming = new Swimming();
                    swimming.start();
                    
                    totalCalory+= swimming.CaloriesBurned();
                    System.out.println("Calories Burned: " + totalCalory);
                }
                default -> System.out.println("Invalid Choice");
            }

            
                System.out.println("Do you want to continue attending activities? (yes/no)");
                String continueChoice = scan.next().toLowerCase();
                continueActivities = continueChoice.equals("yes");
                
            
                   
            
        }
     }
     
     
     
}


         
         
         

        
    
    


