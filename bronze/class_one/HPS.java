import java.io.*;
import java.util.StringTokenizer;

public class HPS {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("hps.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("hps.out"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] cow1 = new int[n];
        int[] cow2 = new int[n];
        for (int i=0; i < n; i++){
            String line = br.readLine(); // returns "1 2"
            StringTokenizer st = new StringTokenizer(line); // default delimiter is whitespace
            int gesture1 = Integer.parseInt(st.nextToken());
            cow1[i] = gesture1;
            int gesture2 = Integer.parseInt(st.nextToken());
            cow2[i] = gesture2;
        }
//        pw.println(n);
//        for (int i=0; i < n; i++){
//            pw.println(cow1[i] + " " + cow2[i]);
//        }
        // case one : 1 beats 2, 2 beats 3, 3 beats 1
        int case1 = 0; // number of wins cow 1 will get if we use the case one ruleset
        for (int i=0; i < n; i++){
            if ((cow1[i] == 1 && cow2[i] == 2) || (cow1[i] == 2 && cow2[i] == 3) || (cow1[i] == 3 && cow2[i] == 1)){
                case1++;
            }
        }
        // case two : 1 beats 3, 3 beats 2, 2 beats 1
        int case2 = 0;
        for (int i=0; i < n; i++){
            if ((cow1[i] == 1 && cow2[i] == 3) || (cow1[i] == 3 && cow2[i] == 2) || (cow1[i] == 2 && cow2[i] == 1)){
                case2++;
            }
        }
        int ans = Math.max(case1, case2);
        pw.println(ans);
        pw.close();
    }


}
