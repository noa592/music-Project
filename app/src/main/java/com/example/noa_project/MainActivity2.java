       package com.example.noa_project;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;


       public class MainActivity2 extends AppCompatActivity {

private ViewPager viewPager;
private TabLayout tabLayout;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

    // מחברים בין ה-TabLayout ל-ViewPager2
    TabLayout tabLayout = findViewById(R.id.tablayout);
    ViewPager2 viewPager = findViewById(R.id.viewPager);

    // יוצרים מתאם לפרגמנטים
    FragmentAdapter adapter = new FragmentAdapter(this);
    viewPager.setAdapter(adapter);

    // מחברים את ה-TabLayout ל-ViewPager2
    new TabLayoutMediator(tabLayout, viewPager, (tab, position) -> {
        if (position == 0) {
            tab.setText("Tab 1"); // שם לטאב הראשון
        } else if (position == 1) {
            tab.setText("Tab 2"); // שם לטאב השני
        }
    }).attach();
}


}