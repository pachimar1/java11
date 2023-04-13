package ru.netology.javaqa.homework;

public class Epic extends Task {
    protected String[] subtasks;

    public Epic(int id, String[] subtasks) {
        super(id);
        this.subtasks = subtasks;
    }

    public String[] getSubtasks() {
        return subtasks;
    }

    public void setSubtasks(String[] subtasks) {
        this.subtasks = subtasks;
    }

    @Override
    public boolean matches(String query) {
        for (String task : subtasks) {
            if (task.contains(query)) {
                return true;
            }
        }
        return false;
    }
}
