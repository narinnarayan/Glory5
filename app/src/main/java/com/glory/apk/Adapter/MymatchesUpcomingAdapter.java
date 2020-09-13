package com.glory.apk.Adapter;

import android.content.Context;
import android.net.Uri;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.glory.apk.Model.MyMatchesUpComing.MyMatchesUpComingDatum;
import com.glory.apk.R;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MymatchesUpcomingAdapter extends RecyclerView.Adapter<MymatchesUpcomingAdapter.FilterViewHolder> {

    String qty;
    String sub_category_id;
    private Context mCtx;
    //we are storing all the products in a list
    private List<MyMatchesUpComingDatum> courses_offered_list;
    private MymatchesUpcomingAdapter.OnItemClickcourses mCallback1;


    public MymatchesUpcomingAdapter(Context activity, List<MyMatchesUpComingDatum> data, MymatchesUpcomingAdapter.OnItemClickcourses mCallback1) {
        this.mCtx = activity;
        this.courses_offered_list = data;
        this.mCallback1 = mCallback1;
    }

    @Override
    public MymatchesUpcomingAdapter.FilterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.item_update_matches, parent, false);
        return new FilterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MymatchesUpcomingAdapter.FilterViewHolder holder, final int position) {

        final MyMatchesUpComingDatum follow = courses_offered_list.get(position);

//        holder.xTvTitle.setText(follow.getMyMatchesUpComingSeries().getName()+follow.getName());

        if (follow.getSeason_name() != (null)) {
//            holder.xTvTitle.setText(follow.getSeries().getName()+follow.getName());
            holder.xTvTitle.setText(follow.getSeason_name());
        } else {

        }

        holder.xTvHomeTeam.setText(follow.getMyMatchesUpComingHometeam().getShortName());
        holder.xTvOppositeTeamName.setText(follow.getMyMatchesUpComingAwayteam().getShortName());
        if (follow.getMyMatchesUpComingDatetime().getTime_left() != null) {
            holder.xTvTime.setText(follow.getMyMatchesUpComingDatetime().getTime_left() + " left");
        }
        if (follow.getMyMatchesUpComingDatetime().getTime_left() != null) {


            if (holder.timer != null) {
                holder.timer.cancel();
            }
            holder.timer = new CountDownTimer(Integer.parseInt(follow.getMyMatchesUpComingDatetime().getSeconds()) * 1000, 1000) {
                public void onTick(long millisUntilFinished) {
                    long millis = millisUntilFinished;
                    //Convert milliseconds into hour,minute and seconds
                    String hms = String.format("%02dh %02dm %02ds left", TimeUnit.MILLISECONDS.toHours(millis), TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)), TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
                    holder.xTvTime.setText(hms);//set text
                }

                public void onFinish() {

//                        countdownTimerText.setText("TIME'S UP!!"); //On finish change timer text
//                        countDownTimer = null;//set CountDownTimer to null
//                        startTimer.setText(getString(R.string.start_timer));//Change button text
                }
            }.start();


        } else
            holder.xTvTime.setText(follow.getMyMatchesUpComingDatetime().getTime_left() + " left");

        if (follow.getCmsMatchAssociatedType() != (null)) {
//            holder.xTvTitle.setText(follow.getSeries().getName()+follow.getName());

            if (follow.getCmsMatchAssociatedType().equalsIgnoreCase("t10")) {
                holder.xTvMatchType.setText("T10");

            } else if (follow.getCmsMatchAssociatedType().equalsIgnoreCase("t20")) {
                holder.xTvMatchType.setText("T20");

            } else if (follow.getCmsMatchAssociatedType().equalsIgnoreCase("test")) {
                holder.xTvMatchType.setText("TEST");

            } else if (follow.getCmsMatchAssociatedType().equalsIgnoreCase("one-day")) {
                holder.xTvMatchType.setText("ODI");

            } else {
                holder.xTvMatchType.setVisibility(View.INVISIBLE);
            }

        } else {
            holder.xTvMatchType.setVisibility(View.INVISIBLE);
        }


        String erfgerfg = follow.getMyMatchesUpComingHometeam().getLogoUrl();
        if (follow.getMyMatchesUpComingHometeam().getLogoUrl() == null || follow.getMyMatchesUpComingHometeam().getLogoUrl().length() == 0) {
            Glide.with(mCtx)
                    .load(Uri.parse(String.valueOf(R.drawable.default_team_logo))
                    )
                    .error(R.drawable.default_team_logo)
                    .into(holder.xIvHomeTeam);
        } else {

            Glide.with(mCtx)
                    .load(Uri.parse(follow.getMyMatchesUpComingHometeam().getLogoUrl()))
                    .error(R.drawable.default_team_logo)
                    .into(holder.xIvHomeTeam);
        }

        if (follow.getMyMatchesUpComingAwayteam().getLogoUrl() == null || follow.getMyMatchesUpComingAwayteam().getLogoUrl().length() == 0) {
            Glide.with(mCtx)
                    .load(Uri.parse(String.valueOf(R.drawable.default_team_logo)))
                    .error(R.drawable.default_team_logo)
                    .into(holder.xIvOppsiteTeam);

        } else {

            Glide.with(mCtx)
                    .load(Uri.parse(follow.getMyMatchesUpComingAwayteam().getLogoUrl()))
                    .error(R.drawable.default_team_logo)
                    .into(holder.xIvOppsiteTeam);
        }

        holder.card_view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mCallback1 != null) {
                    mCallback1.OnItemClickcourses(position);
                }


            }
        });


    }

    @Override
    public int getItemCount() {
        return courses_offered_list.size();
    }

    public interface OnItemClickcourses {
        void OnItemClickcourses(int pos);
    }

    public class FilterViewHolder extends RecyclerView.ViewHolder {

        TextView xTvTitle;
        TextView xTvHomeTeam, xTvOppositeTeamName, xTvTime, xTvMatchType;
        ImageView xIvHomeTeam, xIvOppsiteTeam;
        CardView card_view1;
        CountDownTimer timer;

        public FilterViewHolder(View itemView) {
            super(itemView);
            xTvTitle = itemView.findViewById(R.id.xTvTitle);
            xTvHomeTeam = itemView.findViewById(R.id.xTvHomeTeam);
            xTvOppositeTeamName = itemView.findViewById(R.id.xTvOppositeTeamName);
            xTvTime = itemView.findViewById(R.id.xTvTime);
            card_view1 = itemView.findViewById(R.id.card_view1);

            xIvHomeTeam = itemView.findViewById(R.id.xIvHomeTeam);
            xIvOppsiteTeam = itemView.findViewById(R.id.xIvOppsiteTeam);
            xTvMatchType = itemView.findViewById(R.id.xTvMatchType);

        }
    }
}