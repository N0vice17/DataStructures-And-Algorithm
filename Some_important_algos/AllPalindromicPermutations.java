import java.io.*;
import java.util.*;

public class AllPallindromicPermutations {

	public static void generatepw(int cs, int ts, HashMap<Character, Integer> fmap, Character oddc, String asf) {
        if(cs == ts){
            if(oddc != null){
                asf += oddc;
            }
            String s = reverse(asf);
            asf += s;

            System.out.println(asf);
            return;
        }
		for(char ch : fmap.keySet()){
            if(fmap.get(ch) != 0){
                fmap.put(ch, fmap.get(ch) - 1);
                generatepw(cs+1, ts, fmap, oddc, asf+ch);
                fmap.put(ch, fmap.get(ch) + 1);
            }
        }
	}

    public static String reverse(String str){
        String s = "";
        for(int i = str.length() -1; i >= 0; i--){
            char ch = str.charAt(i);
            s += ch;
        }
        return s;
    }


	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		HashMap<Character, Integer> fmap = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			fmap.put(ch, fmap.getOrDefault(ch, 0) + 1);
		}

		char oddc = '1';
        int len = 0;
		HashMap<Character, Integer> halfmap = new HashMap<>();
		for (char ch : fmap.keySet()){
            if(fmap.get(ch) == 1){
                oddc = ch;
                continue;
            }
            
            else{
                if(fmap.get(ch) % 2 != 0){
                    oddc = ch;
                }
		        halfmap.put(ch, fmap.get(ch) / 2);
                len += halfmap.get(ch);
            }
		}

        generatepw(0, len, halfmap, oddc == '1' ? null : oddc, "");
		
		
	}
	
}