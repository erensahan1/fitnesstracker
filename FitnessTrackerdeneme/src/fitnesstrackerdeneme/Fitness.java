/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fitnesstrackerdeneme;

import java.util.Scanner;

/**
 *
 * @author ernm1
 */
public class Fitness extends  Activities {
    
    @Override
    public void attendActivities(){
     Fitness fitness = new Fitness();
                    fitness.Choice();
                    
    
    }

  
        
    
    public void Choice(){
        System.out.println("1-Upperbody Workouts \n 2-Lowerbody Workouts \n 3-Core Workouts ");
        Scanner scan=new Scanner(System.in);
        int choice=scan.nextInt();
        switch (choice) {
            case 1 -> {    
                System.out.println("1- Arm Movements");
                System.out.println("2- Upper Shoulder Movements");
                System.out.println("3- Back Movements");
                int choice4=scan.nextInt();
                switch (choice4) {
                    case 1 -> {  
                        System.out.println("1-DumbbellHammerCurl \n 2-BarbellBicepsCurl");
                        int choice5=scan.nextInt();
                        switch (choice5) {
                            case 1 -> {
                                DumbbellHammerCurl dumbbellHammerCurl=new DumbbellHammerCurl();
                                totalCalory+=dumbbellHammerCurl.CaloriesBurned();
                        }
                            case 2 -> {
                                BarbellBicepsCurl barbellBicepsCurl=new BarbellBicepsCurl();
                                totalCalory+=barbellBicepsCurl.CaloriesBurned();
                        }
                            default -> throw new AssertionError();
                        }
                }
                        
                    case 2 -> {
                        System.out.println("1-OverheadPress \n 2-FrontRaise");
                        int choice6=scan.nextInt();
                        switch (choice6) {
                            case 1 -> {
                                OverheadPress overheadPress=new OverheadPress();
                                totalCalory+=overheadPress.CaloriesBurned();
                        }
                            case 2 -> {
                                FrontRaise fr=new FrontRaise();
                                totalCalory+=fr.CaloriesBurned();
                        }
                            default -> throw new AssertionError();
                        }
                }
                    case 3 -> {
                        System.out.println("1-DumbbellRow \n 2-vBarPulldown");
                        int choice7=scan.nextInt();
                        switch (choice7) {
                            case 1 -> {
                                DumbbellRow dumbbellRow=new DumbbellRow();
                                totalCalory+=dumbbellRow.CaloriesBurned();
                        }
                            case 2 -> {
                                vBarPulldown vbarpulldown=new vBarPulldown();
                                totalCalory+=vbarpulldown.CaloriesBurned();
                        }
                            default -> throw new AssertionError();
                        }
                }
                    default -> throw new AssertionError();
                }
            }
            case 2 -> {
                System.out.println("1-Back Squat \n 2-Hip Thrust \n 3-FrontRack Bulgarian Split Squat \n4-Romanian Deadlift");
                
                int choice3 =scan.nextInt();
                switch (choice3) {
                    case 1:
                        BackSquat backSquat=new BackSquat();
                        totalCalory+=backSquat.CaloriesBurned();
                        
                        
                        
                        break;
                    case 2:
                        HipThrust hipThrust=new HipThrust();
                        totalCalory+=hipThrust.CaloriesBurned();
                       
                        break;
                    case 3:
                        FrontRackBulgarianSplitSquat frontRackBulgarianSplitSquat=new FrontRackBulgarianSplitSquat();
                        totalCalory+=frontRackBulgarianSplitSquat.CaloriesBurned();
                       
                        break;
                    case 4:
                        RomanianDeadlift romanianDeadlift=new RomanianDeadlift();
                        totalCalory+=romanianDeadlift.CaloriesBurned();
                        
                        
                    default:
                        throw new AssertionError();
                }
            }
            case 3 -> {
                System.out.println("1-Crunches \n 2-Plank \n 3-Russian Twists \n 4-Leg Raises");
                Scanner scanner=new Scanner(System.in);
                int choice2 =scanner.nextInt();
                switch (choice2) {
                    case 1 -> {
                        Crunches crunches=new Crunches(); 
                        
                        totalCalory+=crunches.CaloriesBurned();
                }
                    case 2 -> {
                        Plank plank=new Plank();
                        totalCalory +=plank.CaloriesBurned();
                }
                    case 3 -> {
                        RussianTwists russianTwists=new RussianTwists();
                        totalCalory+=russianTwists.CaloriesBurned();
                }
                    case 4 -> {
                        LegRaises legRaises=new LegRaises();
                        totalCalory+=legRaises.CaloriesBurned();
                }
                        
                   
                    default -> {
                        System.out.println("invalid choice");
                }
                }
            }
            default -> {
                System.out.println("invalid choice");
            }
        }
        
        
        
        
        
        
    }
    
