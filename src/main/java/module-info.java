module com.example.comp3111f23g05 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.swing;

    opens com.example.comp3111f23g05 to javafx.fxml, javafx.controls;
    exports com.example.comp3111f23g05;
    exports com.example.comp3111f23g05.map;
    opens com.example.comp3111f23g05.map to javafx.controls;

    exports com.example.comp3111f23g05.controller to javafx.fxml;
    opens com.example.comp3111f23g05.controller to javafx.fxml;
    exports com.example.comp3111f23g05.movables;
    opens com.example.comp3111f23g05.movables to javafx.controls, javafx.fxml;
}