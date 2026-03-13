import java.util.*;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        displayWelcomeMessage();      // UC1
        hardcodedPalindrome();
        reverseUsingLoop("madam");
        twoPointerCheck("madam");
        stackPalindrome("madam");
        queueVsStack("madam");
       
    }

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
public static void twoPointerCheck(String word) {
    char[] arr = word.toCharArray();
    int left = 0, right = arr.length - 1;
    boolean isPalindrome = true;
    while (left < right) {
        if (arr[left] != arr[right]) {
            isPalindrome = false;
            break;
        }
        left++;
        right--;
    }
    System.out.println(isPalindrome ? "UC4: Two Pointer → Palindrome" : "UC4: Not Palindrome");
}
public static void stackPalindrome(String word) {
    Stack<Character> stack = new Stack<>();
    for (char ch : word.toCharArray()) stack.push(ch);
    String reversed = "";
    while (!stack.isEmpty()) reversed += stack.pop();
    System.out.println(word.equals(reversed) ? "UC5: Stack → Palindrome" : "UC5: Not Palindrome");
}
public static void queueVsStack(String word) {
    Queue<Character> queue = new LinkedList<>();
    Stack<Character> stack = new Stack<>();
    for (char ch : word.toCharArray()) { queue.add(ch); stack.push(ch); }
    boolean isPalindrome = true;
    while (!queue.isEmpty()) {
        if (!queue.remove().equals(stack.pop())) { isPalindrome = false; break; }
    }
    System.out.println(isPalindrome ? "UC6: Queue vs Stack → Palindrome" : "UC6: Not Palindrome");
}
}