package ir.farahbakhsh3.LoanManager.ui.Daftarche;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import ir.farahbakhsh3.LoanManager.databinding.FragmentDaftarcheBinding;

public class DaftarcheFragment extends Fragment {

    private FragmentDaftarcheBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DaftarcheViewModel daftarcheViewModel =
                new ViewModelProvider(this).get(DaftarcheViewModel.class);

        binding = FragmentDaftarcheBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textDaftarche;
        daftarcheViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}