package lesson1;

/*
* Добавить класс Course (полоса препятствий), в котором будут находиться:
массив препятствий;
метод, который будет просить команду пройти всю полосу.
* */
public class Course {
    private Obstacle[] obstacles;

    public Course(Obstacle[] obstacles) {
        this.obstacles = obstacles;
    }

    public void doIt(Team team){
        String[] results = new String[obstacles.length * team.getTeamMembers().length];
        int i = 0;
        for(Member member : team.getTeamMembers()){
            for(Obstacle obstacle : obstacles){
                boolean canDoIt = member.canDoIt(obstacle);
                String result = "Участник: " + member.getClass().getSimpleName() +
                        ", препятствие: " + obstacle.getClass().getSimpleName() +
                        ", результат: " + canDoIt;
                results[i] = result;
                i++;
            }
        }
        team.setResults(results);
    }

    public Obstacle[] getObstacles() {
        return obstacles;
    }
}
