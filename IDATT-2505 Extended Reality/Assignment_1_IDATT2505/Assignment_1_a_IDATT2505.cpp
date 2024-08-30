#include <GL/glut.h>

void displayTriangel(void) {

  glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // Clear the screen and the depth buffer
  glLoadIdentity();

  glMatrixMode(GL_PROJECTION);
  glLoadIdentity();
  gluPerspective(45.0, 4.0 / 3.0, 0.1, 100.0); // 45-degree field of view, 4:3 aspect ratio, near and far planes

  // Switch to modelview matrix
  glMatrixMode(GL_MODELVIEW);
  glLoadIdentity();

  glTranslatef(-1.5f, 0.0f, -8.0f); // Move left 1.5 Units and 7 units into the screen
  glColor3f(1.0f, 0.0f, 0.0f);      // Set the color to red

  glBegin(GL_TRIANGLES);          // Start drawing using the polygon primitive GL_TRIANGLES
  glVertex3f(0.0f, 1.0f, 0.0f);   // Top
  glVertex3f(-1.0f, -1.0f, 0.0f); // Bottom left
  glVertex3f(1.0f, -1.0f, 0.0f);  // Bottom right
  glEnd();

  glutSwapBuffers(); // Swap buffers to double buffering
}

void idle() {
  glutPostRedisplay(); // Re-render the scene continuously
}

int main(int argc, char **argv) {
  glutInit(&argc, argv);
  glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB | GLUT_DEPTH);
  glutInitWindowSize(800, 600);
  glutInitWindowPosition(100, 100);
  glutCreateWindow("Assignment_1_a_IDATT2505");

  glutDisplayFunc(displayTriangel);
  glutIdleFunc(idle);
  glutMainLoop();
  return 0;
}
