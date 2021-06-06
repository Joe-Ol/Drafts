import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {
        Scanner scan_object = new Scanner(System.in);

        System.out.println("Enter a number: ");

        int num = scan_object.nextInt();
        int init_num ;
        int remainder ;
        int result = 0;

        init_num = num;

        while (init_num != 0) {
            remainder = init_num % 10;
            result += Math.pow(remainder, 3);
            init_num /= 10;
        }

        if (result == num) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
