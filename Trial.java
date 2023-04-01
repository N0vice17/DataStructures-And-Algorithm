import Tree.*;
import java.util.*;
import LinkedList.*;
import Tries_and_Huffman_Coding.*;
public class Trial {
    public static void main(String[]args){
        Trie node=new Trie();
        node.add("DEBOJIT");
        node.add("DONKEY");
        node.add("DEBO");
        node.remove("DONKEY");
        System.out.println(node.search("DEBO"));
    }    
}
