class Scene{
  Board board;
  PFont ubuntu;
  
  Scene(Board board){
    this.board = board;
    ubuntu = loadFont("Ubuntu-24.vlw");
  }
  
  void update(){
    
  }
  
  void draw(){
    background(255);
    strokeWeight(2);
    noFill();
    ellipseMode(CENTER);
    
    //draw the word line
    stroke(38, 133, 36);
    line(0, height/2, width, height/2);
    
    //draw tiles
    rectMode(CORNER);
    
    stroke(0);
    textFont(ubuntu, 24);
    for(Word w: board.words){
      fill(200);
      rect(w.pos.x, w.pos.y,wordSize, wordSize);
      //draw the words from the tiles
      fill(0);
      text(w.word, w.pos.x + 10, w.pos.y + wordSize/2);
    }
    
    
  }
  
  void onMouseEvent(MouseEvent e){
    board.onMouseEvent(e);
  }
  
}
