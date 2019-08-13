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
import p32929.officeaboutlib.Others.GlobalMethods;
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

                Picasso.get().load(officeInfo.getOfficeLogoUrl()).into(imageViewOfficeLogo);

                imageViewGooglePlay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (GlobalMethods.isAvailable(officeInfo.getGooglePlayUrl())) {
                            Intent browse = new Intent(Intent.ACTION_VIEW, Uri.parse(officeInfo.getGooglePlayUrl()));
                            startActivity(browse);
                        } else {
                            Toast.makeText(OfficeAboutActivity.this, "URL is not provided yet", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                imageViewFacebook.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (GlobalMethods.isAvailable(officeInfo.getFacebookPageUrl())) {
                            startActivity(GlobalMethods.getFacebookPageIntent(OfficeAboutActivity.this, officeInfo));
                        } else {
                            Toast.makeText(OfficeAboutActivity.this, "URL is not provided yet", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                imageViewGroup.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (GlobalMethods.isAvailable(officeInfo.getGroupUrl())) {
                            Intent browse = new Intent(Intent.ACTION_VIEW, Uri.parse(officeInfo.getGroupUrl()));
                            startActivity(browse);
                        } else {
                            Toast.makeText(OfficeAboutActivity.this, "URL is not provided yet", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                imageViewYoutube.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (GlobalMethods.isAvailable(officeInfo.getYoutubeUrl())) {
                            Intent browse = new Intent(Intent.ACTION_VIEW, Uri.parse(officeInfo.getYoutubeUrl()));
                            startActivity(browse);
                        } else {
                            Toast.makeText(OfficeAboutActivity.this, "URL is not provided yet", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                imageViewGithub.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (GlobalMethods.isAvailable(officeInfo.getGithubUrl())) {
                            Intent browse = new Intent(Intent.ACTION_VIEW, Uri.parse(officeInfo.getGithubUrl()));
                            startActivity(browse);
                        } else {
                            Toast.makeText(OfficeAboutActivity.this, "URL is not provided yet", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                imageViewWeb.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (GlobalMethods.isAvailable(officeInfo.getWebUrl())) {
                            Intent browse = new Intent(Intent.ACTION_VIEW, Uri.parse(officeInfo.getWebUrl()));
                            startActivity(browse);
                        } else {
                            Toast.makeText(OfficeAboutActivity.this, "URL is not provided yet", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


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
