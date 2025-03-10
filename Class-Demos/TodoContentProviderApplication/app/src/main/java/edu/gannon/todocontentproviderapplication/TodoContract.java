package edu.gannon.todocontentproviderapplication;

import android.net.Uri;

public class TodoContract {

    public static final String AUTHORITY = "edu.gannon.todocontentproviderapplication.provider";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/tasks");


    public static final String TABLE_NAME = "tasks";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_TASK = "task";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_IS_COMPLETED = "isCompleted";


}
