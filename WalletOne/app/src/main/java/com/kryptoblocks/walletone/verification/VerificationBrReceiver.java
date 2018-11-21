package com.kryptoblocks.walletone.verification;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import com.twilio.verification.TwilioVerification;
import com.twilio.verification.external.VerificationStatus;

public class VerificationBrReceiver extends BroadcastReceiver {

    private VerificationPresenter verificationPresenter;

    public VerificationBrReceiver(@NonNull VerificationPresenter verificationPresenter) {
        this.verificationPresenter = verificationPresenter;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        VerificationStatus verificationStatus = TwilioVerification.getVerificationStatus(intent);
        verificationPresenter.verificationStatusUpdated(verificationStatus);

    }
}
