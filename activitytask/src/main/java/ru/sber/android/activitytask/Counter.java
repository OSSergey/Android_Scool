package ru.sber.android.activitytask;

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
