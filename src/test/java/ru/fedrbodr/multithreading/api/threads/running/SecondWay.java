package ru.fedrbodr.multithreading.api.threads.running;

import java.util.concurrent.TimeUnit;

public class SecondWay {
	public static void main(String[] args) {
		System.out.println("main thread start");
		new SecondTask().start();
		Thread task = new SecondTask();
		task.start();
		System.out.println("main thread stop");
	}
}

class SecondTask extends Thread{
	private static int count;
	private int id;
	public SecondTask() {
		id = ++count;
	}

	@Override
	public void run() {
		for (int i=10; i>0; i--){
			System.out.println("id = "+id+" TICK " + i);
			try {
				TimeUnit.MILLISECONDS.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
