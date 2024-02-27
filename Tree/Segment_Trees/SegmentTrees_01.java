package Tree.Segment_Trees;

//return the sum from range [i,j] from the array and update the idx element 
public class SegmentTrees_01 {
    static int treeST[];

     static class SegmentTrees {
        SegmentTrees(int n) {
            treeST = new int[4 * n];
        }

        //Construction of a segment tree ~ TC -0(n); [n is the number of element in the array].
        public int buildSt(int arr[], int idxST, int start, int end) {
            if (start == end) {
                treeST[idxST] = arr[start];
                return treeST[idxST];
            }
            int mid = start + ((end - start) / 2);
            buildSt(arr, 2 * idxST + 1, start, mid);
            buildSt(arr, 2 * idxST + 2, mid + 1, end);
            treeST[idxST] = treeST[2 * idxST + 1] + treeST[2 * idxST + 2];
            return treeST[idxST];
        }

        //Sum of elements in a range[i,j] ~ TC-0(logn)
        public int getSum(int arr[],int i,int j){
            int n=arr.length;// ~ TC-0(k)
            return getSumUtil(0, 0, n-1, i, j);// ~ TC-0(logn)
            
        }
        private int getSumUtil(int idx,int si,int sj,int i,int j){
            //Non-Overlapping
            if(j<=si || i>=sj){
                return 0;
            }
            //Complete Overlap
            else if(si>=i && sj<=j){
                return treeST[idx];
            }
            //Partial Overlap
            else{
                int mid=si+((sj-si)/2);
                int left=getSumUtil(2*idx+1, si, mid, i, j);
                int right=getSumUtil(2*idx+2, mid+1,sj, i, j);
                return left+right;
            }
        }

        //Update element at index with new_Value ~ TC-0(logn)
        public void update(int arr[],int idx,int newVal){
            int n=arr.length;
            int diff=newVal-arr[idx];
            arr[idx]=newVal;

            //segment tree updation
            updateUtil(0,0,n-1,idx,diff);// ~ TC-0(logn)
        }
        private void updateUtil(int idxST,int si,int sj,int idx,int diff){
            if(idx>sj || idx<si){
                return;
            }
            treeST[idxST]+=diff;
            //non-Leaf child
            if(si!=sj){
                int mid=si+((sj-si)/2);
                updateUtil(2*idxST+1, si, mid, idx, diff);
                updateUtil(2*idxST+2, mid+1, sj, idx, diff);
            }
            
        }

        public void printTree() {
            for (int e : treeST) {
                System.out.print(e+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int n = arr.length;
        SegmentTrees st = new SegmentTrees(n);
        st.buildSt(arr, 0, 0, n-1);
        st.printTree();
        int sum=st.getSum(arr, 2, 5);
        System.out.println("range query sum = "+sum);
        st.update(arr, 2, 2);
        System.out.println("updated range query sum = "+st.getSum(arr, 2, 5));

    }
}