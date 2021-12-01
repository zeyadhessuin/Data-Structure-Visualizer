package com.example.datastructurevisualizer;

import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class Controller {
    /* General
     */
    @FXML
    private Label welcomeText;
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    /*
     */
    @FXML
    protected void onLinkedListBtnClick(){

    }
    @FXML
    protected void onStackBtnClick(){

    }
    @FXML
    protected void onQueueBtnClick(){

    }
}