package Greedy;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class greedy_01 {

    // activity selection
    public static int activitySelection(int start[], int end[]) {
        int activites[][] = new int[start.length][3];
        // sorted on basis of end time
        sortArrAccToEnd(start, end, activites);
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(0);
        int maxActivity = 1;
        int endTime = activites[0][2];

        // non overlapping activites
        for (int i = 1; i < start.length; i++) {
            if (activites[i][1] >= endTime) {
                ans.add(i);
                maxActivity++;
                endTime = activites[i][2];
            }
        }
        for (int i = 0; i < ans.size(); i++) {
            System.out.print("A" + ans.get(i) + " ");
        }
        System.out.println();
        System.out.print("max activties that can be performed are = ");
        return maxActivity;

    }

    public static void sortArrAccToEnd(int start[], int end[], int activites[][]) {
        for (int i = 0; i < start.length; i++) {
            // 0th column contains the index
            activites[i][0] = i;
            // 1st column contains the start time
            activites[i][1] = start[i];
            // 2nd column contains the end time
            activites[i][2] = end[i];
        }
        // this lambda functions sort this array on the basis of second coloum
        Arrays.sort(activites, Comparator.comparingDouble(o -> o[2]));
    }

    // fractional knapsack
    public static double maxValue(int weight[], int value[], int capacity) {
        double ratio[][] = new double[weight.length][2];
        sortArrAccToPro(weight, value, ratio);
        int remCap=capacity;
        double finalValue=0;

        for(int i=ratio.length-1;i>=0;i--){
            int idx=(int)ratio[i][0];
            if(remCap>=weight[idx]){
                remCap-=weight[idx];
                finalValue+=value[idx];
            }
            else{
                finalValue+=(ratio[i][1]*remCap);
                remCap=0;
                break;
            }
        }
        return finalValue;        
    }
    public static void sortArrAccToPro(int weight[], int value[], double ratio[][]) {
        for (int i = 0; i < value.length; i++) {
            // 0th column contains the index
            ratio[i][0] = i;
            // 1st column contains the profitability time
            ratio[i][1] = value[i]/(double)weight[i];
            
        }
        // this lambda functions sort this array on the basis of second coloum
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));
    }

    //minimum absolute differnce
    public static int minAbosDiff(int a[],int b[]){
        int minDiff=0;
        Arrays.sort(a);
        Arrays.sort(b);
        for(int i=0;i<a.length;i++){
            minDiff+=Math.abs(b[i]-a[i]);
        }
        return minDiff;
    }

    //max Length chains of pairs ~TC-0(nlogn)
    public static int maxChain(int pairs[][]){
        Arrays.sort(pairs,Comparator.comparingDouble(o->o[1]));
        int maxLen=1;
        int lastChainLen=pairs[0][1];
        for(int i=1;i<pairs.length;i++){
            if(lastChainLen <= pairs[i][0]){
                maxLen++;
                lastChainLen=pairs[i][1];
            }
        }
        System.out.println("maximum length of the chain ");
        return maxLen;
    }

    //return minimum number of notes needed to settle a particular 
    public static int indnNotes(int notes[],int amount){
        Arrays.sort(notes);
        ArrayList <Integer> note=new ArrayList<>();
        int minNotes=0;
        int remAmount=amount;
        for(int i=notes.length-1;i>=0;i--){
            if(notes[i]<=remAmount){
                while(notes[i]<=remAmount){
                    note.add(notes[i]);
                    remAmount-=notes[i];
                    minNotes++;
                }
            }
        }
        System.out.println(amount+" = "+note);
        return minNotes;
    }

   //job sequencing problem
   static class jobProfile{
    int deadline;
    int profit;
    int id;
    public jobProfile(int deadline,int profit,int id){
        this.deadline=deadline;
        this.profit=profit;
        this.id=id;
    }
   }
   public static int maxJobPro(int jobs[][]){
    ArrayList<jobProfile> job =new ArrayList<>();
    for(int i=0;i<jobs.length;i++){
        job.add(new jobProfile(jobs[i][0],jobs[i][1], i));
    }
    Collections.sort(job,(obj1,obj2)-> obj2.profit-obj1.profit);
    ArrayList<Integer> seq=new ArrayList<>();
    int maxProfit=0;
    int time=0;

    for(int i=0;i<job.size();i++){
        jobProfile curr=job.get(i);
        if(curr.deadline>time){
            seq.add(curr.id);
            time++;
            maxProfit+=curr.profit;
        }
    }
    System.out.println(seq);
    return maxProfit;



   }
   
   //choco cutting problem --~ every cut has some given value , find the minimum value to cut the chocolate;
   public static int chocoCut(Integer costVer[],Integer costHor[]){
    Arrays.sort(costVer,Collections.reverseOrder());
    Arrays.sort(costHor,Collections.reverseOrder());
    int vp=1,hp=1;
    int v=0,h=0;
    int cost=0;
    while(h<costHor.length&&v<costVer.length){
        if(costVer[v]<=costHor[h]){
            cost+=costHor[h]*vp;
            hp++;
            h++;
        }
        else{
            cost+=costVer[v]*hp;
            vp++;v++;
        }
    }
    while(h<costHor.length){
        cost+=costHor[h]*vp;
        h++;hp++;
    }
    while(v<costVer.length){
        cost+=costVer[v]*hp;
        v++;vp++;
    }
    System.out.print("minimum cost to cut down a chocolate into single pieces is ");
    return cost;
   }
   
    public static void main(String[] args) {

        System.out.println("Activity selection");
        int start[] = { 12, 10, 20 };
        int end[] = { 25, 20, 30 };
        System.out.println(activitySelection(start, end));

        System.out.println("max value from fractional knapsack");
        int value[] = { 100, 60, 120 };
        int weight[] = { 20, 10, 30 };
        int w=50;
        System.out.println(maxValue(weight, value, w));

        System.out.println("Minimum absolute difference b/w arrays");
        int a[]={2,1,3};
        int b[]={2,3,1};
        System.out.println(minAbosDiff(a, b));

        System.out.println("Max length of the joint pairs of chain");
        int pairs[][]={{5,24},{39,60},{5,28},{27,40},{50,90}};
        System.out.println(maxChain(pairs));

        System.out.println("No. of notes needed to settle an amount");
        int notes[]={1,2,5,10,20,50,100,500,2000};
        System.out.println(indnNotes(notes,1499));

        System.out.println("activites that can be done within given deadline");
        int jobs[][]={{4,20},{1,10},{1,40},{1,30}};
        System.out.println(maxJobPro(jobs));

        System.out.println("Minimum amount needed to cut chocolate into single pieces.");
        Integer costVer[]={2,1,3,1,4};
        Integer costHor[]={4,1,2};
        System.out.println(chocoCut(costVer,costHor));

    }
}