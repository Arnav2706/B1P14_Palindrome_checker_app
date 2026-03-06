import java.util.*;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        displayWelcomeMessage();      // UC1
        hardcodedPalindrome();        // UC2
        reverseUsingLoop("madam");    // UC3
        twoPointerCheck("madam");     // UC4
        stackPalindrome("madam");     // UC5
        queueVsStack("madam");        // UC6
        dequePalindrome("madam");     // UC7
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

    // =========================
    // UC2 – Hardcoded String
    // =========================
    public static void hardcodedPalindrome() {

        String word = "madam";

        if (word.equals("madam")) {
            System.out.println("UC2: Hardcoded check → It is a Palindrome");
        } else {
            System.out.println("UC2: Not a Palindrome");
        }
    }

    // =========================
    // UC3 – Reverse Using Loop
    // =========================
    public static void reverseUsingLoop(String word) {

        String reversed = "";

        for (int i = word.length() - 1; i >= 0; i--) {
            reversed += word.charAt(i);
        }

        if (word.equals(reversed)) {
            System.out.println("UC3: Reverse Loop → Palindrome");
        } else {
            System.out.println("UC3: Not Palindrome");
        }
    }

    // =========================
    // UC4 – Two Pointer Technique
    // =========================
    public static void twoPointerCheck(String word) {

        char[] arr = word.toCharArray();
        int left = 0;
        int right = arr.length - 1;
        boolean isPalindrome = true;

        while (left < right) {
            if (arr[left] != arr[right]) {
                isPalindrome = false;
                break;
            }
            left++;
            right--;
        }

        if (isPalindrome) {
            System.out.println("UC4: Two Pointer → Palindrome");
        } else {
            System.out.println("UC4: Not Palindrome");
        }
    }

    // =========================
    // UC5 – Stack Approach (LIFO)
    // =========================
    public static void stackPalindrome(String word) {

        Stack<Character> stack = new Stack<>();

        for (char ch : word.toCharArray()) {
            stack.push(ch);
        }

        String reversed = "";
        while (!stack.isEmpty()) {
            reversed += stack.pop();
        }

        if (word.equals(reversed)) {
            System.out.println("UC5: Stack → Palindrome");
        } else {
            System.out.println("UC5: Not Palindrome");
        }
    }

    // =========================
    // UC6 – Queue vs Stack (FIFO vs LIFO)
    // =========================
    public static void queueVsStack(String word) {

        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        for (char ch : word.toCharArray()) {
            queue.add(ch);
            stack.push(ch);
        }

        boolean isPalindrome = true;

        while (!queue.isEmpty()) {
            if (!queue.remove().equals(stack.pop())) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println("UC6: Queue vs Stack → Palindrome");
        } else {
            System.out.println("UC6: Not Palindrome");
        }
    }

    // =========================
    // UC7 – Deque Approach
    // =========================
    public static void dequePalindrome(String word) {

        Deque<Character> deque = new LinkedList<>();

        for (char ch : word.toCharArray()) {
            deque.add(ch);
        }

        boolean isPalindrome = true;

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println("UC7: Deque → Palindrome");
        } else {
            System.out.println("UC7: Not Palindrome");
        }
    }
}