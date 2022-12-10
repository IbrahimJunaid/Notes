package com.dodo.note.database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.dodo.note.dao.NoteDao;
import com.dodo.note.entities.Note;

@Database(entities = Note.class, version = 1, exportSchema = false)
public abstract class NoteDatabase extends RoomDatabase {

    private static NoteDatabase noteDatabase;

    public static synchronized NoteDatabase getDatabase(Context context){
        if (noteDatabase==null){
            noteDatabase= Room.databaseBuilder(
                    context,
                    NoteDatabase.class,"note_db"
            ).build();
        }
        return noteDatabase;
    }
    public abstract NoteDao noteDao();
}
