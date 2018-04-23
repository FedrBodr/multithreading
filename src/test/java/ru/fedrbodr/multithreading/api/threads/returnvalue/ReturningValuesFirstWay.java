package ru.fedrbodr.multithreading.api.threads.returnvalue;

import ru.fedrbodr.multithreading.common.ValueReturningTaskA;

public class ReturningValuesFirstWay {
	public static void main(String[] args) {
		String currentTread = Thread.currentThread().getName();
		System.out.println("main thread start by thread " + currentTread);

//		ValueReturningTaskA task1 = new ValueReturningTaskA(2, 3, 2000);
		ValueReturningTaskA task1 = new ValueReturningTaskA(2, 3, 100);
		Thread t1 = new Thread(task1, "Thread-1");

		ValueReturningTaskA task2 = new ValueReturningTaskA(3, 4, 1000);
		Thread t2 = new Thread(task2, "Thread-2");

		ValueReturningTaskA task3 = new ValueReturningTaskA(4, 5, 300);
		Thread t3 = new Thread(task3, "Thread-3");

		t1.start();
		t2.start();
		t3.start();

		System.out.println("Result1 = " + task1.getSum());
		System.out.println("Result2 = " + task2.getSum());
		System.out.println("Result3 = " + task3.getSum());

		System.out.println("main thread stop by thread " + currentTread);
	}
}