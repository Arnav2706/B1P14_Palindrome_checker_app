import java.util.*;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        displayWelcomeMessage();      // UC1
        hardcodedPalindrome();
       
    }

    // =========================
    // UC1 – Welcome Message
    // =========================
    public static void displayWelcomeMessage() {
        System.out.println("===================================");
        System.out.println("Palindrome Checker App");
        System.out.println("Version: 1.0");
        System.out.println("===================================");
    }
    public static void hardcodedPalindrome() {
    String word = "madam";
    if (word.equals("madam")) {
        System.out.println("UC2: Hardcoded check → It is a Palindrome");
    } else {
        System.out.println("UC2: Not a Palindrome");
    }
}