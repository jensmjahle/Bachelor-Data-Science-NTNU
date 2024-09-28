#include <GL/glut.h>
#include <cmath>

// Variables for camera movement
float cameraDistance = 10.0f;     // Distance from the robot
float cameraAngleY = 0.0f;        // Horizontal angle (rotation around the Y-axis)
float cameraAngleX = 0.0f;        // Vertical angle (rotation around the X-axis)
const float rotationSpeed = 3.0f; // Speed of rotation
const float zoomSpeed = 0.5f;     // Speed of zoom

// Animation variables
float animationTime = 0.0f;        // Time variable for animation
const float armAnimationSpeed = 1.5f;  // Speed of arm swinging
const float legAnimationSpeed = 1.5f;  // Speed of leg swinging
const float movementAnimationSpeed = 0.05f; // Speed of forward/backward movement
const float swingAmplitude = 30.0f; // Amplitude of the swing motion
const float movementAmplitude = 5.0f; // Amplitude of the forward/backward movement
const float movementLimit = 5.0f;   // Limit before the robot turns around

// Direction and rotation variables
bool rotating = false;          // Tracks if the robot is rotating
float currentRotation = 0.0f;   // Tracks the current rotation angle (0 or 180 degrees)
const float rotationSpeedAnim = 2.0f; // Speed of the rotation animation

float movement = 0.0f;          // Movement along the Z-axis
int direction = 1;              // 1 for forward, -1 for backward movement

// Rotation variables for parts
float armSwing = 0.0f;
float legSwing = 0.0f;

void drawRobot(void) {
    glPushMatrix();
       
       // Handle rotation
       if (rotating) {
           currentRotation += rotationSpeedAnim;  // Increment rotation angle
           if (currentRotation >= 180.0f) {       // When 180 degrees rotation is done
               currentRotation = 0.0f;            // Reset the rotation angle
               rotating = false;                  // Stop rotating
               direction *= -1;                   // Reverse the direction
           }
       }
    
    // Translate the robot and rotate it based on direction and current rotation
    glTranslatef(0.0f, 2.0f, movement);
    glRotatef(currentRotation, 0.0f, 1.0f, 0.0f);  // Rotate around the Y-axis for turning
    
    // Draw the body (inverted cone)
    glRotatef(90, 1.0f, 0.0f, 0.0f); // Rotate the cone 90 degrees to point downward
    glutSolidCone(1.0, 2.5, 16, 16);  // Draw the torso as an inverted cone
    glPopMatrix();
  
    // Draw the head (sphere)
    glPushMatrix();
    glTranslatef(0.0f, 2.5f, movement);  // Position the head above the body
    glColor3f(1.0f, 0.0f, 0.0f);    // Set the color to red
    glutSolidSphere(0.5, 16, 16);     // Draw the head as a sphere
    glPopMatrix();
  
    glColor3f(0.0f, 1.0f, 1.0f); // Set the color to blue
    
    // Draw the left arm (cylinder)
    glPushMatrix();
    glTranslatef(-1.2f, 2.0f, movement); // Position the left arm at the shoulder level

    // Rotate around the robot’s center when rotating, otherwise swing
       if (rotating) {
         glPushMatrix();
         glTranslatef(1.2f, -4.5f, 0.0f); // Translate to the robot's center
         glRotatef(currentRotation, 0.0f, 1.0f, 0.0f); // Rotate around the Z-axis (parallel to the arm)
         glTranslatef(-1.2f, 4.5f, 0.0f); // Translate back
       } else {
           armSwing = swingAmplitude * sin(animationTime * armAnimationSpeed);
           glRotatef(armSwing, 1.0f, 0.0f, 0.0f);  // Swing the arm
       }
       
   // float armSwing = swingAmplitude * sin(animationTime * armAnimationSpeed);
    glRotatef(armSwing, 1.0f, 0.0f, 0.0f);
    
    glRotatef(90, 1.0f, 0.0f, 0.0f); // Rotate so the cylinder stands vertically
    GLUquadric* quad = gluNewQuadric(); 
    gluCylinder(quad, 0.2, 0.2, 1.5, 16, 16); // Draw the left arm (cylinder)
    glPopMatrix();
    
    // Draw the right arm (cylinder)
    glPushMatrix();
    glTranslatef(1.2f, 2.0f, movement);  // Position the right arm at the shoulder level
    
    // Rotate around the robot’s center when rotating, otherwise swing
       if (rotating) {
         glPushMatrix();
                glTranslatef(-1.2f, -2.0f, 0.0f); // Translate to robot's center
                glRotatef(currentRotation, 0.0f, 1.0f, 0.0f); // Rotate around the Y-axis (parallel to the arm)
                glTranslatef(1.2f, 2.0f, 0.0f); // Translate back
           //glRotatef(armSwing, 10.0f, 10.0f + armSwing, 2.0f); // Rotate around center
       } else {
           glRotatef(-armSwing, 1.0f, 0.0f, 0.0f); // Swing the arm
       }
    
       glRotatef(90, 1.0f, 0.0f, 0.0f);      // Rotate so the cylinder stands vertically
      
    gluCylinder(quad, 0.2, 0.2, 1.5, 16, 16); // Draw the right arm (cylinder)
    glPopMatrix();
    
    // Draw the left leg (cylinder)
    glPushMatrix();
    glTranslatef(-0.6f, 0.0f, movement); // Position the left leg
    glRotatef(90, 1.0f, 0.0f, 0.0f); // Rotate so the cylinder stands vertically
    
    // Rotate around the robot’s center when rotating, otherwise swing
    if (rotating) {
        glPushMatrix();
        glTranslatef(0.6f, 0.0f, 0.0f); // Translate to robot's center
        glRotatef(-currentRotation, 0.0f, 0.0f, 1.0f); // Rotate around the Y-axis (parallel to the leg)
        glTranslatef(-0.6f, 0.0f, 0.0f); // Translate back
    } else {
        legSwing = swingAmplitude * sin(animationTime * legAnimationSpeed);
        glRotatef(-legSwing, 1.0f, 0.0f, 0.0f); // Swing the leg
    }
    
    gluCylinder(quad, 0.3, 0.3, 2.0, 16, 16); // Draw the left leg (cylinder)
    glPopMatrix();
    
    // Draw the right leg (cylinder)
    glPushMatrix();
    glTranslatef(0.6f, 0.0f, movement);  // Position the right leg
    glRotatef(90, 1.0f, 0.0f, 0.0f); // Rotate so the cylinder stands vertically
    
    // Rotate around the robot’s center when rotating, otherwise swing
    if (rotating) {
        glPushMatrix();
        glTranslatef(-0.6f, 0.0f, 0.0f); // Translate to robot's center
        glRotatef(-currentRotation, 0.0f, 0.0f, 1.0f); // Rotate around the Y-axis (parallel to the leg)
        glTranslatef(0.6f, 0.0f, 0.0f); // Translate back
    } else {
        legSwing = swingAmplitude * sin(animationTime * legAnimationSpeed);
        glRotatef(legSwing, 1.0f, 0.0f, 0.0f); // Swing the leg
    }
    
    gluCylinder(quad, 0.3, 0.3, 2.0, 16, 16); // Draw the right leg (cylinder)
    glPopMatrix();
    glColor3f(1.0f, 1.0f, 1.0f); // Set the color to white
}

