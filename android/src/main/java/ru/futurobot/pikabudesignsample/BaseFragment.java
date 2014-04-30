package ru.futurobot.pikabudesignsample;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import com.readystatesoftware.systembartint.SystemBarTintManager;

/**
 * Created by Alexey on 30.04.2014.
 */
public class BaseFragment extends Fragment {

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        assert (activity instanceof MainActivity);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SystemBarTintManager tintManager = ((MainActivity) getActivity()).tintManager;

        if (tintManager.isStatusBarTintEnabled()) {
            SystemBarTintManager.SystemBarConfig config = tintManager.getConfig();
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop() + config.getPixelInsetTop(true), view.getPaddingRight(), view.getPaddingBottom());
        }
    }
}
