    /*
    https://www.hackerearth.com/practice/algorithms/string-algorithm/string-searching/practice-problems/algorithm/twitter-trends/
    */
    
    
    import java.util.*;
    import java.io.*;
     
     
    public class twitterTrends
    {
        private static InputStream stream;
        private static byte[] buf = new byte[1024];
        private static int curChar;
        private static int numChars;
        private static SpaceCharFilter filter;
        private static PrintWriter pw;
     
        static int MOD = 1000000007;
     
        // Driver program to test above functions
     
        public static void main(String[] args)
        {
            InputReader(System.in);
            pw = new PrintWriter(System.out);
     
            int N = nextInt();
     
            String tweets [] = nextStringLineArray(N);
     
     
            TreeMap<String, Integer> treeMap = new TreeMap<>();
     
            for (int i = 0; i <N; i++) {
                String tweetParts [] = tweets[i].split(" ");
                for (int j = 0; j <tweetParts.length; j++) {
                    String s = tweetParts[j];
                    if (s.startsWith("#")){
                        if (treeMap.containsKey(s))
                            treeMap.put(s,treeMap.get(s)+1);
                        else
                            treeMap.put(s,1);
                    }
                }
            }
     
    //        System.out.println(treeMap);
     
            ArrayList<String> list = new ArrayList<>();
     
            while(!treeMap.isEmpty()){
     
                int max = Integer.MIN_VALUE;
                String ht = "";
                for (String hs : treeMap.keySet()) {
     
                    if (treeMap.get(hs)>max){
                        max = treeMap.get(hs);
                        ht = hs;
                    }
                }
     
                treeMap.remove(ht,max);
                list.add(ht);
            }
     
            for (int i = 0; i <5; i++) {
                pw.println(list.get(i));
            }
     
            pw.flush();
            pw.close();
        }
     
     
     // Fast IO templates
     
        public static void InputReader(InputStream stream1) {
            stream = stream1;
        }
     
        private static boolean isWhitespace(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
     
        private static boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }
     
        private static int read() {
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
     
        private static int nextInt() {
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
     
        private static long nextLong() {
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
     
        private static String nextToken() {
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
     
        private static String nextLine() {
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
     
        private static int[] nextIntArray(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }
     
        private static int[][] next2dArray(int n, int m) {
            int[][] arr = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = nextInt();
                }
            }
            return arr;
        }
        private static char[][] nextCharArray(int n,int m){
            char [][]c=new char[n][m];
            for(int i=0;i<n;i++){
                String s=nextLine();
                for(int j=0;j<s.length();j++){
                    c[i][j]=s.charAt(j);
                }
            }
            return c;
        }
     
        private static long[] nextLongArray(int n) {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }
     
        private static String[] nextStringArray(int n) {
     
            String ans [] = new String[n];
            for (int i = 0; i <n; i++) {
                ans [i] = nextToken();
            }
            return ans;
        }
        private static String[] nextStringLineArray(int n) {
     
            String ans [] = new String[n];
            for (int i = 0; i <n; i++) {
                ans [i] = nextLine();
            }
            return ans;
        }
     
        private static void pArray(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                pw.print(arr[i] + " ");
            }
            pw.println();
            return;
        }
     
        private static void pArray(long[] arr) {
            for (int i = 0; i < arr.length; i++) {
                pw.print(arr[i] + " ");
            }
            pw.println();
            return;
        }
     
        private static void pArray(boolean[] arr) {
            for (int i = 0; i < arr.length; i++) {
                pw.print(arr[i] + " ");
            }
            pw.println();
            return;
        }
     
        private static boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return isWhitespace(c);
        }
     
        private interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }
