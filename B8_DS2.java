//import java.io.*;
//import java.util.*;
//
//public class B8_DS2 {
//
//    static class Pair {
//        int a;
//        int b;
//
//        public Pair(int a, int b) {
//            this.a = a;
//            this.b = b;
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
////        BufferedReader br = new BufferedReader(new FileReader("buckets.in"));
////        PrintWriter pw = new PrintWriter(new FileWriter("buckets.out"));
////        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
////        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
////        PriorityQueue<Integer> pq = new PriorityQueue<>();
////        pq.add(1);
////        pq.add(5);
////        pq.add(4);
////        pq.add(0);
////        pq.add(9);
////        System.out.println(pq.poll());
//        PriorityQueue<Pair> pairs = new PriorityQueue<>(new Comparator<Pair>() {
//            @Override
//            public int compare(Pair o1, Pair o2) {
//                return o2.b-o1.b;
//            }
//        });
//        pairs.add(new Pair (1, 6));
//        pairs.add(new Pair (4, 3));
//        pairs.add(new Pair (0, 8));
//        System.out.println(pairs.peek().a + " " + pairs.peek().b);
//
//
//        Stack<Integer> stack = new Stack<>();
//        stack.add(2);
//        stack.add(1);
//        stack.pop();
////        System.out.println(stack.peek());
//        Queue<Integer> queue = new LinkedList<>();
//        queue.add(5); // [5]
//        queue.add(4); // [5, 4]
//        queue.peek(); // returns 5
////        System.out.println(queue.size()); // output 2
////        queue.add(8); // [5, 4, 8]
////        System.out.println(queue.poll()); // output 5, queue becomes [4, 8]
//        Deque<Integer> deq = new LinkedList<>();
//        deq.addFirst(7);
//        deq.addFirst(6);
//        deq.addLast(10);
//        deq.addFirst(9);
//        deq.addLast(11);
////        System.out.println(deq.peekFirst());
////        System.out.println(deq.pollLast());
////        System.out.println(deq.size());
////        System.out.println(deq.peekLast());
//    }
//}
