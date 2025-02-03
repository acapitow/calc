package org.calcmvc.main;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.calcmvc.calcop.calclong.CalcLong;
import org.calcmvc.common.operation.OperationType;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MainCalcMVC extends Application {
    private PropertyChangeListener propertyChangeListener;

    public MainCalcMVC() {}

    @Override
    public void start(Stage stage) {
        initPropertyChangeListener();
        CalcLong calcLong = CalcLong.create();
        calcLong.addPropertyChangeListener(this.propertyChangeListener);

        calcLong.execute();


    }

    public static void main(String[] args) {
        launch();
    }

    //// Private ////

    private void initPropertyChangeListener() {
        this.propertyChangeListener = (PropertyChangeEvent propertyChangeEvent) -> {
            String property = propertyChangeEvent.getPropertyName();

            if (property.equalsIgnoreCase(OperationType.QUIT.name())) {
                Platform.exit();
            }
        };
    }
}