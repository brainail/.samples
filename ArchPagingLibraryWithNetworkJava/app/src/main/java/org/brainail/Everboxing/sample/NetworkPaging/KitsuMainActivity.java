package org.brainail.Everboxing.sample.NetworkPaging;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.arch.paging.PagedList;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import org.brainail.Everboxing.sample.NetworkPaging.model.KitsuItem;

/**
 * This file is part of Everboxing modules. <br/><br/>
 * <p>
 * The MIT License (MIT) <br/><br/>
 * <p>
 * Copyright (c) 2017 Malyshev Yegor aka brainail at org.brainail.everboxing@gmail.com <br/><br/>
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy <br/>
 * of this software and associated documentation files (the "Software"), to deal <br/>
 * in the Software without restriction, including without limitation the rights <br/>
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell <br/>
 * copies of the Software, and to permit persons to whom the Software is <br/>
 * furnished to do so, subject to the following conditions: <br/><br/>
 * <p>
 * The above copyright notice and this permission notice shall be included in <br/>
 * all copies or substantial portions of the Software. <br/><br/>
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR <br/>
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, <br/>
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE <br/>
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER <br/>
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, <br/>
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN <br/>
 * THE SOFTWARE.
 */
public class KitsuMainActivity extends AppCompatActivity {
    private KitsuViewModel viewModel;
    
    private RecyclerView searchResultsRecyclerView;
    private EditText searchInputView;
    private View searchContainerView;
    private View searchStartView;
    private AppBarLayout appBarView;
    
    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        viewModel = ViewModelProviders.of(this).get(KitsuViewModel.class);
        
        searchResultsRecyclerView = findViewById(R.id.searchResultsRecyclerView);
        searchInputView = findViewById(R.id.searchInputView);
        searchContainerView = findViewById(R.id.searchContainerView);
        searchStartView = findViewById(R.id.searchStartView);
        appBarView = findViewById(R.id.appBarView);
        
        initSearchField();
        searchForResults("Android");
    }
    
    private void searchForResults(final String queryFilter) {
        viewModel.setQueryFilter(queryFilter);
        initKitsu();
    }
    
    private void initKitsu() {
        final KitsuPagedListAdapter kitsuAdapter = new KitsuPagedListAdapter();
        searchResultsRecyclerView.setAdapter(kitsuAdapter);
        viewModel.allKitsu().observe(this, new Observer<PagedList<KitsuItem>>() {
            @Override
            public void onChanged(@Nullable final PagedList<KitsuItem> kitsuItems) {
                kitsuAdapter.setList(kitsuItems);
            }
        });
    }
    
    private void hideIme() {
        final InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(searchInputView.getWindowToken(), 0);
    }
    
    private void initSearchField() {
        searchStartView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                hideIme();
                searchForResults(searchInputView.getText().toString());
            }
        });
        appBarView.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(final AppBarLayout appBarLayout, final int verticalOffset) {
                searchContainerView.setTranslationY(verticalOffset);
            }
        });
    }
}
