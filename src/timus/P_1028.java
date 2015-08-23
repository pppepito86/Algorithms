package timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// http://acm.timus.ru/problem.aspx?space=1&num=1028
// #fenwick
/*
 *  We sort all the starts ascending according to their x coordinates
 *  if x's are equal according to ascending y coordinates
 *  
 *  We iterate over the stars.
 *  For the current star all previous stars are with previous x coordinates.
 *  So the level of the star depends on the previous stars with y coordinate not bigger 
 *  than the one of the current star.
 *  We use bit tree to count the number of stars with not bigger y coordinate.
 *  Then we increase the sums containing current y coordinate with 1.
 *  Algorithm complxity N*logN+N*log32000 -> N*logN
 */

public class P_1028 {

    public static void main(String[] args) {
        Star[] stars = getStars();
        int[] l = new int[stars.length];
        int[] a = new int[32002];
        for (Star s : stars) {
            l[sum(a, s.y + 1)]++;
            add(a, s.y + 1);
        }
        for (int ll : l) {
            System.out.println(ll);
        }
    }

    private static void add(int[] a, int i) {
        while (i < a.length) {
            a[i]++;
            i += i & -i;
        }
    }

    private static int sum(int[] a, int i) {
        int ans = 0;
        while (i > 0) {
            ans += a[i];
            i -= i & -i;
        }
        return ans;
    }

    static class Star {
        int x, y;

        public Star(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static Star[] getStars() {
        InputReader r = new InputReader(System.in);
        int n = r.nextInt();
        Star[] s = new Star[n];
        for (int i = 0; i < n; i++) {
            s[i] = new Star(r.nextInt(), r.nextInt());
        }
        Arrays.sort(s, new Comparator<Star>() {
            @Override
            public int compare(Star s1, Star s2) {
                if (s1.x != s2.x)
                    return s1.x - s2.x;
                return s1.y - s2.y;
            }
        });
        return s;
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
