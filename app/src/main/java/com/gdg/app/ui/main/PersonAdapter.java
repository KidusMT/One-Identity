package com.gdg.app.ui.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.gdg.app.R;
import com.gdg.app.data.db.model.person.Person;
import com.gdg.app.ui.base.BaseViewHolder;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PersonAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private List<Person> posts;
    private CallBack mCallback;
//    private MeasurementCallback mMeasurementCallback;

    public PersonAdapter(List<Person> posts) {
        this.posts = posts;
    }

    @NonNull
    @Override
    public SensorViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.card_posts, viewGroup, false);
        return new SensorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder sensorViewHolder, int i) {
        sensorViewHolder.onBind(i);
    }

    public void addItems(List<Person> sensors) {
        this.posts.clear();
        this.posts.addAll(sensors);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public void setCallback(CallBack callback) {
        mCallback = callback;
    }

    public class SensorViewHolder extends BaseViewHolder {

//        @BindView(R.id.card_post_vote_count)
//        TextView mPostVoteCount;
//
//        @BindView(R.id.card_post_btn_vote_up)
//        ImageView btnVoteUp;

        Person post;

        public SensorViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        @Override
        public void onBind(int position) {
            super.onBind(position);

            if (posts != null) {
                post = posts.get(position);

            } else {
                // todo find a better way of handling this condition
            }
            itemView.setOnClickListener(v -> mCallback.onItemClicked(posts.get(getAdapterPosition())));
        }

        @Override
        protected void clear() {
//            mPostTitle.setText("");
//            mPostDate.setText("");
//            mPostDescription.setText("");
//            mPostVoteCount.setText("");
        }
    }
}
