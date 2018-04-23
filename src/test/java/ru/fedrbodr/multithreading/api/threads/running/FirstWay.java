package ru.fedrbodr.multithreading.api.threads.running;

import java.util.concurrent.TimeUnit;

public class FirstWay {
	public static void main(String[] args) {
		System.out.println("main thread start");
		new FirstTask();
		Thread task = new FirstTask();
		System.out.println("main thread stop");
	}
}

class FirstTask extends Thread{
	private static int count;
	private int id;
	public FirstTask() {
		id = ++count;
		this.start();
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
