/*
 * Copyright (C) 2017 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.fragmentexample;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    private boolean isFragmentDisplayed = false;
    private Button mButton;
    static final String IS_FRAGMENT_DISPLAYED_KEY = "state_of_fragment";

    /*
     * FragmentManager (after configuration change) reattaches all fragments to Activity
     * Then we can find them with e.g. findFragmentByTag
     * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButton = findViewById(R.id.button);

        if (savedInstanceState != null) {
            isFragmentDisplayed = savedInstanceState.getBoolean(IS_FRAGMENT_DISPLAYED_KEY);
            if (isFragmentDisplayed) {
                mButton.setText(R.string.close);
            }
        }

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isFragmentDisplayed) {
                    displayFragment();
                } else {
                    closeFragment();
                }
                Log.e(TAG, getSupportFragmentManager().getFragments().toString());
            }
        });

        Log.e(this.toString(), "onCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();

//        Below works as well, but probably not reliable as much. Or so?...
//
//        Fragment simpleFragment = getSupportFragmentManager().findFragmentByTag(SimpleFragment.TAG);
//        isFragmentDisplayed = simpleFragment != null && simpleFragment.getUserVisibleHint();
//        if (isFragmentDisplayed) {
//            mButton.setText(R.string.close);
//        } else {
//            mButton.setText(R.string.open);
//        }


        Log.e(this.toString(), "onStart");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putBoolean(IS_FRAGMENT_DISPLAYED_KEY, isFragmentDisplayed);
        super.onSaveInstanceState(outState);
    }

    private void displayFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, SimpleFragment.newInstance(), SimpleFragment.TAG)
                .commit();

        mButton.setText(R.string.close);

        isFragmentDisplayed = true;
    }

    public void closeFragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        SimpleFragment simpleFragment = (SimpleFragment) fragmentManager.findFragmentById(R.id.fragment_container);
        if (simpleFragment != null) {
            fragmentManager
                    .beginTransaction()
                    .remove(simpleFragment)
                    .commit();
        }

        mButton.setText(R.string.open);

        isFragmentDisplayed = false;
    }

    @Override
    public void onAttachFragment(android.support.v4.app.Fragment fragment) {
        super.onAttachFragment(fragment);
        Log.e(this.toString(), "onAttachFragment v4");
    }
}
