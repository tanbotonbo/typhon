/*
 * Copyright (C) 2012 Alex Kuiper
 * 
 * This file is part of PageTurner
 *
 * PageTurner is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * PageTurner is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with PageTurner.  If not, see <http://www.gnu.org/licenses/>.*
 */
package net.zorgblub.typhon.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;

import net.zorgblub.typhon.R;
import net.zorgblub.typhon.fragment.LibraryFragment;

public class LibraryActivity extends TyphonActivity {

    private LibraryFragment libraryFragment;

    @Override
    protected int getMainLayoutResource() {
        return net.zorgblub.typhon.R.layout.activity_library;
    }

    @Override
    protected void onCreateTyphonActivity(Bundle savedInstanceState) {
        super.onCreateTyphonActivity(savedInstanceState);
        FragmentManager fragmentManager = this.getSupportFragmentManager();
        libraryFragment = (LibraryFragment) fragmentManager.findFragmentById(R.id.fragment_library);
    }

    @Override
	public void onBackPressed() {
		libraryFragment.onBackPressed();
	}

    @Override
    public boolean onSearchRequested() {
        libraryFragment.onSearchRequested();
        return true;
    }
}
