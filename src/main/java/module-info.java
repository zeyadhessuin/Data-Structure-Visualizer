module com.example.datastructurevisualizer {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    //requires jfxrt;
    //requires rt;

    opens com.example.datastructurevisualizer to javafx.fxml;
    exports com.example.datastructurevisualizer;
}