#include <GL/glut.h>


void displayCube(void) {

  glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // Clear the screen and the depth buffer
  glLoadIdentity();

  glMatrixMode(GL_PROJECTION);
  glLoadIdentity();
  gluPerspective(45.0, 4.0 / 3.0, 0.1, 100.0); // 45-degree field of view, 4:3 aspect ratio, near and far planes

  // Switch to modelview matrix
  glMatrixMode(GL_MODELVIEW);
  glLoadIdentity();


  glColor3f(1.0f, 0.0f, 0.0f);      // Set the color to red
  
  glTranslatef(-1.5f, 0.0f, -8.0f); // Move left 1.5 Units and 7 units into the screen

  glutWireCube(2.0); // Creates a cube with sides of length 2.0

  glutSwapBuffers(); // Swap buffers to double buffering
}


int main(int argc, char **argv) {
  glutInit(&argc, argv);
  glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB | GLUT_DEPTH);
  glutInitWindowSize(800, 600);
  glutInitWindowPosition(100, 100);
  glutCreateWindow("Assignment_2_2b_IDATT2505");

  glutDisplayFunc(displayCube);
  glutMainLoop();
  return 0;
}
