// Custom exception class
class ExcessiveWorkingHoursException extends Exception {
    public ExcessiveWorkingHoursException(String message) {
        super(message);
    }
}

public class WorkingHoursValidator {
    
    // Method to validate working hours
    public static void validateWorkingHours(int hours) throws ExcessiveWorkingHoursException {
        if (hours > 8) {
            throw new ExcessiveWorkingHoursException("Excessive working hours: " + hours + " hours. Maximum allowed is 8 hours.");
        } else {
            System.out.println("Working hours are within the acceptable range: " + hours + " hours.");
        }
    }

    public static void main(String[] args) {
        // Check if an argument is passed (working hours)
        if (args.length == 0) {
            System.out.println("Please provide working hours as a command-line argument.");
            return;
        }

        try {
            // Parse the working hours from command-line argument
            int workingHours = Integer.parseInt(args[0]);

            // Validate the working hours
            validateWorkingHours(workingHours);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a valid number for working hours.");
        } catch (ExcessiveWorkingHoursException e) {
            System.out.println(e.getMessage());
        }
    }
}
