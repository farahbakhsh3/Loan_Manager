package ir.farahbakhsh3.LoanManager.ui.Moavagh;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import ir.farahbakhsh3.LoanManager.databinding.FragmentMoavaghBinding;

public class MoavaghFragment extends Fragment {

    private FragmentMoavaghBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MoavaghViewModel moavaghViewModel =
                new ViewModelProvider(this).get(MoavaghViewModel.class);

        binding = FragmentMoavaghBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textMoavagh;
        moavaghViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}