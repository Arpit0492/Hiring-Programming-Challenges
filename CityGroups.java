
// https://www.hackerearth.com/challenge/competitive/may-circuits-17/problems/
import java.util.*;
import java.io.*;


class CityGroups{
    public static void main(String[] args) {

        fastIO fs = new fastIO();
        fs.InputReader(System.in);
        fs.pw = new PrintWriter(new OutputStreamWriter(System.out));
        int N = fs.nextInt(), K = fs.nextInt();

        HashMap<Integer,Integer> cityGroups = new HashMap<>();
        for (int i = 0; i <K; i++) {

            int S = fs.nextInt();

            for (int j = 0; j <S; j++) {
                cityGroups.put(fs.nextInt(),i+1);
            }

        }

        int Q = fs.nextInt();

        for (int i = 0; i <Q; i++) {

            int X = fs.nextInt(), Y = fs.nextInt();

            int xGrp = cityGroups.get(X), yGrp = cityGroups.get(Y);

            int diff = Math.abs(xGrp-yGrp);
            if (diff<=1){
                fs.pw.println(diff);
            }
            else{

                int frwd = (yGrp-xGrp+K)%K;
                int bkwd = (xGrp-yGrp+K)%K;

                int minTime = bkwd<frwd?bkwd:frwd;
                fs.pw.println(minTime);

            }


        }

        fs.pw.flush();
        fs.pw.close();

    }
}


/*
FAST INPUT OUTPUT TEMPLATE
 */
class fastIO
{
    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
    private SpaceCharFilter filter;
    PrintWriter pw;
    int MOD = 1000000007;

    void InputReader(InputStream stream1) {
        stream = stream1;
    }

    private boolean isWhitespace(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    private boolean isEndOfLine(int c) {
        return c == '\n' || c == '\r' || c == -1;
    }

    int read() {
        if (numChars == -1)
            throw new InputMismatchException();
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0)
                return -1;
        }
        return buf[curChar++];
    }

    int nextInt() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    long nextLong() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        long res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    String nextToken() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }

    String nextLine() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isEndOfLine(c));
        return res.toString();
    }

    int[] nextIntArray(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextInt();
        }
        return arr;
    }

    int[][] next2dArray(int n, int m) {
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = nextInt();
            }
        }
        return arr;
    }
    char[][] nextCharArray(int n,int m){
        char [][]c=new char[n][m];
        for(int i=0;i<n;i++){
            String s=nextLine();
            for(int j=0;j<s.length();j++){
                c[i][j]=s.charAt(j);
            }
        }
        return c;
    }

    long[] nextLongArray(int n) {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nextLong();
        }
        return arr;
    }

    String[] nextStringArray(int n) {

        String ans [] = new String[n];
        for (int i = 0; i <n; i++) {
            ans [i] = nextToken();
        }
        return ans;
    }
    String[] nextStringLineArray(int n) {

        String ans [] = new String[n];
        for (int i = 0; i <n; i++) {
            ans [i] = nextLine();
        }
        return ans;
    }

    void pArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            pw.print(arr[i] + " ");
        }
        pw.println();
        return;
    }

    void pArray(long[] arr) {
        for (int i = 0; i < arr.length; i++) {
            pw.print(arr[i] + " ");
        }
        pw.println();
        return;
    }

    void pArray(boolean[] arr) {
        for (int i = 0; i < arr.length; i++) {
            pw.print(arr[i] + " ");
        }
        pw.println();
        return;
    }

    private boolean isSpaceChar(int c) {
        if (filter != null)
            return filter.isSpaceChar(c);
        return isWhitespace(c);
    }

    private interface SpaceCharFilter {
        public boolean isSpaceChar(int ch);
    }
}
