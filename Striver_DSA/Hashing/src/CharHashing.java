import java.util.Scanner;
import java.util.Arrays;

public class CharHashing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] hash_arr = new int[52];
        Arrays.fill(hash_arr, 0);

        char A = 'A';
        char Z = 'Z';
        char a = 'a';
        char z = 'z';


        System.out.print("Enter the string: ");
        String str = sc.next();

        for (int i = 0; i < str.length(); i++) {
            if ('A' <= str.charAt(i) && str.charAt(i) <= 'Z') {
                hash_arr[str.charAt(i) - 65]++;
            } else if ('a' <= str.charAt(i) && str.charAt(i) <= 'z') {
                hash_arr[str.charAt(i) - 71]++;
            }
        }

        System.out.println("Hash Array:");
        for (int i = 0; i < hash_arr.length; i++) {
            System.out.print(i + " : " + hash_arr[i] + " | ");
        }

        System.out.print("Number of times you want to check the character: ");
        int numOfTimes = sc.nextInt();

        for (int i = 0; i < numOfTimes; i++) {
            System.out.print("Enter the character: ");
            char ch = sc.next().charAt(0);


            if ('A' <= ch && ch <= 'Z') {
                System.out.println(ch + " : " + hash_arr[ch - 65]);
            } else if ('a' <= ch && ch <= 'z') {
                System.out.println(ch + " : " + hash_arr[ch - 'a' + 26]);
            }
            else{
                System.out.println(ch + " : " + 0);
            }

        }
    }
}
