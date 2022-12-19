
module kr.kmu.ims {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires java.sql.rowset;
    requires javax.persistence;
    requires jasperreports;

    opens kr.kmu.ims to javafx.fxml;
    exports kr.kmu.ims;
    exports kr.kmu.ims.models;
    opens kr.kmu.ims.models to javafx.fxml;
    exports kr.kmu.ims.controllers;
    opens kr.kmu.ims.controllers to javafx.fxml;
    exports kr.kmu.ims.repositories;
    opens kr.kmu.ims.repositories to javafx.fxml;
    exports kr.kmu.ims.util;
    opens kr.kmu.ims.util to javafx.fxml;
}