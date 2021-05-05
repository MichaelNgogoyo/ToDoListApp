package com.itechinfluencer.todolist;

import com.itechinfluencer.todolist.datamodel.ToDoItem;
import com.itechinfluencer.todolist.datamodel.TodoData;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class DialogController {
    @FXML
    private TextField shortDescriptionField;

    @FXML
    private TextArea detailsArea;

    @FXML
    private DatePicker deadlinePicker;

    public ToDoItem processResults() {

        String shortDescription = shortDescriptionField.getText().trim();
        String details = detailsArea.getText().trim();
        LocalDate deadlineValue = deadlinePicker.getValue();

        ToDoItem newItem = new ToDoItem(shortDescription, details, deadlineValue);
        TodoData.getInstance().addTodoItem(newItem);

        return newItem;

    }

    public TextField getShortDescriptionField() {
        return shortDescriptionField;
    }

    public void setShortDescriptionField(TextField shortDescriptionField) {
        this.shortDescriptionField = shortDescriptionField;
    }

    public TextArea getDetailsArea() {
        return detailsArea;
    }

    public void setDetailsArea(TextArea detailsArea) {
        this.detailsArea = detailsArea;
    }

    public DatePicker getDeadlinePicker() {
        return deadlinePicker;
    }

    public void setDeadlinePicker(DatePicker deadlinePicker) {
        this.deadlinePicker = deadlinePicker;
    }
}
