package com.xuebing.algorithm.utils;

import java.util.Arrays;
import java.util.Random;

public class ArrayUtil {

	public static final int DEFAULT_INITIAL_CAPACITY = 10;

	public static int[] createRandomDisorderArray() {
		return createRandomDisorderArray(DEFAULT_INITIAL_CAPACITY);
	}

	public static int[] createArray(int initialCapacity) {
		int[] dataSet = new int[initialCapacity];
		for (int i = 0; i < initialCapacity; i++) {
			dataSet[i] = i + 2;
		}
		printArray(dataSet);
		return dataSet;
	}

	public static int[] createRandomDisorderArray(int initialCapacity) {
		int[] dataSet = new int[initialCapacity];
		Random r = new Random();
		for (int i = 0; i < initialCapacity; i++) {
			dataSet[i] = r.nextInt(initialCapacity);
		}
		if (dataSet.length < 100) {
			printArray(dataSet);
		}
		return dataSet;
	}

	public static int[] createRandomOrderArray(int initialCapacity) {
		int[] dataSet = new int[initialCapacity];
		Random r = new Random();
		for (int i = 0; i < initialCapacity; i++) {
			dataSet[i] = r.nextInt(initialCapacity);
		}
		Arrays.sort(dataSet);
		if (dataSet.length < 100) {
			printArray(dataSet);
		}
		return dataSet;
	}

    public static void printArray(int[] dataSet) {
		for (int data : dataSet) {
			System.out.print(data + "   ");
		}
		System.out.println();
	}

	public static int[][]  genTwoDimensionalArray(){
		int[][] data={{100,200,300,400},{500,600,700,800},{900,1000,1100,1200}};
		return data;
	}

}
