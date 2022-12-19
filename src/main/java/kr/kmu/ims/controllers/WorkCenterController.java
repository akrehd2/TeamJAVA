package kr.kmu.ims.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import kr.kmu.ims.repositories.WorkCenterRepository;

import java.sql.SQLException;

public class WorkCenterController {
    public TextField IDText;
    public TextField NameText;



    public void DeleteButtonClick(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        //workcenter 삭제 버튼
        WorkCenterRepository.deleteWorkCenter(IDText.getText(), NameText.getText());


    }


    public void CloseButtonClick(ActionEvent actionEvent)  {
        System.exit(0);
    }


    public void SearchButtonClick(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        //id찾기
        IDText.setText(WorkCenterRepository.searchWorkCenter (NameText.getText()));

    }

    public void InseartButton(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        WorkCenterRepository.insertWorkCenter( NameText.getText());

    }
}
