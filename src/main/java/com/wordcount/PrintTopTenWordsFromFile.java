package com.wordcount;


import static org.junit.Assert.assertNotNull;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Assertions;

/**
 * The programming exercise is to create a Java program that counts unique words from a text file and lists the top 10 occurrences.
*Using the supplied text file (tempest.txt), English locale and treating hyphen and apostrophe as part of a word, 
 */
public class PrintTopTenWordsFromFile {

	/**
	 * Method to parse the file & read the words , considering -, ' as part of words &
	 * count the unique words and add them to map
	 * @param path Input file path
	 * @return map of unique words with their count
	 */
	public Map<String, Integer> countWords(String path)  {
		Map<String, Integer> wordMap = new HashMap<>();
		try (BufferedReader reader = new BufferedReader(new FileReader(path))) {

			String currentLine = reader.readLine();
			 Pattern wordPattern = Pattern.compile("[\\w'-]+");
			while (currentLine != null) {
				 Matcher matcher = wordPattern.matcher(currentLine);
				 while(matcher.find()) {
					 String word = matcher.group().toLowerCase();
					if (!word.isBlank()) {
							wordMap.put(word, wordMap.getOrDefault(word,0) + 1);
					}
				}
				currentLine = reader.readLine();
			}
		} catch (IOException e) {
			System.err.println("Exception Occurred while reading the file "+e);
		}

		return wordMap;
	}

	/**
	 * This method prints the top 10 unique words with their count
	 * @param map of unique words with their count
	 */
	public void printTop10Entries(Map<String,Integer> map) {
		List<Entry<String,Integer>> lst = map.entrySet().stream().sorted((e1,e2) -> e2.getValue().compareTo(e1.getValue())).limit(10).collect(Collectors.toList());
		System.out.println( " Printing top 10 unique words with count :  "+lst);
	}
	
	/**
	 * Main method to run & see the output in the console
	 * @param arg
	 */
	public static void main(String arg[]) {
		String relativePath = "./src/main/resources/tempest.txt"; 
		PrintTopTenWordsFromFile file = new PrintTopTenWordsFromFile();
		Map<String,Integer> resultMap = file.countWords(relativePath); 
		file.printTop10Entries(resultMap); 
	}
}
