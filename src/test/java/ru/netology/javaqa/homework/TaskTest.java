package ru.netology.javaqa.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {
    @Test
    public void testSimpleTaskMatches() {
        Task simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean expected = true;
        boolean actual = simpleTask.matches("Позвонить");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testSimpleTaskNonMatches() {
        Task simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean expected = false;
        boolean actual = simpleTask.matches("Приехать");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testEpicMatches() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Task epic = new Epic(55, subtasks);

        boolean expected = true;
        boolean actual = epic.matches("Яйца");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testEpicNonMatches() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Task epic = new Epic(55, subtasks);

        boolean expected = false;
        boolean actual = epic.matches("Масло");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMeetingMatches() {
        Task meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean expected = true;
        boolean actual = meeting.matches("Приложение");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMeetingNonMatches() {
        Task meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean expected = false;
        boolean actual = meeting.matches("Нетология");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testEqualsFalse() {
        Task task = new Task(1);

        boolean expected = false;
        boolean actual = task.equals(new Object());
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testNotEquals() {
        Task task1 = new Task(55);
        Task task2 = new Task(55);
        Task task3 = new Task(60);

        boolean expected = false;
        boolean actual = task1.equals(task3);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testEqualsOne() {
        Task task1 = new Task(55);
        Task task2 = new Task(55);
        Task task3 = new Task(60);

        boolean expected = true;
        boolean actual = task1.equals(task1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testEqualsTwo() {
        Task task1 = new Task(55);
        Task task2 = new Task(55);
        Task task3 = new Task(60);

        boolean expected = true;
        boolean actual = task1.equals(task2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testEqualsNull() {
        Task task1 = new Task(55);
        Task task2 = new Task(55);
        Task task3 = new Task(60);

        boolean expected = false;
        boolean actual = task1.equals(null);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testTaskMatches() {
        Task task = new Task(555);

        boolean expected = false;
        boolean actual = task.matches("551");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testMeetingMatchesTopic() {
        Task meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        boolean expected = true;
        boolean actual = meeting.matches("Выкатка");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testShouldId() {
        Task id = new Task(555);

        int expected = 555;
        int actual = id.getId();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testShouldHashCode() {
        Task code = new Task(510);

        int expected = 541;
        int actual = code.hashCode();
        Assertions.assertEquals(expected, actual);
    }
}
