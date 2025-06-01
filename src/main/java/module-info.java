module com.app.oclock {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires com.fasterxml.jackson.databind;
    opens com.app.oclock.models to com.fasterxml.jackson.databind;

    opens com.app.oclock to javafx.fxml;
    opens com.app.oclock.controllers to javafx.fxml;
    exports com.app.oclock;
}