public class MinimumOperationstoMakeArrayEqual_1551 {
    public static void main(String[] args) {
            System.out.println(new MinimumOperationstoMakeArrayEqual_1551().minOperations(3));

        }

    public int minOperations(int n) {
        int arr[] = new int[n];
        int count = 0;

        for(int i = 0; i < n; i++){
            arr[i] = (2*i)+1;
            for(int j = arr[i]; j < n; j++){
                arr[i] += 1;
                arr[n-1] -= 1;
                count++;
            }
        }

            return count;
        }
    }


