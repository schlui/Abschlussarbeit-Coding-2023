module com.example.abschlussprojekt2023 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.abschlussprojekt2023 to javafx.fxml;
    exports com.example.abschlussprojekt2023;
}