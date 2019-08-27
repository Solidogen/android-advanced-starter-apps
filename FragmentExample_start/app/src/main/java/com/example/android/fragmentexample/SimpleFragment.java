package com.example.android.fragmentexample;


import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class SimpleFragment extends Fragment {

    private static final int YES = 0;
    private static final int NO = 1;


    public SimpleFragment() {
        // Required empty public constructor
        Log.e(this.toString(), "ctor");
    }

    @Override
    public void onInflate(Context context, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(context, attrs, savedInstanceState);
        Log.e(this.toString(), "onInflate - a fragment is being created as part of" +
                " a view layout inflation, typically from setting the content view of an activity");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.e(this.toString(), "onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(this.toString(), "onCreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment.
        final View rootView =
                inflater.inflate(R.layout.fragment_simple, container, false);
        final RadioGroup radioGroup = rootView.findViewById(R.id.radio_group);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                View radioButton = radioGroup.findViewById(checkedId);
                int index = radioGroup.indexOfChild(radioButton);
                TextView textView =
                        rootView.findViewById(R.id.fragment_header);
                switch (index) {
                    case YES: // User chose "Yes."
                        textView.setText(R.string.yes_message);
                        break;
                    case NO: // User chose "No."
                        textView.setText(R.string.no_message);
                        break;
                    default: // No choice made.
                        // Do nothing.
                        break;
                }
            }
        });
        // Return the View for the fragment's UI.
        Log.e(this.toString(), "onCreateView");
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.e(this.toString(), "onViewCreated");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e(this.toString(), "onActivityCreated");
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.e(this.toString(), "onViewStateRestored");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e(this.toString(), "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e(this.toString(), "onResume");
    }

    //

    @Override
    public void onPause() {
        super.onPause();
        Log.e(this.toString(), "onPause");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e(this.toString(), "onSaveInstanceState");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e(this.toString(), "onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e(this.toString(), "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(this.toString(), "onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e(this.toString(), "onDetach");
    }

    //

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.e(this.toString(), "onConfigurationChanged - only if activity has configChanges overridden");
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.e(this.toString(), "onHiddenChanged");
    }

    @Override
    public void onAttachFragment(Fragment childFragment) {
        super.onAttachFragment(childFragment);
        Log.e(this.toString(), "onAttachFragment - child fragment: " + childFragment.toString());
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        Log.e(this.toString(), "onCreateContextMenu");
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        Log.e(this.toString(), "onCreateOptionsMenu");
    }

    @Override
    public void onDestroyOptionsMenu() {
        super.onDestroyOptionsMenu();
        Log.e(this.toString(), "onDestroyOptionsMenu");
    }
}
