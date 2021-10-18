package lesson1;

public class Delphine implements Member {

    @Override
    public boolean canDoIt(Obstacle obstacle) {
        if (obstacle.getProperty() == "swim") {
            return true;
        }
        return false;
    }
}
