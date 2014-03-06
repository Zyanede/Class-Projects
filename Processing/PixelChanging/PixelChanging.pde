PImage im;
int c = 0;
void setup(){
  size(500,490);
  im =loadImage("1.jpg");
}
void draw(){
  if(im==null) return;
  im.loadPixels();
  for(int i = 0; i < im.pixels.length; i++) {
    if (im.pixels[i]!=0xffffffff)
      im.pixels[i] = (int)(Math.random()*c);
  }
  im.updatePixels();
  image(im,0,0);
  c=c+1;
}
