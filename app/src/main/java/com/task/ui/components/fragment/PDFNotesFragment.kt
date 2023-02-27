package com.task.ui.components.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.task.R
import com.task.databinding.FragmentPdfNotesBinding
import com.task.ui.base.BaseFragment
import com.task.ui.components.viewmodel.DetailViewModel
import com.task.utils.EnumUtils
import com.task.utils.toGone
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class PDFNotesFragment : BaseFragment(), View.OnClickListener {
    private lateinit var binding: FragmentPdfNotesBinding
    private var pdfFileName = ""
    private var pdfFilePath = ""

    companion object {
        fun newInstance() = PDFNotesFragment()
    }

    private lateinit var detailViewModel: DetailViewModel

    override fun initOnClickListener() {
        binding.inlDetailHeader.imgCloseAppHeader.setOnClickListener(this)
        binding.inlDetailHeader.imgLeftArrowAppHeader.setOnClickListener(this)
    }

    override fun init() {
    }


    override fun appHeaderAction() {
        binding.inlDetailHeader.tvTitleAppHeader.text =
            returnResString(R.string.app_name)
        binding.inlDetailHeader.imgCloseAppHeader.toGone()
        binding.inlDetailHeader.imgLeftArrowAppHeader.toGone()
        binding.inlDetailHeader.imgSettingAppHeader.toGone()

    }

    override fun observeViewModel() {

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPdfNotesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        detailViewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        getArgumentData()
    }

    override fun onClick(v: View?) {
        when (v) {
            binding.inlDetailHeader.imgCloseAppHeader -> {
                Navigation.findNavController(binding.root)
                    .navigate(R.id.homeFragment)
            }
            binding.inlDetailHeader.imgLeftArrowAppHeader -> {
                Navigation.findNavController(binding.root)
                    .navigate(R.id.detailListFragment)
            }
        }
    }

    private fun getArgumentData() {
        if (arguments != null) {
            pdfFileName = arguments?.getString(EnumUtils.PDF_FILENAME.value).toString()
            pdfFilePath = arguments?.getString(EnumUtils.PDF_FILEPATH.value).toString()
            ///App Header Title
            binding.inlDetailHeader.tvTitleAppHeader.text =
                if (pdfFileName == "")
                    returnResString(R.string.app_name)
                else
                    pdfFileName
            binding.wvPdfNotes.settings.javaScriptEnabled = true
            binding.wvPdfNotes.settings.setSupportZoom(true)
            binding.wvPdfNotes.webViewClient = object : WebViewClient() {
                @Deprecated("Deprecated in Java")
                override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                    view.loadUrl(url)
                    return true
                }

                override fun onPageFinished(view: WebView, url: String) {
                    binding.progressBar.toGone()
                }

                @Deprecated("Deprecated in Java")
                override fun onReceivedError(
                    view: WebView,
                    errorCode: Int,
                    description: String,
                    failingUrl: String
                ) {
                    Toast.makeText(activity, "Error: $description", Toast.LENGTH_SHORT).show();
                    binding.progressBar.toGone()
                }
            }
            binding.wvPdfNotes.loadUrl("https://drive.google.com/viewerng/viewer?embedded=true&url=$pdfFilePath");
        }
    }

}