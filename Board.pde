class Board{
  ArrayList<Word> words;
  Dragger dragger;  
  Board(){
   words = new ArrayList<Word>();
   dragger = new Dragger(this);
  }
  
  void makeWords(){
    addWord("walk");
    addWord("I");
    addWord("home");
  }
  
  void addWord(String word){
    words.add(new Word(new PVector(100*words.size()+20, 100), word));
  }
  
  void onMouseEvent(MouseEvent e){
    
    dragger.onMouseEvent(e);
  }
}
