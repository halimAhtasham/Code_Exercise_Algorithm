import java.util.Scanner;

class LevenshteinDistanceDP {
    String S, D;
    int m, n;
    int[][] dp;

    public LevenshteinDistanceDP(String p, String q) {
        S = p;
        D = q;
        m = S.length();
        n = D.length();
        dp = new int[m + 1][n + 1];
    }

    public int CalculateDP() {

        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (S.charAt(i - 1) == D.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else {
                    dp[i][j] = 1 + Math.min(
                            dp[i - 1][j - 1],
                            Math.min(
                                    dp[i - 1][j],
                                    dp[i][j - 1]));
                }
            }
        }
        return dp[m][n];
    }
}

public class EditDistanceDP {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String p, q;
        System.out.println("Enter two Strings: ");
        p = in.nextLine();
        q = in.nextLine();
        LevenshteinDistanceDP ld = new LevenshteinDistanceDP(p, q);
        int distance = ld.CalculateDP();
        System.out.println("Levenshtein Distance: " + distance);
        in.close();
    }
}
