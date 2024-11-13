module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;


    opens PizzaMaker to javafx.fxml;
    exports PizzaMaker;
}