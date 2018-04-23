package ru.fedrbodr.multithreading.common;

import java.util.concurrent.ThreadFactory;

public class NamedThreadFactory implements ThreadFactory {
	private static int count;
	private static String NAME="MyThread-";
	@Override
	public Thread newThread(Runnable r) {
		Thread thread = new Thread(r, NAME + ++count);
		return thread;
	}
}
