package com.task.ui.base


import android.content.Context
import android.os.Bundle
import android.view.ContextThemeWrapper
import android.view.MenuItem
import android.view.View
import androidx.annotation.MenuRes
import androidx.appcompat.widget.PopupMenu
import androidx.fragment.app.Fragment
import com.task.R
import com.task.ui.components.callback.PopupMenuCallback

abstract class BaseFragment : Fragment() {

    abstract fun initOnClickListener()
    abstract fun init()
    abstract fun appHeaderAction()
    abstract fun observeViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        initOnClickListener()
        appHeaderAction()
    }

    override fun onResume() {
        super.onResume()
    }

    fun returnResString(id: Int): String? {
        return activity?.resources?.getString(id)
    }

    fun showMenu(v: View, @MenuRes menuRes: Int, listener: PopupMenuCallback) {
        val wrapper: Context = ContextThemeWrapper(requireActivity(), R.style.BasePopupMenu)
        val popup = PopupMenu(wrapper, v)
        popup.menuInflater.inflate(menuRes, popup.menu)
        popup.setOnDismissListener {

        }
        popup.setOnMenuItemClickListener { item: MenuItem? ->
            when (item?.itemId) {
                R.id.menuLanguageSetting -> {
                    listener.onTapLanguageSetting()
                }
            }
            true
        }

        try {
            val fieldMPopup = PopupMenu::class.java.getDeclaredField("mPopup")
            fieldMPopup.isAccessible = true
            val mPopup = fieldMPopup.get(popup)
            mPopup.javaClass
                .getDeclaredMethod("setForceShowIcon", Boolean::class.java)
                .invoke(mPopup, true)
        } catch (e: Exception) {
        } finally {
            popup.show()
        }
    }
}