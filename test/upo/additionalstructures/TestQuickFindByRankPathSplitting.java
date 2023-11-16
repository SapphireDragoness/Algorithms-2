package upo.additionalstructures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestQuickFindByRankPathSplitting {

	QuickFindByRankPathSplitting unionFind = new QuickFindByRankPathSplitting();

	@Test
	void testUnionFind() {
		unionFind.makeSet("A");
		unionFind.makeSet("B");
		unionFind.union("A", "B");

		assertEquals(unionFind.find("A"), "A");
		assertEquals(unionFind.find("B"), "A");

		unionFind.makeSet("C");
		unionFind.union("A", "C");

		assertEquals(unionFind.find("C"), "A");

		unionFind.makeSet("D");
		unionFind.makeSet("E");
		unionFind.union("A", "D");
		unionFind.union("D", "E");

		assertEquals(unionFind.find("E"), "A");

		unionFind.makeSet("L");
		unionFind.makeSet("M");
		unionFind.union("L", "M");

		assertEquals(unionFind.find("L"), "L");
		assertEquals(unionFind.find("M"), "L");

		unionFind.makeSet("N");
		unionFind.union("L", "N");

		assertEquals(unionFind.find("N"), "L");

		unionFind.union("A", "N");

		assertEquals(unionFind.find("N"), "A");

		assertThrows(IndexOutOfBoundsException.class, () -> {
			unionFind.find("Z");
		});
		assertThrows(IndexOutOfBoundsException.class, () -> {
			unionFind.union("A", "Z");
		});
		assertThrows(IllegalArgumentException.class, () -> {
			unionFind.union(null, null);
		});
	}

}
