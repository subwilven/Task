package com.example.android.task;

import android.content.Context;
import android.os.AsyncTask;

import com.example.android.task.POJO.Task;

import org.json.JSONException;

import java.util.ArrayList;

/**
 * Created by eslam on 08-Mar-18.
 */

public class FetchTaskData extends AsyncTask<Void, Void, ArrayList<Task>> {
    public FetchTaskData(Context context, CallBack callBack) {
        mCallBack = callBack;
        this.context = context;
    }

    private CallBack mCallBack;
    private Context context;

    public interface CallBack {
        void handleInResult(ArrayList<Task> tasks);
    }

    @Override
    protected ArrayList<Task> doInBackground(Void... voids) {
        String json = Utility.loadTasksJSONFromAsset(context);
        ArrayList<Task> tasks = null;
        try {
            tasks = Utility.parseTasksJson(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    @Override
    protected void onPostExecute(ArrayList<Task> tasks) {
        super.onPostExecute(tasks);
        if (mCallBack != null) {
            mCallBack.handleInResult(tasks);
        }
    }
}

