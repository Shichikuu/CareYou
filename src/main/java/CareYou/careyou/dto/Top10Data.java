package CareYou.careyou.dto;

public class Top10Data {
    private int id;
    private int rank;
    private String name;
    private int amount;
    private String image;

    // Constructors
    public Top10Data(int id, int rank, String name, int amount, String image) {
        this.id = id;
        this.rank = rank;
        this.name = name;
        this.amount = amount;
        this.image = image;
    }

    // Getters and setters
    // ...
}
