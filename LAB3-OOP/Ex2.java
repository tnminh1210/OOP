import java.util.ArrayList;
import java.util.List;

abstract class Ticket {
    private String ticketId;
    private String holderName;
    private int birthYear;
    private int gamesPlayed;

    public Ticket(String ticketId, String holderName, int birthYear, int gamesPlayed) {
        this.ticketId = ticketId;
        this.holderName = holderName;
        this.birthYear = birthYear;
        this.gamesPlayed = gamesPlayed;
    }

    // Bổ sung các getter để tránh cảnh báo biến private không được sử dụng
    public String getTicketId() { return ticketId; }
    public String getHolderName() { return holderName; }
    public int getBirthYear() { return birthYear; }
    public int getGamesPlayed() { return gamesPlayed; }

    public abstract double calculatePrice();
}

class FullPackageTicket extends Ticket {
    public FullPackageTicket(String ticketId, String holderName, int birthYear) {
        super(ticketId, holderName, birthYear, 30);
    }

    @Override
    public double calculatePrice() {
        return 200000.0;
    }
}

class PartialTicket extends Ticket {
    public PartialTicket(String ticketId, String holderName, int birthYear, int gamesPlayed) {
        super(ticketId, holderName, birthYear, gamesPlayed);
    }

    @Override
    public double calculatePrice() {
        return 70000.0 + 20000.0 * getGamesPlayed();
    }
}

class Exercise2Test {
    public static void main(String[] args) {
        List<Ticket> tickets = new ArrayList<>();
        tickets.add(new FullPackageTicket("T01", "Alex", 2000));
        tickets.add(new PartialTicket("T02", "Bob", 2002, 4));

        double totalRevenue = 0;
        int partialCount = 0;

        for (Ticket t : tickets) {
            totalRevenue += t.calculatePrice();
            if (t instanceof PartialTicket) {
                partialCount++;
            }
        }

        System.out.println("Tong doanh thu: " + totalRevenue + " VND");
        System.out.println("So luong ve phan (Partial Ticket) da ban: " + partialCount);
    }
}