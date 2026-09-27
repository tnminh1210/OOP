import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a String: ");
        String input = scanner.nextLine();

        String reverse = "";

        for(int i = input.length() -1; i >=0; i--) {
            reverse += input.charAt(i);

        }
        System.out.println("The reverse of the string is: " + reverse);

        scanner.close();
    }
}