import java.util.Scanner;

public class Ex7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the first sorted array (n): ");
        int n = scanner.nextInt();
        int[] arr1 = new int[n];
        System.out.println("Enter " + n + " integers for the first sorted array:");
        for (int i = 0; i < n; i++) {
            arr1[i] = scanner.nextInt();
        }
        System.out.print("Enter the number of elements in the second sorted array (m): ");
        int m = scanner.nextInt();
        int[] arr2 = new int[m];
        System.out.println("Enter " + m + " integers for the second sorted array:");
        for (int i = 0; i < m; i++) {
            arr2[i] = scanner.nextInt();
        }
        int[] mergedArray = new int[n + m];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) {
                mergedArray[k++] = arr1[i++];
            } else {
                mergedArray[k++] = arr2[j++];
            }
        }

        while (i < n) {
            mergedArray[k++] = arr1[i++];
        }

        while (j < m) {
            mergedArray[k++] = arr2[j++];
        }

        System.out.println("The merged sorted array is:");
        for (int num : mergedArray) {
            System.out.print(num + " ");
        }
        System.out.println();

        scanner.close();
    }
}