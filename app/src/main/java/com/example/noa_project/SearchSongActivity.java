package com.example.noa_project;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class SearchSongActivity extends AppCompatActivity {

    private WebView webView;
    private YouTubeApi youTubeApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_search_song);
        // api ket-AIzaSyDgdNk-_oFP_Mlb354bTPWqmpL0GBcavHU




            EditText searchEditText = findViewById(R.id.searchEditText);
            Button searchButton = findViewById(R.id.searchButton);
            webView = findViewById(R.id.webView);

            WebSettings webSettings = webView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            webView.setWebViewClient(new WebViewClient());

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://www.googleapis.com/youtube/v3/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            youTubeApi = retrofit.create(YouTubeApi.class);

            searchButton.setOnClickListener(v -> {
                String query = searchEditText.getText().toString();
                if (!query.isEmpty()) {
                    searchYouTube(query);
                } else {
                    Toast.makeText(this, "Enter a song name", Toast.LENGTH_SHORT).show();
                }
            });
        }

        private void searchYouTube (String query){
            String apiKey = "AIzaSyDgdNk-_oFP_Mlb354bTPWqmpL0GBcavHU"; // הכניסי כאן את מפתח ה-API שלך
            youTubeApi.searchVideos("snippet", query, "video", apiKey, 1)
                    .enqueue(new Callback<YouTubeResponse>() {
                        @Override
                        public void onResponse(Call<YouTubeResponse> call, Response<YouTubeResponse> response) {
                            if (response.isSuccessful() && response.body() != null) {
                                if (response.body().items != null && !response.body().items.isEmpty()) {
                                    String videoId = response.body().items.get(0).id.videoId;
                                    webView.getSettings().setMediaPlaybackRequiresUserGesture(false);
                                    String videoUrl = "https://www.youtube.com/embed/" + videoId;
                                    String youtubeVideoEmbed = "<html><body>" +
                                            "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/" + videoId + "\" frameborder=\"0\" allowfullscreen></iframe>" +
                                            "</body></html>";

                                    // הטמעת הסרטון ב-WebView
                                    webView.loadData(youtubeVideoEmbed, "text/html", "UTF-8");

                                    // videoUrl = "https://www.youtube.com/watch?v=HXxd_DW0k1Y";
                                    // webView.loadUrl(videoUrl);
                                    //webView.
                                    //String youtubeVideoEmbed = "<html><body>" +
                                    //      "<iframe width=\"100%\" height=\"100%\" src=\"videoId\" frameborder=\"0\" allowfullscreen></iframe>" +
                                    //    "</body></html>";
                                    //webView.loadData(youtubeVideoEmbed, "text/html", "UTF-8");
                                } else {
                                    Toast.makeText(SearchSongActivity.this, "No results found", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(SearchSongActivity.this, "Error: " + response.code(), Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<YouTubeResponse> call, Throwable t) {
                            Toast.makeText(SearchSongActivity.this,"Failed: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
        }

        private void AddToPlaylist()
        {

        }



}
