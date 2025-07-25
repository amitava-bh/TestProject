package mypkg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@FunctionalInterface
interface MyFunction{
	public int add(int x, int y);
	
}

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		//MyFunction func = (int x, int y) -> x+y;
		MyFunction func = (int x, int y) -> {
			int z = x+y;
			System.out.println(z);
			return z;
		};
		int z = func.add(2, 3);
		System.out.println(z);
		
		
		//Reversing the string without using string, stringbuffer or stringbuilder's reverse method.
		reverseString("Hello");
		//System.out.println(reverseString("Hello"));
		
		reverseStringBySWAP("Hello");
		
		//Check if the string is a palindrome or not
		System.out.println(isPalindrome("madam"));
		
		//Findout the smallest and largest Element in an array
		int [] randomArray = {10, 8, 2, 6, 4, 9, 7, 12, 18, 0, 5};
		int smallestElement = findSmallestElementInArray(randomArray);
		int largestElement = findLargestElementInArray(randomArray);
		System.out.println("smallestElement = "+smallestElement);
		System.out.println("largestElement = "+largestElement);
		
		//Sorting an array using bubble sort
		bubbleSort(randomArray);
		
		//calculate the factorial of a number using loop
		factorial(4);
		
		int fact_recursion = factorial_rec(4);
		System.out.println("factorial using recursion = "+fact_recursion);
		
		//Count the characters from the string
		countCharacterOccurrences("Hello");
		
		//remove duplicate characters
		removeDuplicates("Hello");

		int [] arr1= {1,3,5,7,9, 11,13};
		int [] arr2= {2,4,6,8,10,12,14};
		mergeArrays(arr1, arr2);
		
		Arrays.asList(arr1).stream().filter(var -> var.equals(arr2));
				
		List<Integer> list1 = Arrays.asList(1,3,5,7,9);
		List<Integer> list2 = Arrays.asList(2,4,6,8,10);
		combineLists(list1, list2);
		
		
		//list1.stream().
		
		
		int [] randomArr = {10, 8, 2, 6, 4, 9, 7, 12, 18, 0, 5};
		Arrays.sort(randomArr);
		//Arrays.toString(randomArr);
		System.out.println(Arrays.toString(randomArr));	
		
		// Remove duplicates from a list (using Set or Java 8 streams)
		String[] names = {"Alice", "Bob", "Andrew", "Charlie", "Alice"};
		int [] myInt = {3, 2, 6, 5, 7, 6, 2};
		System.out.println(Arrays.asList(names));
		
		Set<String> myset = new HashSet<String>();
		myset.addAll(Arrays.asList(names));		
		System.out.println(myset);
				
		System.out.println(Arrays.stream(names).distinct().toList());
		
		System.out.println(Arrays.stream(names).distinct().collect(Collectors.toList()));
				
		
	}
	
	public static String reverseString(String str) {
		
		if(str == null || str.isBlank() || str.isEmpty()) 
			return null;
		
		char [] origStrChar = str.toCharArray();
		char [] revStrChar = new char [origStrChar.length];
		
//		for(int index = 0; index< origStrChar.length; index++) {
//			char tempChar = origStrChar[index];
//			System.out.println(tempChar);
//		}
		
		int count=0;
		for(int index = origStrChar.length-1; index>=0; index--) {			
			revStrChar[count++] = origStrChar[index];
		}
		
		String reverseStr = new String(revStrChar);
		System.out.println(reverseStr);
		return reverseStr;
	}
	
	public static boolean isPalindrome(String str) {
		
		if(str == null || str.isBlank() || str.isEmpty())
			return false;
		
		String reverseStr = reverseString(str);
		boolean isPalindromeFlag = false;
		if(reverseStr.equalsIgnoreCase(str)) 
			isPalindromeFlag=true;
		else 
			isPalindromeFlag=false;
		
		return isPalindromeFlag;
	}
	
	public static String reverseStringBySWAP(String str) {
		
		char [] charArray = str.toCharArray();
		int left = 0;
		int right = charArray.length-1;
		
		while(left < right) {
			//swap the characters
			char temp = charArray[right];
			charArray[right] = charArray[left];
			charArray[left] = temp;
			
			left++;
			right--;			
		}
		
		String reverseStr = new String(charArray);
		System.out.println("reverseStringBySWAP = "+reverseStr);
		return reverseStr;
		
	}
	
	public static int findSmallestElementInArray(int[] intArr) {
		
		int smallestInt = intArr[0];
		for(int i=0; i<intArr.length; i++) {
			int getElement = intArr[i];
			
			//System.out.print(intArr[i]+", ");			
			if(smallestInt>getElement)				
				smallestInt = getElement;
		}		
		return smallestInt;
	}
	
	public static int findLargestElementInArray(int[] intArr) {
		int largestElement = intArr[0];
		for(int i=0; i<intArr.length; i++) {
			if(intArr[i]>largestElement)
				largestElement = intArr[i];
		}
		return largestElement;
	}
	
	
	public static void bubbleSort(int [] array) {
		
		//Before sorting the array.
		System.out.println("Before sorting the array : "+Arrays.toString(array));
		
		int length = array.length;
		
		// Outer loop for passes through the array
		for(int i=0; i< length-1; i++) {
			//System.out.println(i +"th Element = "+array[i]);
			
			//In each pass, the largest unsorted element "bubbles up" to its correct position
			for(int j=0; j<length-i-1; j++) {
				//swap the numbers
				if(array[j] > array[j+1]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
		//After sorting the array
		System.out.println("After sorting the array:"+Arrays.toString(array));		
	}
	
	public static int factorial_rec(int number) {
		
		int factorial = 1;
		if(number ==1) 
			return 1;
		else
			factorial = number*factorial_rec(number-1);
		
		return factorial;
	}
	
	public static int factorial(int number) {
		
		int factorial = 1;
		
		//Using increasing loop
		for(int count=1; count<=number; count++) {
			//factorial = factorial*count;
		}
		
		//Using decreasing loop
		for(int count=number; count>=1; count--) {
			factorial = factorial*count;
		}
		
		System.out.println("factorial = "+factorial);
		return factorial;
	}
	
	public static void countCharacterOccurrences(String str) {
		
		Map<Character, Integer> charCountsMap = new HashMap<>();
		
		if(str == null || str.isBlank() || str.isEmpty())
			System.out.println("No characters to count (string was empty or null).");
		
		char [] charArr = str.toCharArray();
		
		for(int index=0; index < charArr.length; index++) {
			char c  = charArr[index];
			charCountsMap.put(c, charCountsMap.getOrDefault(c, 0)+1);
		}
		
		charCountsMap.forEach((character, count) -> System.out.println(character + " : " + count));
		
	}
	
	public static String removeDuplicates(String str) {
		
		Set<Character> uniqueSet = new HashSet<Character>();		
		for(char c: str.toCharArray()) {
			uniqueSet.add(c);
		}
		
		StringBuilder sb = new StringBuilder();
		for(char c: uniqueSet) {
			sb.append(c);
		}
		
		System.out.println(sb.toString());		
		return sb.toString();		
	}
	
	public static int[] mergeArrays(int[] arr1, int[] arr2) {
		
		int n = arr1.length + arr2.length;
		int[] mergedArray = new int[n];
		
		// Traverse 1st arrays and add elements to mergedArray 
		int currentPos = 0;
		for(int i=0; i< arr1.length; i++) {
			mergedArray[currentPos++] = arr1[i];
		}
				
		// Traverse 2nd arrays and add elements to mergedArray
		for(int i=0; i< arr2.length; i++) {
			mergedArray[currentPos++] = arr2[i];
		}
		
		//display the merged array		
		System.out.println("Before sorting --> "+ Arrays.toString(mergedArray));
				
		for(int i=0; i<n-1; i++) {
			for(int j=0; j<n-1-i; j++) {			
				if(mergedArray[j]>mergedArray[j+1]) {
					//swap the value
					int temp = mergedArray[j];
					mergedArray[j] = mergedArray[j+1];
					mergedArray[j+1] = temp;
				}
			}
		}		
		
		//display the merged array
		System.out.println("Before sorting --> "+ Arrays.toString(mergedArray));
		
		return mergedArray;
		
	}
	
	
	public static List<Integer> combineLists(List<Integer> list1, List<Integer> list2) {
		List<Integer> combineList = new ArrayList<Integer>();
		
		combineList.addAll(list1);
		combineList.addAll(list2);
		
		System.out.println(combineList);
		
		List<Integer> combinedSortedList = combineList.stream().sorted().toList();
		
		System.out.println(combinedSortedList);
		
		return combineList;
	}
	

}
