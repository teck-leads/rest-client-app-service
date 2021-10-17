package com.techleads.app.service;

import java.util.HashSet;
import java.util.Set;

public class WordCounter {
	private int wordsSofar = 0;

	public void add(String words) {

		Set<String> set = new HashSet<>();

		if (words != "") {
//			String[] split = words.toLowerCase().trim().split("\\s+");
			String[] split = words.toLowerCase().trim().split("[., ]+");

			for (String str : split) {
				set.add(str);
			}

		}
		wordsSofar = set.size();

	}

	public int getUniqueWordsCount() {
		return wordsSofar;
	}

}
