package fitnesstrackerdeneme;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PremiumUser extends User{
    private String gender;
    private String username;
    private String password;
    private double weight;
    private double height;
    private double lenghtNeck;
    private double lenghtHip;
    private double lenghtWaist;
    
    static boolean login = false;
    PreActivities activities = new PreActivities();

    public PremiumUser(String gender, String username, String password, double weight, double height, double lenghtNeck, double lenghtHip, double lenghtWaist,Date date) {
        this.gender = gender;
        this.username = username;
        this.password = password;
        this.weight = weight;
        this.height = height;
        this.lenghtNeck = lenghtNeck;
        this.lenghtHip = lenghtHip;
        this.lenghtWaist = lenghtWaist;
        
    }
    public PremiumUser(){
        super();
    }
    public PremiumUser(String username,String password){
        this.username=username;
        this.password=password;
        
        
    }
    

    

    
    

    @Override
    public double fatRate() {
        if (isMale()) {
            return 495 / (1.0324 - 0.19077 * Math.log10(getLenghtWaist() - getLenghtNeck()) + 0.15456 * Math.log10(getHeight())) - 450;
        } else {
            return 495 / (1.29579 - 0.35004 * Math.log10(getLenghtWaist() + getLenghtHip() - getLenghtNeck()) + 0.22100 * Math.log10(getHeight())) - 450;
        }
    }

    @Override
    public double bodyMassIndex() {
        return 10000*(weight/height/height);
    }
    
    @Override
    public void bmiInfo() {
        

        if (bodyMassIndex() <= 18.5) {
            System.out.println("Your weight is classified as Underweight. Consider a balanced diet to gain healthy weight.");
        } else if (bodyMassIndex() > 18.5 && bodyMassIndex() <= 24.9) {
            System.out.println("Your weight is classified as Normal. Keep up the good work maintaining a healthy lifestyle!");
        } else if (bodyMassIndex() >= 25.0 && bodyMassIndex() <= 29.9) {
            System.out.println("You are classified as Overweight. Small changes can make a big difference. Start with regular exercise and a balanced diet.");
        } else if (bodyMassIndex() >= 30.0 && bodyMassIndex() <= 34.9) {
            System.out.println("You are classified as Obese (Class 1). It's a great time to take control of your health. Believe in yourself and take one step at a time!");
        } else if (bodyMassIndex() >= 35.0 && bodyMassIndex() <= 39.9) {
            System.out.println("You are classified as Severely obese (Class 2). Remember, every journey begins with a single step. ");
        } else if (bodyMassIndex() >= 40.0) {
            System.out.println("You are classified as Morbidly obese (Class 3). Your health is important, and there are many resources available to support you. Stay positive and reach out for help.");
        } else {
            System.out.println("Invalid BMI value. Please check your input values and try again.");
        }
    }

public void loginWithObject(){
    if(this.username.equals(getUsername())&&this.password.equals(getPassword())){
        System.out.println(getUsername()+"   logged in ");
        System.out.println("Fat Rate: " + fatRate());
        
        System.out.println("Welcome "+getUsername()+" !");
                                System.out.println("Body Mass Index: " + bodyMassIndex());
                                bmiInfo();
                                System.out.println("----------------------");
                                Scanner scann=new Scanner(System.in);

                                System.out.println("Do you want to attend an activity? (yes/no)");
                                String response = scann.nextLine().toLowerCase();
                                if (response.equals("yes")) {
                                    activities.attendActivities();
                                } else {
                                    System.out.println("Take care!");
                                }
    }
    else{
                System.out.println("Login  failed");
                }
}
    public void login() {
        Scanner scanner = new Scanner(System.in);

        String url = "jdbc:sqlite:C://mydatabase/fitnesstracker.db";
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Connection completed");

            boolean exit = false;

            while (!exit) {
                System.out.println("Choose an option: \n1. Register\n2. Login\n3. Exit ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        collectPreUserDetails(scanner);
                        registerPreUser(conn);
                        break;
                    case 2:
                        loginPreUser(conn, scanner);
                        if (login) {
                            if (fatRate() > 0) {
                               System.out.println("Welcome " + getUsername() + "!");
                                System.out.println("Fat Rate: " + fatRate());
                                System.out.println("Body Mass Index: " + bodyMassIndex());
                                bmiInfo();
                                System.out.println("----------------------");
                                
                                    System.out.println("Do you want to update your details? (yes/no)");
                                    String updateResponse = scanner.nextLine().toLowerCase();
                                    if (updateResponse.equals("yes")) {
                                        updatePreUserDetails(scanner, conn);
                                    }
                                    else if(updateResponse.equals("no")){
                                        System.out.print("");
                                    }
                                    else{
                                        System.out.println("Your response is invalid");
                                    }
                                    
                                    
                                    
                                 

                                
                                    System.out.println("Do you want to attend an activity? (yes/no)");
                                    String response = scanner.nextLine().toLowerCase();
                                switch (response) {
                                    case "yes" -> activities.attendActivities();
                                    case "no" -> {
                                        System.out.println("Take care!");
                                        exit = true;
                                    }
                                    default -> System.out.println("invalid value please enter yes or no  ");
                                }
                                
                            } else {
                                System.out.println("You must have made a mistake. Please try again.");
                                exit = true;
                            }
                        }
                        break;
                    
                    case 3:
                        exit = true;
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid option");
                        break;
                }
            }
        } catch (SQLException e) {
            System.out.println("Connection not successful: " + e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println("Failed to close the connection: " + ex.getMessage());
            }
        }
    }

    private void collectPreUserDetails(Scanner scanner) {
        System.out.println("Enter username:");
        this.username = scanner.nextLine();
        
        String password;
        while (true) {
            System.out.println("Enter password:");
            password = scanner.nextLine();

            if (isValidPassword(password)) {
                this.password = password;
                break;
            } else {
                System.out.println("Password must contain at least one number, one symbol, and be at least 8 characters long.");
            }
        }

        System.out.println("Enter gender:");
        this.gender = scanner.nextLine();

        System.out.println("Enter weight (kg):");
        this.weight = scanner.nextDouble();

        System.out.println("Enter height (cm):");
        this.height = scanner.nextDouble();

        System.out.println("Enter neck circumference (cm):");
        this.lenghtNeck = scanner.nextDouble();

        if (!isMale()) {
            System.out.println("Enter hip circumference (cm):");
            this.lenghtHip = scanner.nextDouble();
        }

        System.out.println("Enter waist circumference (cm):");
        this.lenghtWaist = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
    }

    private void registerPreUser(Connection conn) {
        String sql = "INSERT INTO User(username, password, gender, weight, height, neck, hip, waist) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, gender);
            pstmt.setDouble(4, weight);
            pstmt.setDouble(5, height);
            pstmt.setDouble(6, lenghtNeck);
            pstmt.setDouble(7, lenghtHip);
            pstmt.setDouble(8, lenghtWaist);

            pstmt.executeUpdate();
            System.out.println("User registered successfully");
        } catch (SQLException e) {
            System.out.println("Your username is already used. Please choose another username.");
        }
    }

    private static boolean isValidPassword(String password) {
        String regex = "^(?=.*[0-9])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?]).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    private void loginPreUser(Connection conn, Scanner scanner) {
        System.out.println("Enter username:");
        String username = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();

        String sql = "SELECT * FROM User WHERE username = ? AND password = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                System.out.println("Login successful");
              
                this.username = username;
                this.password = password;
                this.gender = rs.getString("gender");
                this.weight = rs.getDouble("weight");
                this.height = rs.getDouble("height");
                this.lenghtNeck = rs.getDouble("neck");
                this.lenghtHip = rs.getDouble("hip");
                this.lenghtWaist = rs.getDouble("waist");
                login = true;
            } else {
                System.out.println("Login failed: Invalid username or password");
                login = false;
            }
        } catch (SQLException e) {
            System.out.println("Login failed: " + e.getMessage());
            login = false;
        }
    }

    private void updatePreUserDetails(Scanner scanner, Connection conn) {
        System.out.println("Enter new weight (kg):");
        this.weight = scanner.nextDouble();

        System.out.println("Enter new height (cm):");
        this.height = scanner.nextDouble();

        System.out.println("Enter new neck circumference (cm):");
        this.lenghtNeck = scanner.nextDouble();

        if (!isMale()) {
            System.out.println("Enter new hip circumference (cm):");
            this.lenghtHip = scanner.nextDouble();
        }

        System.out.println("Enter new waist circumference (cm):");
        this.lenghtWaist = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        String sql = "UPDATE User SET weight = ?, height = ?, neck = ?, hip = ?, waist = ? WHERE username = ? AND password = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDouble(1, weight);
            pstmt.setDouble(2, height);
            pstmt.setDouble(3, lenghtNeck);
            pstmt.setDouble(4, lenghtHip);
            pstmt.setDouble(5, lenghtWaist);
            pstmt.setString(6, username);
            pstmt.setString(7, password);

            pstmt.executeUpdate();
            System.out.println("User details updated successfully");
        } catch (SQLException e) {
            System.out.println("Failed to update user details: " + e.getMessage());
        }
    }

    private boolean isMale() {
        return gender.equalsIgnoreCase("male");
    }

    public double getLenghtNeck() {
        return lenghtNeck;
    }

    public void setLenghtNeck(double lenghtNeck) {
        this.lenghtNeck = lenghtNeck;
    }

    public double getLenghtHip() {
        return lenghtHip;
    }

    public void setLenghtHip(double lenghtHip) {
        this.lenghtHip = lenghtHip;
    }

    public double getLenghtWaist() {
        return lenghtWaist;
    }

    public void setLenghtWaist(double lenghtWaist) {
        this.lenghtWaist = lenghtWaist;
    }

    public String getGender() {
        return gender;
    }

  public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}

