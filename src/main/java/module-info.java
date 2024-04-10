module com.example.veterinaria {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.veterinaria to javafx.fxml;
    exports com.example.veterinaria;
    exports com.example.veterinaria.Controllers;
    opens com.example.veterinaria.Controllers to javafx.fxml;
}