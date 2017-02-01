package com.teaguelander.audio.perfectcast.services;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.IOException;

/**
 * Created by Teague-Win10 on 1/31/2017.
 */

public class PicassoService {

	private static PicassoService instance;
	private static Context mContext;

	private PicassoService(Context context) {
		mContext = context;
		Picasso.with(mContext)
			.setIndicatorsEnabled(true);
	}

	public static synchronized PicassoService getInstance(Context context) {
		if (instance == null) {
			instance = new PicassoService (context);
		}
		return instance;
	}

	public static void loadImage(String url, ImageView imageView) {
		Picasso.with(mContext)
			.load(url)
			.into(imageView);
	}

	public static Bitmap getBitmap(String url) {
		Bitmap bmp = null;
		try {
			bmp = Picasso.with(mContext)
				.load(url)
				.get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bmp;
	}


}
