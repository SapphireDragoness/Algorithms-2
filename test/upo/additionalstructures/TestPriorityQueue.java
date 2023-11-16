package upo.additionalstructures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Semplice test per verificare il corretto funzionamento della classe
 * PriorityQueue.
 */

class TestPriorityQueue {

	PriorityQueue pq = new PriorityQueue();

	@Test
	void testPQ() {
		pq.enqueue(20, 1);
		pq.enqueue(10, 7);
		pq.enqueue(40, 5);
		pq.enqueue(70, 6);
		pq.enqueue(30, 2);
		pq.enqueue(90, 4);
		pq.enqueue(50, 9);

		assertEquals(pq.dequeue(), 20);
		assertEquals(pq.dequeue(), 30);

		pq.modify_priority(50, 2);
		pq.modify_priority(70, 1);

		assertEquals(pq.dequeue(), 70);
		assertEquals(pq.dequeue(), 50);
	}

}
