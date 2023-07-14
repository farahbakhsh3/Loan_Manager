package ir.farahbakhsh3.LoanManager.ui.Restore;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import ir.farahbakhsh3.LoanManager.databinding.FragmentRestoreBinding;

public class RestoreFragment extends Fragment {

    private FragmentRestoreBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        RestoreViewModel restoreViewModel =
                new ViewModelProvider(this).get(RestoreViewModel.class);

        binding = FragmentRestoreBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textRestore;
        restoreViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}