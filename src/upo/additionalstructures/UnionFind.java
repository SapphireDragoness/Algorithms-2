package upo.additionalstructures;

import upo.graph.base.VisitForest;
import upo.graph.impl.AdjMatrixUndir;

/** 
 * Classe generica per UnionFind.
 */

public class UnionFind implements UnionFindInterface<String> {

	protected AdjMatrixUndir unionFind;
	protected VisitForest parents;

	public UnionFind() {
		unionFind = new AdjMatrixUndir();
		parents = new VisitForest(unionFind, null);

	}

	@Override
	public void makeSet(String element) {
		unionFind.addVertex(element);

		VisitForest newParents = new VisitForest(unionFind, null);

		newParents.setParent(element, element);

		if (parents != null) {
			for (int i = 0; i < unionFind.size() - 1; i++) {
				newParents.setParent(unionFind.getVertexLabel(i), parents.getPartent(unionFind.getVertexLabel(i)));
			}
		}

		parents = newParents;
	}

	@Override
	public void union(String el1, String el2) {
		// TODO Auto-generated method stub
	}

	@Override
	public String find(String el) {
		// TODO Auto-generated method stub
		return null;
	}
}
