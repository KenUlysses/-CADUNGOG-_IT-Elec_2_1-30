package fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.fragmentpizza.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("DEBUG", getResources().getConfiguration().orientation + "");

        if (savedInstanceState == null) {
            // Instance of first fragment
            FragmentMenus firstFragment = new FragmentMenus();

            // Add Fragment to FrameLayout (flContainer), using FragmentManager
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();// begin  FragmentTransaction
            ft.add(R.id.flContainer, firstFragment);                                // add    Fragment
            ft.commit();                                                            // commit FragmentTransaction
        }

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            FragmentDetails secondFragment = new FragmentDetails();
            Bundle args = new Bundle();
            args.putInt("position", 0);
            secondFragment.setArguments(args);          // (1) Communicate with Fragment using Bundle
            FragmentTransaction ft2 = getSupportFragmentManager().beginTransaction();// begin  FragmentTransaction
            ft2.add(R.id.flContainer2, secondFragment);                               // add    Fragment
            ft2.commit();                                                            // commit FragmentTransaction
        }
    }

    public void onPizzaItemSelected(int position) {
        Toast.makeText(this, "Called By Fragment A: position - "+ position, Toast.LENGTH_SHORT).show();

        // Load Pizza Detail Fragment
        FragmentDetails secondFragment = new FragmentDetails();

        Bundle args = new Bundle();
        args.putInt("position", position);
        secondFragment.setArguments(args);          // (1) Communicate with Fragment using Bundle


        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flContainer2, secondFragment) // replace flContainer
                    //.addToBackStack(null)
                    .commit();
        }else{
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flContainer, secondFragment) // replace flContainer
                    .addToBackStack(null)
                    .commit();
        }

    }
}