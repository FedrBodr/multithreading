package ru.fedrbodr.multithreading.api.executors.running;

import ru.fedrbodr.multithreading.common.LoopTaskA;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UsingSingleThreadPool {
	public static void main(String[] args) {
		System.out.println("main thread start");

		ExecutorService executorService = Executors.newSingleThreadExecutor();

		executorService.submit(new LoopTaskA());
		executorService.submit(new LoopTaskA());
		executorService.submit(new LoopTaskA());

		executorService.shutdown();
		executorService.submit(new LoopTaskA());
		System.out.println("main thread stop");
	}
}
