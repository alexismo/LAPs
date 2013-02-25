int sceneNo;
Scene scene;
Board board;

void setup (){
  size(MAPWIDTH, MAPHEIGHT);
  smooth();
  setupVariables();
}

void setupVariables(){
  board = new Board();
  board.makeWords();
  
  scene = new Scene(board);
  sceneNo = 1;
}

void draw(){
  switch(sceneNo){
    case 1:
      scene.update();
      scene.draw();
  }
}

void mousePressed(){
  MouseEvent m = new MouseEvent(MOUSE_PRESSED, mouseX, mouseY);
  scene.onMouseEvent(m);
}

void mouseReleased(){
  MouseEvent m = new MouseEvent(MOUSE_RELEASED, mouseX, mouseY);
  scene.onMouseEvent(m);
}

void mouseDragged(){
  MouseEvent m = new MouseEvent(MOUSE_DRAGGED, mouseX, mouseY);
  scene.onMouseEvent(m);
}
/*---- not really using these ones now
void mouseMoved(){
  MouseEvent m = new MouseEvent(MOUSE_MOVED, mouseX, mouseY);
  //scene.onMouseEvent(m);
}
void mouseClicked(){
  MouseEvent m = new MouseEvent(MOUSE_CLICKED, mouseX, mouseY);
  //scene.onMouseEvent(m);
}
--------*/
