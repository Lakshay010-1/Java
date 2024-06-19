package String;
public class string_01 {

    public static String stringCompress(String str){
        StringBuilder strb=new StringBuilder();

        for(int i=0;i<str.length();i++){
            char currChar=str.charAt(i);
            int n=1;
            while(i+1<str.length() && currChar==str.charAt(i+1)){
                n++;
                i++;
            }
            strb.append(currChar).append(n);
        }
        return strb.toString();
    }
    public static void main(String[] args) {

        //string compression aabbcc=a2b2c2
        String str="aaabbc";
        System.out.println(stringCompress(str));
        
    }
    
}
