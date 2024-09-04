#include <GL/glut.h>
#include <cmath>

float angle = 0.0f;  
float size = 1.0f;
const float sizeSpeed = 0.02f;
const float rotationSpeed = 1.0f;

void displayCube(void) {

  glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // Clear the screen and the depth buffer
  glLoadIdentity();

  glMatrixMode(GL_PROJECTION);
  glLoadIdentity();
  gluPerspective(45.0, 4.0 / 3.0, 0.1, 100.0); // 45-degree field of view, 4:3 aspect ratio, near and far planes

  // Switch to modelview matrix
  glMatrixMode(GL_MODELVIEW);
  glLoadIdentity();
  
  // LEFT CUBE
  glTranslatef(-1.5f, 0.0f, -8.0f); // Move left 1.5 Units and 7  units into the screen
  glRotatef(angle, 0.0f, 1.0f, 0.0f); // Rotate around the y-axis
  glScalef(size, size, size); // scale the cube
  glColor3f(1.0f, 0.0f, 0.0f);      // Set the color to red
  glutWireCube(size); // Creates a cube with sides of length 2.0
  
  glLoadIdentity();
  
   // LEFT CUBE DIFFERENT ORDER
  glScalef(size, size, size); // scale the cube
  glTranslatef(-1.5f, 0.0f, -8.0f); // Move left 1.5 Units and 7  units into the screen
  glRotatef(angle, 0.0f, 1.0f, 0.0f); // Rotate around the y-axis
  glColor3f(1.0f, 0.0f, 0.0f);      // Set the color to red
  glutWireCube(size); // Creates a cube with sides of length 2.0
  
  glLoadIdentity();
  
  // RIGHT CUBE
  glTranslatef(1.5f, size, -8.0f);
  glRotatef(-angle, angle, 1.0f, 0.0f);
  glColor3f(0.0f, 1.0f, 0.0f);
  glutWireCube(1.0f);
  
  glLoadIdentity();
  
   // RIGHT CUBE DIFFERENT ORDER
  glRotatef(-angle, angle, 1.0f, 0.0f);
  glColor3f(0.0f, 1.0f, 0.0f);
  glTranslatef(1.5f, size, -8.0f);
  glutWireCube(1.0f);
  

  glutSwapBuffers(); // Swap buffers to double buffering
}

void timer(int value) {
    angle += 1.0f;  
    if (angle > 360.0f) {
        angle -= 360.0f;  // Reset the angle when it reaches 360
    }
     size = 1.0f + 0.5f * sin(angle * M_PI / 180.0f); // Vary the size from 0.5 to 1.5
    
    glutPostRedisplay();  // Ask for a redraw of the cube
    glutTimerFunc(16, timer, 0);  //Call this functions again in 16ms
}

int main(int argc, char **argv) {
  glutInit(&argc, argv);
  glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB | GLUT_DEPTH);
  glutInitWindowSize(800, 600);
  glutInitWindowPosition(100, 100);
  glutCreateWindow("Assignment_2_3_IDATT2505");

  glutDisplayFunc(displayCube);
  glutTimerFunc(0, timer, 0); 
  glutMainLoop();
  return 0;
}
