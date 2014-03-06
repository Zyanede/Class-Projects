//Ashleigh Amrine
//Computer Graphics Lab #2
//900749251
size(200, 200);
int x1, y1, x2, y2;
x1 = 30;
y1 = 20;
x2 = 130;
y2 = 20;

strokeWeight(5);
translate(120,20);
rotate(radians(110));
line(x1, y1, x2, y2);

strokeWeight(10);
translate(95,-45);
rotate(radians(70));
scale(.5);
line(x1, y1, x2, y2);

strokeWeight(5);
translate(25,-92);
rotate(radians(70));
scale(2);
line(x1, y1, x2, y2);
