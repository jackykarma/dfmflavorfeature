package com.jacky.android.app_aab.featureflavors;

import androidx.annotation.NonNull;

import com.jacky.android.app_aab.IFlavorGetter;


/**
 * Copyright (C)  2022 Jacky夜雨
 * Description
 *
 * @author jacky.li
 * 2023/2/11, jacky.li, Create file
 * @version v1.0.00
 * @since 2023/2/11
 */
public class FlavorImpl implements IFlavorGetter {

    @NonNull
    @Override
    public String getFlavor() {
        return "domestic";
    }
}
