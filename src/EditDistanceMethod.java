import java.util.Scanner;


class LevenshteinDistance{
    String S, T;
    int m, n;
    int[][] edit;

    LevenshteinDistance(String p, String q){
        S = p;
        T = q;
        m = S.length();
        n = T.length();
        edit = new int[m+1][n+1];
    }

    public int computeDistance(String S, String T, int m, int n){
        if(edit[m][n] != 0) return edit[m][n];
        if(m == 0) return n;
        if(n == 0) return m;
        if(S.charAt(m-1) == T.charAt(n-1)){
            return edit[m][n] = computeDistance(S, T, m-1, n-1); // no change
        }
        else{
            return edit[m][n] = 1 + Math.min(
                computeDistance(S, T, m-1, n-1),
                Math.min(
                    computeDistance(S, T, m-1, n),
                    computeDistance(S, T, m, n-1)
                )
                );
        }
    }

    public void printEditDistance(){
        computeDistance(S, T, m, n);
        System.out.println("Distance : " + edit[m][n]);
    }
}

public class EditDistanceMethod {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String p, q;
        System.out.println("Enter two Strings: ");
        p = in.nextLine();
        q = in.nextLine();
        LevenshteinDistance ld = new LevenshteinDistance(p , q);
        ld.printEditDistance();
        in.close();
    }
}
