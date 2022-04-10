package com.Question2;

/* Author:Jeyachithra Balaraman*/

// Given Problem Statement : Have used Linkedlist instead of Array as mentioned here.

/*You are a traveler and traveling to a country where the currency denominations are 
unknown and as you travel, you get to know about the denomination in random order.
You want to make a payment of amount x, in such a way that the number of notes you give 
is minimum.
//Assume that the denominations are in such a way that any amount can be paid.
Input
Take input of all the currency denominations ( random order)
Lab 2 – Algorithms Problem Statement
Take input of the amount that you want to pay.
Output
Print the minimum no of notes that you will be using to pay the net amount*/

import java.util.Scanner;
import java.util.Collections;
import java.util.LinkedList;

public class Currency {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// Initialization
		int size, i, amount;
		Integer Value;
		LinkedList<Integer> denominations = new LinkedList<Integer>();
		LinkedList<Integer> currencyNotes = new LinkedList<Integer>();
		try {
			// Input number of Currency denomination
			System.out.println("Enter the Size of Currency Denominations");
			size = sc.nextInt();

			// Input Denominations in random order
			System.out.println("Enter the currency denominations value");
			for (i = 0; i < size; i++) {
				Value = sc.nextInt();
				denominations.add(Value);
			}
		} catch (Exception e) {
			System.out.println(e + " Invalid Input");
			return;
		}
		// Input Amount to be paid
		System.out.println("Enter the amount you want to pay");
		amount = sc.nextInt();

		// Sort denominations in Descending Order
		Collections.sort(denominations, Collections.reverseOrder());

		// Calculate the no. of notes in each denomination
		for (i = 0; i < size; i++) {
			if (amount != 0 && amount > denominations.getLast()) {
				currencyNotes.add(amount / denominations.get(i));
				amount = amount - (denominations.get(i) * currencyNotes.get(i));
			} else
				currencyNotes.add(0);
		}
		// Print output
		System.out.println("Your payment approach in order to give him min no of notes will be");
		for (i = 0; i < size; i++) {
			if (currencyNotes.get(i) != 0)
				System.out.println("Denomination " + denominations.get(i) + " notes :" + currencyNotes.get(i));
		}
		// balance is printed as coins to be paid
		if (amount != 0) {
			System.out.println("Pay in coins : " + amount);
		}
		sc.close();
	}
}
