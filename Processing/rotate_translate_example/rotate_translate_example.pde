PVector v = new PVector(50,50,0);
PVector w = new PVector(100,100,0);
line(v.x,v.y,w.x,w.y);
double rad = Math.toRadians(30);
float cosine = (float)Math.cos(rad);
float sine = (float)Math.sin(rad);
//v.set(cosine*v.x-sine*v.y,cosine*v.y+sine*v.x,0);
//w.set(cosine*w.x-sine*w.y,cosine*w.y+sine*w.x,0);
rotate((float)rad);
line(v.x,v.y,w.x,w.y);
printMatrix();
//translate(-30,-40);
//line(v.x,v.y,w.x,w.y);
//printMatrix();

