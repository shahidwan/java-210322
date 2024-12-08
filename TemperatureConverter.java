import java.util.Scanner;

public class TemperatureConverter {

    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }

    public static double celsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }

    public static double fahrenheitToKelvin(double fahrenheit) {
        return (fahrenheit - 32) * 5/9 + 273.15;
    }

    public static double kelvinToCelsius(double kelvin) {
        if (kelvin < 0) {
            System.out.println("Invalid input! Kelvin cannot be negative.");
            return -1; // Return an invalid value
        }
        return kelvin - 273.15;
    }

    public static double kelvinToFahrenheit(double kelvin) {
        if (kelvin < 0) {
            System.out.println("Invalid input! Kelvin cannot be negative.");
            return -1; // Return an invalid value
        }
        return (kelvin - 273.15) * 9/5 + 32;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the temperature value: ");
        double temperature = scanner.nextDouble();

        System.out.print("Enter the scale (Celsius, Fahrenheit, Kelvin): ");
        String scale = scanner.next().toLowerCase();

        if (scale.equals("celsius")) {
            double fahrenheit = celsiusToFahrenheit(temperature);
            double kelvin = celsiusToKelvin(temperature);
            System.out.println(temperature + " Celsius is " + fahrenheit + " Fahrenheit and " + kelvin + " Kelvin.");
        } else if (scale.equals("fahrenheit")) {
            double celsius = fahrenheitToCelsius(temperature);
            double kelvin = fahrenheitToKelvin(temperature);
            System.out.println(temperature + " Fahrenheit is " + celsius + " Celsius and " + kelvin + " Kelvin.");
        } else if (scale.equals("kelvin")) {
            double celsius = kelvinToCelsius(temperature);
            double fahrenheit = kelvinToFahrenheit(temperature);
            if (celsius != -1 && fahrenheit != -1) {
                System.out.println(temperature + " Kelvin is " + celsius + " Celsius and " + fahrenheit + " Fahrenheit.");
            }
        } else {
            System.out.println("Invalid scale! Please use 'Celsius', 'Fahrenheit', or 'Kelvin'.");
        }

        scanner.close();
    }
}
