import java.io.*;
import java.util.StringTokenizer;

public class SpeedingTicket {

    public static int limitAt (int mile, int[][] speedLimits){
        int n = speedLimits.length;
        int index = 0;
        int sumOfAllSegments = 0;
        while (index < n && speedLimits[index][0] + sumOfAllSegments < mile){
            sumOfAllSegments += speedLimits[index][0];
            index++;
        }
        return speedLimits[index][1];
    }

    public static int bessieAt (int mile, int[][] bessieSpeed){
        int m = bessieSpeed.length;
        int index = 0;
        int sumOfAllSegments = 0;
        while (index < m && bessieSpeed[index][0] + sumOfAllSegments < mile){
            sumOfAllSegments += bessieSpeed[index][0];
            index++;
        }
        return bessieSpeed[index][1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("speeding.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("speeding.out"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] speedLimits = new int[n][2]; // first element is length, second is speed limit
        int[][] bessieSpeed = new int[m][2]; // first element is length, second is bessie's speed
        for (int i=0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            speedLimits[i][0] = Integer.parseInt(st.nextToken());
            speedLimits[i][1] = Integer.parseInt(st.nextToken());
        }
        for (int i=0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            bessieSpeed[i][0] = Integer.parseInt(st.nextToken());
            bessieSpeed[i][1] = Integer.parseInt(st.nextToken());
        }
        int ans = 0;
        for (int mile=1; mile <= 100; mile++){
            // calculate the speed limit and bessie's speed at that time
            ans = Math.max(ans, bessieAt (mile, bessieSpeed) - limitAt (mile, speedLimits));
        }
        pw.println(ans);
        pw.close();

    }
}
