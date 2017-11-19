package org.brainail.Everboxing.sample.NetworkPaging;

import android.arch.paging.DataSource;
import android.arch.paging.LivePagedListProvider;

import org.brainail.Everboxing.sample.NetworkPaging.model.KitsuItem;
import org.brainail.Everboxing.sample.NetworkPaging.model.KitsuResponse;

import java.util.ArrayList;
import java.util.List;

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
public class KitsuMediaPagedListProvider {
    private final KitsuLimitOffsetNetworkDataSource<KitsuItem> dataSource
            = new KitsuLimitOffsetNetworkDataSource<KitsuItem>(KitsuRestApi.getInstance()) {
        @Override
        protected List<KitsuItem> convertToItems(final KitsuResponse response, final int size) {
            final List<KitsuItem> items = new ArrayList<>(size);
            for (int index = 0; index < size; ++ index) {
                if (index >= response.data.size()) {
                    items.add(new KitsuItem(0, null, null));
                } else {
                    items.add(response.data.get(index));
                }
            }
            return items;
        }
    };
    
    public LivePagedListProvider<Integer, KitsuItem> allKitsu() {
        return new LivePagedListProvider<Integer, KitsuItem>() {
            @Override
            protected DataSource<Integer, KitsuItem> createDataSource() {
                return dataSource;
            }
        };
    }
    
    public static KitsuMediaPagedListProvider getInstance() {
        return InstanceHolder.INSTASNCE;
    }
    
    public void setQueryFilter(String queryFilter) {
        dataSource.setQueryFilter(queryFilter);
    }
    
    private static final class InstanceHolder {
        private static final KitsuMediaPagedListProvider INSTASNCE = new KitsuMediaPagedListProvider();
    }
}
