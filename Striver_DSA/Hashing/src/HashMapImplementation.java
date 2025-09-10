import java.util.HashMap;
import java.util.Scanner;

public class HashMapImplementation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<Integer, Integer> map = new HashMap<>();

        System.out.print("Enter number of elements in the array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array elements:");
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for(int key: map.keySet()){
            System.out.println(key + " -> " + map.get(key));
        }

        System.out.print("Enter number of times you wish to check: ");
        int numOfTimes = sc.nextInt();

        for(int i=0; i<numOfTimes; i++){
            System.out.print("Enter the number: ");
            int num = sc.nextInt();

            System.out.println(num + " -> " + map.getOrDefault(num, 0));
        }
    }
}
