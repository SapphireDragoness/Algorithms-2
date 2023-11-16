package upo.progdin;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestDynamicProgramming {
	
	@Test 
	void testLongestCommonSubsequence() {
		String res = DynamicProgramming.LongestCommonSubsequence("GACATGC", "ATCGAG");
		
		assertEquals(res, "ACAG");
		
		res = DynamicProgramming.LongestCommonSubsequence("", "");
		
		//assertEquals(res, "");
	}

	@Test
	void testKnapsack01() {
		int maxWeight = 10;
		int[] weights = {2, 7, 6, 4};
		int[] values = {12, 6, 1, 0};
		
		boolean[] res = DynamicProgramming.getKnapsack01(weights, values, maxWeight);
		assertTrue(res[1]);
		assertTrue(res[2]);
		assertFalse(res[4]);
		assertFalse(res[3]);
	}
}
