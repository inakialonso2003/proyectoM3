module com.mycompany.projectecaixerautomatic {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.projectecaixerautomatic to javafx.fxml;
    exports com.mycompany.projectecaixerautomatic;
}
