package lesson1;

public class Crow implements Member {
    @Override
    public boolean canDoIt(Obstacle obstacle) {
        if (obstacle.getProperty() == "fly") {
            return true;
        }
        return false;
    }
}
