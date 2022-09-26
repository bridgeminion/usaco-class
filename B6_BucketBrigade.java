import java.io.*;
import java.util.StringTokenizer;

public class B6_BucketBrigade {

    public static boolean bad (int barn_x, int barn_y, int rock_x, int rock_y, int lake_x, int lake_y){
        // are they on the same horizontal line
        if (barn_y == lake_y && rock_y == barn_y){ // all 3 have the same y coordinate
            if (Math.min(barn_x, lake_x) <= rock_x && rock_x <= Math.max(barn_x, lake_x)){
                return true;
            }
        }
        // are they on the same vertical line
        if (barn_x == lake_x && rock_x == barn_x) { // same x
            if (Math.min(barn_y, lake_y) <= rock_y && rock_y <= Math.max(barn_y, lake_y)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("buckets.in"));
        PrintWriter pw = new PrintWriter(new FileWriter("buckets.out"));
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        int barn_x = 0, barn_y = 0, rock_x = 0, rock_y = 0, lake_x = 0, lake_y = 0;
        for (int i=0; i < 10; i++){ // each row
            String s = br.readLine();
            for (int j=0; j < 10; j++){
                char current = s.charAt(j);
                if (current == 'B'){
                    barn_x = i;
                    barn_y = j;
                }
                else if (current == 'R'){
                    rock_x = i;
                    rock_y = j;
                }
                else if (current == 'L'){
                    lake_x = i;
                    lake_y = j;
                }
            }
        }
        int ans = Math.abs(barn_x-lake_x) + Math.abs(barn_y-lake_y) - 1;
        // special case
        if (bad (barn_x, barn_y, rock_x, rock_y, lake_x, lake_y)){
            ans+=2;
        }
        pw.println(ans);
        pw.close();
    }
}
