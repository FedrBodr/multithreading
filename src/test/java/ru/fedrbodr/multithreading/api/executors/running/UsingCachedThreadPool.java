package ru.fedrbodr.multithreading.api.executors.running;

import ru.fedrbodr.multithreading.common.LoopTaskA;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UsingCachedThreadPool {
	public static void main(String[] args) {
		System.out.println("main thread start");

		ExecutorService executorService = Executors.newCachedThreadPool();

		executorService.submit(new LoopTaskA());
		executorService.submit(new LoopTaskA());
		executorService.submit(new LoopTaskA());
		executorService.submit(new LoopTaskA());
		executorService.submit(new LoopTaskA());
		executorService.submit(new LoopTaskA());

		executorService.shutdown();

		System.out.println("main thread stop");
	}
}
