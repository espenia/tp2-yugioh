package vista;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.stage.Stage;


public class BarraDeMenu extends MenuBar {

    public BarraDeMenu(Stage primaryStage){
        Menu menuFile = new Menu("File");
        MenuItem quit = new MenuItem("Quit");
        quit.setOnAction(quitAction());
        menuFile.getItems().add(quit);
        this.getMenus().addAll(menuFile);

    }

    private EventHandler<ActionEvent> quitAction(){
        return new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION,"Esta Seguro que Quiere Salir?", ButtonType.YES, ButtonType.NO);
                alert.getDialogPane().setMaxHeight(5);
                alert.getDialogPane().setMaxWidth(5);
                alert.showAndWait();
                if (alert.getResult()==ButtonType.YES)
                    System.exit(0);
            }
        };
    }

}
