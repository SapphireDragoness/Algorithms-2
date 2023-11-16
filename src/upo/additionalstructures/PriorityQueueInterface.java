package upo.additionalstructures;

/** ATTENZIONE: chi avesse bisogno delle priority queue per il proprio algoritmo le deve implementare seguendo
 * questa interfaccia. Non � per� necessario che siano implementazioni efficienti. Anche l'implementazione con un array da 0 a n,
 * dove la posizione i-esima rappresenta la priorit� del verice i-esimo, come spiegato nel video, va benissimo
 * (anzi, abbiamo anche spiegato essere la più efficiente in alcuni casi).
 * NB: questa PriorityQueue pu� essere usata anche per Huffman. 
 * NB2: in caso di implementazioni come descritto sopra, per indicare che un elemento non � contenuto nella 
 * priority queue, potete usare un valore di priorit� fuori range (ad es. -1 se tutte le priorit� sono non negative). 
 * 
 * @author Luca Piovesan
 *
 */
public interface PriorityQueueInterface {
	
	/** Aggiunge l'elemento el alla coda, con priorità priority.
	 * 
	 * @param el l'elemento (o l'indice dell'elemento) da inserire.
	 * @param priority la priorità dell'elemento.
	 */
	public void enqueue(int el, double priority);
	
	/** Rimuove e restituisce l'elemento con priorità maggiore (o minore, a seconda dell'implementazione) di
	 * questa coda con priorità.
	 * 
	 * @return l'elemento con priorità maggiore (o minore, a seconda dell'implementazione) di
	 * questa coda con priorità.
	 */
	public int dequeue();
	
	/** Cambia la priorità di el.
	 * 
	 * @param el l'elemento (o l'indice dell'elemento).
	 * @param newPriority la nuova priorità di el.
	 */
	public void modify_priority(int el, double newPriority);
	
}
