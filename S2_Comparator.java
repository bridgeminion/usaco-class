import java.io.*;
import java.util.*;

public class S2_Comparator {

    static class Cow {
        String name;
        int height;
        int weight;

        public Cow (String name, int height, int weight) {
            this.name = name;
            this.height = height;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("gymnastics.in"));
//        PrintWriter pw = new PrintWriter(new FileWriter("gymnastics.out"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        List<Cow> cows = new ArrayList<>();
        for (int i=0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            cows.add(new Cow (name, h, w));
        }
        Collections.sort(cows, new Comparator<Cow>() {
            @Override
            public int compare(Cow o1, Cow o2) {
                if (o1.name.equals(o2.name)){
                    Double CMI1 = (double)o1.weight/o1.height;
                    Double CMI2 = (double)o2.weight/o2.height;
                    return CMI1.compareTo(CMI2);
                }
                return o1.name.compareTo(o2.name);
            }
        });
        for (int i=0; i < n; i++){
            Cow cur = cows.get(i);
            System.out.println(cur.name + " " + cur.height + " " + cur.weight);
        }


        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(10);
        list.add(7);
        list.add(9);
        Collections.sort(list); // increasing order
        for (int i : list) System.out.println(i);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // increasing order = return o1-o2
                return o2-o1;
            }
            // compare function
            // compare (o1, o2) < 0, keep the order of o1 and o2
            // compare (o1, o2) > 0, reverse the order
        });
        System.out.println("decreasing");
        for (int i : list) System.out.println(i);
    }
}
