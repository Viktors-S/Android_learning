package com.main.first;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class BottomSheetDialog extends BottomSheetDialogFragment {

    OnCalculationListener myListener;

    public BottomSheetDialog(OnCalculationListener listener){
        myListener=listener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.bottom_sheet_dialog,container,false);

        TextView tv = v.findViewById(R.id.tv_sheet);
        Button btn = v.findViewById(R.id.btn_validate);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myListener.onCalculationClicked(tv.getText().toString());
                dismiss();
            }
        });
        return v;
    }



    interface OnCalculationListener{
        void onCalculationClicked(String clicked);
    }

}
