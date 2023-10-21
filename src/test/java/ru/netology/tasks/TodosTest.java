package ru.netology.tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    SimpleTask simpleTask1 = new SimpleTask(5, "Позвонить родителям");
    SimpleTask simpleTask2 = new SimpleTask(7, "Позвонить бабушке");
    String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
    Epic epic = new Epic(55, subtasks);
    Meeting meeting = new Meeting(
            555,
            "Выкатка 3й версии приложения",
            "Приложение НетоБанка",
            "Во вторник после обеда"
    );
    Meeting meeting1 = new Meeting(
            555,
            "Позвонить дедушке",
            "Звонок",
            "Во среду после обеда"
    );


    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        Todos todos = new Todos();
        todos.add(simpleTask1);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask1, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSimpleTask() {
        Todos todos = new Todos();
        todos.add(simpleTask1);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask1};
        Task[] actual = todos.search("Позвонить родителям");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchEpic() {
        Todos todos = new Todos();
        todos.add(simpleTask1);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {epic};
        Task[] actual = todos.search("Яйца");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchMore2() {
        Todos todos = new Todos();
        todos.add(simpleTask1);
        todos.add(simpleTask2);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask1, simpleTask2};
        Task[] actual = todos.search("Позвонить");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchMore3() {
        Todos todos = new Todos();
        todos.add(simpleTask1);
        todos.add(simpleTask2);
        todos.add(epic);
        todos.add(meeting);
        todos.add(meeting1);

        Task[] expected = {simpleTask1, simpleTask2, meeting1};
        Task[] actual = todos.search("Позвонить");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void NoShouldSearch() {
        Todos todos = new Todos();
        todos.add(simpleTask1);
        todos.add(simpleTask2);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("Поздравить");
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldSearchMeeting() {
        Todos todos = new Todos();
        todos.add(simpleTask1);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search("Выкатка 3й версии приложения");
        Assertions.assertArrayEquals(expected, actual);
    }
}