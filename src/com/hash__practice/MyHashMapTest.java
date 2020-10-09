package com.hash__practice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

import junit.framework.Assert;
import static org.junit.Assert.*;
import org.junit.Ignore;

public class MyHashMapTest<K, V> {
	@Test
	public void givenASentence_WhenWordsAreAddedToList_ShouldReturnFrequency() {
		String sentence = "to be or not to be";
		MyHashMap<String, Integer> myHashMap = new MyHashMap<>();
		String[] words = sentence.split(" ");
		for (String word : words) {
			Integer value = myHashMap.get(word);
			if (value == null)
				value = 1;
			else
				value += 1;
			myHashMap.add(word, value);
		}
		Integer frequency = myHashMap.get("to");
		System.out.println(myHashMap);
		Assert.assertEquals((Integer)2, frequency);
	}
}
