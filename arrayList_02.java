import java.util.ArrayList;

public class arrayList_02 {

    //is arraylist monotonic increasing and decreasing
    public boolean isMonotonic(ArrayList<Integer> A) {
        boolean inc = true;
        boolean dec = true;
        for (int i = 0; i < A.size() - 1; i++) {
            if (A.get(i) > A.get(i + 1))
                inc = false;
            if (A.get(i) < A.get(i + 1))
                dec = false;
        }
        return inc || dec;
    }

    // pair sum (rotated) --~0(n)
    // this funciton is only applicable when arraylist is sorted in ascending order and rotated.
    public static boolean pairsumRotatedExists(ArrayList<Integer> list, int key) {
        int breakingPoint = -1;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i + 1)) {
                breakingPoint = i;
                break;
            }
        }
        int left = breakingPoint + 1, right = breakingPoint;
        while (left != right) {
            if (list.get(left) + list.get(right) == key) {
                return true;
            }
            if (list.get(left) + list.get(right) < key) {
                left = (left + 1) % list.size();
            } else {
                right = (list.size() + right + 1) % list.size();
            }

        }
        return false;
    }

    // pair sum --~ 0(n)
    // this function is only applicable,if the arraylist is sorted in ascending
    // order.
    public static boolean pairSumExists(ArrayList<Integer> list, int key) {
        int left = 0, right = list.size() - 1;
        while (left != right) {
            if (list.get(left) + list.get(right) == key) {
                return true;
            }
            if (list.get(left) + list.get(right) < key) {
                left++;
            } else {
                right--;
            }
        }
        return false;
    }

    // container with most water --~ 0(n)
    public static int maxContainer(ArrayList<Integer> list) {
        int left = 0, right = list.size() - 1;
        int maxWater = 0;
        while (left != right) {
            int width = right - left;
            int ht = Math.min(list.get(left), list.get(right));
            int currWater = width * ht;
            maxWater = Math.max(maxWater, currWater);
            if (left < right) {
                left++;
            } else {
                right--;
            }
        }
        return maxWater;
    }

    // reversing an arraylist
    public static void reverseList(ArrayList<Integer> list) {
        for (int i = 0; i < list.size() / 2; i++) {
            int temp = list.get(i);
            list.set(i, list.get(list.size() - i - 1));
            list.set(list.size() - i - 1, temp);
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);

        // reverseList(list1);
        System.out.println(list1);
        System.out.println(pairSumExists(list1, 6));

        list2.add(5);
        list2.add(6);
        list2.add(7);
        list2.add(8);

        list3.add(9);
        list3.add(10);

        mainList.add(list1);
        mainList.add(list2);
        mainList.add(list3);
        System.out.println(mainList);

        ArrayList<Integer> heightBucket = new ArrayList<>();
        heightBucket.add(1);
        heightBucket.add(8);
        heightBucket.add(6);
        heightBucket.add(2);
        heightBucket.add(5);
        heightBucket.add(4);
        heightBucket.add(8);
        heightBucket.add(3);
        heightBucket.add(7);
        System.out.println(maxContainer(heightBucket));

        ArrayList<Integer> rotatedList = new ArrayList<>();
        rotatedList.add(11);
        rotatedList.add(15);
        rotatedList.add(6);
        rotatedList.add(8);
        rotatedList.add(9);
        rotatedList.add(10);
        System.out.println(pairsumRotatedExists(rotatedList, 25));
    }
}
