package ru.fedrbodr.multithreading.common;

import java.util.concurrent.TimeUnit;

public class ValueReturningTaskA implements Runnable {
	private int a;
	private int b;
	private long sleepTime;
	private int sum;

	private static int count;
	private int instanceNumber;
	private String taskId;

	private volatile boolean done;

	public ValueReturningTaskA(int a, int b, long sleepTime) {
		this.a = a;
		this.b = b;
		this.sleepTime = sleepTime;

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
		done = true;
		synchronized (this) {
			System.out.println("["+Thread.currentThread().getName()+"] ==== NOTIFYING for result from taskId="+taskId);
			this.notifyAll();
		}
	}

	public int getSum() {
		if(!done){
			synchronized (this){
				try {
					System.out.println("["+Thread.currentThread().getName()+"] ==== WAITING for result from taskId="+taskId);
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			System.out.println("["+Thread.currentThread().getName()+"] ==== WOKEN UP for result from taskId="+taskId);
		}
		return sum;
	}
}