void displayRobot(void) {
    // Clear the screen and the depth buffer
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); 
    glLoadIdentity();  // Reset the modelview matrix

    // Calculate camera position based on angles and distance
    float cameraX = cameraDistance * sin(cameraAngleY * M_PI / 180.0f) * cos(cameraAngleX * M_PI / 180.0f);
    float cameraY = cameraDistance * sin(cameraAngleX * M_PI / 180.0f);
    float cameraZ = cameraDistance * cos(cameraAngleY * M_PI / 180.0f) * cos(cameraAngleX * M_PI / 180.0f);

    // Use gluLookAt to set up the camera
    gluLookAt(cameraX, cameraY, cameraZ,   // Camera position
              0.0, 0.0, 0.0,              // Look at origin
              0.0, 1.0, 0.0);             // Up direction (Y-axis)
    
    drawRobot();
    
    // Swap buffers to display the rendered frame
    glutSwapBuffers(); 
}

// Timer function for controlling animation
void timer(int value) {
        if (!rotating) {
               animationTime += 0.02f;  // Increment animation time
               movement += direction * movementAnimationSpeed;  // Move forward or backward
        
               if (fabs(movement) > movementLimit) {  // Check if movement limit is reached
                   rotating = true;  // Start rotating
               }
           } else {
               animationTime += 0.01f;  // Increment animation time for rotation
           }
        
        glutPostRedisplay();    // Redraw the scene
        glutTimerFunc(16, timer, 0);  // Call this function again in 16 ms (approx 60 FPS)
    }
    

// Reshape function for GLUT
void reshapeRobot(int w, int h) {
    glViewport(0, 0, w, h); // Set the viewport
    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();
    gluPerspective(45.0f, (GLfloat)w / (GLfloat)h, 1.0f, 100.0f); // Perspective projection
    glMatrixMode(GL_MODELVIEW);
}


// Function to handle keyboard input
void handleKeypress(int key, int x, int y) {
    switch (key) {
           case GLUT_KEY_UP:    // Zoom in
               cameraDistance -= zoomSpeed;
               if (cameraDistance < 2.0f) cameraDistance = 2.0f;  // Prevent zooming too close
               break;
           case GLUT_KEY_DOWN:  // Zoom out
               cameraDistance += zoomSpeed;
               break;
           case GLUT_KEY_LEFT:  // Rotate camera left (around the Y-axis)
               cameraAngleY -= rotationSpeed;
               break;
           case GLUT_KEY_RIGHT: // Rotate camera right (around the Y-axis)
               cameraAngleY += rotationSpeed;
               break;
       }
    glutPostRedisplay(); // Redraw after a change
}

int main(int argc, char **argv) {
    glutInit(&argc, argv);
    glutInitDisplayMode(GLUT_DOUBLE | GLUT_RGB | GLUT_DEPTH);
    glutInitWindowSize(1000, 800);
    glutInitWindowPosition(100, 100);
    glutCreateWindow("Assignment_3_IDATT2505");

    // Set up the projection matrix
    glMatrixMode(GL_PROJECTION);
    glLoadIdentity();
    gluPerspective(45.0, 4.0 / 3.0, 0.1, 100.0); // 45-degree field of view, 4:3 aspect ratio, near and far planes

    // Switch back to the modelview matrix
    glMatrixMode(GL_MODELVIEW);
    
    glEnable(GL_DEPTH_TEST); // Enable depth testing for true 3D effects

    glutDisplayFunc(displayRobot);
    glutReshapeFunc(reshapeRobot);
    glutTimerFunc(0, timer, 0); 
    glutSpecialFunc(handleKeypress); // Register function for special keys (arrow keys)
    glutMainLoop();
    return 0;
}

