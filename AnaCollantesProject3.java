///project 2
///By: Ana Collantes
float redX, redY, redDX, redDY;
float yellowX;
float yellowY;
float yellowDX, yellowDY;
float blueX, blueY, blueDX, blueDY;
float left;
float right;
float down;
float up;
float temp;
float buttonX;
float buttonY;


void setup() {
  rectMode(CORNERS);
  size( 700, 500);
  background(255);
  
  buttonX=600;
  buttonY=50;
  
 redX = 200;
 yellowX = 200;
 yellowY = 200;
 redDX = random(-4,4);
 redDY = random(-4,4);
 yellowDX = random(-4,4);
 yellowDY = random(-4,4);
 blueDX = random(-4,4);
 blueDY = random(-4,4);
 
 left=90;
 right = width-90;
 down = height-90;
 up= 90;
 
 redX= random(left, right);
 redY= random(up, down);
 yellowX=random(left, right);
 yellowY= random(up, down);
 blueX=random(left, right);
 blueY=random(up, down);
 
}
void draw() {
  background(0);
 table();
  move();
  collisions();
 button();
 bird();
rat();


}
void table() {
  ///pool table
  fill(95, 83, 57);
  rect(left-10, up-10, right+10, down+10);

  ///borders
  fill(156, 255, 137);
  rect(left, up, right, down);


}

void move() {
  ///RED ball
  fill(252,0, 0);   ellipse(redX,redY, 25, 25);
  
  redX=redX + redDX;
 redY=redY + redDY;
 if (redX>right || redX<left){
   redDX=-redDX;
 }
   if (redY>down || redY<up){
   redDY=-redDY;
   }
  
/*redX=redX + DY;
redY=redY + DY;
*/
  

  ///YELLOW ball
  fill(243, 252, 0);  ellipse(yellowX, yellowY, 25, 25);
  yellowX=yellowX + yellowDX;
 yellowY=yellowY + yellowDY;
 if (yellowX>right || yellowX<left){
   yellowDX=-yellowDX;
 }
   if (yellowY>down || yellowY<up){
   yellowDY=-yellowDY;
   }
  
  
  ///BLUE ball
  fill(3,12, 255);   ellipse(blueX, blueY, 25, 25);
  blueX=blueX + blueDX;
 blueY=blueY + blueDY;
 if (blueX>right || blueX<left){
   blueDX=-blueDX;
 }
   if (blueY>down || blueY<up){
   blueDY=-blueDY;
   }

 
  
}
void collisions() {
  if( dist(redX, redY,yellowX, yellowY)<25) {
    temp=redDX;
    redDX=yellowDX;
    yellowDX=temp;
    
    temp=redDY;
    redDY=yellowDY;
    yellowDY=temp;
  }
    if(dist(yellowX, yellowY, blueX, blueY)<25) {
      temp=yellowDX;
      yellowDX=blueDX;
      blueDX=temp;
      
      temp=yellowDY;
      yellowDY=blueDY;
      blueDY=temp;
    }
    if(dist(blueX, blueY, redX, redY)<25) {
      temp=blueDX;
      blueDX=redDX;
      redDX=temp;
      
      temp=blueDY;
      blueDY=redDY;
      redDY=temp;
    }
}
  
  void reset() {
    
     redDX = random(-4,4);
 redDY = random(-4,4);
 yellowDX = random(-4,4);
 yellowDY = random(-4,4);
 blueDX = random(-4,4);
 blueDY = random(-4,4);
 
  redX= random(width/2, right);
 redY= random(up, down);
 yellowX=random(width/2, right);
 yellowY= random(up, down);
 blueX=random(width/2, right);
 blueY=random(up, down);
}
void button() {
  
  fill(178, 255, 245);
  ellipse(buttonX, buttonY, 40,40);
  fill(78,59,255);
  text("reset", 587, 54);
}
void mousePressed() {
  if( dist(buttonX, buttonY, mouseX, mouseY)<25) {
    reset();
  }
}
void bird() {
  fill(245, 245, 247);
  if ((frameCount % 30) <15) {
  triangle(40,50, 50, 90, 100, 55);} else {
      triangle(50, 50, 80, 70, 115, 55);
    }
   
}
void rat() {
  fill(110,110, 113);
  if ((frameCount % 30) <15) {
    ellipse(90,383, 20, 20);} else {
      ellipse(90, 383, 25, 25);
    }
}
