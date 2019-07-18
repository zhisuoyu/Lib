//package zsy.base.android.wrapper.dialog;
////
//
//import android.app.Dialog;
//import android.content.Context;
//import android.os.Bundle;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
//import android.support.v4.app.FragmentActivity;
//import android.support.v7.app.AppCompatDialogFragment;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//public class FragmentDg extends AbsDg<FragmentDg> {
//
//    private MyDialogFragment dialogFragment;
//
//    public FragmentDg(@NonNull FragmentActivity fragmentActivity) {
//        super(fragmentActivity);
//    }
//
//
////    private AlertDialog.Builder getBuilder() {
////        if (builder == null) {
////            builder = new AlertDialog.Builder(fragmentActivity);
////        }
////        return builder;
////    }
////
////    @Override
////    public FragmentDg setTitle(String title) {
//////        new AppCompatDialogFragment().show();
////        getBuilder().setTitle(title);
////        return this;
////    }
////
////    @Override
////    public FragmentDg setIcon(Drawable icon) {
////        getBuilder().setIcon(icon);
////        return this;
////    }
////
////    @Override
////    public FragmentDg setMessage(String message) {
////        getBuilder().setMessage(message);
////        return this;
////    }
////
////    @Override
////    public FragmentDg setCancelable(boolean cancelable) {
////        getBuilder().setCancelable(cancelable);
////        return this;
////    }
////
////    @Override
////    public FragmentDg setPositiveButton(CharSequence text, OnClickListener listener) {
////        getBuilder().setPositiveButton(text,)
////        return null;
////    }
////
////    @Override
////    public FragmentDg setNegativeButton(CharSequence text, OnClickListener listener) {
////        return null;
////    }
////
////    @Override
////    public FragmentDg setNeutralButton(CharSequence text, OnClickListener listener) {
////        return null;
////    }
////
////    @Override
////    public FragmentDg setView(View view) {
////        return null;
////    }
//
//    @Override
//    public void show() {
//        if (dialogFragment == null) {
//            dialogFragment = MyDialogFragment.newInstance();
//            dialogFragment.setFragmentDg(this);
//        }
//        dialogFragment.show(fragmentActivity.getSupportFragmentManager(), "DialogFragment");
//    }
//
//    @Override
//    public void cancel() {
//        dismiss();
//    }
//
//    @Override
//    public void dismiss() {
//        dialogFragment.dismiss();
//    }
//
//    public static class MyDialogFragment extends AppCompatDialogFragment {
//
//        private FragmentDg fragmentDg;
//
//
//        @Override
//        public void onAttach(Context context) {
//            super.onAttach(context);
//            Log.i("onAttach", context.getClass().getName());
//        }
//
//        public static MyDialogFragment newInstance() {
////            MyDialogFragment.fragmentDg = fragmentDg;
//            return new MyDialogFragment();
//        }
//
//        public void setFragmentDg(FragmentDg fragmentDg) {
//            this.fragmentDg = fragmentDg;
//        }
//
//        @Nullable
//        @Override
//        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//            return super.onCreateView(inflater, container, savedInstanceState);
//        }
//
//        @Override
//        public Dialog onCreateDialog(Bundle savedInstanceState) {
//            return fragmentDg.getBuilder().create();
////            return super.onCreateDialog(savedInstanceState);
////            return new AlertDialog.Builder(getActivity())
////                    .setTitle("TITLE")
////                    .setMessage("MESSAGE").create();
//        }
//
//
//    }
//
//}