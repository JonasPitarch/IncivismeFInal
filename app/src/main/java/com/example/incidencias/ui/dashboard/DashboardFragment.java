package com.example.incidencias.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.incidencias.databinding.FragmentDashboardBinding;
import com.example.incidencias.databinding.RvIncidenciesItemBinding;
import com.example.incidencias.ui.Servidor;
import com.example.incidencias.ui.home.SharedViewModel;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    private FirebaseUser authUser;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);
        SharedViewModel sharedViewModel = new ViewModelProvider(
                requireActivity()
        ).get(SharedViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        sharedViewModel.getUser().observe(getViewLifecycleOwner(), user -> {
            authUser = user;

            if (user != null) {
                DatabaseReference base = FirebaseDatabase.getInstance().getReference();

                DatabaseReference users = base.child("users");
                DatabaseReference uid = users.child(authUser.getUid());
                DatabaseReference incidencies = uid.child("incidencies");

                FirebaseRecyclerOptions<Servidor> options = new FirebaseRecyclerOptions.Builder<Servidor>()
                        .setQuery(incidencies, Servidor.class)
                        .setLifecycleOwner(this)
                        .build();

                ServerAdapter adapter = new ServerAdapter(options);

                binding.rvIncidencies.setAdapter(adapter);
                binding.rvIncidencies.setLayoutManager(
                new LinearLayoutManager(requireContext())
                );

            }
        });

        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public class ServerAdapter extends FirebaseRecyclerAdapter<Servidor, ServerAdapter.ServerViewHolder> {
        public ServerAdapter(@NonNull FirebaseRecyclerOptions<Servidor> options) {
            super(options);
        }

        @Override
        protected void onBindViewHolder(
        @NonNull ServerViewHolder holder, int position, @NonNull Servidor model
            ) {
            holder.binding.txtDescripcio.setText(model.getDserver());
            holder.binding.txtAdreca.setText(model.getDireccio());
        }

        @NonNull
        @Override
        public ServerViewHolder onCreateViewHolder(
        @NonNull ViewGroup parent, int viewType
            ) {
            return new ServerViewHolder(RvIncidenciesItemBinding.inflate(
                    LayoutInflater.from(parent.getContext()),
                    parent, false));
        }

        class ServerViewHolder extends RecyclerView.ViewHolder {
            RvIncidenciesItemBinding binding;

            public ServerViewHolder(RvIncidenciesItemBinding binding) {
                super(binding.getRoot());
                this.binding = binding;
            }
        }
    }
}