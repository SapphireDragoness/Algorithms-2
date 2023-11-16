package upo.additionalstructures;

import java.util.ArrayList;
import java.util.Collections;

/**
 * PriorityQueue implementata in maniera elementare con l'utilizzo di due
 * ArrayList che operano in sincrono: la prima (elements) contiene gli elementi
 * della coda vera e propria; la seconda (priorities) contiene le priorità degli
 * elementi della prima lista. Ho aggiunto due metodi ausiliari, isEmpty e size,
 * per facilitare l'uso della struttura.
 */

public class PriorityQueue implements PriorityQueueInterface {

	private ArrayList<Integer> elements; // elementi della coda
	private ArrayList<Double> priorities; // priorità degli elementi della coda

	public PriorityQueue() {
		this.elements = new ArrayList<>();
		this.priorities = new ArrayList<>();
	}

	public boolean isEmpty() {
		return elements.isEmpty();
	}

	public int size() {
		return elements.size();
	}

	@Override
	public void enqueue(int el, double priority) {
		elements.add(el);
		priorities.add(priority);
	}

	// rimuove l'elemento con priorità minore
	@Override
	public int dequeue() {
		int maxIndex = priorities.indexOf(Collections.min(priorities));
		priorities.remove(maxIndex);
		return elements.remove(maxIndex);
	}

	@Override
	public void modify_priority(int el, double newPriority) {
		priorities.set(elements.indexOf(el), newPriority);
	}

}
