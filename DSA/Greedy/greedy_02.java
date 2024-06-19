package Greedy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class greedy_02 {

    // Maximum Balanced String Partitions
    public static int maxBalPar(String str) {
        int ans = 0;
        int l = 0, r = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'L') {
                l++;
            } else {
                r++;
            }
            if (l == r) {
                ans++;
            }
        }
        return ans;
    }

    // Kth largest odd number in a given range
    public static int maxKthno(int left, int right, int k) {
        if (k <= 0) {
            return 0;
        }
        int L = left;
        int R = right;
        if ((R & 1) > 0) {
            int Count = (int) Math.ceil((R - L + 1) / 2);
            if (k > Count) {
                return 0;
            } else {
                return (R - 2 * k + 2);
            }
        } else {

            int Count = (R - L + 1) / 2;
            if (k > Count)
                return 0;
            else
                return (R - 2 * k + 1);
        }
    }

    // Lexicographically smallest string of length N and sum K
    public static char[] minStr(int n, int k) {
        char arr[] = new char[n];
        Arrays.fill(arr, 'a');
        for (int i= n-1;i>=0;i--) {
            k -= i;
            if (k >= 0) {
                if (k >= 26) {
                    arr[i] = 'z';
                    k -= 26;
                } else {
                    arr[i] = (char) (k + 97 - 1);
                    k -= arr[i] - 'a' + 1;
                }
            } else{
                break;
                }
            k += i;
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println("Maximum Balanced String Partitions");
        String str = "LRRRRLLRLLRL";
        System.out.println(maxBalPar(str));

        System.out.println("Kth largest odd number in a given range");
        int left = -3, right = 3;
        // -1 1 3
        int k = 1;
        System.out.println(maxKthno(left, right, k));

        System.out.println("Lexicographically smallest string of length N and sum K");
        int n = 5, kk = 42;
        char [] arr=minStr(n, kk);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]);
        }

    }

}
