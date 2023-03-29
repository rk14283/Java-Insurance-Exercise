module com.example.insuranceplanupdated {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.insuranceplanupdated to javafx.fxml;
    exports com.example.insuranceplanupdated;
}