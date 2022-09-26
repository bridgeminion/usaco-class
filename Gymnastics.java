import java.io.*;
import java.util.StringTokenizer;

public class Gymnastics {

    public static boolean isConsistent (int a, int b, int[][] pos, int k, int n){
        boolean aIsBetter = pos[1][a] > pos[1][b];
        for (int i=2; i <= k; i++){
            if ((pos[i][a] > pos[i][b]) != aIsBetter){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("gymnastics.in"));
        PrintWriter pw = new PrintWriter(new PrintWriter("gymnastics.out"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[][] pos = new int[k+1][n+1]; // pos[i][j] = position of cow j in practice session i
        for (int i=0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j < n; j++){
                int cowId = Integer.parseInt(st.nextToken());
                pos[i+1][cowId] = j+1;
            }
        }
        int ans = 0;
        for (int i=1; i <= n; i++){
            for (int j=i+1; j <= n; j++){
                if (isConsistent(i, j, pos, k, n)){
                    ans++;
                }
            }
        }
        pw.println(ans);
        pw.close();
    }
}
