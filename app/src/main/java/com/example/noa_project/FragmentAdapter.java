package com.example.noa_project;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class FragmentAdapter extends FragmentStateAdapter {

    public FragmentAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new BlankFragment();
            case 1:
                return new BlankFragment2();
            default:
                return new BlankFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2; // Number of tabs
    }
}