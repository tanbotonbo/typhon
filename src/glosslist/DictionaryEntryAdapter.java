/*
Copyright (C) 2013 Ray Zhou

JadeRead is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

JadeRead is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with JadeRead.  If not, see <http://www.gnu.org/licenses/>

Author: Ray Zhou
Date: 2013 07 31

*/

package org.zorgblub.rikai.glosslist;

import android.content.Context;
import android.graphics.Typeface;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.zorgblub.rikai.DroidEntry;

import java.util.List;


public class DictionaryEntryAdapter<T extends DroidEntry> extends ArrayAdapter<T> {

    private int mColor = -1;
    private boolean mColorSet = false;
    private Typeface typeface;
    private int mTextPixelSize = -1;


    public DictionaryEntryAdapter(Context context, int textViewResourceId, List<T> objects) {
        super(context, textViewResourceId, objects);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = super.getView(position, convertView, parent);

        if (v instanceof TextView) {
            TextView textView = (TextView) v;
            T item = getItem(position);

            textView.setText(item.render(), TextView.BufferType.SPANNABLE);
            textView.setBackgroundColor(item.getBackgroundColor());
            if(typeface != null)
                textView.setTypeface(typeface);

            if (mColorSet) {
                textView.setTextColor(mColor);
            }
            if (mTextPixelSize > 0) {
                textView.setTextSize(TypedValue.COMPLEX_UNIT_PX, mTextPixelSize);
            }
        }
        return v;
    }

    public void setColor(int color) {
        mColor = color;
        mColorSet = true;
        notifyDataSetChanged();
    }


    public void setTextPixelSize(int size) {
        mTextPixelSize = size;
        notifyDataSetChanged();
    }

    public Typeface getTypeface() {
        return typeface;
    }

    public void setTypeface(Typeface typeface) {
        this.typeface = typeface;
    }
}
