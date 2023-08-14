
import java.util.Arrays;
import java.util.Random;

public class BubbleSort {

    public static void main(String[] args) {
        // Input possitive number of array from keyboard and check validate data input
        int number = inputNumberOfArray();
        //Create random array
        int[] array = randomArray(number);
        // display array before soft
        displayBeforSort(array);
        // bubble sort
        bubbleSort(array);
        // display arry after soft
        displayAftersort(array);
    }

    // Random array
    private static int[] randomArray(int number) {
        Random random = new Random();
        int arr[] = new int[number];
        for (int i = 0; i < number; i++) {
            arr[i] = random.nextInt(arr.length);
        }
        return arr;
    }

    // input number of array
    private static int inputNumberOfArray() {
        //check valid of input number
        int PossitiveNumber = GetIn.checkInput();
        return PossitiveNumber;
    }

    // display unsorted array
    private static void displayBeforSort(int[] arr) {
        System.out.print("Unsorted array: ");
        System.out.print(Arrays.toString(arr));
    }

    // bubble sort array
    private static void bubbleSort(int[] arr) {
        //iterate through all the elements in the array
        for (int i = 0; i < arr.length; i++) {
            // browse index from first to before the index has been sorted 
            // and last element already bubble 
            for (int j = 0; j < arr.length - i - 1; j++) {
                // displayAftersort(arr); // display each step
                //If the number in front is greater than the number after, swap the places
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp; 
               }
            }
        }
    }

    // display sort array
    private static void displayAftersort(int[] arr) {
        System.out.print("\nSorted array: ");
        System.out.print(Arrays.toString(arr));
    }
}
