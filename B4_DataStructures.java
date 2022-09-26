import java.io.IOException;
import java.io.*;
import java.util.*;

public class B4_DataStructures {

    static class Pair {
        int a;
        int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return a == pair.a && b == pair.b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
    }

    public static void main(String[] args) throws IOException {
//        List<Pair> pairs = new ArrayList<>();
//        pairs.add(new Pair (1, 2));
//        pairs.add(new Pair (4, 6));
//        pairs.remove(new Pair (4, 6));
//        Pair p1 = new Pair (3, 5);
//        Pair p2 = new Pair (3, 5);
//        System.out.println(p1.equals(p2));
//        for (int i=0; i < 1; i++){
//            System.out.println(pairs.get(i).a + " " + pairs.get(i).b);
//        }
//        List<Integer> original = new ArrayList<>();
//        original.add(2);
//        original.add(5);
//        List<Integer> list = new ArrayList<>();
//        System.out.println("size " + list.size());
//        list.add(3);
//        list.add(7);
//        list.add(9);
//        for (int i : list){
//            System.out.println(i);
//        }
//        System.out.println("size " + list.size());
//        list.add(1, 2); // adding/deleting in the middle of the list O(N)
//        list.remove((Integer)(9));
//        for (int i : list){
//            System.out.println(i);
//        }
//        Set<Pair> set = new HashSet<>();
//        set.add(new Pair (1, 2));
//        set.add(new Pair (1, 2));
//        System.out.println(set.size());
////        System.out.println(set.remove(new Pair (1, 4)));
//        TreeSet<Pair> treeSet = new TreeSet<>(new Comparator<Pair>() {
//            @Override
//            public int compare(Pair o1, Pair o2) {
//                return o1.b-o2.b;
//            }
//        });
//        treeSet.add(new Pair (1, 2)); // O(log N)
//        treeSet.add(new Pair (3, 4)); // O(log N)
//        treeSet.add(new Pair (0, 7));
//        for (Pair i : treeSet){
//            System.out.println(i.a + " " + i.b);
//        }
//        Map<Character, List<Integer>> map = new HashMap<>();
//        map.put('b', new ArrayList<>());
//        map.get('b').add(10);
//        System.out.println(map.get('b').get(0));
        TreeMap<Integer, Integer> tmap = new TreeMap<>();
        tmap.put(5, 3);
        tmap.put(2, 4);
        tmap.put(7, 1);
        for (int i : tmap.keySet()){
            System.out.println(tmap.get(i));
        }
        int n = 10;
        Map<String, Integer> cowAmount = new HashMap<>();
        // cow names: Bessie, Elsie, Daisy, Gertie, Annabelle, Maggie, and Henrietta
        cowAmount.put("Bessie", 0);


    }
}
