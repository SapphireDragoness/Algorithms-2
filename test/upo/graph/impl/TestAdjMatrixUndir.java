package upo.graph.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestAdjMatrixUndir {

	AdjMatrixUndir graph = new AdjMatrixUndir();
	AdjMatrixUndir graph2 = new AdjMatrixUndir();

	@BeforeEach
	void before() {
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addEdge("A", "B");
		graph.addEdge("A", "C");
		graph.addEdge("C", "D");
		graph.addEdge("A", "D");

		graph2.addVertex("A");
		graph2.addVertex("B");
		graph2.addVertex("C");
		graph2.addVertex("D");
	}

	@Test
	void testGetEdgeWeight() {
		assertThrows(UnsupportedOperationException.class, () -> {
			graph.getEdgeWeight("A", "B");
		});
	}
	
	@Test
	void testSetEdgeWeight() {
		assertThrows(UnsupportedOperationException.class, () -> {
			graph.setEdgeWeight("A", "B", 1.0);
		});
	}
	
	@Test
	void testDijkstraShortestPaths() {
		assertThrows(UnsupportedOperationException.class, () -> {
			graph.getDijkstraShortestPaths("A");
		});
	}
	
	@Test
	void testPrimMST() {
		assertThrows(UnsupportedOperationException.class, () -> {
			graph.getPrimMST("A");
		});
	}

	@Test
	void testKruskalMST() {
		assertThrows(UnsupportedOperationException.class, () -> {
			graph.getKruskalMST();
		});
	}

	@Test
	void testGetBellmanFordShortestPaths() {
		assertThrows(UnsupportedOperationException.class, () -> {
			graph.getBellmanFordShortestPaths("A");
		});
	}

	@Test
	void testGetFloydWarshallShortestPaths() {
		assertThrows(UnsupportedOperationException.class, () -> {
			graph.getFloydWarshallShortestPaths();
		});
	}
}
