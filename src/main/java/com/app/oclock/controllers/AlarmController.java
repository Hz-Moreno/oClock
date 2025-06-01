package com.app.oclock.controllers;

import com.app.oclock.models.Alarm;
import javafx.fxml.FXML;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.io.File;
import java.util.Arrays;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class AlarmController {
    @FXML
    private TextField timeInput;

    @FXML
    private Label statusLabel;

    @FXML
    private TextField titleInput;

    @FXML
    private TextArea descriptionInput;

    private final Timer timer = new Timer();
    private static final String FILE_PATH = "alarms.json";

    @FXML
    public void setAlarm(){
        String time = timeInput.getText();
        String title = titleInput.getText();
        String description = descriptionInput.getText();

        if(time.isBlank() || title.isBlank()){
            statusLabel.setText("Time and title is required!");
        }

        Alarm alarm = new Alarm(title, time, description);
        ObjectMapper mapper = new ObjectMapper();
        List<Alarm> alarms = new ArrayList<>();

        try{
            File file = new File(FILE_PATH);

            if(!file.exists()){
                file.getParentFile().mkdirs();
                mapper.writeValue(file, alarms);
            }

            if(file.exists()){
                alarms = Arrays.asList(mapper.readValue(file, Alarm[].class));
                alarms = new ArrayList<>(alarms);
            }

            alarms.add(alarm);

            mapper.writerWithDefaultPrettyPrinter().writeValue(file, alarms);
            statusLabel.setText("Alarm saved! " + time);

            timeInput.clear();
            descriptionInput.clear();
            titleInput.clear();
        }catch (IOException e){
            statusLabel.setText("Error saving alarm: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void showAlert(String title, String description){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(description);
        alert.show();
    }
}
