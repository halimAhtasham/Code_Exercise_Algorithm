import java.util.Scanner;

class LCS{
    String A, B;
    int m, n, lcsLength;
    int[][] l;
    char[] lcsString;
    public LCS(String p, String q){
        A = p;
        B = q;
        m = A.length();
        n = B.length();
        lcsLength = 0;
        l = new int[m + 1][n + 1];
    } // Constructor to init

    public int lcs(){
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if(i == 0 || j == 0){
                    l[i][j] = 0;
                }
                else if(A.charAt(i - 1) == B.charAt(j - 1)){
                    l[i][j] = 1 + l[i - 1][j - 1];
                }
                else{
                    l[i][j] = Math.max(l[i - 1][j], l[i][j - 1]);
                }
            }
        }
        lcsLength = l[m][n];
        return lcsLength;
    } // Function to calculate the length

    void PrintLcsString(){
        lcs();
        lcsString = new char[lcsLength];
        int k = lcsLength;
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (A.charAt(i - 1) == B.charAt(j - 1)) {
                k--;
                lcsString[k] = A.charAt(i - 1);
                i--; j--;
            }
            else if(l[i - 1][j] > l[i][j - 1]){
                i--;
            }
            else{
                j--;
            }
        }

        System.out.println("Length of LCS string: " + lcsLength);
        System.out.println("LCS string: ");
        for (int j2 = 0; j2 < lcsLength; j2++) {
            System.out.print(lcsString[j2] + " ");
        }
    } // Function to print the LCS string
}
public class LongestCommonSub {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter two strings: ");
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        LCS lcs = new LCS(s1, s2);
        lcs.PrintLcsString();
        in.close();
    }
}
