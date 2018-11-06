package leetcodecn;

public class isPowerOfTwo {
    public static void main(String[] args) {
        System.out.println(new isPowerOfTwo().isPowerOfTwo(127));
    }


    public boolean isPowerOfTwo(int n) {
        if(n == 0){
            return false;
        }

        if( n == 1){
            return true;
        }

        if(n % 2  == 1)
            return false;

        else{
            return isPowerOfTwo(n/2);
        }
    }
}
