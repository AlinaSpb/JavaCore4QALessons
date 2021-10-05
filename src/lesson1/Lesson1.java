package lesson1;

public class Lesson1 {
    public static void main(String[] args) {
        Course c = new Course(new Obstacle[]{new Fly(), new Run(), new Swim()}); // Создаем полосу препятствий
        Team team = new Team("команда мечты!",
                new Member[]{new Bear(), new Crow(), new Snake(), new Delphine()}); // Создаем команду
        c.doIt(team); // Просим команду пройти полосу
        team.showResults(); // Показываем результат
    }
}
