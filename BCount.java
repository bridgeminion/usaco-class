import java.io.*;
import java.util.StringTokenizer;

public class BCount {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("bcount.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("bcount.out"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        int[] breedIDs = new int[n];
        for (int i=0; i < n; i++){
            breedIDs[i] = Integer.parseInt(br.readLine());
        }
        int[][] queries = new int[q][2];
        for (int i=0; i < q; i++){
            st = new StringTokenizer(br.readLine());
            queries[i][0] = Integer.parseInt(st.nextToken());
            queries[i][1] = Integer.parseInt(st.nextToken());
        }
        int[][] prefix = new int[4][n+1]; // for each breed type (1, 2, 3), make a prefix sum array of size n+1
        for (int i=1; i <= 3; i++){ // breed type that we want
            prefix[i][0] = 0;
            for (int j=0; j < n; j++){ // position in the breedIDs array
                if (breedIDs[j] == i){
                    prefix[i][j+1] = prefix[i][j] + 1;
                }
                else {
                    prefix[i][j+1] = prefix[i][j];
                }
            }
        }
        for (int i=0; i < q; i++){
            int a = queries[i][0];
            int b = queries[i][1];
            for (int j=1; j <= 3; j++){ // each breed type
                int ans = prefix[j][b] - prefix[j][a-1];
                if (j == 1){
                    pw.print(ans);
                }
                else {
                    pw.print(" " + ans);
                }
            }
            pw.println();
        }
        pw.close();
    }
}
