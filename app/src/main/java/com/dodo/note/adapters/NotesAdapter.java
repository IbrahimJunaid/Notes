package com.dodo.note.adapters;

import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dodo.note.R;
import com.dodo.note.entities.Note;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NoteViewHolder>{

    private final List<Note> notes;

    public NotesAdapter(List<Note> notes) {
        this.notes = notes;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NoteViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_container_note,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        holder.setNote(notes.get(position));
    }

    @Override
    public int getItemCount() {
        return notes.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position ;
    }
}

    class NoteViewHolder extends RecyclerView.ViewHolder{

        TextView textTitle,textSubtitle, textDateTime;
        LinearLayout layoutNote;
        RoundedImageView imageNote1;

        NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            textTitle= itemView.findViewById(R.id.textTitle);
            textSubtitle=itemView.findViewById(R.id.textSubtitle);
            textDateTime=itemView.findViewById(R.id.textDateTime);
            layoutNote= itemView.findViewById(R.id.layoutNote);
            imageNote1=itemView.findViewById(R.id.imageNote1);
        }

        void setNote(Note note){
            textTitle.setText(note.getTitle());
            if (note.getSubtitle().trim().isEmpty()){
                textSubtitle.setVisibility(View.GONE);
            }else {textSubtitle.setText(note.getSubtitle());}
            textDateTime.setText(note.getDateTime());

            GradientDrawable gradientDrawable=(GradientDrawable) layoutNote.getBackground();
            if (note.getColor()!= null){
                gradientDrawable.setColor(Color.parseColor(note.getColor()));
            }else {
                gradientDrawable.setColor(Color.parseColor("#333333"));
            }


            if (note.getImagepath() !=null){
                imageNote1.setImageBitmap(BitmapFactory.decodeFile(note.getImagepath()));
                imageNote1.setVisibility(View.VISIBLE);
            }else {
                imageNote1.setVisibility(View.VISIBLE);
            }
        }

    }

