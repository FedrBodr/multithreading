package ru.fedrbodr.multithreading.common;

public interface ResultListener<T> {
	void notifyResult(T result);
}
