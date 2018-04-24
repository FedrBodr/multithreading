package ru.fedrbodr.multithreading.common;

import java.util.concurrent.TimeUnit;

public class ValueReturningTaskB implements Runnable {
	private int a;
	private int b;
	private long sleepTime;
	private int sum;

	private static int count;
	private int instanceNumber;
	private String taskId;
	private ResultListener<Integer> listener;

	public ValueReturningTaskB(int a, int b, long sleepTime, ResultListener<Integer> listener) {
		this.a = a;
		this.b = b;
		this.sleepTime = sleepTime;
		this.listener = listener;

		this.instanceNumber = ++count;
		this.taskId = "ValReturnTaskA-" + instanceNumber;

	}

	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		System.out.println("#### <TASK-"+taskId+"> STARTING #### by thread " + threadName);

		System.out.println("#### sleeping for "+sleepTime+" <TASK-"+taskId+"> STARTING #### by thread " + threadName);

		try {
			TimeUnit.MILLISECONDS.sleep(sleepTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		sum = a + b;
		System.out.println("#### <TASK-"+taskId+"> DONE #### by thread " + threadName);

		listener.notifyResult(sum);
	}

}
