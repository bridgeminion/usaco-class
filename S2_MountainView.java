import java.io.*;
import java.util.*;

public class S2_MountainView {

    static class Point {
        int left;
        int right;

        public Point(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("mountains.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("mountains.out"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        List<Point> list = new ArrayList<>();
        for (int i=0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new Point (x-y, x+y));
        }
        Collections.sort(list, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.left == o2.left){
                    return o2.right - o1.right;
                }
                return o1.left - o2.left;
            }
        });
        int rightmost = -1;
        int ans = 0;
        for (Point i : list){
            if (i.right > rightmost){
                rightmost = i.right;
                ans++;
            }
        }
        pw.println(ans);
        pw.close();
    }
}
