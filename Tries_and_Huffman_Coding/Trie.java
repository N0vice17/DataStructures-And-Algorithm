package Tries_and_Huffman_Coding;

import java.util.*;

class TrieNode {
    char data;
    boolean isTerminal;
    TrieNode children[];

    public TrieNode(char data) {
        this.data = data;
        this.isTerminal = false;
        this.children = new TrieNode[26];
    }
}

public class Trie {
    private static TrieNode root;

    public Trie() {
        this.root = new TrieNode('\0');
    }

    // -------------------------------------------------------------------------------
    private static void helperadd(TrieNode root, String word) {
        if (word.length() == 0) {
            root.isTerminal = true;
            return;
        }
        TrieNode insert = new TrieNode(word.charAt(0));
        if (root.children[word.charAt(0) - 'A'] == null) {
            root.children[word.charAt(0) - 'A'] = insert;
        }
        helperadd(root.children[word.charAt(0) - 'A'], word.substring(1));
    }

    public static void add(String word) {
        helperadd(root, word.toUpperCase());
    }

    // --------------------------------------------------------------------------------
    public static boolean search(String word) {
        return helpersearch(root, word);
    }

    private static boolean helpersearch(TrieNode root, String word) {
        if (word.length() == 0) {
            if (root.isTerminal) {
                return true;
            }
            return false;
        }
        if (root.children[word.charAt(0) - 'A'] == null) {
            return false;
        }
        boolean check = helpersearch(root.children[word.charAt(0) - 'A'], word.substring(1));
        return check;
    }

    // -----------------------------------------------------------------------------------
    private static void helperremove(TrieNode root, String word) {
        if (word.length() == 1) {
            root.children[word.charAt(0) - 'A'].isTerminal = false;
            return;
        }
        helperremove(root.children[word.charAt(0) - 'A'], word.substring(1));
    }

    public static void remove(String word) {
        helperremove(root, word);
    }

    // -----------------------------------------------------------------------------
    public static void allwords(TrieNode root, String word, ArrayList<String> output, String helper) {
        if (root.isTerminal) {
            output.add(helper);
            System.out.println(helper);
            return;
        }
        if (word.length() > 0 && root.children[word.charAt(0) - 'A'] != null) {
            allwords(root.children[word.charAt(0) - 'A'], word.substring(1), output, helper + word.charAt(0));
        } else if (word.length() > 0 && root.children[word.charAt(0) - 'A'] == null) {
            return;
        }
        for (int i = 0; i < root.children.length; i++) {
            if (root.children[i] != null) {
                allwords(root.children[i], "", output, helper + Character.toString(root.children[i].data));
            }
        }
    }

    public static void autocomplete(String word, ArrayList<String> arr) {
        for (int i = 0; i < arr.size(); i++) {
            add(arr.get(i));
        }
        ArrayList<String> output = new ArrayList<String>();
        if (search(word)) {
            output.add(word);
        }
        String str = "";
        System.out.println(output);
        allwords(root, word, output, str);
    }
}