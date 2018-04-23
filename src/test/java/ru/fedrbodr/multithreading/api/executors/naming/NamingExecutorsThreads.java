package ru.fedrbodr.multithreading.api.executors.naming;

import ch.qos.logback.core.util.TimeUtil;
import org.omg.CORBA.TIMEOUT;
import ru.fedrbodr.multithreading.common.LoopTaskA;
import ru.fedrbodr.multithreading.common.LoopTaskB;
import ru.fedrbodr.multithreading.common.LoopTaskC;
import ru.fedrbodr.multithreading.common.NamedThreadFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class NamingExecutorsThreads {
	public static void main(String[] args) throws InterruptedException {
		String currentTread = Thread.currentThread().getName();
		System.out.println("main thread start by thread "+currentTread);

		ExecutorService executorService = Executors.newCachedThreadPool(new NamedThreadFactory());

		executorService.submit(new LoopTaskC());
		executorService.submit(new LoopTaskC());
		executorService.submit(new LoopTaskC());
		TimeUnit.SECONDS.sleep(15);
		executorService.submit(new LoopTaskC());
		executorService.submit(new LoopTaskC());
		executorService.submit(new LoopTaskC());
		executorService.submit(new LoopTaskC());
		executorService.submit(new LoopTaskC());

		executorService.shutdown();

		System.out.println("main thread stop by thread "+currentTread);
	}
}