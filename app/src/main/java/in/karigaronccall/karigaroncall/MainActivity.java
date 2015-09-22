package in.karigaronccall.karigaroncall;

import android.content.Intent;
import android.support.v4.text.TextUtilsCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.Toast;

import in.karigaronccall.karigaroncall.utils.InReachAreaProvider;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_toolbar);

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowHomeEnabled(true);

        NavigationDrawerFragment navigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationDrawerFragment.setUp(R.id.fragment_navigation_drawer, drawerLayout, toolbar);

        AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.txtAreaLookup);
        String[] areasCovered = InReachAreaProvider.getAreaInReach().toArray(new String[InReachAreaProvider.getAreaInReach().size()]);
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, areasCovered);
        textView.setAdapter(adapter);
        Button searchAreaButton = (Button) findViewById(R.id.btnAreaLookup);
        searchAreaButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnAreaLookup) {
            //handle the click here
            AutoCompleteTextView txtArea = (AutoCompleteTextView) findViewById(R.id.txtAreaLookup);
            String area = txtArea.getText().toString().trim();
            if (!area.isEmpty()) {
                if (InReachAreaProvider.isInReach(area)) {
                    Intent iinent = new Intent(MainActivity.this, WorkTypeListActivity.class);
                    startActivity(iinent);

                } else {
                    Intent iinent = new Intent(MainActivity.this, WeAreExpanding.class);
                    startActivity(iinent);
                    //slide from right to left
                }
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            } else {
                Toast.makeText(v.getContext(), "Please type an area to lookup", Toast.LENGTH_SHORT).show();
            }
        }
    }


    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}
