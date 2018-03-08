package com.example.android.task;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.task.POJO.User;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by eslam on 08-Mar-18.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private Context mContext;
    private List<User> mUserList;

    public UserAdapter() {

    }

    public void setData(List<User> userList) {
        mUserList = userList;
        notifyDataSetChanged();
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_user, parent, false);
        return new UserViewHolder(v);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        User user = mUserList.get(position);
        holder.setPhotoImageView(user.getPhotoUrl());
        holder.setUserNameTextView(user.getName());
    }

    @Override
    public int getItemCount() {
        if(mUserList!=null)
        {
            return mUserList.size();
        }
        return 0;
    }


    public class UserViewHolder extends RecyclerView.ViewHolder {
        final private TextView userNameTextView;
        final private CircleImageView userImageView;

        public UserViewHolder(View itemView) {
            super(itemView);
            userNameTextView = itemView.findViewById(R.id.tv_user_name);
            userImageView = itemView.findViewById(R.id.iv_user_photo);
        }

        public void setUserNameTextView(String text) {
            userNameTextView.setText(text);
        }

        public void setPhotoImageView(String url) {
            if (url != null && !url.isEmpty()) {
                Picasso.with(mContext).load(url)
                        .error(R.drawable.ic_account_circle_blue_24dp).into(userImageView);
            } else {
                userImageView.setImageResource(R.drawable.ic_account_circle_blue_24dp);
            }
        }
    }
}
