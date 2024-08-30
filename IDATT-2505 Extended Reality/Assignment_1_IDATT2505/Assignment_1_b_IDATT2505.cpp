#include <GL/glut.h>

// Define the points as arrays
GLfloat points[8][3] = {
    {0.0, 2.0, 0.0},
    {1.5, 1.5, 0.0},
    {2.0, 0.0, 0.0},
    {1.5, -1.5, 0.0},
    {0.0, -2.0, 0.0},
    {-1.5, -1.5, 0.0},
    {-2.0, 0.0, 0.0},
    {-1.5, 1.5, 0.0}
};

void displayItems(void) {

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

  // Drawing points
    glBegin(GL_POINTS);     
    for (int i = 0; i < 8; ++i) {
        glVertex3fv(points[i]); // Use glVertex3fv to pass a GLfloat array
    }
    glEnd();
  
  // Drawing a line
  glBegin(GL_LINES);
  glVertex3fv(points[0]);
  glVertex3fv(points[1]);
  glEnd();
  
  // Drawing a line strip
  glBegin(GL_LINE_STRIP);
  glVertex3fv(points[2]);
  glVertex3fv(points[3]);
  glVertex3fv(points[4]);
  glVertex3fv(points[5]);
  glEnd();

   // Drawing a line loop
  glBegin(GL_LINE_LOOP);
  glVertex3fv(points[4]);
  glVertex3fv(points[5]);
  glVertex3fv(points[6]);
  glVertex3fv(points[7]);
  glEnd();

   // Drawing a triangle
  /*
  glBegin(GL_TRIANGLES);
  glVertex3fv(points[0]);
  glVertex3fv(points[5]);
  glVertex3fv(points[7]);
  glEnd();
  */
  
  glColor3f(0.0f, 0.0f, 1.0f);      // Set the color to blue
  
   // Drawing a triangle fan
  glBegin(GL_TRIANGLE_FAN);
  glVertex3fv(points[2]);
  glVertex3fv(points[3]);
  glVertex3fv(points[4]);
  glVertex3fv(points[5]);
  glEnd();
  
   glColor3f(0.0f, 1.0f, 0.0f);      // Set the color to blue
   
   // Drawing a polygon
  glBegin(GL_POLYGON);
  glVertex3fv(points[6]);
  glVertex3fv(points[7]);
  glVertex3fv(points[4]);
  glVertex3fv(points[5]);
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
  glutCreateWindow("Assignment_1_b_IDATT2505");

  glutDisplayFunc(displayItems);
  glutIdleFunc(idle);
  glutMainLoop();
  return 0;
}
