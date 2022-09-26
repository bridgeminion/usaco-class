import java.io.*;
import java.util.*;

public class S5_ClosingTheFarm {

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("socdist.in"));
//        PrintWriter pw = new PrintWriter(new FileWriter("socdist.out"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i=1; i <= n; i++) adj.put(i, new ArrayList<>());
        for (int i=0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj.get(a).add(b);
            adj.get(b).add(a);
        }


    }
}
