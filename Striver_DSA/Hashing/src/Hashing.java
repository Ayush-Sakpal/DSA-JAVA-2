import java.util.Scanner;
import java.util.Arrays;

public class Hashing {
    public static void main(String[] args) {
        Scanner  sc = new Scanner(System.in);

        int n;
        System.out.print("Enter the array size: ");
        n = sc.nextInt();

        int[] arr = new int[n]; // n can go up to 10^7 - 10^8 (as a safe case)

        System.out.println("Enter the array elements: ");
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }

//        Arrays.fill(arr, 3);

        int max = 0;
        for(int i=0; i<n; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }

        int[] hash_arr = new int[max+1];

        Arrays.fill(hash_arr, 0);

        for(int i=0; i<n; i++){
            hash_arr[arr[i]]++;
        }

        System.out.println("Hash Array:");
        for(int i=0; i<hash_arr.length; i++){
            System.out.println(i + " : " + hash_arr[i]);
        }

        System.out.print("Number of times you want to check the number: ");
        int numOfTimes = sc.nextInt();

        for(int i=0; i< numOfTimes; i++){
            System.out.print("Enter the number: ");
            int num = sc.nextInt();

            if(num >= hash_arr.length){
                System.out.println(num + " : " + 0);
            }
            else{
                System.out.println(num + " : " + hash_arr[num]);
            }
        }
    }
}
