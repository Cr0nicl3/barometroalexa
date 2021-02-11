module com.mycompany.barometrofx {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.barometrofx to javafx.fxml;
    exports com.mycompany.barometrofx;
}
