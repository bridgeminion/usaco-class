import java.io.*;
import java.util.*;

public class B12_CreatingStrings {

    static Set<String> set = new HashSet<>();

    public static void recurse (StringBuilder cur, String s, boolean[] used){
        if (cur.length() == s.length()){
            set.add(cur.toString());
            return;
        }
        for (int i=0; i < s.length(); i++){
            if (!used[i]){
                used[i] = true;
                cur.append(s.charAt(i));
                recurse (cur, s, used);
                used[i] = false;
                cur.deleteCharAt(cur.length()-1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new FileReader("gravity.in"));
//        PrintWriter pw = new PrintWriter(new FileWriter("gravity.out"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        recurse (new StringBuilder(), s, new boolean[s.length()]);
        List<String> list = new ArrayList<>(set);
        Collections.sort(list);
        System.out.println(list.size());
        for (String i : list){
            System.out.println(i);
        }
    }
}
