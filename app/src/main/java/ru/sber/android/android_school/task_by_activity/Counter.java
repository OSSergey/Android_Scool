package ru.sber.android.android_school.task_by_activity;

public class Counter {
    private Integer count = 0;

    public void increment() {
        count++;
    }

    public void decrement() {
        count--;
    }

    public Integer getCount() {
        return count;
    }
}
