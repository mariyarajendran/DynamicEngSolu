package com.task.ui.components.fragment

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.task.R

public class HomeFragmentDirections private constructor() {
  public companion object {
    public fun actionHomeFragmentToDetailListFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_homeFragment_to_detailListFragment)
  }
}
