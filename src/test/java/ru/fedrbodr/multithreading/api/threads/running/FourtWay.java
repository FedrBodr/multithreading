package ru.fedrbodr.multithreading.api.threads.running;

import java.util.concurrent.TimeUnit;

public class FourtWay {
	public static void main(String[] args) {
		System.out.println("main thread start");
		new Thread(new FourtTask()).start();
		Thread thread = new Thread(new FourtTask());
		thread.start();
		System.out.println("main thread stop");
	}
}

class FourtTask implements Runnable{
	private static int count;
	private int id;
	public FourtTask() {
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
