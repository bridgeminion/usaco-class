import java.io.*;
import java.util.StringTokenizer;

public class S5_DFS {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};

    static boolean works = false;

    public static void DFS (int n, int m, int curRow, int curCol, int endRow, int endCol, char[][] grid, boolean[][] vis){
        if (vis[curRow][curCol] || works){
            return;
        }
        vis[curRow][curCol] = true;
        if (curRow == endRow && curCol == endCol){
            works = true;
            return;
        }
        for (int i=0; i < 4; i++){
            int newRow = curRow + dr[i];
            int newCol = curCol + dc[i];
            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] != '#'){
                DFS (n, m, newRow, newCol, endRow, endCol, grid, vis);
            }
        }
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("socdist.in"));
//        PrintWriter pw = new PrintWriter(new FileWriter("socdist.out"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int startRow = Integer.parseInt(st.nextToken());
        int startCol = Integer.parseInt(st.nextToken());
        int endRow = Integer.parseInt(st.nextToken());
        int endCol = Integer.parseInt(st.nextToken());
        char[][] grid = new char[n][m];
        for (int i=0; i < n; i++){
            String s = br.readLine();
            for (int j=0; j < m; j++){
                grid[i][j] = s.charAt(j);
            }
        }
        DFS (n, m, startRow, startCol, endRow, endCol, grid, new boolean[n][m]);
        System.out.println(works);
    }
}
