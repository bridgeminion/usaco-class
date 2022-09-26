import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B3_MeasuringTraffic {

    public static class Mile {
        String s;
        int a;
        int b;

        public Mile(String s, int a, int b) {
            this.s = s;
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("traffic.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("traffic.out"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        List<Mile> list = new ArrayList<>();
        List<Mile> rev = new ArrayList<>();
        for (int i=0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Mile (st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        for (int i=0; i < n; i++){
            rev.add(list.get(n-i-1));
        }
        int enda = Integer.MIN_VALUE;
        int endb = Integer.MAX_VALUE;
        for (Mile i : list){
            if (i.s.equals("none")){
                enda = Math.max(enda, i.a);
                endb = Math.min(endb, i.b);
            }
            else if (i.s.equals("on")){
                if (enda != Integer.MIN_VALUE){
                    enda += i.a;
                    endb += i.b;
                }
            }
            else {
                if (enda != Integer.MIN_VALUE){
                    enda -= i.b;
                    endb -= i.a;
                    enda = Math.max(enda, 0);
                }
            }
        }
        int starta = Integer.MIN_VALUE;
        int startb = Integer.MAX_VALUE;
        for (Mile i : rev){
            if (i.s.equals("none")){
                starta = Math.max(starta, i.a);
                startb = Math.min(startb, i.b);
            }
            else if (i.s.equals("off")){
                if (starta != Integer.MIN_VALUE){
                    starta += i.a;
                    startb += i.b;
                }
            }
            else {
                if (starta != Integer.MIN_VALUE){
                    starta -= i.b;
                    startb -= i.a;
                    starta = Math.max(starta, 0);
                }
            }
        }
        pw.println(starta + " " + startb);
        pw.println(enda + " " + endb);
        pw.close();
    }
}
