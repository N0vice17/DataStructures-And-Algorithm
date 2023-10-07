package Some_important_algos;

public class LongestPalindromeInString {
    public String longestPalindrome(String s) {
        s = s.replace("", "*");
        char[] chars = s.toCharArray();
        int[] palindromeSize = new int[chars.length];
        int i;
        int c = 0;
        int r = 0;
        int mirror;
        int maxPalindrome = 0;
        int maxPalindromeCenter = 0;
        for (i = 0; i < chars.length; i++) {
            mirror = 2 * c - i;
            if (r > i) {
                palindromeSize[i] = Math.min(palindromeSize[mirror], r - i);
            }
            while (i + 1 + palindromeSize[i] < chars.length && i - 1 - palindromeSize[i] >= 0
                    && chars[i + 1 + palindromeSize[i]] == chars[i - 1 - palindromeSize[i]]) {
                palindromeSize[i]++;
            }

            if (i + palindromeSize[i] > r) {
                c = i;
                r = i + palindromeSize[i];
            }

            if (palindromeSize[i] > maxPalindrome) {
                maxPalindrome = palindromeSize[i];
                maxPalindromeCenter = i;
            }
        }
        return s.substring(maxPalindromeCenter - maxPalindrome, maxPalindromeCenter + maxPalindrome).replace("*", "");
    }

    public static void main(String[] args) {
        String longestPalindrome = new LongestPalindromeInString().longestPalindrome("babad");
        System.out.println(longestPalindrome);
    }
}
