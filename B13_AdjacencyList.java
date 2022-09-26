import java.io.*;
import java.util.*;

public class B13_AdjacencyList {


    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("gravity.in"));
//        PrintWriter pw = new PrintWriter(new FileWriter("gravity.out"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        // input first gives us N, number of nodes, then M, number of edges, then M lines, each describing an edge
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        List<List<Integer>> list = new ArrayList<>();

        boolean[][] matrix = new boolean[n+1][n+1];

        for (int i=1; i <= n; i++){
            adj.put(i, new HashSet<>());
        }
        for (int i=0; i <= n; i++){ // n+1 times instead of n to prevent out of bounds
            list.add(new ArrayList<>());
        }
        for (int i=0; i < m; i++){
            // two integers A and B, each from 1 to N
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj.get(a).add(b); // edge from A to B
            adj.get(b).add(a); // from B to A

            list.get(a).add(b);
            list.get(b).add(a);

            matrix[a][b] = true;
            matrix[b][a] = true;
        }
        // check if two nodes have an edge
        System.out.println(adj.get(3).contains(5));
    }
}
