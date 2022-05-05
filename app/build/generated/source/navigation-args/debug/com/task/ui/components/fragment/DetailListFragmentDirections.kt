package com.task.ui.components.fragment

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.task.R

public class DetailListFragmentDirections private constructor() {
  public companion object {
    public fun actionDetailListFragmentToDetailFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_detailListFragment_to_detailFragment)
  }
}
