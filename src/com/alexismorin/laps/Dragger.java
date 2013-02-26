package com.alexismorin.laps;

import com.alexismorin.laps.mouse.MouseEvent;
import com.alexismorin.laps.words.Word;

import processing.core.PApplet;
import processing.core.PVector;

public class Dragger {
	int target = -1;
	PApplet parent;
	  Board parentBoard;
	  boolean isDragging = false;
	  boolean mouseDown = false;
	  
	  PVector mouseOffset = new PVector(0,0);//how far away the mouse is from the object corner
	  
	  Dragger(Board parentBoard, PApplet p){
		  this.parent = p;
	    this.parentBoard = parentBoard;
	  }
	  
	  void drag(MouseEvent e){
	    if(mouseDown && target != -1){
	       Word w = parentBoard.words.get(target);
	       w.pos.x = e.mousePos.x - mouseOffset.x;
	       w.pos.y = e.mousePos.y - mouseOffset.y;
	    }
	  }
	  
	  public void onMouseEvent(MouseEvent e){
	      if(e.type == Config.MOUSE_PRESSED){
	        mouseDown = true;
	        //iterate through the tiles, if intersection is found
	         for(int i = 0; i<parentBoard.words.size();i++){
	           Word t = parentBoard.words.get(i);
	           if(e.mousePos.x > t.pos.x
	            && e.mousePos.x < t.pos.x + Config.wordSize 
	            && e.mousePos.y > t.pos.y
	            && e.mousePos.y < t.pos.y + Config.wordSize){
	              
	              this.target = i;
	              mouseOffset.x = e.mousePos.x - t.pos.x;
	              mouseOffset.y = e.mousePos.y - t.pos.y; 
	              break;
	           }
	         }
	      }
	      
	      if(e.type == Config.MOUSE_RELEASED){
	    	  
	    	if(target != -1){
	    		Word t = parentBoard.words.get(target);
	    		
	    		if(t.pos.y > (parent.height/2-Config.wordSize)+5 && t.pos.y < (parent.height/2)-5){
	    			t.pos.y = parent.height/2 - (Config.wordSize/2);
	    			t.snapped = true;
	    		}else{
	    			t.snapped = false;
	    		}
	    	}
	    	  
	        mouseDown = false;
	        mouseOffset.x = 0;
	        mouseOffset.y = 0;
	        target = -1;
	        
	        //check for new sentences
	        parentBoard.sortSentence();
	      }
	      
	      if(e.type == Config.MOUSE_DRAGGED){
	        if(this.target != -1){
	           drag(e);
	        }
	      }
	  }
}
