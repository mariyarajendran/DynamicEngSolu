// Generated by data binding compiler. Do not edit!
package com.task.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.task.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class DetailListFragmentBinding extends ViewDataBinding {
  @NonNull
  public final LayoutAppHeaderBinding inlHomeDetailHeader;

  @NonNull
  public final RecyclerView rvHomeDetail;

  protected DetailListFragmentBinding(Object _bindingComponent, View _root, int _localFieldCount,
      LayoutAppHeaderBinding inlHomeDetailHeader, RecyclerView rvHomeDetail) {
    super(_bindingComponent, _root, _localFieldCount);
    this.inlHomeDetailHeader = inlHomeDetailHeader;
    this.rvHomeDetail = rvHomeDetail;
  }

  @NonNull
  public static DetailListFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.detail_list_fragment, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static DetailListFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<DetailListFragmentBinding>inflateInternal(inflater, R.layout.detail_list_fragment, root, attachToRoot, component);
  }

  @NonNull
  public static DetailListFragmentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.detail_list_fragment, null, false, component)
   */
  @NonNull
  @Deprecated
  public static DetailListFragmentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<DetailListFragmentBinding>inflateInternal(inflater, R.layout.detail_list_fragment, null, false, component);
  }

  public static DetailListFragmentBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static DetailListFragmentBinding bind(@NonNull View view, @Nullable Object component) {
    return (DetailListFragmentBinding)bind(component, view, R.layout.detail_list_fragment);
  }
}