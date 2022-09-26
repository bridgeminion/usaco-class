import java.io.*;
import java.util.StringTokenizer;

public class B1_CowCross {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("crossroad.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("crossroad.out"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[][] input = new int[n][2];
        for (int i=0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            input[i][0] = Integer.parseInt(st.nextToken()); // cow id
            input[i][1] = Integer.parseInt(st.nextToken()); // which side of the road it's on
        }
        int[] lastSeen = new int[11]; // lastSeen[i] stores the cow i's last seen position
        for (int i=1; i <= 10; i++){
            lastSeen[i] = -1;
        }
        int ans = 0;
        for (int i=0; i < n; i++){
            int currentCowID = input[i][0];
            int pos = input[i][1];
            if (lastSeen[currentCowID] == -1){
                lastSeen[currentCowID] = pos;
            }
            else if (lastSeen[currentCowID] == 0){
                if (pos == 1){
                    ans++;
                }
                lastSeen[currentCowID] = pos;
            }
            else { // lastSeen == 1
                if (pos == 0){
                    ans++;
                }
                lastSeen[currentCowID] = pos;
            }
        }
        pw.println(ans);
        pw.close();
    }
}
