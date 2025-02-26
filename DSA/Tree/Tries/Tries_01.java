package Tree.Tries;

public class Tries_01{

    static class NodeMod{
        NodeMod child[];
        boolean endOfWord;
        int fre;

        public NodeMod(){
            child=new NodeMod[26];
            endOfWord=false;
            fre=1;
            for(int i=0;i<child.length;i++){
                child[i]=null;
            }
        }
    }
    public static NodeMod rootMod=new NodeMod();

    static class Node{
        Node child[];
        boolean endOfWord;

        public Node(){
            this.child=new Node[26];
            this.endOfWord=false;
            for(int i=0;i<child.length;i++){
                child[i]=null;
            }
        }

    }
    public static Node root=new Node();

    //insert in trie ~ TC-0(Length of the longest word)
    public static void insert(String word){
        Node cur=root;
        for(int i=0;i<word.length();i++){
            int idx=(int) word.charAt(i)-'a';
            if(cur.child[idx]==null){
                cur.child[idx]=new Node();
            }
            cur=cur.child[idx];
            
        }
        cur.endOfWord=true;
    }

    //search word in trie ~ TC -0(Length of the longest word)
    public static boolean search(String key){
        Node cur=root;
        for(int i=0;i<key.length();i++){
            int idx=key.charAt(i)-'a';
            if(cur.child[idx]==null){
                return false;
            }
            cur=cur.child[idx];            
        }    
        return cur.endOfWord==true;
    }

    //word break problem ~ TC -0(Length of the key)
    public static boolean wordBreak(String key){
        if(key.length()==0){
            return true;
        }
        for(int i=1;i<=key.length();i++){
            if(search(key.substring(0,i)) && wordBreak(key.substring(i))){
                return true;
            }
        }
        return false;
    }

    //Unique Prefix problem ~ TC-0(length of the longest word)
    public static void uniquePrefix(NodeMod root,String ans){
        if(root==null){
            return ;
        }
        if(root.fre==1){
            System.out.print(ans+" ");
            return;
        }
        for(int i=0;i<root.child.length;i++){
            if(root.child[i]!=null){
                uniquePrefix(root.child[i],ans+(char)(i+'a'));
            }
        }

    }
    public static void insertMod(String word){
        NodeMod cur=rootMod;
        for(int i=0;i<word.length();i++){
            int idx=word.charAt(i)-'a';
            if(cur.child[idx]==null){
                cur.child[idx]=new NodeMod();
            }
            else{
                cur.child[idx].fre++;
            }
            cur=cur.child[idx];
        }
        cur.endOfWord=true;
    }

    //given a word,return if it is a prefix of a some word in the trie or not
    public static boolean startsWithPrefix(String prefix){
        Node cur=root;
        for(int i=0;i<prefix.length();i++){
            int idx=prefix.charAt(i)-'a';
            if(cur.child[idx]==null){
                return false;
            }
            cur=cur.child[idx];
        }
        return true;
    }

    //total unique substrings of a string
    //total unique substring of a string==total nodes in an trie.(because in a trie it stores unique string)
    public static int countUSubstring(Node root){
        if(root==null){
            return 0;
        }
        int count=0;
        for(int i=0;i<root.child.length;i++){
            if(root.child[i]!=null){
                count+=countUSubstring(root.child[i]);
            }
        }
        return count+1;
    }

    //longest word with all prefix
    public static String ans="";
    public static void longestWordWithPrefix(Node root,StringBuilder temp){
        if(root==null){
            return;
        }

        for(int i=0;i<root.child.length;i++){
            if(root.child[i]!=null && root.child[i].endOfWord==true){
                char c=(char)(i+'a');
                temp.append(c);
                if(temp.length()>ans.length()){
                    ans=temp.toString();
                }
                longestWordWithPrefix(root.child[i], temp);
                //backtracking
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }


    public static void main(String[] args) {
        //creation of trie
        String words[]={"there","apple","their","apply","thee","appl","app","ap","a"};
        for(int i=0;i<words.length;i++){
            insert(words[i]);
        }

        //search function to check if the word exists or not
        System.out.println("apple exists = "+search("apple"));
        System.out.println("theer exists = "+search("theer"));
        System.out.println("thee exists = "+search("thee"));
        System.out.println();

        //wordbreak function to check if words(key) exist in the trie in the form of subStrings
        String key="thereapple";
        System.out.println("wordBreak of thereapple = "+ wordBreak(key));
        System.out.println();

        //unique prefix function is to get all unique prefix of the words in the trie.This function uses special type of node as it also carries the frequency of the character in the trie.
        for(int i=0;i<words.length;i++){
            insertMod(words[i]);
        }
        rootMod.fre=-1;
        System.out.print("uniquePrefixes are : ");
        uniquePrefix(rootMod,"");
        System.out.println();
        System.out.println();

        //startwithprefix function is to check if the given word is a prefix of some word in the trie
        String p1="app";
        String p2="apk";
        String p3="the";
        System.out.println("prefix app exists?= "+startsWithPrefix(p1));
        System.out.println("prefix apk exists?= "+startsWithPrefix(p2));
        System.out.println("prefix the exists?= "+startsWithPrefix(p3));
        System.out.println();

        //longestWordWithPrefix function is determine the word whose all prefixes exist in the trie
        longestWordWithPrefix(root, new StringBuilder(""));
        System.out.println("longest word with all prefix is '"+ans+"'");
        System.out.println();

        //countUsubString function is to determine the total number of unique substring of str 
        root=new Node();
        String str="ababa";
        for(int i=0;i<str.length();i++){
            insert(str.substring(i));
        }
        System.out.println("total unique subString = "+ countUSubstring(root));
    }    
}