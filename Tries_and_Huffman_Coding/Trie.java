package Tries_and_Huffman_Coding;
class TrieNode{
    char data;
    boolean isTerminal;
    TrieNode children[];
    public TrieNode(char data){
        this.data=data;
        this.isTerminal=false;
        this.children= new TrieNode [26];
    }
}
public class Trie{
    private static TrieNode root;
    public Trie(){
        this.root=new TrieNode('\0');
    }
    //-------------------------------------------------------------------------------
    private static void helperadd(TrieNode root,String word){
        if(word.length()==0){
            root.isTerminal=true;
            return;
        }
        TrieNode insert=new TrieNode(word.charAt(0));
        if(root.children[word.charAt(0)-'A']==null){
            root.children[word.charAt(0)-'A']=insert; 
        }
        helperadd(root.children[word.charAt(0)-'A'],word.substring(1));
    }
    public static void add(String word){
        helperadd(root,word.toUpperCase());
    }
    //--------------------------------------------------------------------------------
    public static boolean search(String word){
        return helpersearch(root,word);
    }
    private static boolean helpersearch(TrieNode root,String word){
        if(word.length()==0){
            if(root.isTerminal){
                return true;
            }
            return false;
        }
        if(root.children[word.charAt(0)-'A']==null){
            return false;
        }
        boolean check=helpersearch(root.children[word.charAt(0)-'A'],word.substring(1));
        return check;
    }
    //-----------------------------------------------------------------------------------
    private static void helperremove(TrieNode root,String word){
        if(word.length()==1){
            root.children[word.charAt(0)-'A'].isTerminal=false;
            return;
        }
        helperremove(root.children[word.charAt(0)-'A'], word.substring(1));
    }
    public static void remove(String word){
        helperremove(root, word);
    }
    //-------------------------------------------------------------------------------
}