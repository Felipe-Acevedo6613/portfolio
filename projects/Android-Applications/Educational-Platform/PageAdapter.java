package com.example.cmaisonneuve;

import android.util.SparseArray;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.adapter.FragmentViewHolder;

import java.util.List;

public class PageAdapter extends FragmentStateAdapter {
    private final SparseArray<Fragment> registeredFragments = new SparseArray<>();

    public PageAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }
    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment fragment;
        switch (position){
            case 0:
                fragment =  new ListCoursFragment();
                break;
            case 1:
                fragment =  new ListProfessorFragment();
                break;

            default:
                fragment =  new ListCoursFragment();
                break;
        }
        registeredFragments.put(position, fragment);
        return fragment;
    }
    @Override
    public int getItemCount() {
        return 2; // nombre d'onglets
    }


    // Méthode pour récupérer le fragment à une position donnée
    public Fragment getFragment(int position) {
        return registeredFragments.get(position);
    }
}
