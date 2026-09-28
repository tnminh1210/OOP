import java.util.Scanner;

public class BristlebackDamage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Đọc số lần bị trúng chiêu
        int n = Integer.parseInt(scanner.nextLine().trim());

        // Đọc mảng thời điểm bị trúng
        double[] thoiDiem = new double[n];
        String[] parts = scanner.nextLine().trim().split("\\s+");
        for (int i = 0; i < n; i++) {
            thoiDiem[i] = Double.parseDouble(parts[i]);
        }

        // Đọc x, y, z
        double x = Double.parseDouble(scanner.nextLine().trim()); // sát thương gốc
        double y = Double.parseDouble(scanner.nextLine().trim()); // sát thương cộng thêm mỗi gai
        double z = Double.parseDouble(scanner.nextLine().trim()); // thời gian tồn tại của gai

        // Mảng lưu thời điểm cắm của các gai còn sống
        double[] gaiConSong = new double[n];
        int dauMang = 0;      // vị trí gai cũ nhất còn sống trong mảng
        int cuoiMang = 0;     // vị trí trống tiếp theo để thêm gai mới
        int soGaiConSong = 0; // đếm số gai hiện đang tồn tại

        double tongSatThuong = 0;

        for (int i = 0; i < n; i++) {
            double t = thoiDiem[i];

            // Bước 1: Loại bỏ các gai đã hết hạn (đi từ đầu mảng)
            while (soGaiConSong > 0 && (t - gaiConSong[dauMang]) > z) {
                dauMang++;
                soGaiConSong--;
            }

            // Bước 2: Tính sát thương lần này
            double satThuongLanNay = x + y * soGaiConSong;
            tongSatThuong = tongSatThuong + satThuongLanNay;

            // Bước 3: Thêm gai mới vào cuối mảng
            gaiConSong[cuoiMang] = t;
            cuoiMang++;
            soGaiConSong++;
        }

        System.out.println(tongSatThuong);
        scanner.close();
    }
}