    public class Crunches implements CalorieCalculator {
    @Override
    public double CaloriesBurned() {
        System.out.println("How many times did you do Crunches?");
        Scanner scan = new Scanner(System.in);
        double minutes = scan.nextDouble();
        double perCal = 4;
        return minutes * perCal;
    }
}
    
    //coreworkout
    public class Plank implements CalorieCalculator {
    @Override
    public double CaloriesBurned() {
        System.out.println("How many times did you do Plank?");
        Scanner scan = new Scanner(System.in);
        double minutes = scan.nextDouble();
        double perCal = 5; 
        return minutes * perCal;
    }
}

public class RussianTwists implements CalorieCalculator {
    @Override
    public double CaloriesBurned() {
        System.out.println("How many times did you do Russian Twists?");
        Scanner scan = new Scanner(System.in);
        double minutes = scan.nextDouble();
        double perCal = 7; 
        return minutes * perCal;
    }
}

public class LegRaises implements CalorieCalculator {
    @Override
    public double CaloriesBurned() {
        System.out.println("How many times did you do Leg Raises?");
        Scanner scan = new Scanner(System.in);
        double minutes = scan.nextDouble();
        double perCal = 4.5; 
        return minutes * perCal;
    }
}

public class BarbellBicepsCurl implements CalorieCalculator {
    @Override
    public double CaloriesBurned() {
        System.out.println("How many times did you do Barbell Biceps Curl?");
        Scanner scan = new Scanner(System.in);
        double minutes = scan.nextDouble();
        double perCal = 6; 
        return minutes * perCal;
    }
}

public class DumbbellHammerCurl implements CalorieCalculator {
    @Override
    public double CaloriesBurned() {
        System.out.println("How many times did you do Dumbbell Hammer Curl?");
        Scanner scan = new Scanner(System.in);
        double minutes = scan.nextDouble();
        double perCal = 6.5; 
        return minutes * perCal;
    }
}

public class OverheadPress implements CalorieCalculator {
    @Override
    public double CaloriesBurned() {
        System.out.println("How many times did you do Overhead Press?");
        Scanner scan = new Scanner(System.in);
        double minutes = scan.nextDouble();
        double perCal = 8; 
        return minutes * perCal;
    }
}

public class FrontRaise implements CalorieCalculator {
    @Override
    public double CaloriesBurned() {
        System.out.println("How many times did you do Front Raise?");
        Scanner scan = new Scanner(System.in);
        double minutes = scan.nextDouble();
        double perCal = 7.5; 
        return minutes * perCal;
    }
}

public class DumbbellRow implements CalorieCalculator {
    @Override
    public double CaloriesBurned() {
        System.out.println("How many times did you do Dumbbell Row?");
        Scanner scan = new Scanner(System.in);
        double minutes = scan.nextDouble();
        double perCal = 9; 
        return minutes * perCal;
    }
}

public class vBarPulldown implements CalorieCalculator {
    @Override
    public double CaloriesBurned() {
        System.out.println("How many times did you do V-Bar Pulldown?");
        Scanner scan = new Scanner(System.in);
        double minutes = scan.nextDouble();
        double perCal = 7; 
        return minutes * perCal;
    }
}

public class BackSquat implements CalorieCalculator {
    @Override
    public double CaloriesBurned() {
        System.out.println("How many times did you do Back Squat?");
        Scanner scan = new Scanner(System.in);
        double minutes = scan.nextDouble();
        double perCal = 10; 
        return minutes * perCal;
    }
}

public class HipThrust implements CalorieCalculator {
    @Override
    public double CaloriesBurned() {
        System.out.println("How many times did you do Hip Thrust?");
        Scanner scan = new Scanner(System.in);
        double minutes = scan.nextDouble();
        double perCal = 9; 
        return minutes * perCal;
    }
}

public class FrontRackBulgarianSplitSquat implements CalorieCalculator {
    @Override
    public double CaloriesBurned() {
        System.out.println("How many times did you do Front Rack Bulgarian Split Squat?");
        Scanner scan = new Scanner(System.in);
        double minutes = scan.nextDouble();
        double perCal = 11; 
        return minutes * perCal;
    }
}

public class RomanianDeadlift implements CalorieCalculator {
    @Override
    public double CaloriesBurned() {
        System.out.println("How many times did you do Romanian Deadlift?");
        Scanner scan = new Scanner(System.in);
        double minutes = scan.nextDouble();
        double perCal = 10.5; 
        return minutes * perCal;
    }
    
}
}





    
    
    
    
    
    


        
        
    
    
    