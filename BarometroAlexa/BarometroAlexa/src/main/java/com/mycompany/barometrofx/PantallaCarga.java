package com.mycompany.barometrofx;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;

/**
 *
 * @author Cronicle
 */
public class PantallaCarga {
    @FXML
    public ProgressBar carga;
    @FXML
    void initialize(){
    new Thread(createWorker()).start();
    }
    public Task createWorker() {
        return new Task() {
            @Override
            protected Object call() throws Exception {
                for (int i = 0; i < 10; i++) {
                    Thread.sleep(200);
                    carga.setProgress((double)i/10);
                }
                App.setRoot("barometro");
                return true;
            }
        };
    }
}
