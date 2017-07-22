package kai.tan.com.testscroll;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void call(View view) {
        switch (view.getId()) {
            case R.id.btn_1:
                to(LayoutActivity.class);
                break;

            case R.id.btn_2:

                break;
        }
    }

    public void to(Class c) {
        Intent intent = new Intent(this, c);
        startActivity(intent);
    }
}
