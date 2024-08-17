module fulgurstrike.warframemoddingproject {
    requires javafx.controls;
    requires javafx.fxml;


    opens fulgurstrike.warframemoddingproject to javafx.fxml;
    exports fulgurstrike.warframemoddingproject;
    exports fulgurstrike.warframemoddingproject.mod;
    exports fulgurstrike.warframemoddingproject.warframe;
    exports fulgurstrike.warframemoddingproject.exceptions;
}