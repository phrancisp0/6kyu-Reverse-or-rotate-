public class RevRot {
    
    public static String revRot(String strng, int sz) {
        if(sz <= 0 || strng.isEmpty()) return "";
        String[] chunks = new String[strng.length()/sz];
        int i=0;
        while(true) {
            if((i+1)*sz > strng.length()) break;
            chunks[i] = strng.substring(i*sz, (i+1)*sz);
            i++;
        }
        String res = "";
        for(String s:chunks) {
            int cubesSum = 0;
            for(int j = 0; j<s.length(); j++) {
                int jc = Integer.parseInt(s.substring(j, j+1));
                cubesSum += (jc*jc*jc);
            }
            if(cubesSum%2==0) {
                res += reverse(s);
            } else {
                res += rotate(s);
            }
        }
        return res;
    }
    
    private static String reverse(String s) {
        StringBuffer sb = new StringBuffer();
        for(int i=s.length()-1; i>=0; i--) {
            sb.append(s.substring(i, i+1));
        }
        return sb.toString();
    }
    
    private static String rotate(String s) {
        String res = s.substring(1) + s.substring(0,1);
        return res;
    }
}
/*
The input is a string str of digits. Cut the string into chunks (a chunk here is a substring of the initial string) of size sz (ignore the last chunk if its size is less than sz).

If a chunk represents an integer such as the sum of the cubes of its digits is divisible by 2, reverse that chunk; otherwise rotate it to the left by one position. Put together these modified chunks and return the result as a string.

If

sz is <= 0 or if str is empty return ""
sz is greater (>) than the length of str it is impossible to take a chunk of size sz hence return "".
Examples:
revrot("123456987654", 6) --> "234561876549"
revrot("123456987653", 6) --> "234561356789"
revrot("66443875", 4) --> "44668753"
revrot("66443875", 8) --> "64438756"
revrot("664438769", 8) --> "67834466"
revrot("123456779", 8) --> "23456771"
revrot("", 8) --> ""
revrot("123456779", 0) --> "" 
revrot("563000655734469485", 4) --> "0365065073456944"
Example of a string rotated to the left by one position:
s = "123456" gives "234561".
*/
