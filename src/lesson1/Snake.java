package lesson1;

public class Snake implements Member {
    private final static String PROPERTY = "crawl";

    @Override
    public boolean canDoIt(Obstacle obstacle) {
        if (obstacle.getProperty().equals(PROPERTY)) {
            return true;
        }
        return false;
    }
}
