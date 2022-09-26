public class B1_Integer_Overflow {

    public static void main(String[] args){
        int a = 1000000;
        int b = 5000;
        int c = 25000;
        int d = a*b/c;
        System.out.println(d);
    }

}
