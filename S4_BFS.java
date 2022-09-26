import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class S4_BFS {

    static class Point {
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("gymnastics.in"));
//        PrintWriter pw = new PrintWriter(new FileWriter("gymnastics.out"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] grid = new char[n][m];
        int startRow = -1;
        int startCol = -1;
        int endRow = -1;
        int endCol = -1;
        for (int i=0; i < n; i++){
            String s = br.readLine();
            for (int j=0; j < m; j++){
                grid[i][j] = s.charAt(j);
                if (grid[i][j] == 'A'){
                    startRow = i;
                    startCol = j;
                }
                else if (grid[i][j] == 'B'){
                    endRow = i;
                    endCol = j;
                }
            }
        }
        Queue<Point> queue = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];
        queue.add(new Point (startRow, startCol));
        vis[startRow][startCol] = true;
        int length = 0;
        while (!queue.isEmpty()){
            // for a floodfill
            int size = queue.size();
            for (int i=0; i < size; i++){
                Point cur = queue.remove();
                if (cur.r == endRow && cur.c == endCol){
                    System.out.println("YES");
                    System.out.println(length);
                }
                for (int j=0; j < 4; j++){
                    int newRow = cur.r + dr[j];
                    int newCol = cur.c + dc[j];
                    // check inBounds, not visited, and not a wall
                    if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m){
                        if (!vis[newRow][newCol] && grid[newRow][newCol] != '#'){
                            vis[newRow][newCol] = true;
                            queue.add(new Point (newRow, newCol));
                        }
                    }
                }
            }
            length++;
        }
    }
}
