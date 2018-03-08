package com.example.android.task;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.task.POJO.Task;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by eslam on 08-Mar-18.
 */

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private Context mContext;
    private List<Task> mTaskList;

    public TaskAdapter() {

    }

    public void setData(List<Task> tasks) {
        mTaskList = tasks;
        notifyDataSetChanged();
    }

    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_task, parent, false);
        return new TaskViewHolder(v);
    }

    @Override
    public void onBindViewHolder(TaskViewHolder holder, int position) {
        Task task = mTaskList.get(position);
        holder.setPhotoImageView(task.getPhotoUrl());
        holder.setTagTextView(task.getTag());
        holder.setPodNumberNameTextView(task.getPodNumber());
        holder.setTitleTextView(task.getTitle());
    }

    @Override
    public int getItemCount() {
        if(mTaskList!=null)
        {
            return mTaskList.size();
        }
        return 0;
    }


    public class TaskViewHolder extends RecyclerView.ViewHolder {
        final private TextView titleTextView;
        final private TextView tagTextView;
        final private TextView podNumberNameTextView;
        final private CircleImageView userImageView;

        public TaskViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.tv_task_title);
            tagTextView = itemView.findViewById(R.id.tv_tag);
            podNumberNameTextView = itemView.findViewById(R.id.tv_pod_number);
            userImageView = itemView.findViewById(R.id.iv_user_photo);
        }

        public void setTitleTextView(String text) {
            titleTextView.setText(text);
        }
        public void setTagTextView(String text) {
            tagTextView.setText(text);
        }
        public void setPodNumberNameTextView(String text) {
            podNumberNameTextView.setText(text);
        }
        public void setPhotoImageView(String url) {
            if (url != null && !url.isEmpty()) {
                Picasso.with(mContext).load(url).centerCrop().noFade().resize(175, 175)
                        .error(R.drawable.ic_account_circle_blue_24dp).into(userImageView);
            } else {
                userImageView.setImageResource(R.drawable.ic_account_circle_blue_24dp);
            }
        }
    }
}
