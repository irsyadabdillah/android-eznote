package com.irzstudio.eznote.screen

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.irzstudio.eznote.R
import kotlinx.android.synthetic.main.bottomsheet_fragment.*

class BottomSheetFragment : BottomSheetDialogFragment() {

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.bottomsheet_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.background = context?.resources?.getDrawable(R.drawable.bg_bottom_sheet)

        btn_stared.setOnClickListener {
            dismiss()
        }
    }
}