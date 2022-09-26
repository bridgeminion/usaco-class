import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S7_Gravity {

    static class State {
        int row;
        int col;
        boolean grav;

        public State(int row, int col, boolean grav) {
            this.row = row;
            this.col = col;
            this.grav = grav;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("gravity.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("gravity.out"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] grid = new char[n][m];
        int sr = -1;
        int sc = -1;
        for (int i=0; i < n; i++){
            String s = br.readLine();
            for (int j=0; j < m; j++){
                grid[i][j] = s.charAt(j);
            }
        }
        boolean[][] vis = new boolean[n][m];
        vis[sr][sc] = true;
        Queue<State> q = new LinkedList<>();
        q.add(new State (sr, sc, true));
        while (!q.isEmpty()){
            int size = q.size();
            for (int i=0; i < size; i++){
                State cur = q.remove();

            }
        }
    }
}
