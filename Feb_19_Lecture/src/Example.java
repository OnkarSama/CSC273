public class Example {

    public static void main(String[] args) {

        long n = 1000000;  // compute the sum of the consecutive integers from 1 to n

        // Algorithm A
        long sum = 0;

        for(long i = 1; i <= n; i++) {
            sum += i;
        }

        System.out.println("Algorithm A: " + sum);

        // Algorithm B

        sum = 0;

        for(long i = 1; i <= n; i ++) {
            for(long j = 1; j<= i; j++) {
                sum++;
            }
        }

        System.out.println("Algorithm B: " + sum);

        // Algorithm C

        sum = n*(n+1)/2;

        System.out.println("Algorithm C: " + sum);


    }
}
