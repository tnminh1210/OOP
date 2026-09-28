import java.util.Scanner;

public class BristlebackDamage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        double[] thoiDiem = new double[n];
        String[] parts = scanner.nextLine().trim().split("\\s+");
        for (int i = 0; i < n; i++) {
            thoiDiem[i] = Double.parseDouble(parts[i]);
        }
        double x = Double.parseDouble(scanner.nextLine().trim());
        double y = Double.parseDouble(scanner.nextLine().trim());
        double z = Double.parseDouble(scanner.nextLine().trim());
        double[] gaiConSong = new double[n];
        int dauMang = 0;
        int cuoiMang = 0;
        int soGaiConSong = 0; 
        double tongSatThuong = 0;
        for (int i = 0; i < n; i++) {
            double t = thoiDiem[i];
            while (soGaiConSong > 0 && (t - gaiConSong[dauMang]) > z) {
                dauMang++;
                soGaiConSong--;
            }
            double satThuongLanNay = x + y * soGaiConSong;
            tongSatThuong = tongSatThuong + satThuongLanNay;
            gaiConSong[cuoiMang] = t;
            cuoiMang++;
            soGaiConSong++;
        }
        System.out.println(tongSatThuong);
        scanner.close();
    }
}