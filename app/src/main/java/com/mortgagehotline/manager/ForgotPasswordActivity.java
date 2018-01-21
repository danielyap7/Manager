package com.mortgagehotline.manager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ForgotPasswordActivity extends AppCompatActivity {

    WebView hwebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_Forgot);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        hwebView = (WebView) findViewById(R.id.forgotID);
        hwebView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }
        });
        hwebView.getSettings().setLoadsImagesAutomatically(true);
        hwebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        hwebView.loadUrl("https://www.apple.com/my");

    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
