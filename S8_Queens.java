import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class S8_Queens {

    // rows and cols are 0-based

    public static class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static int ans = 0;

    public static void search (int row, List<Point> previousQueens, char[][] grid){
        if (row == 8){
            ans++;
            return;
        }
        for (int i=0; i < 8; i++){
            if (grid[row][i] == '.' && valid(new Point (row, i), previousQueens)){
                previousQueens.add(new Point (row, i));
                search(row+1, previousQueens, grid);
                previousQueens.remove(previousQueens.size()-1);
            }
        }
    }

    public static boolean valid (Point cur, List<Point> previousQueens){
        for (Point i : previousQueens){
            if (i.col == cur.col) return false;
            if (Math.abs(i.col-cur.col) == Math.abs(i.row-cur.row)) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("gravity.in"));
//        PrintWriter pw = new PrintWriter(new FileWriter("gravity.out"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        char[][] grid = new char[8][8];
        for (int i=0; i < 8; i++){
            String s = br.readLine();
            for (int j=0; j < 8; j++){
                grid[i][j] = s.charAt(j);
            }
        }
        search (0, new ArrayList<>(), grid);
        System.out.println(ans);
    }
}
