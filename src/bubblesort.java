public class bubblesort {

        public static void main(String[] args) {
            int arr[] = {17,18,5,4,6,1};
            int n =arr.length;
            int temp =0;

            for(int i=0;i<n-1;i++){
                for(int j=i+1;j<n;j++){
                    if(arr[i]>arr[j]){
                        temp =arr[i];
                        arr[i]=arr[j];
                        arr[j]=temp;
                    }

                }
            }
            for(int y:arr){
                System.out.println(y);
            }

        }
    }

