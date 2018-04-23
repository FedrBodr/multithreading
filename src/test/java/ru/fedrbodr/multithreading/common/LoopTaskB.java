package ru.fedrbodr.multithreading.common;

import java.util.concurrent.TimeUnit;

public class LoopTaskB implements Runnable {
	private static int count;
	private int instanceNumber;
	private String taskId;
	public LoopTaskB() {
		this.instanceNumber = ++count;
		this.taskId = "LoopTaskB" + instanceNumber;
	}

	@Override
	public void run() {
		Thread.currentThread().setName("Amazing-Thread-"+instanceNumber);
		String threadName = Thread.currentThread().getName();
		System.out.println("#### <TASK-"+taskId+"> STARTING #### by thread " + threadName);
		for (int i=10; i>0; i--){
			System.out.println("id = "+taskId+" TICK " + i +" by thread " + threadName);
			try {
				TimeUnit.MILLISECONDS.sleep((long) (Math.random()*1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("#### <TASK-"+taskId+"> DONE #### by thread " + threadName);
	}
}
