module com.example.comp3111f23g05 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.comp3111f23g05 to javafx.fxml;
    exports com.example.comp3111f23g05;
}