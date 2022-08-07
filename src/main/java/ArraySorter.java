import java.util.*;

public class ArraySorter {

    public static int[] boobleSorter(int[] arr){

        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length - i - 1; ++j){

                if (arr[j + 1] < arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        return arr;
    }

    void merge(int arr[], int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;


        int L[] = new int[n1];
        int R[] = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    void sort(int arr[], int l, int r)
    {
        if (l < r) {
            int m =l+ (r-l)/2;

            sort(arr, l, m);
            sort(arr, m + 1, r);

            merge(arr, l, m, r);
        }
    }

    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

        //Bucket
    public static int hash(int i, int max, int numberOfBuckets) {
        return (int) ((double) i / max * (numberOfBuckets - 1));
    }

    public static int findMax(List<Integer> input) {
        int m = Integer.MIN_VALUE;
        for (int i : input) {
            m = Math.max(i, m);
        }
        return m;
    }

    public static List nrOfBin(int[] arr){
        final int numberOfBuckets = (int) Math.sqrt(arr.length);
        List<List<Integer>> buckets = new ArrayList<>(numberOfBuckets);

        for(int i = 0; i < numberOfBuckets; i++) {
            buckets.add(new ArrayList<>());
        }

        ArrayList<Integer> initialList = new ArrayList<>();

        for (int j = 0; j < arr.length; j++){
            initialList.add(arr[j]);
        }

        int max = findMax(initialList);

        for (int i : initialList) {
            buckets.get(hash(i, max, numberOfBuckets)).add(i);
        }

        Comparator<Integer> comparator = Comparator.naturalOrder();

        for(List<Integer> bucket  : buckets){
            bucket.sort(comparator);
        }

        List<Integer> sortedArray = new LinkedList<>();

        for(List<Integer> bucket : buckets) {
            sortedArray.addAll(bucket);
        }

        return sortedArray;
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter length of the array: ");
        int len = input.nextInt();
        int choosen = 0;

        int[] arr = new int[len];
        Random r = new Random();

        for (int i = 0; i < len; i++) {
            arr[i] = r.nextInt(0, 100);
        }

        System.out.print("Sorting systems:\n1. Bubble sorter\n2. Merge sorter\n3. Bucket sorter\nEnter the number: ");

        if (input.hasNextInt()){
            choosen = input.nextInt();
            if (choosen > 3 || choosen < 0)
                System.out.println("Invalid input");
        } else {
            System.out.println("Invalid input");
        }

        System.out.print("\nInitial array is: ");
        for (int num : arr){
            System.out.print(num + " ");
        }

        if (choosen == 1) {
            System.out.print("\nThe Bobble sorted array: ");
            for (int a : boobleSorter(arr))
                System.out.print(a + " ");

        } else if (choosen == 2) {

            ArraySorter ob = new ArraySorter();
            ob.sort(arr, 0, arr.length - 1);
            System.out.print("\nThe Merge sorted array: ");
            printArray(arr);

        } else {
            System.out.print("\nThe Bucket sorted array: ");
            for (int n = 0; n < arr.length; n++){
                System.out.print(nrOfBin(arr).get(n) + " ");
            }
        }
    }
}
