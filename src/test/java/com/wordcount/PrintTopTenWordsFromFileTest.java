package com.wordcount;


import static org.junit.Assert.assertNotNull;
import  static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * This is test class for PrintTopTenWordsFromFile
 */
public class PrintTopTenWordsFromFileTest {
	
	/**
	 * To test the file to print the top 10 unique words with their count
	 */
	@Test
	public void testPrintingTopTenUniqueWords()  {
		String relativePath = "./src/test/resources/tempest.txt"; 
		Assertions.assertNotNull(relativePath);
		PrintTopTenWordsFromFile file = new PrintTopTenWordsFromFile();
		
		Map<String,Integer> resultMap = file.countWords(relativePath); 
		assertNotNull(resultMap);
		file.printTop10Entries(resultMap); 
		
	}
	
	/**
	 * To test the Exception scenario
	 * @throws Exception
	 */
	@Test
	public void testPrintingTopTenUniqueWordsForException() throws Exception{
		String relativePath1 = "./src/test/resources/tempest1.txt"; 
		PrintTopTenWordsFromFile file1 = new PrintTopTenWordsFromFile();
		Map<String,Integer> resultMap1 = file1.countWords(relativePath1); 
		Map<String,Integer> resultMapexpected = new HashMap<>();
		assertEquals(resultMapexpected,resultMap1);
		        
	}
	
	@Test
	public void testMain() {
		PrintTopTenWordsFromFile.main(null);
	}
}

