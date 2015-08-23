package timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// http://acm.timus.ru/problem.aspx?space=1&num=1470
// #fenwick,#3d

public class P_1470 {

    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        int n = in.nextInt();
        int[][][] f = new int[n+1][n+1][n+1];
        while (true) {
            int op = in.nextInt();
            if (op == 3) return;
            if (op == 1) {
                add(f, in.nextInt()+1, in.nextInt()+1, in.nextInt()+1, in.nextInt());
            } else {
                int sum = sum(f, in.nextInt()+1, in.nextInt()+1, in.nextInt()+1,
                        in.nextInt()+1, in.nextInt()+1, in.nextInt()+1);
                System.out.println(sum);
            }
        }
    }
    
    private static int sum(int[][][] f, int x1, int y1, int z1, int x2, int y2, int z2) {
        return sum(f, x2, y2, z2) 
                - sum(f, x1-1, y2, z2) - sum(f, x2, y1-1, z2) - sum(f, x2, y2, z1-1)
                + sum(f, x1-1, y1-1, z2) + sum(f, x1-1, y2, z1-1) + sum(f, x2, y1-1, z1-1)
                - sum(f, x1-1, y1-1, z1-1);
    }
    
    private static int sum(int[][][] f, int x, int y, int z) {
        int ans = 0;
        for (int i = x; i > 0; i -= i&-i) 
            for(int j = y; j > 0; j -= j&-j)
                for(int k = z; k > 0; k -= k&-k)
                    ans += f[i][j][k];
        return ans;
    }

    private static void add(int[][][] f, int x, int y, int z, int v) {
        for (int i = x;i < f.length; i += i&-i) 
            for(int j = y; j < f.length; j += j&-j)
                for(int k = z; k < f.length; k += k&-k)
                    f[i][j][k] += v;
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }

}
