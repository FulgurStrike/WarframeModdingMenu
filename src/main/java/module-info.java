module fulgurstrike.warframemoddingproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens fulgurstrike.warframemoddingproject to javafx.fxml;
    exports fulgurstrike.warframemoddingproject;
}