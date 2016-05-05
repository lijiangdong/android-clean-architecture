package com.ljd.architecture.clean.presentation.view.fragment;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Build;
import android.widget.Toast;

import com.ljd.architecture.clean.presentation.internal.di.HasComponent;

/**
 * Created by ljd on 5/5/16.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public abstract class BaseFragment extends Fragment {

    protected void showToastMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    protected <C> C getComponent(Class<C> componentType) {
        return componentType.cast(((HasComponent<C>) getActivity()).getComponent());
    }
}
