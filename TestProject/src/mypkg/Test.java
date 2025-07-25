// You are given a List/Array of characters
// You have to group the adjacent matching characters into a group of maximum size 3.
//
// If there are more than 3 consecutive matching characters, split the group. No group
// should be larger than 3 in size.
//
// For example, given this list: ["x", "x", "d", "d", "d", "d", "n", "m", "l", "l", "x"]
// The output should be: [["x", "x"], ["d", "d", "d"], ["d"], ["n"], ["m"], ["l", "l"], ["x"]]
//
// You can use any collection or data-structure you want. You can also search on the internet
// for syntax or library help. 
// 
// Using AI is not allowed. If AI usage is detected, the interview will be terminated.

package mypkg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    /**
     * Groups adjacent matching characters into groups of maximum size 3.
     * If there are more than 3 consecutive matching characters, they are split into multiple groups.
     *
     * @param charList A list of characters (e.g., ["x", "x", "d", "d", "d", "d", "n", "m", "l", "l", "x"]).
     * @return A list of lists, where each inner list represents a group of characters.
     * (e.g., [["x", "x"], ["d", "d", "d"], ["d"], ["n"], ["m"], ["l", "l"], ["x"]])
     */
    public static List<List<Character>> groupAdjacentCharacters(List<Character> charList) {
        // If the input list is null or empty, return an empty list
        if (charList == null || charList.isEmpty()) {
            return new ArrayList<>();
        }

        List<List<Character>> finalResult = new ArrayList<>();
        int i = 0; // Pointer for the main iteration through the character list

        // Iterate through the character list
        while (i < charList.size()) {
            char currentChar = charList.get(i); // Get the current character
            int count = 0; // Initialize count for the current group
            int j = i; // Pointer to look ahead for consecutive matching characters

            // Count consecutive occurrences of the currentChar, up to a maximum of 3
            while (j < charList.size() && charList.get(j) == currentChar && count < 3) {
                count++; // Increment count
                j++;     // Move to the next character
            }

            // Create a new group (a list of characters)
            List<Character> currentGroup = new ArrayList<>();
            // Add the currentChar 'count' times to the currentGroup
            for (int k = 0; k < count; k++) {
                currentGroup.add(currentChar);
            }
            // Add the completed group to the final result
            finalResult.add(currentGroup);

            // Move the main pointer 'i' to the position after the characters just processed
            i = j;
        }

        return finalResult;
    }

    public static void main(String[] args) {
        // Example usage 1: ["x", "x", "d", "d", "d", "d", "n", "m", "l", "l", "x"]
        List<Character> inputList1 = Arrays.asList('x', 'x', 'd', 'd', 'd', 'd', 'n', 'm', 'l', 'l', 'x');
        List<List<Character>> output1 = groupAdjacentCharacters(inputList1);
        System.out.println("Input: " + inputList1);
        System.out.println("Output: " + output1);
        // Expected: [[x, x], [d, d, d], [d], [n], [m], [l, l], [x]]
        System.out.println("---");

        // Example usage 2: "aaaaa" should be [["a", "a", "a"], ["a", "a"]]
        List<Character> inputList2 = Arrays.asList('a', 'a', 'a', 'a', 'a');
        List<List<Character>> output2 = groupAdjacentCharacters(inputList2);
        System.out.println("Input: " + inputList2);
        System.out.println("Output: " + output2);
        // Expected: [[a, a, a], [a, a]]
        System.out.println("---");

        // Example usage 3: "bbbbbb" should be [["b", "b", "b"], ["b", "b", "b"]]
        List<Character> inputList3 = Arrays.asList('b', 'b', 'b', 'b', 'b', 'b');
        List<List<Character>> output3 = groupAdjacentCharacters(inputList3);
        System.out.println("Input: " + inputList3);
        System.out.println("Output: " + output3);
        // Expected: [[b, b, b], [b, b, b]]
        System.out.println("---");

        // Example usage 4: single characters
        List<Character> inputList4 = Arrays.asList('a', 'b', 'c');
        List<List<Character>> output4 = groupAdjacentCharacters(inputList4);
        System.out.println("Input: " + inputList4);
        System.out.println("Output: " + output4);
        // Expected: [[a], [b], [c]]
        System.out.println("---");

        // Example usage 5: empty list
        List<Character> inputList5 = new ArrayList<>();
        List<List<Character>> output5 = groupAdjacentCharacters(inputList5);
        System.out.println("Input: " + inputList5);
        System.out.println("Output: " + output5);
        // Expected: []
        System.out.println("---");

        // Example usage 6: all same characters, less than 3
        List<Character> inputList6 = Arrays.asList('z', 'z');
        List<List<Character>> output6 = groupAdjacentCharacters(inputList6);
        System.out.println("Input: " + inputList6);
        System.out.println("Output: " + output6);
        // Expected: [[z, z]]
        System.out.println("---");
    }
}