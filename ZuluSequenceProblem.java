
//https://www.hackerearth.com/challenge/competitive/may-circuits-17/algorithm/zulu-encounters-a-sequence-problem/


class ZuluSequenceProblem{
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
        fastIO fs = new fastIO();
        fs.InputReader(System.in);
        fs.pw = new PrintWriter(new OutputStreamWriter(System.out));
        int T = fs.nextInt();
        for (int t = 0; t <T; t++) {
            int N = fs.nextInt();
            long [] A = new long[N];

            for (int j = 0; j <N; j++) {
                A[j] = fs.nextInt();
            }


            /**
             * 1 1 4 4 2 -1 5 5 3 9
             */

            int l_incr [] = new int[N];
            int l_decr [] = new int[N];
            int L [] = new int[N];
            l_incr[0]=0;
            l_decr[0]=0;
            for (int i = 1; i <N; i++) {
                if (A[i]<=A[i-1]){
                    l_incr[i] = l_incr[i-1];
                }
                else {
                    l_incr[i]=i;
                }
            }
            for (int i = 1; i <N; i++) {
                if (A[i]>=A[i-1]){
                    l_decr[i] = l_decr[i-1];
                }
                else {
                    l_decr[i]=i;
                }
            }

            for (int i = 0; i <N; i++) {
                L[i] = Math.min(l_incr[i],l_decr[i]);
            }

//            for (int l : L) {
//                System.out.printf(l+" ");
//            }
            /**
             * 1 1 4 4 2 -1 5 5 3 9
             */
            int r_incr [] = new int[N];
            int r_decr [] = new int[N];
            int R [] = new int[N];
            r_incr[N-1]=N-1;
            r_decr[N-1]=N-1;
            for (int i = N-2; i >=0; i--) {
                if (A[i]<=A[i+1]){
                    r_incr[i] = r_incr[i+1];
                }
                else{
                    r_incr[i]=i;
                }
            }
            for (int i = N-2; i >=0 ; i--) {
                if (A[i]>=A[i+1]){
                    r_decr[i]=r_decr[i+1];
                }
                else{
                    r_decr[i]=i;
                }
            }

            for (int i = 0; i <N; i++) {
                R[i] = Math.max(r_incr[i],r_decr[i]);
            }

//            System.out.println();
//            for (int r : R) {
//                System.out.printf(r+" ");
//            }

            long ans = Long.MIN_VALUE;
            for (int i = 0; i <N; i++) {
                long val = Math.max(Math.abs(A[i]-A[L[i]]),Math.abs(A[i]-A[R[i]]));
                ans = Math.max(ans,val);
            }

            fs.pw.println(ans);

        }

        fs.pw.flush();
        fs.pw.close();

    }
}
