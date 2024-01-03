#!/usr/bin/env pybricks-micropython
from pybricks.hubs import EV3Brick
from pybricks.ev3devices import (Motor, TouchSensor, ColorSensor,
                                 InfraredSensor, UltrasonicSensor, GyroSensor)
from pybricks.parameters import Port, Stop, Direction, Button, Color
from pybricks.tools import wait, StopWatch, DataLog
from pybricks.robotics import DriveBase
from pybricks.media.ev3dev import SoundFile, ImageFile


# This program requires LEGO EV3 MicroPython v2.0 or higher.
# Click "Open user guide" on the EV3 extension tab for more information.


# Create your objects here.
ev3 = EV3Brick()


# Write your program here.
ev3.speaker.beep()

leftMotor = Motor(port=Port.B)
rightMotor = Motor(port=Port.A)
robot = DriveBase(leftMotor, rightMotor, wheel_diameter=56, axle_track=100)

touchSensorOnOff = TouchSensor(port=Port.S2)
ultraSoniskSensor = UltrasonicSensor(port=Port.S1)


while not touchSensorOnOff.pressed():
    continue

ev3.speaker.say("Exercise 2")
wait(1000)
# ev3.speaker.play_file("playboi.wav")
while not touchSensorOnOff.pressed():
    robot.straight(-100)
    if (ultraSoniskSensor.distance() < 200):
        robot.straight(100)
        robot.turn(60)

ev3.speaker.say("Exercise over")
