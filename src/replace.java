import java.util.Arrays;

public class replace {
    public static void main(String[] arr){
        int aarr []={17,18,5,4,6,1};
        int n =aarr.length;
        int swap=-1;

        for(int i=n-1;i>=0;i--) {
            int current = aarr[i];
            aarr[i] = swap;


            swap = Math.max(swap, current);


        }
        System.out.println(Arrays.toString(aarr));

    }
}

