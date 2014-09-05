package com.androidassignment;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.model.people.Person;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.Toast;

public class LoginActivity extends Activity implements ConnectionCallbacks,
		OnConnectionFailedListener {

	/* Request code used to invoke sign in user interactions. */
	private static final int RC_SIGN_IN = 0;

	/* Client used to interact with Google APIs. */
	private GoogleApiClient mGoogleApiClient;

	/*
	 * A flag indicating that a PendingIntent is in progress and prevents us
	 * from starting further intents.
	 */

	private boolean mIntentInProgress;
	com.google.android.gms.common.SignInButton signInBtn;

	ProgressBar progressBar;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		  requestWindowFeature(Window.FEATURE_NO_TITLE);
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
				.permitAll().build();
		StrictMode.setThreadPolicy(policy);

		setContentView(R.layout.login_page);
		
		
		progressBar = (ProgressBar)findViewById(R.id.progressBar2);
		
		
		// Client initiation
		mGoogleApiClient = new GoogleApiClient.Builder(this)
				.addConnectionCallbacks(this)
				.addOnConnectionFailedListener(this).addApi(Plus.API)
				.addScope(Plus.SCOPE_PLUS_LOGIN).build();
       // Action for Signin Button
		signInBtn = (com.google.android.gms.common.SignInButton) findViewById(R.id.sign_in_button);
		signInBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				mGoogleApiClient.connect();

			}
		});

	}

	protected void onStart() {
		super.onStart();

	}

	protected void onStop() {
		super.onStop();

		if (mGoogleApiClient.isConnected()) {
			mGoogleApiClient.disconnect();
		}
	}

	@Override
	public void onConnectionFailed(ConnectionResult arg0) {

		if (!mIntentInProgress && arg0.hasResolution()) {
			try {
				mIntentInProgress = true;
				arg0.startResolutionForResult(this, RC_SIGN_IN);
			} catch (SendIntentException e) {
				// The intent was canceled before it was sent. Return to the
				// default
				// state and attempt to connect to get an updated
				// ConnectionResult.
				mIntentInProgress = false;
				mGoogleApiClient.connect();
			}

		}

		// Log.e("error", "error code" + arg0.getResolution());
		Toast.makeText(this, "Wait a while..!", Toast.LENGTH_LONG).show();
	}

	@Override
	protected void onActivityResult(int requestCode, int responseCode,
			Intent intent) {
		if (requestCode == RC_SIGN_IN) {
			mIntentInProgress = false;
			if (!mGoogleApiClient.isConnecting()) {
				mGoogleApiClient.connect();
			}
		}
	}

	@Override
	public void onConnected(Bundle arg0) {

		Toast.makeText(this, "User is connected!", Toast.LENGTH_LONG).show();
		signInBtn.setVisibility(View.GONE);
		if (Plus.PeopleApi.getCurrentPerson(mGoogleApiClient) != null) {
			Person person = Plus.PeopleApi.getCurrentPerson(mGoogleApiClient);
			Toast.makeText(LoginActivity.this,
					"Welcome : " + person.getDisplayName(), 2000).show();
			
			progressBar.setVisibility(View.GONE);
			Intent intent = new Intent(LoginActivity.this,ServicesActivity.class);
			startActivity(intent);
			finish();
		}

	}

	@Override
	public void onConnectionSuspended(int arg0) {

		Toast.makeText(this, "User is onConnectionSuspended!",
				Toast.LENGTH_LONG).show();
	}

}
