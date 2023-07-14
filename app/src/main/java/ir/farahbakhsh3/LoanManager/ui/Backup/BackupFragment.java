package ir.farahbakhsh3.LoanManager.ui.Backup;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import ir.farahbakhsh3.LoanManager.databinding.FragmentBackupBinding;

public class BackupFragment extends Fragment {

    private FragmentBackupBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        BackupViewModel backupViewModel =
                new ViewModelProvider(this).get(BackupViewModel.class);

        binding = FragmentBackupBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textBackup;
        backupViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}