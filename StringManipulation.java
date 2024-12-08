import java.util.Scanner;

public class StringManipulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        int choice;

        while (true) {
            System.out.println("String Manipulation Toolkit");
            System.out.println("1. Reverse String");
            System.out.println("2. Convert to Uppercase");
            System.out.println("3. Convert to Lowercase");
            System.out.println("4. Check Palindrome");
            System.out.println("5. Count Vowels and Consonants");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter a string to reverse: ");
                    input = scanner.nextLine();
                    System.out.println("Reversed String: " + reverseString(input));
                    break;
                case 2:
                    System.out.print("Enter a string to convert to uppercase: ");
                    input = scanner.nextLine();
                    System.out.println("Uppercase String: " + input.toUpperCase());
                    break;
                case 3:
                    System.out.print("Enter a string to convert to lowercase: ");
                    input = scanner.nextLine();
                    System.out.println("Lowercase String: " + input.toLowerCase());
                    break;
                case 4:
                    System.out.print("Enter a string to check for palindrome: ");
                    input = scanner.nextLine();
                    if (isPalindrome(input)) {
                        System.out.println(input + " is a palindrome.");
                    } else {
                        System.out.println(input + " is not a palindrome.");
                    }
                    break;
                case 5:
                    System.out.print("Enter a string to count vowels and consonants: ");
                    input = scanner.nextLine();
                    countVowelsAndConsonants(input);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static String reverseString(String str) {
        StringBuilder reversed = new StringBuilder(str);
        return reversed.reverse().toString();
    }

    public static boolean isPalindrome(String str) {
        String reversed = reverseString(str);
        return str.equalsIgnoreCase(reversed);
    }

    public static void countVowelsAndConsonants(String str) {
        int vowels = 0, consonants = 0;
        str = str.toLowerCase().replaceAll("[^a-z]", "");
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if ("aeiou".indexOf(ch) != -1) {
                vowels++;
            } else {
                consonants++;
            }
        }
        
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }
}
