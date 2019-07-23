package p32929.officeaboutlib.Activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import p32929.officeaboutlib.Adapters.AboutRecyclerviewAdapter;
import p32929.officeaboutlib.Models.Member;
import p32929.officeaboutlib.Models.OfficeInfo;
import p32929.officeaboutlib.Others.MembersListener;
import p32929.officeaboutlib.Others.OfficeAboutLoader;
import p32929.officeaboutlib.R;

public class OfficeAboutActivity extends AppCompatActivity {

    public static String jsonUrl;

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    LinearLayoutManager manager;
    SwipeRefreshLayout swipeRefreshLayout;
    ImageView imageViewOfficeLogo;
    ImageView imageViewGooglePlay, imageViewFacebook, imageViewGroup, imageViewYoutube, imageViewGithub, imageViewWeb;
    LinearLayout linearLayoutParent;

    ArrayList<Member> members = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_office_about);

        swipeRefreshLayout = findViewById(R.id.srl);
        linearLayoutParent = findViewById(R.id.parentLL);
        imageViewOfficeLogo = findViewById(R.id.officeLogoImage);

        imageViewGooglePlay = findViewById(R.id.googlePlayLogo);
        imageViewFacebook = findViewById(R.id.facebookLogo);
        imageViewGroup = findViewById(R.id.groupLogo);
        imageViewYoutube = findViewById(R.id.youtubeLogo);
        imageViewGithub = findViewById(R.id.githubLogo);
        imageViewWeb = findViewById(R.id.webLogo);

        recyclerView = findViewById(R.id.officeAboutRecyclerView);
        manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        adapter = new AboutRecyclerviewAdapter(OfficeAboutActivity.this, members);
        recyclerView.setAdapter(adapter);

        swipeRefreshLayout.setRefreshing(true);
        new OfficeAboutLoader(this, jsonUrl, new MembersListener() {
            @Override
            public void onJsonDataReceived(final OfficeInfo officeInfo) {

                members.clear();
                members.addAll(officeInfo.getMembers());
                adapter.notifyDataSetChanged();

                if (officeInfo.getOfficeLogoUrl().isEmpty()) {
                    imageViewOfficeLogo.setVisibility(View.GONE);
                } else {
                    imageViewOfficeLogo.setVisibility(View.VISIBLE);
                    Picasso.get().load(officeInfo.getOfficeLogoUrl()).into(imageViewOfficeLogo);
                }

                if (officeInfo.getOfficeLogoUrl().isEmpty()) {
                    imageViewGooglePlay.setVisibility(View.GONE);
                } else {
                    imageViewGooglePlay.setVisibility(View.VISIBLE);
                    imageViewGooglePlay.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent browse = new Intent(Intent.ACTION_VIEW, Uri.parse(officeInfo.getGooglePlayUrl()));
                            startActivity(browse);
                        }
                    });
                }

                if (officeInfo.getOfficeLogoUrl().isEmpty()) {
                    imageViewFacebook.setVisibility(View.GONE);
                } else {
                    imageViewFacebook.setVisibility(View.VISIBLE);
                    imageViewFacebook.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent browse = new Intent(Intent.ACTION_VIEW, Uri.parse(officeInfo.getFacebookUrl()));
                            startActivity(browse);
                        }
                    });
                }

                if (officeInfo.getOfficeLogoUrl().isEmpty()) {
                    imageViewGroup.setVisibility(View.GONE);
                } else {
                    imageViewGroup.setVisibility(View.VISIBLE);
                    imageViewGroup.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent browse = new Intent(Intent.ACTION_VIEW, Uri.parse(officeInfo.getGroupUrl()));
                            startActivity(browse);
                        }
                    });
                }

                if (officeInfo.getOfficeLogoUrl().isEmpty()) {
                    imageViewYoutube.setVisibility(View.GONE);
                } else {
                    imageViewYoutube.setVisibility(View.VISIBLE);
                    imageViewYoutube.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent browse = new Intent(Intent.ACTION_VIEW, Uri.parse(officeInfo.getYoutubeUrl()));
                            startActivity(browse);
                        }
                    });
                }

                if (officeInfo.getOfficeLogoUrl().isEmpty()) {
                    imageViewGithub.setVisibility(View.GONE);
                } else {
                    imageViewGithub.setVisibility(View.VISIBLE);
                    imageViewGithub.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent browse = new Intent(Intent.ACTION_VIEW, Uri.parse(officeInfo.getGithubUrl()));
                            startActivity(browse);
                        }
                    });
                }

                if (officeInfo.getOfficeLogoUrl().isEmpty()) {
                    imageViewWeb.setVisibility(View.GONE);
                } else {
                    imageViewWeb.setVisibility(View.VISIBLE);
                    imageViewWeb.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent browse = new Intent(Intent.ACTION_VIEW, Uri.parse(officeInfo.getWebUrl()));
                            startActivity(browse);
                        }
                    });
                }

                swipeRefreshLayout.setRefreshing(false);
                swipeRefreshLayout.setEnabled(false);
                linearLayoutParent.setVisibility(View.VISIBLE);
            }

            @Override
            public void onError(String error) {
                Toast.makeText(OfficeAboutActivity.this, "Error loading. Please try again later", Toast.LENGTH_LONG).show();
                finish();
            }
        }).execute();
    }
}
