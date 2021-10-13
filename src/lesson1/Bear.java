package lesson1;

public class Bear implements Member {
    @Override
    public boolean canDoIt(Obstacle obstacle) {
        if (obstacle.getProperty() == "fly") {
            return false;
        }
        return true;
    }
}
