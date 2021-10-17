package com.techleads.app.dateutils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.techleads.app.service.WordCounter;

class WordCounterTest {

	private WordCounter counter = new WordCounter();

	@Test
	void emptyStrngHashNowords() {

		counter.add("");
		assertEquals(0, counter.getUniqueWordsCount());
	}

	@Test
	void singleWordStringHasOneWord() {

		counter.add("hello");
		assertEquals(1, counter.getUniqueWordsCount());
	}

	@Test
	void twoWordsTesting() {

		counter.add("hello madhav");
		assertEquals(2, counter.getUniqueWordsCount());
	}
	
	@Test
	void multipleWordsTesting() {

		counter.add("hello madhav teja");
//		counter.add("hi teja");
		
		assertEquals(3, counter.getUniqueWordsCount());
	}
	
	
	@Test
	void countUniqueWords() {

		counter.add("madhav teja madhav teja");
		
		assertEquals(2, counter.getUniqueWordsCount());
	}
	
	
	@Test
	void countMixedCaeUniqueWords() {

		counter.add("teja TEJA TeJa");
		
		assertEquals(1, counter.getUniqueWordsCount());
	}
	
	
	@Test
	void countWithPunctuationUniqueWords() {

		counter.add("Nine.");
		counter.add("Nine ten.");
		counter.add("Nine,ten,eleven.");
		
		
		assertEquals(3, counter.getUniqueWordsCount());
	}
	


}
