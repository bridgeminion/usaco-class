import java.io.*;
import java.util.*;

public class B5_CSSample1 {

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    // checks if the distance from A to B is at most 10
    public static boolean isValid (Point a, Point b){
        return (a.x-b.x)*(a.x-b.x) + (a.y-b.y)*(a.y-b.y) <= 100;
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("traffic.in"));
//        PrintWriter pw = new PrintWriter(new FileWriter("traffic.out"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        List<Point> points = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        for (int i=0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points.add(new Point (x, y));
        }
        Set<Point> set = new HashSet<>(points);
        // loop through every pair of points
        int ans1 = 0;
        for (int i=0; i < n; i++){
            for (int j=i+1; j < n; j++){
                // check if this pair of points is valid
                Point p1 = points.get(i);
                Point p2 = points.get(j);
                if (isValid(p1, p2)){
                    ans1++;
                }
            }
        }
        int ans2 = 0;
        for (int i=0; i < n; i++){
            for (int j=i+1; j < n; j++){
                // check if we have the midpoint
                Point p1 = points.get(i); // 0, 0
                Point p2 = points.get(j); // 1, 2
                // midpoint should be 0.5, 1
                if ((p1.x+p2.x)%2 == 1 || (p1.y+p2.y)%2 == 1){
                    continue;
                }
                Point mid = new Point ((p1.x+p2.x)/2, (p1.y+p2.y)/2);
                if (set.contains(mid)){
                    ans2++;
                }
            }
        }

    }
}
