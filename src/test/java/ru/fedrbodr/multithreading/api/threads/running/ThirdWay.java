package ru.fedrbodr.multithreading.api.threads.running;

import java.util.concurrent.TimeUnit;

public class ThirdWay {
	public static void main(String[] args) {
		System.out.println("main thread start");
		new ThirdTask();
		new ThirdTask();
		System.out.println("main thread stop");
	}
}

class ThirdTask implements Runnable{
	private static int count;
	private int id;
	public ThirdTask() {
		id = ++count;
		new Thread(this).start();
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
