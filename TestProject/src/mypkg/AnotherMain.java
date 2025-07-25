package mypkg;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class AnotherMain {

	public static void main_1(String[] args) {
		
		String text = "I am a boy and people call me busy boy";
		String delim = " ";
		StringTokenizer tokenizer = new StringTokenizer(text, delim);
		
		HashMap<String, Integer> wordCountMap = new HashMap<String, Integer>();
		
		
		while(tokenizer.hasMoreTokens()) {
			String token = tokenizer.nextToken();
			
			if(wordCountMap.containsKey(token))
				wordCountMap.put(token, wordCountMap.get(token).intValue()+1);
			else
				wordCountMap.put(token, 1);
		}
		System.out.println(wordCountMap);
		
		
		String [] words = text.split("\\s+");		
		for(String word: words)
			System.out.println(word);

		
		Set  entrySet = wordCountMap.entrySet();
		System.out.println(entrySet);

	}
	
	public static void main(String[] args) {
        // List of lists of names
        List<List<String>> listOfLists = Arrays.asList(
            Arrays.asList("Reflection", "Collection", "Stream"),
            Arrays.asList("Structure", "State", "Flow"),
            Arrays.asList("Sorting", "Mapping", "Reduction", "Stream")
        );

        // Create a set to hold intermediate results
        Set<String> intermediateResults = new HashSet<>();

        // Stream pipeline demonstrating various intermediate operations
        List<String> result = listOfLists.stream()
            .flatMap(List::stream)               // Flatten the list of lists into a single stream
            .filter(s -> s.startsWith("S"))      // Filter elements starting with "S"
            .map(String::toUpperCase)            // Transform each element to uppercase
            .distinct()                          // Remove duplicate elements
            .sorted()                            // Sort elements
            .peek(s -> intermediateResults.add(s)) // Perform an action (add to set) on each element
            .collect(Collectors.toList());       // Collect the final result into a list

        // Print the intermediate results
        System.out.println("Intermediate Results:");
        intermediateResults.forEach(System.out::println);

        // Print the final result
        System.out.println("\nFinal Result:");
        result.forEach(System.out::println);
    }

}
