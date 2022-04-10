package com.Question1;
/*Author : Jeyachithra Balaraman*/

/*Note: Have used Linkedlist Instead of Arrays to improve space management*/

/*PayMoney. processes thousands of transactions daily amounting to crores of Rupees. They 
also have a daily target that they must achieve. Given a list of transactions done by 
PayMoney and a daily target, your task is to determine at which transaction PayMoney 
achieves the same. If the target is not achievable, then display the target is not achieved.*/
import java.util.Scanner;
import java.util.LinkedList;

public class PayMoney {
	public static void main(String[] args) {
		// Initialize variables used
		Scanner sc = new Scanner(System.in);
		LinkedList<Integer> linkedlist = new LinkedList<Integer>();
		int i, j, target_no = 0, size = 0, flag = 0;
		long target_value;
		long total;

		try {
			// Input Size of transaction list
			System.out.println("PayMoney");
			System.out.println("Enter the number of transactions");
			size = sc.nextInt();

			// Store transaction values in linkedlist
			System.out.println("Enter the values of " + size + " transactions ");
			for (i = 0; i < size; i++)
				linkedlist.add(sc.nextInt());

			// Input Target values
			System.out.println("Enter the total number of targets to be achieved");
			target_no = sc.nextInt();

		} catch (Exception e) {
			System.out.println(e + "  Invalid Input");
			return;
		}

		for (j = 0; j < target_no; j++) {
			flag = 0;
			System.out.println("Enter the value of target");
			target_value = sc.nextInt();
			total = 0;
			// Checking if transaction sum exceeds target value
			for (i = 0; i < size; i++) {
				total = total + linkedlist.get(i);
				if (total > target_value && flag != 1) {
					System.out.println("Target achieved after " + (i + 1) + " transactions");
					flag = 1;
				}
			} // close i loop
			if (flag == 0) {
				System.out.println("Given target is not achieved");
			}

		} // close j loop
		sc.close();
	}
}
