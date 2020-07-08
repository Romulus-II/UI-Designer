/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 *
 * @author Owner
 */
public class MainToolbar {
    
    private final int WIDTH, HEIGHT;
    private final VBox tools; 
    
    public MainToolbar(int width, int height) {
        WIDTH = width;
        HEIGHT = height;
        tools = new VBox();
        tools.setPrefWidth(WIDTH);
        tools.setPrefHeight(HEIGHT);
        
        tools.setBackground(Background.EMPTY);
        String style = "-fx-background-color: rgba(255, 255, 255, 0.5);";
        tools.setStyle(style);
    }
    
    public VBox getContent(){
        return tools;
    }
    
}
