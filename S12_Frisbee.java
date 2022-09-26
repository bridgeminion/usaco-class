import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class S12_Frisbee {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("buckets.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("buckets.out"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] h = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i < n; i++){
            h[i] = Integer.parseInt(st.nextToken());
        }
        Map<Integer, Integer> position = new HashMap<>();
        for (int i=0; i < n; i++){
            position.put(h[i], i);
        }
        long ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i=n-1; i >= 0; i--){
            if (stack.isEmpty()){
                stack.add(h[i]);
            }
            else {
                while (!stack.isEmpty() && stack.peek() < h[i]){
                    stack.pop();
                }
                if (!stack.isEmpty()){
                    int nextHeight = stack.peek();
                    ans += position.get(nextHeight) - position.get(h[i]) + 1;
                }
            }
        }
        stack.clear();
        for (int i=0; i < n; i++){
            if (stack.isEmpty()){
                stack.add(h[i]);
            }
            else {
                while (!stack.isEmpty() && stack.peek() < h[i]){
                    stack.pop();
                }
                if (!stack.isEmpty()){
                    int nextHeight = stack.peek();
                    ans += position.get(nextHeight) - position.get(h[i]) + 1;
                }
            }
        }
        pw.println(ans);
        pw.close();
    }
}
