module com.example.dimlom {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.dimlom to javafx.fxml;
    exports com.example.dimlom;
}