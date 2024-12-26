package BM62_斐波那契数列.java_solutions;

public class IterateSolution {
    public int Fibonacci (int n) {
        if( n==1 || n==2 ){
            return 1;
        }

        int[] record = new int[n+1];
        
        record[1] = 1;
        record[2] = 1;
        
        for (int i = 3; i < record.length; i++) {
            record[i] = record[i-1] + record[i-2];
        }

        return record[n];
    }
}
