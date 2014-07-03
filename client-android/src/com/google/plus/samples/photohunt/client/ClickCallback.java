/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.plus.samples.photohunt.client;

import com.google.plus.samples.photohunt.tasks.FetchJsonTask;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

public class ClickCallback<T> extends FetchJsonTask.FetchCallback<T> {
	
	private Context mContext;
	private View mView;
	
	private int mSuccessId;
	private int mFailureId;
	
	public ClickCallback(Context c, View v, int successId, int failureId) {
		mView = v;
		mContext = c;
		mSuccessId = successId;
		mFailureId = failureId;
	}
	
	@Override
	public void onSuccess(T t) {
		String displayText = mContext.getString(mSuccessId);
		
		Toast toast = 
				Toast.makeText(mContext, displayText, Toast.LENGTH_LONG);
		toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
		toast.show();
	}
	
	@Override
	public void onError(T t) {
		mView.setEnabled(true);
		String displayText = mContext.getString(mFailureId);
		
		Toast toast = 
				Toast.makeText(mContext, displayText, Toast.LENGTH_LONG);
		toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
		toast.show();
	}
}
