class MouseEvent{
  
  PVector mousePos;
  int type;
  
  MouseEvent(int type, int posX, int posY){
    this.type = type;
    mousePos = new PVector(posX, posY);
  }
  
}
