#!/usr/bin/env pybricks-micropython
from pybricks.hubs import EV3Brick
from pybricks.ev3devices import (Motor, TouchSensor, ColorSensor, InfraredSensor, UltrasonicSensor, GyroSensor)
from pybricks.parameters import Port, Stop, Direction, Button, Color
from pybricks.tools import wait, StopWatch, DataLog
from pybricks.robotics import DriveBase
from pybricks.media.ev3dev import SoundFile, ImageFile
import time
import random

# Metoder
def Sabotasje():
	backMotor.run(300)
	wait(400)
	backMotor.run(-300)
	wait(650)
	backMotor.stop()
 
def Lerp(a, b, t):
    return a + (b - a) * t

# Objekter
ev3 = EV3Brick()

rightMotor = Motor(port=Port.A)
leftMotor = Motor(port=Port.B)
backMotor = Motor(port=Port.C)

robot = DriveBase(leftMotor, rightMotor, wheel_diameter=56, axle_track=114)

touchSensorOnOff = TouchSensor(port=Port.S2)
colorSensor1 = ColorSensor(port = Port.S3)
colorSensor2 = ColorSensor(port = Port.S4)
ultraSoniskSensor = UltrasonicSensor(port=Port.S1)

# Variabler
driveSpeed = -250
turnSpeed = (-250, -120)

# Program
ev3.speaker.set_volume(100, which='_all_')
ev3.speaker.beep()
print("Starting")

while not touchSensorOnOff.pressed():
    continue

print("Button pressed")
wait(500)
#Sabotasje()

#while False:
while not touchSensorOnOff.pressed():
    
	#Farger
	venstre = colorSensor1.color()
	hoyre = colorSensor2.color()

	#Kjøring
	if (hoyre == Color.BLACK and not venstre == Color.BLACK):
		rightMotor.run(turnSpeed[1])
		leftMotor.run(turnSpeed[0])
	elif (not hoyre == Color.BLACK and venstre == Color.BLACK):
		rightMotor.run(turnSpeed[0])
		leftMotor.run(turnSpeed[1])
	#elif (hoyre == Color.BLACK and venstre == Color.BLACK):
		#rightMotor.run(-200)
		#leftMotor.run(200)
	else:
		rightMotor.run(driveSpeed)
		leftMotor.run(driveSpeed)

	#Distanse
	if ultraSoniskSensor.distance() < 200:
		rightMotor.run(-1200)
		leftMotor.run(-1200)