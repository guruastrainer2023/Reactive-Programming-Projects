package com.training.util;

public class ConsoleUtil {

	public static void printLines(int count) {
		for (int i = 1; i <= count; i++) {
			System.out.println();
		}
	}

	public static void printTabs(int count) {
		for (int i = 1; i <= count; i++) {
			System.out.print("\t");
		}
	}

	public static void printCaption(String caption) {
		printLines(2);
		printTabs(2);
		System.out.print("<<<<<< " + caption + " >>>>>>>");
	}

	public static void printData(Object data) {
		printLines(2);
		printTabs(2);
		System.out.print("------ " + data + " ------");
	}

}
