package com.task;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.task.databinding.DetailFragmentBindingImpl;
import com.task.databinding.DetailListFragmentBindingImpl;
import com.task.databinding.FragmentHomeBindingImpl;
import com.task.databinding.LanguageFragmentBindingImpl;
import com.task.databinding.RegistrationFragmentBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_DETAILFRAGMENT = 1;

  private static final int LAYOUT_DETAILLISTFRAGMENT = 2;

  private static final int LAYOUT_FRAGMENTHOME = 3;

  private static final int LAYOUT_LANGUAGEFRAGMENT = 4;

  private static final int LAYOUT_REGISTRATIONFRAGMENT = 5;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(5);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.task.R.layout.detail_fragment, LAYOUT_DETAILFRAGMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.task.R.layout.detail_list_fragment, LAYOUT_DETAILLISTFRAGMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.task.R.layout.fragment_home, LAYOUT_FRAGMENTHOME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.task.R.layout.language_fragment, LAYOUT_LANGUAGEFRAGMENT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.task.R.layout.registration_fragment, LAYOUT_REGISTRATIONFRAGMENT);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_DETAILFRAGMENT: {
          if ("layout/detail_fragment_0".equals(tag)) {
            return new DetailFragmentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for detail_fragment is invalid. Received: " + tag);
        }
        case  LAYOUT_DETAILLISTFRAGMENT: {
          if ("layout/detail_list_fragment_0".equals(tag)) {
            return new DetailListFragmentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for detail_list_fragment is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTHOME: {
          if ("layout/fragment_home_0".equals(tag)) {
            return new FragmentHomeBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_home is invalid. Received: " + tag);
        }
        case  LAYOUT_LANGUAGEFRAGMENT: {
          if ("layout/language_fragment_0".equals(tag)) {
            return new LanguageFragmentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for language_fragment is invalid. Received: " + tag);
        }
        case  LAYOUT_REGISTRATIONFRAGMENT: {
          if ("layout/registration_fragment_0".equals(tag)) {
            return new RegistrationFragmentBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for registration_fragment is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(1);

    static {
      sKeys.put(0, "_all");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(5);

    static {
      sKeys.put("layout/detail_fragment_0", com.task.R.layout.detail_fragment);
      sKeys.put("layout/detail_list_fragment_0", com.task.R.layout.detail_list_fragment);
      sKeys.put("layout/fragment_home_0", com.task.R.layout.fragment_home);
      sKeys.put("layout/language_fragment_0", com.task.R.layout.language_fragment);
      sKeys.put("layout/registration_fragment_0", com.task.R.layout.registration_fragment);
    }
  }
}
