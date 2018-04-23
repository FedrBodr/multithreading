package ru.fedrbodr.multithreading.api.threads.running;

import java.util.concurrent.TimeUnit;

public class FifthWay {
	public static void main(String[] args) {
		System.out.println("main thread start");
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i=10; i>0; i--){
					System.out.println(" TICK " + i);
					try {
						TimeUnit.MILLISECONDS.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
		System.out.println("main thread stop");
	}
}