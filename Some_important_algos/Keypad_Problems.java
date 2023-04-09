package Some_important_algos;

public class Keypad_Problems {
    public static String getString(int num){
        if(num==2){
            return "abc";
        }
        if(num==3){
            return "def";
        }
        if(num==4){
            return "ghi";
        }
        if(num==5){
            return "jkl";
        }
        if(num==6){
            return "mno";
        }
        if(num==7){
            return "pqrs";
        }
        if(num==8){
            return "tuv";
        }
        if(num==9){
            return "wxyz";
        }
        return "";
    }
    public static String[] keystring(int num){
        if(num==0){
            String[]arr=new String[1];
            arr[0]="";
            return arr;
        }
        String[]smalloutput=keystring(num/10);
        String length=getString(num%10);
        String []output=new String[smalloutput.length*length.length()];
        int index=0;
        for(int i=0;i<smalloutput.length;i++){
            for(int j=0;j<length.length();j++){
                output[index]=smalloutput[i]+length.charAt(j);
                index++;
            }
        }
        return output;
    }
    public static void printkeystring(int num,String output){
        if(num==0){
            System.out.println(output);
            return;
        }
        String get=getString(num%10);
        for(int i=0;i<get.length();i++){
            printkeystring(num/10,(get.charAt(i)+output));
        }
    }
    public static void main(String[]args){
        printkeystring(2374, "");
        // String []arr=keystring(23);
        // for(int i=0;i<arr.length;i++){
        //     System.out.println(arr[i]);
        // }
    }
}
