package Tree.Segment_Trees;

//return the max element from range [i,j] from the array and update the idx element
public class SegmentTrees_02 {
    static int treeST[];

     static class SegmentTrees {
        SegmentTrees(int n) {
            treeST = new int[4 * n];
        }

        //Construction of a segment tree ~ TC -0(n); [n is the number of element in the array].
        public void buildSt(int arr[],int idxST,int i,int j){
            if(i==j){
                treeST[idxST]=arr[i];
                return;
            }
            int mid=i+((j-i)/2);
            buildSt(arr, 2*idxST+1, i, mid);
            buildSt(arr, 2*idxST+2, mid+1, j);
            treeST[idxST]=Math.max(treeST[2*idxST+1], treeST[2*idxST+2]);
        }

        //Max element from range[i,j] ~ TC-0(logn)
        public int getMax(int arr[],int i,int j){
            int n=arr.length;
            return getMaxUtil(0,0, n-1, i, j);
        }
        private int getMaxUtil(int idx,int si,int sj,int i,int j){
            //No-Overlapping
            if(si>j || sj<i){
                return Integer.MIN_VALUE;
            }
            //Complete Overlapping
            else if(si>=i && sj<=j){
                return treeST[idx];
            }
            //Partial Overlapping
            else{
                int mid=si+((sj-si)/2);
                int left=getMaxUtil(2*idx+1, si, mid, i, j);
                int right=getMaxUtil(2*idx+2, mid+1,sj, i, j);
                return Math.max(left,right);
            }
        }

        //Update element at index with new_value ~ TC-0(logn)
        public void update(int arr[],int idx,int newVal){
            arr[idx]=newVal;
            int n=arr.length;

            updateUtil(0,0,n-1, idx, newVal);
        }
        private void updateUtil(int idxST,int si,int sj,int idx,int newVal){
            if(idx<si ||idx>sj){
                return;
            }
            if(si==sj){
                treeST[idxST]=newVal;
                return;
            }
            treeST[idxST]=Math.max(treeST[idxST],newVal);
            int mid=si+((sj-si)/2);
            updateUtil(2*idxST+1, si, mid, idx, newVal);
            updateUtil(2*idxST+2, mid+1, sj, idx, newVal);            
        }
    
        public void printTree() {
            for (int e : treeST) {
                System.out.print(e+" ");
            }
            System.out.println();
        }

    }
    public static void main(String[] args) {
        int arr[]={6,8,-1,2,17,1,3,2,4};
        int n=arr.length;
        SegmentTrees st=new SegmentTrees(n);
        st.buildSt(arr, 0, 0, n-1);
        st.printTree();
        System.out.println("range query Max = "+st.getMax(arr, 2, 5));
        st.update(arr,2,20);
        System.out.println("updated range query sum = "+st.getMax(arr, 2, 5));
        
    }
    
}
