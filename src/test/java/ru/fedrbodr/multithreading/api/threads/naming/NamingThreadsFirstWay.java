package ru.fedrbodr.multithreading.api.threads.naming;

import ru.fedrbodr.multithreading.common.LoopTaskB;

public class NamingThreadsFirstWay {
	public static void main(String[] args) {
		String currentTread = Thread.currentThread().getName();
		System.out.println("main thread start by thread "+currentTread);

		new Thread(new LoopTaskB()).start();
		Thread thread2 = new Thread(new LoopTaskB());
		thread2.start();
		System.out.println("main thread stop by thread "+currentTread);
	}
}