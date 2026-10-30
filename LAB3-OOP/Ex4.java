import java.util.ArrayList;
import java.util.List;

abstract class Singer {
    private String fullName;
    private int yearsOfExperience;
    private int albumsSold;
    private int performances;

    public Singer(String fullName, int yearsOfExperience, int albumsSold, int performances) {
        this.fullName = fullName;
        this.yearsOfExperience = yearsOfExperience;
        this.albumsSold = albumsSold;
        this.performances = performances;
    }

    public String getFullName() { return fullName; }
    public int getYearsOfExperience() { return yearsOfExperience; }
    public int getAlbumsSold() { return albumsSold; }
    public int getPerformances() { return performances; }

    public abstract double calculateSalary();
}

class RegularSinger extends Singer {
    public RegularSinger(String fullName, int yearsOfExperience, int albumsSold, int performances) {
        super(fullName, yearsOfExperience, albumsSold, performances);
    }

    @Override
    public double calculateSalary() {
        return 3000000 + 500000 * getYearsOfExperience() + 1000 * getAlbumsSold() + 200000 * getPerformances();
    }
}

class FamousSinger extends Singer {
    private int gameShows;

    public FamousSinger(String fullName, int yearsOfExperience, int albumsSold, int performances, int gameShows) {
        super(fullName, yearsOfExperience, albumsSold, performances);
        this.gameShows = gameShows;
    }

    public int getGameShows() { return gameShows; }

    @Override
    public double calculateSalary() {
        return 5000000 + 500000 * getYearsOfExperience() + 1200 * getAlbumsSold() 
               + 500000 * getPerformances() + 500000 * gameShows;
    }
}

class Exercise4Test {
    public static void main(String[] args) {
        List<Singer> singers = new ArrayList<>();
        singers.add(new RegularSinger("Singer One", 2, 1000, 5));
        singers.add(new FamousSinger("Singer Two", 5, 5000, 10, 3));

        Singer highestPaid = singers.get(0);
        for (Singer s : singers) {
            System.out.println("Ca si: " + s.getFullName() + " - Luong: " + s.calculateSalary() + " VND");
            if (s.calculateSalary() > highestPaid.calculateSalary()) {
                highestPaid = s;
            }
        }

        System.out.println("--> Ca si co luong cao nhat: " + highestPaid.getFullName() + " với " + highestPaid.calculateSalary() + " VND");
    }
}