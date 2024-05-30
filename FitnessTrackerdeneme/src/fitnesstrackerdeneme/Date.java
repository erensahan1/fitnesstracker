package fitnesstrackerdeneme;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.DayOfWeek;

public class Date {
    private LocalDateTime dateTime;
    private CommonUser commonUser;
    private PremiumUser premiumUser;

    public Date(CommonUser commonUser) {
        this.dateTime = LocalDateTime.now();
        this.commonUser = commonUser;
    }
    public Date(PremiumUser premiumUser){
        this.dateTime =LocalDateTime.now();
        this.premiumUser=premiumUser;
    }

    // Method to display the date and time
    public String displayDateTime() {
        String dayName = getDayName();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return String.format(" entered in %s, %s",  dayName, dateTime.format(formatter));
    }

    // Method to get the day name
    private String getDayName() {
        DayOfWeek dayOfWeek = dateTime.getDayOfWeek();
        return dayOfWeek.toString();
    }
}
