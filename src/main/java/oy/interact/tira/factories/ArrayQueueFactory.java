package oy.interact.tira.factories;

import oy.interact.tira.NotYetImplementedException;
import oy.interact.tira.model.Coder;
import oy.interact.tira.util.QueueInterface;
import oy.interact.tira.student.QueueImplementation;

public class ArrayQueueFactory {

	private ArrayQueueFactory() {
		// empty
	}

	public static QueueInterface<Integer> createIntegerQueue() {
		return new QueueImplementation<>();
	}

	public static QueueInterface<Integer> createIntegerQueue(int capacity) {
		return new QueueImplementation<>(capacity);
	}

	public static QueueInterface<String> createStringQueue() {
		return new QueueImplementation<>();
	}

	public static QueueInterface<String> createStringQueue(int capacity) {
		return new QueueImplementation<>(capacity);
	}

	public static QueueInterface<Coder> createCoderQueue() {
		return new QueueImplementation<>();
	}
}
