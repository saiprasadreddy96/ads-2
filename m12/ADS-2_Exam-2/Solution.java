import java.util.Scanner;
public class Solution {

	public static void main(String[] args) {
		// Self loops are not allowed...
		// Parallel Edges are allowed...
		// Take the Graph input here...

		String caseToGo = null;
		Scanner sc = new Scanner(System.in);
		int nvertices = Integer.parseInt(sc.nextLine());
		int nedges = Integer.parseInt(sc.nextLine());
		EdgeWeightedGraph eg = new EdgeWeightedGraph(nvertices);
		for (int i = 0; i < nedges; i++) {
			String[] str = sc.nextLine().split(" ");
			int v = Integer.parseInt(str[0]);
			int w = Integer.parseInt(str[1]);
			int wght = Integer.parseInt(str[2]);
			Edge e = new Edge(v, w, wght);
      		eg.addEdge(e);
		}
		String str1 = sc.nextLine();
		switch (str1) {
		case "Graph":
			//Print the Graph Object.
			System.out.println(nvertices + " vertices " + nedges + " edges");
			for (int i = 0; i < nvertices; i++) {
				System.out.print(i + ": ");
				for (Edge e : eg.adj(i)) {
					System.out.print(e + "  ");
				}
				System.out.println();
			}
			//System.out.println(eg);
			break;

		case "DirectedPaths":
			// Handle the case of DirectedPaths, where two integers are given.
			// First is the source and second is the destination.
			// If the path exists print the distance between them.
			// Other wise print "No Path Found."
			String[] str2 = sc.nextLine().split(" ");
			DijkstraUndirectedSP d = new DijkstraUndirectedSP(eg, Integer.parseInt(str2[0]));
			if(d.hasPathTo(Integer.parseInt(str2[1]))){
				System.out.println(d.distTo(Integer.parseInt(str2[1])));
			} else{
				System.out.println("No Path Found.");
			}

			break;

		case "ViaPaths":
			// Handle the case of ViaPaths, where three integers are given.
			// First is the source and second is the via is the one where path should pass throuh.
			// third is the destination.
			// If the path exists print the distance between them.
			// Other wise print "No Path Found."
			String[] str3 = sc.nextLine().split(" ");
			DijkstraUndirectedSP d1 = new DijkstraUndirectedSP(eg, Integer.parseInt(str3[0]));
			DijkstraUndirectedSP d2 = new DijkstraUndirectedSP(eg, Integer.parseInt(str3[1]));
			if(d1.hasPathTo(Integer.parseInt(str3[1]))&&d2.hasPathTo(Integer.parseInt(str3[2]))){
				System.out.println(d1.distTo(Integer.parseInt(str3[1])) + d2.distTo(Integer.parseInt(str3[2])));
				System.out.println(d1.pathTo(Integer.parseInt(str3[1]))+""+d2.pathTo(Integer.parseInt(str3[2])) + "" + Integer.parseInt(str3[2]));
			} else{
				System.out.println("No Path Found.");
			}
			
			break;

		default:
			break;
		}

	}
}