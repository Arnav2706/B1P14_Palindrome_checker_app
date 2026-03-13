import java.util.*;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

        displayWelcomeMessage();      // UC1
        hardcodedPalindrome();
        reverseUsingLoop("madam");
        twoPointerCheck("madam");
        stackPalindrome("madam");
        queueVsStack("madam");
        dequePalindrome("madam");
        linkedListPalindrome("madam");
        recursivePalindrome("madam");
        normalizedPalindrome("A man a plan a canal Panama");
        PalindromeChecker checker = new PalindromeChecker("madam");
checker.checkPalindrome();

       
    }

static class ListNode {
    char val;
    ListNode next;
    ListNode(char val) { this.val = val; }
}

static class PalindromeChecker {
    private String word;

    PalindromeChecker(String word) {
        this.word = word;
    }

    public void checkPalindrome() {
        Stack<Character> stack = new Stack<>();
        for (char ch : word.toCharArray()) stack.push(ch);
        String reversed = "";
        while (!stack.isEmpty()) reversed += stack.pop();
        System.out.println(word.equals(reversed)
            ? "UC11: OOP Service → Palindrome"
            : "UC11: Not Palindrome");
    }
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
public static void dequePalindrome(String word) {
    Deque<Character> deque = new LinkedList<>();
    for (char ch : word.toCharArray()) deque.add(ch);
    boolean isPalindrome = true;
    while (deque.size() > 1) {
        if (!deque.removeFirst().equals(deque.removeLast())) { isPalindrome = false; break; }
    }
    System.out.println(isPalindrome ? "UC7: Deque → Palindrome" : "UC7: Not Palindrome");
}
public static void linkedListPalindrome(String word) {
    if (word == null || word.isEmpty()) return;

    // Build linked list
    ListNode head = new ListNode(word.charAt(0));
    ListNode curr = head;
    for (int i = 1; i < word.length(); i++) {
        curr.next = new ListNode(word.charAt(i));
        curr = curr.next;
    }

    // Find middle using slow/fast pointer
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }

    // Reverse second half
    ListNode prev = null, current = slow;
    while (current != null) {
        ListNode nextNode = current.next;
        current.next = prev;
        prev = current;
        current = nextNode;
    }

    // Compare halves
    ListNode left = head, right = prev;
    boolean isPalindrome = true;
    while (right != null) {
        if (left.val != right.val) { isPalindrome = false; break; }
        left = left.next;
        right = right.next;
    }

    System.out.println(isPalindrome ? "UC8: Linked List → Palindrome" : "UC8: Not Palindrome");
}
public static void recursivePalindrome(String word) {
    boolean result = checkRecursive(word, 0, word.length() - 1);
    System.out.println(result ? "UC9: Recursive → Palindrome" : "UC9: Not Palindrome");
}

public static boolean checkRecursive(String word, int left, int right) {
    if (left >= right) return true;
    if (word.charAt(left) != word.charAt(right)) return false;
    return checkRecursive(word, left + 1, right - 1);
}
public static void normalizedPalindrome(String word) {
    String cleaned = word.toLowerCase().replaceAll("[^a-z0-9]", "");
    String reversed = new StringBuilder(cleaned).reverse().toString();
    System.out.println(cleaned.equals(reversed)
        ? "UC10: Normalized → Palindrome"
        : "UC10: Not Palindrome");
}
}