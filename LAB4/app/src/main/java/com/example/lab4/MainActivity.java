package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.net.Uri;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    // functions to handle button clicks
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    // this method will handle a user hitting the google maps button
    public void OnOpenInGoogleMaps (View view) {
        EditText teamAddres = (EditText) findViewById(R.id.teamAddressField);
// Create a Uri from an intent string. Use the result to create an Intent.
        Uri gmmIntentUri = Uri.parse("http://maps.google.co.in/maps?q="+teamAddres.getText());
// Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
// Make the Intent explicit by setting the Google Maps package
        mapIntent.setPackage("com.google.android.apps.maps");
// Attempt to start an activity that can handle the Intent
        startActivity(mapIntent);
    }
    public void OnSetAvatarButton(View view) {
//Application Context and Activity
        Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
        startActivityForResult (intent,0);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_CANCELED) return;
        //Getting the Avatar Image we show to our users
        ImageView avatarImage = (ImageView) findViewById(R.id.logoImage);
        //Figuring out the correct image
        String drawableName = "ic_logo_00";
        if (data.getIntExtra("imageID", R.id.logoImage00)==R.id.logoImage00){drawableName = "ic_logo_00";}
        else if (data.getIntExtra("imageID", R.id.logoImage00)==R.id.logoImage01){drawableName = "ic_logo_01";}
        else if(data.getIntExtra("imageID", R.id.logoImage00)==R.id.logoImage02){drawableName = "ic_logo_02";}
        else if(data.getIntExtra("imageID", R.id.logoImage00)==R.id.logoImage03){drawableName = "ic_logo_10";}
        else if(data.getIntExtra("imageID", R.id.logoImage00)==R.id.logoimage04){drawableName = "ic_logo_11";}
        else if(data.getIntExtra("imageID", R.id.logoImage00)==R.id.logoImage05){drawableName = "ic_logo_12";}
        else {drawableName = "ic_logo_00";
        }
        int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
        avatarImage.setImageResource(resID);
    }
}