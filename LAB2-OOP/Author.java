public class Author {
    private String name;
    private String email;

    // Constructor
    public Author(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void display() {
        System.out.println("Author Name: " + name + ", Email: " + email);
    }
}