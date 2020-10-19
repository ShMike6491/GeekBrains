package lesson7;

public class Plate {
    private int feed;

    public Plate(int feed) {
        this.feed = feed;
    }

    public int getFeed() {
        return feed;
    }

    public void setFeed(int amount) {
        if(amount < 0) {
            return;
        }
        feed += amount;
    }

    public int feedEaten(int amount) {
        if(amount < 0) {
            return 0;
        }
        if(amount > feed) {
            amount -= feed;
            feed = 0;
            return amount;
        }
        feed -= amount;
        return 0;
    }



    @Override
    public String toString() {
        return "Plate{" +
                "feed=" + feed +
                '}';
    }
}
