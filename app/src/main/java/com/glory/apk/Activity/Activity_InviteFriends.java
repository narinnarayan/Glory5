package com.glory.apk.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.glory.apk.R;


public class Activity_InviteFriends extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite_friends);
//        findViewById(R.id.xTvShare).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent sendIntent = new Intent();
//                sendIntent.setAction(Intent.ACTION_SEND);
//                sendIntent.putExtra(Intent.EXTRA_SUBJECT, "Glory5");
//
//                sendIntent.putExtra(
//                        Intent.EXTRA_TEXT,
//                        "Me recomemded Glory5, Online Gaming App https://glory5.in/ "
//                );
//                sendIntent.setType("text/plain");
//                startActivity(sendIntent);
////            shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID +"\n\n";
//            }
//        });
    }
}
 