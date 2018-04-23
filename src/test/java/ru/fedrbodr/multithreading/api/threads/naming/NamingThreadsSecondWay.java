package ru.fedrbodr.multithreading.api.threads.naming;

import ru.fedrbodr.multithreading.common.LoopTaskC;

import java.util.concurrent.TimeUnit;

public class NamingThreadsSecondWay {
	public static void main(String[] args) {
		String currentTread = Thread.currentThread().getName();
		System.out.println("main thread start by thread "+currentTread);

		new Thread(new LoopTaskC(), "MyThread-1").start();
		Thread thread2 = new Thread(new LoopTaskC());
//		thread2.setName("MyThread-2");
		thread2.start();
		try {
			TimeUnit.MILLISECONDS.sleep(800);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		thread2.setName("MyThread-2");
		System.out.println("main thread stop by thread "+currentTread);
	}
}