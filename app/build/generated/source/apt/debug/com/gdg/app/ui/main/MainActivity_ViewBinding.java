// Generated code from Butter Knife. Do not modify!
package com.gdg.app.ui.main;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.gdg.app.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  private View view2131296335;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(final MainActivity target, View source) {
    this.target = target;

    View view;
    target.mToolbar = Utils.findRequiredViewAsType(source, R.id.main_toolbar, "field 'mToolbar'", Toolbar.class);
    target.mRecyclerView = Utils.findRequiredViewAsType(source, R.id.home_recycler, "field 'mRecyclerView'", RecyclerView.class);
    target.mDrawer = Utils.findRequiredViewAsType(source, R.id.drawer_view, "field 'mDrawer'", DrawerLayout.class);
    target.mNavigationView = Utils.findRequiredViewAsType(source, R.id.navigation_view, "field 'mNavigationView'", NavigationView.class);
    target.mAppVersionTextView = Utils.findRequiredViewAsType(source, R.id.tv_app_version, "field 'mAppVersionTextView'", TextView.class);
    view = Utils.findRequiredView(source, R.id.fab_home, "method 'onFabClicked'");
    view2131296335 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onFabClicked();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mToolbar = null;
    target.mRecyclerView = null;
    target.mDrawer = null;
    target.mNavigationView = null;
    target.mAppVersionTextView = null;

    view2131296335.setOnClickListener(null);
    view2131296335 = null;
  }
}
