package kr.kmu.ims.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import kr.kmu.ims.repositories.DepartmentRepository;

import java.sql.SQLException;

public class DepartmentController {


    public Button SearchBtn;
    public TextField IDText;
    public TextField NameText;

    public void DeleteButtonClick(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        DepartmentRepository.deleteDepartment(IDText.getText(), NameText.getText());
    }

    public void CloseButtonClick(ActionEvent actionEvent)   {
        System.exit(0);
    }

    public void AddButtonDepartment(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        DepartmentRepository.insertDepartment(NameText.getText());
    }

    public void SearchButtonClick(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        IDText.setText(DepartmentRepository.searchDepartment(NameText.getText()));
    }
}
