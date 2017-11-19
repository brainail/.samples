package org.brainail.Everboxing.sample.NetworkPaging;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.paging.PagedList;

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
public class KitsuViewModel extends ViewModel {
    private static final int PAGED_LIST_PAGE_SIZE = 20;
    private static final boolean PAGED_LIST_ENABLE_PLACEHOLDERS = false;
    
    private LiveData<PagedList<KitsuItem>> allKitsuLiveData;
    
    public LiveData<PagedList<KitsuItem>> allKitsu() {
        if (null == allKitsuLiveData) {
            allKitsuLiveData = KitsuMediaPagedListProvider.getInstance().allKitsu().create(0,
                    new PagedList.Config.Builder()
                            .setPageSize(PAGED_LIST_PAGE_SIZE)
                            .setInitialLoadSizeHint(PAGED_LIST_PAGE_SIZE)
                            .setEnablePlaceholders(PAGED_LIST_ENABLE_PLACEHOLDERS)
                            .build());
        }
        return allKitsuLiveData;
    }
    
    public void setQueryFilter(String queryFilter) {
        KitsuMediaPagedListProvider.getInstance().setQueryFilter(queryFilter);
        allKitsuLiveData = null; // invalidate
    }
}
