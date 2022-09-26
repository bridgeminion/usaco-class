import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CircleCross {

    public static boolean check (char letter1, char letter2, String s){
        List<Integer> pos1 = new ArrayList<>();
        List<Integer> pos2 = new ArrayList<>();
        for (int i=0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == letter1){
                pos1.add(i);
            }
            else if (c == letter2){
                pos2.add(i);
            }
        }
        // A B A B
        // ABCCAB
        // letter1 = 0 (represents 'A')
        // letter2 = 1 (represents 'B')
        // pos1 = [0, 4]
        // pos2 = [1, 5]
        // AABB
        // BABA
        boolean case1 = pos1.get(0) < pos2.get(0) && pos2.get(0) < pos1.get(1) && pos1.get(1) < pos2.get(1);
        boolean case2 = pos2.get(0) < pos1.get(0) && pos1.get(0) < pos2.get(1) && pos2.get(1) < pos1.get(1);
        return case1 || case2;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("circlecross.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("circlecross.out"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        int ans = 0;
        for (int i=0; i < 26; i++){
            for (int j=i+1; j < 26; j++){
                if (check ((char)(i+'A'), (char)(j+'A'), s)){
                    ans++;
                }
            }
        }
        pw.println(ans);
        pw.close();
    }
}
