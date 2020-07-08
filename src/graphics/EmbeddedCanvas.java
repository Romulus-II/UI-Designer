/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphics;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Owner
 */
public class EmbeddedCanvas {
    
    private final double BACKGROUND_WIDTH, BACKGROUND_HEIGHT;
    
    private final double BUFFER = 100;
    
    private final Canvas canvas;
    private final GraphicsContext ctx;
    private final Pane pane;
    
    private boolean grid_view = true;
    
    private Rectangle marker;
    
    public EmbeddedCanvas(double width, double height) {
        BACKGROUND_WIDTH = width;
        BACKGROUND_HEIGHT = height;
        canvas = new Canvas(BACKGROUND_WIDTH, BACKGROUND_HEIGHT);
        ctx = canvas.getGraphicsContext2D();
        pane = new Pane(canvas);
        
        initializeCanvas();
        
        canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>(){
            @Override public void handle(MouseEvent event) {onMousePress(event);}
        });
        canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, new EventHandler<MouseEvent>(){
            @Override public void handle(MouseEvent event) {onMouseDrag(event);}
        });
        canvas.addEventHandler(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>(){
            @Override public void handle(MouseEvent event) {onMouseRelease(event);}
        });
        
    }
    
    public Pane render() {
        return pane;
    }
    
    public void enableGridView() {
        grid_view = true;
    }
    
    public void disableGridView() {
        grid_view = false;
    }
    
    private void initializeCanvas() {
        ctx.clearRect(0, 0, BACKGROUND_WIDTH, BACKGROUND_WIDTH);
        ctx.beginPath();
        ctx.rect(0, 0, BACKGROUND_WIDTH, BACKGROUND_WIDTH);
        ctx.setFill(Color.SLATEGREY);
        ctx.fill();
        ctx.closePath();
        ctx.beginPath();
        ctx.rect(BUFFER, BUFFER, BACKGROUND_WIDTH-(BUFFER*2), BACKGROUND_HEIGHT-(BUFFER*2));
        ctx.setFill(Color.WHITE);
        ctx.fill();
        ctx.closePath();
        if (grid_view) {
            ctx.setStroke(Color.DARKCYAN);
            ctx.setGlobalAlpha(0.5);
            for (int i = 0; i < BACKGROUND_WIDTH; i+=10) {
                ctx.beginPath();
                ctx.moveTo(i, 0);
                ctx.lineTo(i, BACKGROUND_HEIGHT);
                ctx.stroke();
                ctx.closePath();
            }
            for (int i = 0; i < BACKGROUND_HEIGHT; i+=10) {
                ctx.beginPath();
                ctx.moveTo(0, i);
                ctx.lineTo(BACKGROUND_WIDTH, i);
                ctx.stroke();
                ctx.closePath();
            }
            ctx.setGlobalAlpha(1.0);
        }
    }
    
    
    private boolean onCanvas(double x, double y) {
        if(x >= BUFFER && x <= BACKGROUND_WIDTH-BUFFER) {
            if(y >= BUFFER && y <= BACKGROUND_HEIGHT-BUFFER) {
                return true;
            }
        }
        return false;
    }
    
    private void onMousePress(MouseEvent event) {
        double x = event.getX();
        double y = event.getY();
        
        if(onCanvas(x, y)) {
            double marker_x = x - (BUFFER/20);
            double marker_y = y - (BUFFER/20);
            //marker = new Rectangle
        }
    }
    
    private void onMouseDrag(MouseEvent event) {
        double x = event.getX();
        double y = event.getY();
        
        if(onCanvas(x, y)) {
            marker.setX(x - (BUFFER/20));
            marker.setY(y - (BUFFER/20));
        }
    }
    
    private void onMouseRelease(MouseEvent event) {
        marker = null;
    }
    
}
