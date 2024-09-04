#include <GL/glut.h>
#include <cmath>

float angle = 0.0f;  
float size = 1.0f;
const float rotationSpeed = 1.0f;

// Variables for camera movement
float cameraX = 0.0f, cameraY = 0.0f, cameraZ = 10.0f; // Camera position
float cameraAngleX = 0.0f, cameraAngleY = 0.0f;        // Camera rotation angles

void displayCube(void) {
    // Clear the screen and the depth buffer
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); 
    glLoadIdentity();  // Reset the modelview matrix

    // Use gluLookAt to set up the camera
    gluLookAt(cameraX, cameraY, cameraZ,   // Camera position
              0.0, 0.0, 0.0,              // Look at origin
              0.0, 1.0, 0.0);             // Up direction (Y-axis)

    // LEFT CUBE
    glPushMatrix();  // Save the current transformation matrix
    glTranslatef(-1.5f, 0.0f, -8.0f); // Move left and into the screen
    glRotatef(angle, 0.0f, 1.0f, 0.0f); // Rotate around the y-axis
    glScalef(size, size, size); // Scale the cube
    glColor3f(1.0f, 0.0f, 0.0f);  // Set the color to red
    glutWireCube(1.0); // Draw a wireframe cube with side length 1.0
    glPopMatrix();   // Restore the transformation matrix

    // RIGHT CUBE
    glPushMatrix();  // Save the current transformation matrix
    glTranslatef(1.5f, size, -8.0f); // Move right and into the screen
    glRotatef(-angle, angle, 1.0f, 0.0f); // Rotate around an axis
    glColor3f(0.0f, 1.0f, 0.0f);  // Set the color to green
    glutWireCube(1.0); // Draw another wireframe cube with side length 1.0
    glPopMatrix();   // Restore the transformation matrix

    // Swap buffers to display the rendered frame
    glutSwapBuffers(); 
}

void timer(int value) {
    // Update angle and size
    angle += rotationSpeed;  
    if (angle > 360.0f) {
        angle -= 360.0f;  // Reset the angle when it reaches 360 degrees
    }
    size = 1.0f + 0.5f * sin(angle * M_PI / 180.0f); // Vary size between 0.5 and 1.5

    // Request a redraw of the cube
    glutPostRedisplay();  
    glutTimerFunc(16, timer, 0);  // Call this function again in 16 ms
}

// Function to handle keyboard input
void handleKeypress(int key, int x, int y) {
    switch (key) {
        case GLUT_KEY_UP:    // Move camera forward
            cameraZ -= 0.5f;
            break;
        case GLUT_KEY_DOWN:  // Move camera backward
            cameraZ += 0.5f;
            break;
        case GLUT_KEY_LEFT:  // Move camera left
            cameraX -= 0.5f;
            break;
        case GLUT_KEY_RIGHT: // Move camera right
            cameraX += 0.5f;
            break;
    }
    glutPostRedisplay(); // Redraw after a change
}

int main(int argc, char **argv) {
    glutInit(&argc, argv);
    glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB | GLUT_DEPTH);
    glutInitWindowSize(800, 600);
    glutInitWindowPosition(100, 100);
    glutCreateWindow("Assignment_2_3_IDATT2505");

    // Set up the projection matrix
    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();
    gluPerspective(45.0, 4.0 / 3.0, 0.1, 100.0); // 45-degree field of view, 4:3 aspect ratio, near and far planes

    // Switch back to the modelview matrix
    glMatrixMode(GL_MODELVIEW);
    
    glEnable(GL_DEPTH_TEST); // Enable depth testing for true 3D effects

    glutDisplayFunc(displayCube);
    glutTimerFunc(0, timer, 0); 
    glutSpecialFunc(handleKeypress); // Register function for special keys (arrow keys)
    glutMainLoop();
    return 0;
}

