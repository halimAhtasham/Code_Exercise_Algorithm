import java.util.Scanner;

public class EditDistanceMethod {
    static String A, B;
    static int m, n, lcsLength;
    static int[][]editDistanceMethod;

    public static int lcs(String p, String q){
        m = p.length();
        n = q.length();
        A = p;
        B = q;
        lcsLength = 0;
        editDistanceMethod = new int[m +1][n+1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if(i == 0 || j == 0) editDistanceMethod[i][j] = 0;
                else if(A.charAt(i-1) == B.charAt(j-1)){
                    editDistanceMethod[i][j] = 1 + editDistanceMethod[i-1][j-1];
                }
                else{
                    editDistanceMethod[i][j] = Math.max(editDistanceMethod[i-1][j], editDistanceMethod[i][j-1]);
                }
            }
        }
        return lcsLength = editDistanceMethod[m][n];
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String p, q;
        System.out.println("Enter two Strings: ");
        p = in.nextLine();
        q = in.nextLine();
        int result = lcs(p,q);
        System.out.println("Length of LCS: " + result);
        in.close();
    }
}
