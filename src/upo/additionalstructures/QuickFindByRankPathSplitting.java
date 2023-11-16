package upo.additionalstructures;

import java.util.ArrayList;

/**
 * Implementazione di UnionFind con ottimizzazioni QuickUnion by rank e path
 * splitting.
 */

public class QuickFindByRankPathSplitting extends UnionFind {

	/**
	 * <code>ranks</code> tiene traccia del rank dei set, VisitForest tiene traccia dei predecessori (il
	 * predecessore di un nodo radice è il nodo stesso, per semplificare
	 * l'operazione di path splitting)
	 */
	private ArrayList<Integer> ranks;

	public QuickFindByRankPathSplitting() {
		super();
		ranks = new ArrayList<>();
	}
	
	public void makeSet(String element) {
		super.makeSet(element);
		ranks.add(0);
	}

	/**
	 * Operazione di union dal costo O(1) (QuickFind)
	 */
	@Override
	public void union(String el1, String el2) {
		String root1 = find(el1);
		String root2 = find(el2);
		
		if(root1 == null || root2 == null) {
			throw new IllegalArgumentException("I vertici indicati non esistono");
		}

		if (getRank(root1) > getRank(root2)) {
			unionFind.addEdge(root2, root1);
			parents.setParent(root2, root1);
			setRank(root2, getRank(root1));
		} else if (getRank(root1) < getRank(root2)) {
			unionFind.addEdge(root1, root2);
			parents.setParent(root1, root2);
			setRank(root1, getRank(root2));
		} else {
			unionFind.addEdge(root1, root2);
			parents.setParent(root2, root1);
			setRank(root1, getRank(root2) + 1);
		}

	}

	/**
	 * Operazione di find dal costo O(n), implementa path splitting (il nodo el
	 * diventa figlio del predecessore del predecessore)
	 */
	@Override
	public String find(String el) {
		if(el == null) {
			throw new IllegalArgumentException("Il vertice indicato non esiste");
		} 
		
		while (el != parents.getPartent(el)) {
			String p = parents.getPartent(parents.getPartent(el));
			parents.setParent(el, p);
			setRank(el, getRank(p)+1);
			el = p;
		}
		return el;
	}

	/**
	 * Ritorna il rank del set del quale il nodo el è rappresentante (usato solo per
	 * i nodi radice).
	 * 
	 * @param el
	 * @return predecessore
	 */
	public int getRank(String el) {
		return ranks.get(unionFind.getVertexIndex(el));
	}

	/**
	 * Imposta il rank del set del quale il nodo el è rappresentante.
	 * 
	 * @param el1 nodo in questione
	 * @param el2 predecessore
	 */
	public int setRank(String el, int rank) {
		return ranks.set(unionFind.getVertexIndex(el), rank);
	}

}
