import java.io.*;
import java.util.*;

public class S3_SocialDistancing {

    static class Interval{
        long a;
        long b;

        public Interval(long a, long b) {
            this.a = a;
            this.b = b;
        }
    }

    public static boolean works (long x, int n, List<Interval> grass){
        long curLoc = grass.get(0).a;
        int curIndex = 0;
        int cowsPlaced = 1;
        while (cowsPlaced < n){
            if (curLoc + x <= grass.get(curIndex).b){
                curLoc += x;
                cowsPlaced++;
            }
            else {
                while (curIndex < grass.size() && curLoc + x > grass.get(curIndex).b){
                    curIndex++;
                }
                if (curIndex == grass.size()) return false;
                cowsPlaced++;
                curLoc = Math.max(curLoc + x, grass.get(curIndex).a);
            }
        }
        return cowsPlaced == n;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("socdist.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("socdist.out"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Interval> grass = new ArrayList<>();
        for (int i=0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            grass.add(new Interval(a, b));
        }
        Collections.sort(grass, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                // disjoint so only need to sort by start point
                return Long.compare(o1.a, o2.a);
            }
        });
        works (2, n, grass);
        long lo = 0;
        long hi = (long)Math.pow(10, 18);
        long ans = 0;
        while (lo <= hi){
            long mid = (lo+hi)/2;
            if (works(mid, n, grass)){
                ans = Math.max(ans, mid);
                lo = mid+1;
            }
            else {
                hi = mid-1;
            }
        }
        pw.println(ans);
        pw.close();
    }
}
