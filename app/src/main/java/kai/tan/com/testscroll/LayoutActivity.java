package kai.tan.com.testscroll;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import kai.tan.com.testscroll.view.CustomView;

public class LayoutActivity extends AppCompatActivity {

    private CustomView custom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);
        custom = (CustomView) findViewById(R.id.custom);
        //是用view动画使view滑动
//        custom.setAnimation(AnimationUtils.loadAnimation(this, R.anim.translate));
        //使用属性动画使view滑动
//        ObjectAnimator.ofFloat(custom, "translationX", 0, 300).setDuration(1000).start();
        custom.smoothScrollTo(-400,0);
    }

    public void onClick(View view) {

    }
}
