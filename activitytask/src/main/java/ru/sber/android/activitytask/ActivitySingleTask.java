package ru.sber.android.activitytask;

import androidx.appcompat.app.AppCompatActivity;
import android.app.ActivityManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import java.util.List;

public class ActivitySingleTask extends AppCompatActivity {
    private final String LOG_TAG = "MY_LOG";
    private static final Counter mCounter = new Counter();
    ActivityManager mActivityManager;
    List<ActivityManager.RunningTaskInfo> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buttons);
        mActivityManager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        mCounter.increment();

        TextView textView = findViewById(R.id.textView);
        textView.setText(String.format("ActivitySingleTask number: %d", mCounter.getCount()));
        findViewById(R.id.btn_standard).setOnClickListener(v -> startStandard());
        findViewById(R.id.btn_single_task).setOnClickListener(v -> startSingleTask());
        findViewById(R.id.btn_single_top).setOnClickListener(v -> startSingleTop());
        findViewById(R.id.btn_single_instance).setOnClickListener(v -> startSingleInstance());
        findViewById(R.id.btn_info).setOnClickListener(v -> infoTask());
    }

    private void startStandard() {
        startActivity(new Intent(this, ActivityStandard.class));
    }

    private void startSingleTask() {
        startActivity(new Intent(this, ActivitySingleTask.class));
    }

    private void startSingleTop() {
        startActivity(new Intent(this, ActivitySingleTop.class));
    }

    private void startSingleInstance() {
        startActivity(new Intent(this, ActivitySingleInstance.class));
    }

    //todo надо было сделать ведение счетчика через intent (putExtra/getExtra), но не догнал, как это сделать т.к. intent создается заново.
    public void infoTask() {
        List<ActivityManager.AppTask> tasks = mActivityManager.getAppTasks();

        for (ActivityManager.AppTask task : tasks) {
            if (task.getTaskInfo().baseActivity.flattenToShortString().startsWith("ru.sber.android.android_school")) {
                Log.i(LOG_TAG, "------------------------------------------");
                Log.i(LOG_TAG, "Count: " + task.getTaskInfo().numActivities);
                Log.i(LOG_TAG, "Root: " + task.getTaskInfo().baseActivity.getShortClassName());
                Log.i(LOG_TAG, "Top: " + task.getTaskInfo().topActivity.getShortClassName());
                Log.i(LOG_TAG, "ActivitySingleTask number: " + mCounter.getCount());
                Log.i(LOG_TAG, "------------------------------------------");
            }
        }
    }
}