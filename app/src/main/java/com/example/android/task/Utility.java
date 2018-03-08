package com.example.android.task;

import android.content.Context;

import com.example.android.task.POJO.Task;
import com.example.android.task.POJO.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by eslam on 08-Mar-18.
 */

public class Utility {


    public static String loadUsersJSONFromAsset(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open("users.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public static String loadTasksJSONFromAsset(Context context) {
        String json = null;
        try {
            InputStream is = context.getAssets().open("tasks.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    public static ArrayList<User> parseUsersJson(String json) throws JSONException {
        ArrayList<User> users = new ArrayList<User>();

        final String USER_NAME = "name";
        final String USER_IMAGE = "image";

        JSONObject jsonObject = new JSONObject(json);
        JSONArray usersJsonArray = jsonObject.getJSONArray("users");
        for (int i = 0; i < usersJsonArray.length(); i++) {
            JSONObject userJson = usersJsonArray.getJSONObject(i);

            User user = new User();
            user.setName(userJson.getString(USER_NAME));
            user.setPhotoUrl(userJson.getString(USER_IMAGE));
            users.add(user);
        }

        return users;
    }
    public static ArrayList<Task> parseTasksJson(String json) throws JSONException {
        ArrayList<Task> tasks = new ArrayList<Task>();

        final String TASK_TITLE = "title";
        final String TASK_TAG = "tag";
        final String TASK_POD_NUMBER = "podNumber";
        final String TASK_USER_IMAGE = "photoUrl";

        JSONObject jsonObject = new JSONObject(json);
        JSONArray tasksJsonArray = jsonObject.getJSONArray("tasks");
        for (int i = 0; i < tasksJsonArray.length(); i++) {
            JSONObject taskJson = tasksJsonArray.getJSONObject(i);

            Task user = new Task();
            user.setPhotoUrl(taskJson.getString(TASK_USER_IMAGE));
            user.setPodNumber(taskJson.getString(TASK_POD_NUMBER));
            user.setTag(taskJson.getString(TASK_TAG));
            user.setTitle(taskJson.getString(TASK_TITLE));
            tasks.add(user);
        }

        return tasks;
    }


}
