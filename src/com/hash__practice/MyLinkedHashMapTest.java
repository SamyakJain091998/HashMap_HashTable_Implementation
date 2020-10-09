package com.hash__practice;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

import junit.framework.Assert;
import static org.junit.Assert.*;
import org.junit.Ignore;

public class MyLinkedHashMapTest {
	@Ignore
	@Test
	public void givenASentence_WhenWordsAreAddedToList_ShouldReturnParanoidFrequency() {
		String sentence = "Paranoids are not paranoid because they are paranoid but because they keep putting themselves deliberately into paranoid avoidable situations";
		MyLinkedHashMap<String, Integer> myLinkedHashMap = new MyLinkedHashMap<>();
		String[] words = sentence.split(" ");
		for (String word : words) {
			Integer value = myLinkedHashMap.get(word);
			if (value == null) {
				value = 1;
			} else {
				value += 1;
			}
			myLinkedHashMap.add(word, value);
		}
		System.out.println(myLinkedHashMap);
		int frequency = myLinkedHashMap.get("paranoid");
		Assert.assertEquals(3, frequency);
	}
	
	@Test
	public void givenASentence_WhenAWordIsGiven_ShouldDeleteTheWord() {
		String sentence = "Paranoids are not paranoid because they are paranoid but because they keep putting themselves deliberately into paranoid avoidable situations";
		MyLinkedHashMap<String, Integer> myLinkedHashMap = new MyLinkedHashMap<>();
		String[] words = sentence.split(" ");
		for (String word : words) {
			Integer value = myLinkedHashMap.get(word);
			if (value == null) {
				value = 1;
			} else {
				value += 1;
			}
			myLinkedHashMap.add(word, value);
		}
		boolean result = myLinkedHashMap.delete("avoidable");
		System.out.println("My linked list after deleting is : " + myLinkedHashMap);
		Assert.assertTrue(result);
	}
}

