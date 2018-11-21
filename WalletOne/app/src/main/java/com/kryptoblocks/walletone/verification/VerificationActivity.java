package com.kryptoblocks.walletone.verification;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.kryptoblocks.walletone.R;
import com.kryptoblocks.walletone.verification.failure.VerificationFailedActivity;
import com.kryptoblocks.walletone.verification.success.VerificationSuccessfulActivity;
import com.twilio.verification.external.Via;

public class VerificationActivity extends BaseVerificationActivity {

    // UI
    private Button verifyButton;
    private View progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);
    }

    @Override
    public void updateView(VerificationUIModel verificationUIModel) {

        VerificationUIModel.State currentState = verificationUIModel.getCurrentState();

        switch (currentState) {
            case IN_PROGRESS:
                enablePhoneField(false);
                showProgressBar(true);
                break;
            case ERROR:
                enablePhoneField(true);
                showProgressBar(false);
                startActivity(VerificationFailedActivity
                    .getVerificationFailedIntent(this, phoneNumber.getText().toString()));
                break;
            case SUCCESS:
                enablePhoneField(true);
                showProgressBar(false);
                startActivity(VerificationSuccessfulActivity.getIntent(this));
                break;
        }
    }

    @Override
    protected void initViews() {
        verifyButton = (Button) findViewById(R.id.verify_button);
        progressBar = findViewById(R.id.progress_bar);

        verifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Validate input
                validateAndStartVerification(Via.SMS);
            }
        });
    }

    public void showProgressBar(boolean show) {
        progressBar.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    public void enablePhoneField(boolean enable) {
        phoneNumber.setEnabled(enable);
    }

}
