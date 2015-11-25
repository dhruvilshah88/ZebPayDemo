package zebpay.dhruvil.com.zebpaydemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import org.adw.library.widgets.discreteseekbar.DiscreteSeekBar;

import zebpay.dhruvil.com.zebpaydemo.models.User;
import zebpay.dhruvil.com.zebpaydemo.utils.ApplicationClass;

public class Settings extends AppCompatActivity {

    Button buok;
    Switch notswitch;
    DiscreteSeekBar seekbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        try {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        } catch (Exception e) {
            e.printStackTrace();
        }

        notswitch = (Switch) findViewById(R.id.notswitch);
        buok = (Button) findViewById(R.id.buok);
        seekbar = (DiscreteSeekBar) findViewById(R.id.seekbar);

        final User user = ApplicationClass.getInstance().getsharedprefs();
        seekbar.setProgress(user.getVariance());
        notswitch.setChecked(user.isNotify());
        buok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                User userok = new User();
                userok.setNotify(notswitch.isChecked());
                userok.setVariance(seekbar.getProgress());
                ApplicationClass.getInstance().setsharedprefs(userok);
                Toast.makeText(Settings.this, "Updated", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        finish();

        return true;

    }

}

