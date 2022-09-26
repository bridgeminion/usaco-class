import java.io.*;
import java.util.StringTokenizer;

public class B1_HPS {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("hps.in"));
        PrintWriter pw = new PrintWriter(new PrintWriter("hps.out"));
        int n = Integer.parseInt(br.readLine());
        int[] cow1 = new int[n];
        int[] cow2 = new int[n];
        for (int i=0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            cow1[i] = Integer.parseInt(st.nextToken());
            cow2[i] = Integer.parseInt(st.nextToken());
        }
        // two cases are A) 1 beats 2 beats 3 beats 1 and B) 1 beats 3 beats 2 beats 1
        int caseA = 0;
        for (int i=0; i < n; i++){
            if (cow1[i] == cow2[i]-1 || (cow1[i] == 3 && cow2[i] == 1)){
                caseA++;
            }
        }
        int caseB = 0;
        for (int i=0; i < n; i++){
            if (cow1[i] == cow2[i]+1 || (cow1[i] == 1 && cow2[i] == 3)){
                caseB++;
            }
        }
        int ans = Math.max(caseA, caseB); // set ans to maximum
        pw.println(ans);
        pw.close();
    }
}
