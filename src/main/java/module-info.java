module com.example.comp3111f23g05 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.swing;

    opens com.example.comp3111f23g05 to javafx.fxml, javafx.controls;
    exports com.example.comp3111f23g05;
    exports com.example.comp3111f23g05.Map;
    opens com.example.comp3111f23g05.Map to javafx.controls;

    exports com.example.comp3111f23g05.controller to javafx.fxml;
    opens com.example.comp3111f23g05.controller to javafx.fxml;
}