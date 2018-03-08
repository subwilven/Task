package com.example.android.task;

import android.content.Context;
import android.os.AsyncTask;

import com.example.android.task.POJO.User;

import org.json.JSONException;

import java.util.ArrayList;

/**
 * Created by eslam on 08-Mar-18.
 */

public class FetchUsersData extends AsyncTask<Void, Void, ArrayList<User>> {
    public FetchUsersData(Context context, CallBack callBack) {
        mCallBack = callBack;
        this.context = context;
    }

    private CallBack mCallBack;
    private Context context;

    public interface CallBack {
        void handleInResult(ArrayList<User> users);
    }

    @Override
    protected ArrayList<User> doInBackground(Void... voids) {
        String json = Utility.loadUsersJSONFromAsset(context);
//            StringBuilder str = new StringBuilder(json);
//            str.insert(0, "{\"recipes\":\n");
//            str.insert(str.toString().length(), "}");
//            String json2 = str.toString();
        ArrayList<User> users = null;
        try {
            users = Utility.parseUsersJson(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    protected void onPostExecute(ArrayList<User> users) {
        super.onPostExecute(users);
        if (mCallBack != null) {
            mCallBack.handleInResult(users);
        }
    }
}

