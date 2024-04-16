module com.example.veterinaria {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires jakarta.persistence;
    requires java.sql;

    opens com.example.veterinaria to javafx.fxml, jakarta.persistence;
    exports com.example.veterinaria;
    exports com.example.veterinaria.Controllers;
    opens com.example.veterinaria.Controllers to javafx.fxml;
}