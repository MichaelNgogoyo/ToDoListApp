package com.itechinfluencer.todolist;

import com.itechinfluencer.todolist.datamodel.TodoData;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("mainwindow.fxml"));
        primaryStage.setTitle("TODO List APP");
        primaryStage.setScene(new Scene(root, 900, 500));
        primaryStage.getIcons().add(new Image("com/itechinfluencer/todolist/todo.png"));
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws Exception {
        try{
            TodoData.getInstance().loadTodoItems();

        } catch (IOException e){
            System.out.println(e.getMessage());

        }
    }

    @Override
    public void stop() throws Exception {
        try{
            TodoData.getInstance().storeTodoItems();
        }
        catch (IOException e){
            System.out.println(e.getMessage());

        }
    }
}

