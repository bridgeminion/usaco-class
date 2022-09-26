import java.io.*;
import java.util.StringTokenizer;

public class B11_WalkingHome {

    public static int solve (int n, int k, char[][] grid){
        int ans = 0;
        if (k >= 1){
            // down then right or right then down
            boolean works = true;
            for (int i=0; i < n; i++){
                if (grid[i][0] != '.') works = false;
            }
            for (int i=0; i < n; i++){
                if (grid[n-1][i] != '.') works = false;
            }
            if (works) ans++;
            works = true;
            for (int i=0; i < n; i++){
                if (grid[0][i] != '.') works = false;
            }
            for (int i=0; i < n; i++){
                if (grid[n-1][0] != '.') works = false;
            }
            if (works) ans++;
        }
        if (k >= 2){
            // horizontal or vertical line
            for (int i=1; i < n-1; i++){
                boolean works = true;
                for (int j=0; j <= i; j++){
                    if (grid[j][0] != '.') works = false;
                }
                for (int j=0; j < n; j++){
                    if (grid[i][j] != '.') works = false;
                }
                for (int j=i; j < n; j++){
                    if (grid[j][n-1] != '.') works = false;
                }
                if (works) ans++;
            }
            for (int i=1; i < n-1; i++){
                boolean works = true;
                for (int j=0; j <= i; j++){
                    if (grid[0][j] != '.') works = false;
                }
                for (int j=0; j < n; j++){
                    if (grid[j][i] != '.') works = false;
                }
                for (int j=i; j < n; j++){
                    if (grid[n-1][j] != '.') works = false;
                }
                if (works) ans++;
            }
        }
        if (k >= 3){
            for (int i=1; i < n-1; i++){ // row
                for (int j=1; j < n-1; j++){ // col
                    // right down right down
                    boolean works = true;
                    for (int x=0; x <= j; x++){
                        if (grid[0][x] != '.') works = false;
                    }
                    for (int x=0; x <= i; x++){
                        if (grid[x][j] != '.') works = false;
                    }
                    for (int x=j; x < n; x++){
                        if (grid[i][x] != '.') works = false;
                    }
                    for (int x=i; x < n; x++){
                        if (grid[i][n-1] != '.') works = false;
                    }
                    if (works) ans++;
                    // down right down right
                    works = true;
                    for (int x=0; x <= j; x++){
                        if (grid[x][0] != '.') works = false;
                    }
                    for (int x=0; x <= i; x++){
                        if (grid[j][x] != '.') works = false;
                    }
                    for (int x=j; x < n; x++){
                        if (grid[x][i] != '.') works = false;
                    }
                    for (int x=i; x < n; x++){
                        if (grid[n-1][i] != '.') works = false;
                    }
                    if (works) ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("gravity.in"));
//        PrintWriter pw = new PrintWriter(new FileWriter("gravity.out"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i=0; i < t; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            char[][] grid = new char[n][n];
            for (int j=0; j < n; j++){
                String s = br.readLine();
                for (int a=0; a < n; a++){
                    grid[j][a] = s.charAt(a);
                }
            }
            pw.println(solve (n, k, grid));
        }
        pw.close();
    }
}
