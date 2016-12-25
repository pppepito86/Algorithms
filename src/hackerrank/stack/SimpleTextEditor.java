package hackerrank.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.StringTokenizer;

//https://www.hackerrank.com/challenges/simple-text-editor
public class SimpleTextEditor {
	
	public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(System.out);
		int q = in.nextInt();
		int size = 0;
		char[] c = new char[1000000];
		Stack<Integer> op = new Stack<>();
		Stack<Character> deleted = new Stack<>();
		while (q-- > 0) {
			int type = in.nextInt();
			if (type == 1) {
				char[] cc = in.next().toCharArray();
				for (char ccc: cc) c[size++] = ccc;
				op.push(cc.length);
			} else if (type == 2) {
				int k = in.nextInt();
				for (int i = 0; i < k; i++) {
					deleted.push(c[--size]);
				}
				op.push(-k);
			} else if (type == 3) {
				out.println(c[in.nextInt()-1]);
			} else {
				int k = op.pop();
				if (k > 0) size -= k;
				else {
					for (int i = 0; i < -k; i++) c[size++] = deleted.pop();
				}
			}
		}
		out.close();
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
        
        public long nextLong() {
            return Long.parseLong(next());
        }
        
        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}
