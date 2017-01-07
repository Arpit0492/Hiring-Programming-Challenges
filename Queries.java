import java.io.*;
import java.util.*;

public class Queries {


    public static void main(String[] args) {
        MyScanner scan = new MyScanner();
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out), true);

        int N = scan.nextInt();
        for (int i = 0; i <N; i++) {
            int A = scan.nextInt();

            ArrayList<Integer> subSpecial = getSubSpecialSummation(A);


            for (int j = A+1; ; j++) {
                ArrayList<Integer> nextList = getSubSpecialSummation(j);

                if (nextList.containsAll(subSpecial)) {
                    out.println(j);
                    break;
                }

            }

        }

        out.flush();
        out.close();


    }

    private static ArrayList<Integer> getSubSpecialSummation(int A) {
        int val;
        ArrayList<Integer> list = new ArrayList<>();
        while (A!=0){
            val=getPreviousPowerOfTwo(A);
            A-=val;
            list.add(val);
        }

        return list;
    }

    private static int getPreviousPowerOfTwo(int size)
    {
        int n = -1;
        while (size >> ++n > 0);
        return 1 << n - 1;
    }

}

class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
