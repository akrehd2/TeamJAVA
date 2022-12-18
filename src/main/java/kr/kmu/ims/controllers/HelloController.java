package kr.kmu.ims.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private Button FinalBtn;
    @FXML
    private TextField IdText;
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");



    }

    public void onCloseButtonClick(ActionEvent actionEvent) {

    }
    @FXML
    public void FinalBtnClick(ActionEvent actionEvent)
    {
        //해야하는 일...
        //1. GOODS_ADJUSTMENT_NOTE에 값을 Status =“finalized”
        //2 Status Date=Current date time
        //3 Is Finalized=True

        String ID = IdText.getText().toString();

    }
}