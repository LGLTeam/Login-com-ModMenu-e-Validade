package uk.lgl.modmenu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity2 extends Activity {

    public String GameActivity = "com.unity3d.player.UnityPlayerActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);






        //To launch mod menu
        StaticActivity.StartHyupai(this);

        //To load lib only
        //LoadLib.Start(this);

        //To launch game activity
        try {
            MainActivity2.this.startActivity(new Intent(MainActivity2.this, Class.forName(MainActivity2.this.GameActivity)));
            //Start service
        } catch (ClassNotFoundException e) {
            //  Toast.makeText(MainActivity.this, "Error. Game's main activity does not exist", Toast.LENGTH_LONG).show();
            e.printStackTrace();
            return;
        }
    }
}
