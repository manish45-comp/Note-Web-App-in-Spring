package com.NoteApp.Note.NoteController;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Formatter;

public class demo {
    public static void main(String[] args) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH.mm");
        LocalTime time1 = LocalTime.now().minusHours(12);
         String  i = time1.format(dateTimeFormatter);
        System.out.println(i);
    }
}
