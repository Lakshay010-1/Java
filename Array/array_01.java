package Array;
public class array_01 {

    // print all subArray
    public static void printSubarrays(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                System.out.print("( ");
                for (int k = i; k <= j; k++) {
                    System.out.print(arr[k] + " ");
                }
                System.out.print("), ");
            }
            System.out.println();
        }
    }

    public static void printArray(int arr[]) {
        for (int e : arr) {
            System.out.print(e);
        }
        System.out.println();
    }

    // binary search in function approach
    public static int binarySearch(int arr[], int target) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (arr[mid] == target) {
                return mid;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }

        }

        return -1;
    }

    // trap rain water
    public static int trappedWater(int arr[], int width) {
        int count = 0, n = arr.length;
        int rightMax[] = new int[n];
        int leftMax[] = new int[n];

        // maximum right side
        rightMax[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], arr[i]);
        }

        // maximum left side
        leftMax[0] = arr[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(arr[i], leftMax[i - 1]);
        }

        for (int i = 0; i < n; i++) {
            count += width * (Math.min(leftMax[i], rightMax[i]) - arr[i]);
        }
        return count;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3 };

    }
}
