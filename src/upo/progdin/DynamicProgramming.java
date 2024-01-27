package upo.progdin;

import java.util.Arrays;

public class DynamicProgramming {
	
	static String lcs;
	
	/** Calcola la LCS tra <code>s1</code> e <code>s2</code> utilizzando l'algoritmo visto a lezione.
	 * </br>CONSIGLIO: potete usare i metodi di String per accedere alle posizioni di s1 ed s2.
	 * </br>CONSIGLIO2: potete costruire l'output come un array di caratteri, e poi trasformarlo in stringa,
	 * oppure usare le concatenazioni di stringhe nelle chiamate ricorsive (vedi slide).
	 * 
	 * @param s1 una sequenza di caratteri
	 * @param s2 una sequenza di caratteri
	 * @return una LCS di <code>s1</code> e <code>s2</code>
	 */
	public static String LongestCommonSubsequence(String s1, String s2) throws UnsupportedOperationException {
		int m = s1.length();
		int n = s2.length();
		int[][] L = new int[m+1][n+1];
		Arrow[][] LCSC = new Arrow[m+1][n+1];
		int i, j;
		
		// inizializzazione matrici
		for(int[] row : L) Arrays.fill(row, 0);
		for(Arrow[] row : LCSC) Arrays.fill(row, null);
		
		// riempimento matrici
		for(i = 1; i < m+1; i++) {
			for(j = 1; j < n+1; j++) {
				if(s1.charAt(i-1) == s2.charAt(j-1)) {
					L[i][j] = L[i-1][j-1]+1;
					LCSC[i][j] = Arrow.DIAG;
				}
				else if(L[i-1][j] > L[i][j-1]) {
					L[i][j] = L[i-1][j];
					LCSC[i][j] = Arrow.UP;
				}
				else {
					L[i][j] = L[i][j-1];
					LCSC[i][j] = Arrow.LEFT;
				}
			}
		}
		
		lcs = "";
		getLCS(s1, LCSC, m, n);
		
		return lcs;
	}
	
	private static void getLCS(String s1, Arrow[][] LCSC, int i, int j) {
		if(i == 0 || j == 0)
			return;
		if(LCSC[i][j] == Arrow.DIAG) {
			getLCS(s1, LCSC, i-1, j-1);
			lcs += s1.charAt(i-1);
		}
		else if(LCSC[i][j] == Arrow.UP)
			getLCS(s1, LCSC, i-1, j);
		else
			getLCS(s1, LCSC, i, j-1);
	}

	/** Risolve il problema dello zaino 0-1 con l'algoritmo di programmazione dinamica visto a lezione.
	 * 
	 * @param weights un vettore contenente in posizione i-esima, per ogni oggetto oi, il suo peso. 
	 * @param values un vettore contenente in posizione i-esima, per ogni oggetto oi, il suo valore. 
	 * @param maxWeight la capienza dello zaino.
	 * @return un vettore di boolean che contiene, in posizione i-esima, true se l'oggetto i-esimo è
	 * incluso nella soluzione, false altrimenti.
	 */
	public static boolean[] getKnapsack01(int[] weights, int[] values, int maxWeight) {
		int n = weights.length;
		int[][] V = new int[n+1][maxWeight+1];
		boolean[][] K = new boolean[n+1][maxWeight+1];
		boolean[] res = new boolean[n+1];
		Arrays.fill(res, false);
		
		//inizializzazione
		for(int[] row : V) Arrays.fill(row, 0);
		for(boolean[] row : K) Arrays.fill(row, false);
		
		//riempimento matrice
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= maxWeight; j++) {
				if(j < weights[i - 1]) {
					V[i][j] = V[i - 1][j];
					K[i][j] = false;
				}
				else if(V[i - 1][j] >= V[i - 1][j - weights[i - 1]] + values[i - 1]) { 
					V[i][j] = V[i - 1][j];
				}
				else{
					V[i][j] = V[i - 1][j - weights[i - 1]] + values[i - 1];
					K[i][j] = true;
				}
			}
		}
		//riempimento vettore risultati
		int d = maxWeight;
		for(int i = n; i > 0; i--) {
			if(K[i][d] == true) {
				res[i] = true;
				d = d - weights[i - 1];
			}
		}
		return res;
	}
	
}
