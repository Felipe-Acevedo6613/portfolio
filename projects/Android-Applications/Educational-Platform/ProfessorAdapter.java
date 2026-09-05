package com.example.cmaisonneuve;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProfessorAdapter extends RecyclerView.Adapter<ProfessorAdapter.ProfessorViewHolder> {
    private List<ProfessorItem> professorList;
    private OnItemClickListener listener;


    public  interface  OnItemClickListener{
        void onItemClick(ProfessorItem professorItem);
    }
    public ProfessorAdapter(List<ProfessorItem> cList, OnItemClickListener listener){
        this.professorList = professorList;
        this.listener = listener;
    }
    @NonNull
    @Override
    public ProfessorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_professor, parent, false);
        return new ProfessorViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfessorViewHolder holder, int position) {
        ProfessorItem professorItem = professorList.get(position);
        holder.textViewFirstName.setText(professorItem.getFirstName());
        holder.textViewLastName.setText(professorItem.getLastName());
        holder.textViewEmail.setText(professorItem.getEmail());
        holder.textViewDepartment.setText(professorItem.getDepartment());


        // comment afficher un toast quand l utilisateur clique sur un element de la liste
        holder.bind(professorItem, listener);
    }

    @Override
    public int getItemCount() {
        return professorList.size();
    }
    public static class ProfessorViewHolder extends RecyclerView.ViewHolder {
        TextView textViewFirstName;
        TextView textViewLastName;
        TextView textViewEmail;
        TextView textViewDepartment;
        public ProfessorViewHolder(@NonNull View itemView){
            super(itemView);
            textViewFirstName = itemView.findViewById(R.id.firstnametext);
            textViewLastName = itemView.findViewById(R.id.lastname);
            textViewEmail = itemView.findViewById(R.id.email);
            textViewDepartment = itemView.findViewById(R.id.department);


        }

        // Lier les donnees du cours au clic
        public void bind(final ProfessorItem professorItem, final  OnItemClickListener listener){
            textViewFirstName.setText(professorItem.getFirstName());
            textViewLastName.setText(professorItem.getLastName());
            textViewEmail.setText(professorItem.getEmail());
            textViewDepartment.setText(professorItem.getDepartment());

            // gerer le click sur un element
            itemView.setOnClickListener(v->listener.onItemClick(professorItem));


        }
    }
}
