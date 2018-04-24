package ru.fedrbodr.multithreading.api.threads.returnvalue;

import ru.fedrbodr.multithreading.common.ValueReturningTaskB;

public class ReturningValuesSecondWay {
	public static void main(String[] args) {
		String currentTread = Thread.currentThread().getName();
		System.out.println("main thread start by thread " + currentTread);

		ValueReturningTaskB task1 = new ValueReturningTaskB(2, 3, 2000, new SumObserver("Task1"));

		Thread t1 = new Thread(task1, "Thread-1");

		ValueReturningTaskB task2 = new ValueReturningTaskB(3, 4, 1000, new SumObserver("Task2"));
		Thread t2 = new Thread(task2, "Thread-2");

		ValueReturningTaskB task3 = new ValueReturningTaskB(4, 5, 300, new SumObserver("Task3"));
		Thread t3 = new Thread(task3, "Thread-3");

		t1.start();
		t2.start();
		t3.start();

		System.out.println("main thread stop by thread " + currentTread);
	}
}