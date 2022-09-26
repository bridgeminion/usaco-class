import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class S3_Convention {

    public static boolean thisValueWorks (int n, int m, int c, int[] t, int testValue){
        int right = -1;
        int numBusRequired = 0;
        int currentCowsOnBus = 0;
        for (int i=0; i < n; i++){
            if (t[i] > right || currentCowsOnBus == c){
                numBusRequired++;
                currentCowsOnBus = 1;
                right = t[i] + testValue;
            }
            else {
                currentCowsOnBus++;
            }
        }
        return numBusRequired <= m;
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("convention.in"));
//        PrintWriter pw = new PrintWriter(new FileWriter("convention.out"));
////        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
////        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        int m = Integer.parseInt(st.nextToken());
//        int c = Integer.parseInt(st.nextToken());
//        int[] t = new int[n];
//        st = new StringTokenizer(br.readLine());
//        for (int i=0; i < n; i++){
//            t[i] = Integer.parseInt(st.nextToken());
//        }
//        Arrays.sort(t);
//        int low = 0;
//        int high = 1000000000;
//        int ans = Integer.MAX_VALUE;
//        while (low <= high) {
//            int mid = (low+high)/2;
//            if (thisValueWorks(n, m, c, t, mid)){
//                high = mid-1;
//                ans = Math.min(ans, mid);
//            }
//            else {
//                low = mid+1;
//            }
//        }
//        pw.println(ans);
//        pw.close();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(5);
        pq.add(3);
        pq.add(6);
        System.out.println(pq.size());
        System.out.println(pq.poll());
        pq.peek();
        System.out.println(pq.size());
    }
}
