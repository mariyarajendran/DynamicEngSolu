package com.task.ui.components.fragment

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.task.R
import com.task.databinding.RegistrationFragmentBinding
import com.task.ui.base.BaseFragment
import com.task.ui.components.viewmodel.RegistrationViewModel
import com.task.utils.DialogHelper
import com.task.utils.EMAIL_PATTERN
import com.task.utils.toGone
import java.util.regex.Matcher
import java.util.regex.Pattern

class RegistrationFragment : BaseFragment(), View.OnClickListener {

    companion object {
        fun newInstance() = RegistrationFragment()
    }

    private lateinit var viewModel: RegistrationViewModel
    private lateinit var binding: RegistrationFragmentBinding
    private var dialogHelper: DialogHelper? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = RegistrationFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(RegistrationViewModel::class.java)
        init()
        observeViewModel()
    }

    override fun init() {
        dialogHelper = activity?.let { DialogHelper(it) }
        initOnClickListener()
    }

    override fun initOnClickListener() {
        binding.inlRegistrationHeader.imgCloseAppHeader.setOnClickListener(this)
        binding.btnJoinUs.setOnClickListener(this)
        binding.edtRegisterDob.setOnClickListener(this)
        onDobChangeListener()
    }

    override fun appHeaderAction() {
        binding.inlRegistrationHeader.imgLeftArrowAppHeader.toGone()
        binding.inlRegistrationHeader.tvTitleAppHeader.text =
            returnResString(R.string.label_join_us)
        binding.inlRegistrationHeader.tvTitleAppHeader.textSize = 20.0F
    }

    override fun observeViewModel() {

    }

    override fun onClick(v: View?) {
        when (v) {
            binding.inlRegistrationHeader.imgCloseAppHeader -> {
                Navigation.findNavController(binding.root)
                    .navigate(R.id.homeFragment)
            }
            binding.btnJoinUs -> {
                if (registrationValidation()) {
                    Toast.makeText(
                        activity,
                        returnResString(R.string.msg_thank_for_registration),
                        Toast.LENGTH_LONG
                    ).show()
                    Navigation.findNavController(binding.root)
                        .navigate(R.id.homeFragment)
                }
            }
        }
    }

    private fun registrationValidation(): Boolean {
        return if (binding.edtRegisterName.text?.isEmpty() == true) {
            binding.edtRegisterName.error = returnResString(R.string.error_enter_name)
            false
        } else if (binding.edtRegisterMobileNo.text?.isEmpty() == true) {
            binding.edtRegisterMobileNo.error = returnResString(R.string.error_enter_mobile_no)
            false
        } else if (binding.edtRegisterMobileNo.text?.length != 10) {
            binding.edtRegisterMobileNo.error = returnResString(R.string.error_invalid_mobile_no)
            false
        } else if (binding.edtRegisterEmailId.text?.isEmpty() == true) {
            binding.edtRegisterEmailId.error = returnResString(R.string.error_enter_email_id)
            false
        } else if (!emailValidator(binding.edtRegisterEmailId.text)) {
            binding.edtRegisterEmailId.error = returnResString(R.string.error_invalid_email_id)
            false
        } else {
            binding.edtRegisterName.error = null
            binding.edtRegisterDob.error = null
            binding.edtRegisterMobileNo.error = null
            binding.edtRegisterEmailId.error = null
            true
        }
    }

    private fun emailValidator(email: Editable?): Boolean {
        val pattern: Pattern = Pattern.compile(EMAIL_PATTERN)
        val matcher: Matcher = pattern.matcher(email)
        return matcher.matches()
    }

    private fun onDobChangeListener() {

    }
}