package com.example.xyzreader.ui;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xyzreader.R;

/**
 * Created by PepovPC on 9/19/2017.
 */

public class ParallaxPageTransformer implements ViewPager.PageTransformer {

    public void transformPage(View view, float position) {

        int pageWidth = view.getWidth();

        ImageView imageView = (ImageView) view.findViewById(R.id.photo);
        TextView bylineView = (TextView) view.findViewById(R.id.article_byline);
        TextView bodyView = (TextView) view.findViewById(R.id.article_body);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) view.findViewById(R.id.collapsing_toolbar_layout);


        if (position < -1) { // [-Infinity,-1)
            // This page is way off-screen to the left.
            view.setAlpha(1);

        } else if (position <= 1) { // [-1,1]

            bylineView.setTranslationX((position) * (pageWidth / 1));
            bodyView.setTranslationX((position) * (pageWidth / 1));

            imageView.setTranslationX(-position * (pageWidth / 2)); //Half the normal speed

        } else { // (1,+Infinity]
            // This page is way off-screen to the right.
            view.setAlpha(1);
        }


    }
}