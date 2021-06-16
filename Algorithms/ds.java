import java.util.Scanner;


public class review {
    public static int method_one(int n) {
        int total = 0;
        for (int i = 1; i <= n; i++){
            total = total + 1;
            //total += 1;
        }
        return total;
    }

    public static int method_one_alt1(int n) {
        int total = 0;
        for (int i = 1; i <= n; i++){
            //total = total + i;
            total += i;
        }
        return total;
    }

    public static int method_one_alt2(int n) {
        int total = 0;
        int start_int = 1;

        for (int i = 1; i <= n; i++){
            total = total + start_int;
            start_int += 1;
        }
        return total;
    }

    public static int method_two(int n) {
        int total = (n*(n+1))/ 2;
        return total;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an int value n i.e. User Input: ");
        int n = sc.nextInt();

        long start_time = System.currentTimeMillis();
        System.out.println("Total = " + method_one(n));
        System.out.println("Total = " + method_one_alt1(n));
        System.out.println("Total = " + method_one_alt2(n));
        System.out.println("Total = " + method_two(n));
        long exe_time = System.currentTimeMillis() - start_time;
        System.out.println("Time: " + exe_time);
    }
}
