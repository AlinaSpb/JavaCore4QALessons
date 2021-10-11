package lesson1;

import java.util.Arrays;

/*
* Добавить класс Team, который будет содержать:
название команды;
массив из четырех участников — в конструкторе можно сразу всех участников указывать);
метод для вывода информации о членах команды, прошедших дистанцию;
метод вывода информации обо всех членах команды.
* */
public class Team {
    private String teamName;
    private Member[] teamMembers;
    private String[] results;

    public Team(String teamName, Member[] teamMembers) {
        this.teamName = teamName;
        this.teamMembers = teamMembers;
    }

    public void showResults() {
        System.out.println("Команда: " + teamName + " результаты: \n" + Arrays.toString(results));
    }

    public Member[] getTeamMembers(){
        return teamMembers;
    }

    public void setResults(String[] results) {
        this.results = results;
    }

}
