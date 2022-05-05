package com.task.databinding;
import com.task.R;
import com.task.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class RegistrationFragmentBindingImpl extends RegistrationFragmentBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.inlRegistrationHeader, 2);
        sViewsWithIds.put(R.id.glRegisterTop, 3);
        sViewsWithIds.put(R.id.tvRegistrationTitleHint, 4);
        sViewsWithIds.put(R.id.edtRegisterName, 5);
        sViewsWithIds.put(R.id.rgRegisterGender, 6);
        sViewsWithIds.put(R.id.rbRegisterMale, 7);
        sViewsWithIds.put(R.id.rbRegisterFemale, 8);
        sViewsWithIds.put(R.id.edtRegisterDob, 9);
        sViewsWithIds.put(R.id.edtRegisterMobileNo, 10);
        sViewsWithIds.put(R.id.edtRegisterEmailId, 11);
        sViewsWithIds.put(R.id.btnJoinUs, 12);
    }
    // views
    @NonNull
    private final android.widget.ScrollView mboundView0;
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView1;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public RegistrationFragmentBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 13, sIncludes, sViewsWithIds));
    }
    private RegistrationFragmentBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (com.task.utils.font.CustomFontButtonBold) bindings[12]
            , (com.task.utils.font.CustomFontEditTextRegular) bindings[9]
            , (com.task.utils.font.CustomFontEditTextRegular) bindings[11]
            , (com.task.utils.font.CustomFontEditTextRegular) bindings[10]
            , (com.task.utils.font.CustomFontEditTextRegular) bindings[5]
            , (androidx.constraintlayout.widget.Guideline) bindings[3]
            , (bindings[2] != null) ? com.task.databinding.LayoutAppHeaderBinding.bind((android.view.View) bindings[2]) : null
            , (com.task.utils.font.CustomFontRadioButtonRegular) bindings[8]
            , (com.task.utils.font.CustomFontRadioButtonRegular) bindings[7]
            , (android.widget.RadioGroup) bindings[6]
            , (com.task.utils.font.CustomFontTextViewRegular) bindings[4]
            );
        this.mboundView0 = (android.widget.ScrollView) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[1];
        this.mboundView1.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}