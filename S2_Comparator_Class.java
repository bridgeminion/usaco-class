import java.io.*;
import java.util.*;

public class S2_Comparator_Class {

    public static class Cow {
        String name;
        int height;
        int weight;

        public Cow(String name, int height, int weight) {
            this.name = name;
            this.height = height;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("gymnastics.in"));
//        PrintWriter pw = new PrintWriter(new FileWriter("gymnastics.out"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
//        int n = Integer.parseInt(br.readLine());
//        List<Cow> cows = new ArrayList<>();
//        for (int i=0; i < n; i++){
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            String name = st.nextToken();
//            int h = Integer.parseInt(st.nextToken());
//            int w = Integer.parseInt(st.nextToken());
//            cows.add(new Cow (name, h, w));
//        }
//        // increasing order of height
//        Collections.sort(cows, new Comparator<Cow>() {
//            @Override
//            public int compare(Cow o1, Cow o2) {
//                return o1.height-o2.height;
//            }
//        });
//        System.out.println("increasing height");
//        for (int i=0; i < n; i++){
//            Cow cur = cows.get(i);
//            System.out.println(cur.name + " " + cur.height + " " + cur.weight);
//        }
//        // decreasing order of weight
//        Collections.sort(cows, new Comparator<Cow>() {
//            @Override
//            public int compare(Cow o1, Cow o2) {
//                return o2.weight-o1.weight;
//            }
//        });
//        System.out.println("decreasing weight");
//        for (int i=0; i < n; i++){
//            Cow cur = cows.get(i);
//            System.out.println(cur.name + " " + cur.height + " " + cur.weight);
//        }
//        // alphabetical order
//        Collections.sort(cows, new Comparator<Cow>() {
//            @Override
//            public int compare(Cow o1, Cow o2) {
//                // method
//                // if o1 is alphabetically in front of o2 (o1 = a, o2 = b) function will return -1
//                // if o1 is alphabetically behind of o2 (o1 = b, o2 = a) function will return 1
//
//                // CMI = weight/height (increasing)
//                // o1.w = 6 o1.h = 5 o2.w = 8 o2.height = 5
//                if (o1.name.equals(o2.name)){
//                    double CMI1 = (double)(o1.weight)/o1.height; // = 0.5
//                    double CMI2 = (double)(o2.weight)/o2.height; // = 0.2
//                    return Double.compare(CMI1, CMI2);
//                }
//                return o1.name.compareTo(o2.name);
//            }
//        });
//        System.out.println("alphabetical");
//        for (int i=0; i < n; i++){
//            Cow cur = cows.get(i);
//            System.out.println(cur.name + " " + cur.height + " " + cur.weight);
//        }

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(10);
        System.out.println(set.contains(5));
        System.out.println(set.contains(10));
        // set functions
        // contains = O(1)
        // remove elements = O(1)
        set.remove(10);
        System.out.println(set.contains(10));
        int lifeguard;
        for (int i : set){
            lifeguard = i;
        }
        Iterator<Integer> it = set.iterator();
        lifeguard = it.next();
    }
}
