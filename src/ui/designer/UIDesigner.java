/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.designer;

// Load custom modules
import controllers.MainToolbar;
import graphics.EmbeddedCanvas;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Owner
 */
public class UIDesigner extends Application {
    
    private final int WINDOW_WIDTH = 1250, WINDOW_HEIGHT = 750;
    private final int TOOLBAR_WIDTH = WINDOW_WIDTH, TOOLBAR_HEIGHT = 100;
    private final int CANVAS_WIDTH = 1000, CANVAS_HEIGHT = WINDOW_HEIGHT-TOOLBAR_HEIGHT;
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
                
        VBox root = new VBox();
        
        MainToolbar toolbar = new MainToolbar(TOOLBAR_WIDTH, TOOLBAR_HEIGHT);
        EmbeddedCanvas canvas = new EmbeddedCanvas(CANVAS_WIDTH, CANVAS_HEIGHT);
        
        root.getChildren().add(toolbar.getContent());
        root.getChildren().add(canvas.render());
        
        Scene scene = new Scene(root, 1250, 750);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
