
import java.util.Scanner;

class WebSearch {

}


public class Solution {
	public static void main(String[] args) {
		// read the first line of the input to get the number of vertices

		// iterate count of vertices times 
		// to read the adjacency list from std input
		// and build the graph
		
		
		// Create page rank object and pass the graph object to the constructor
		
		// print the page rank object
		
		// This part is only for the final test case
		
		// File path to the web content
		String file = "WebContent.txt";
		
		// instantiate web search object
		// and pass the page rank object and the file path to the constructor
		
		// read the search queries from std in
		// remove the q= prefix and extract the search word
		// pass the word to iAmFeelingLucky method of web search
		// print the return value of iAmFeelingLucky
		Scanner sc = new Scanner(System.in);
		int v = Integer.parseInt(sc.nextLine());
		Digraph graph1 = new Digraph(v);
		Digraph graph2 = new Digraph(v);
		for (int i = 1; i <= v; i++) {
			String[] str = sc.nextLine().split(" ");
			for (int j = 1; j < str.length; j++) {
				graph1.addEdge(Integer.parseInt(str[0]), Integer.parseInt(str[j]));
				graph2.addEdge(Integer.parseInt(str[j]), Integer.parseInt(str[0]));
			}
		}

		Double[] pr = new Double[v];
		Double d = (1.0 / v);
		for (int i = 0; i < v; i++) {
			pr[i] = d;
		}
		for (int i = 1; i <= 1; i++) {
			for (int j = 0; j < v; j++) {
				//Iterable<Integer> invertices = graph2.adj(j);
				pr[j] = 0.0;
				for (int k : graph2.adj(j)) {
					pr[j] += (pr[k] / graph1.outdegree(k));
				}

			}
		}
		for (int i = 0; i < v; i++) {
			System.out.print(i + ": ");
			for (int j:graph1.adj(i)) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
		for (int i = 0; i < v; i++) {
			System.out.print(i + ": ");
			for (int j:graph2.adj(i)) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
		for (int i = 0; i < v; i++) {
			System.out.println(i +" - " + pr[i]);
		}

	}
}
