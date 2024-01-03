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

megalovania = ["D4/4", "D4/4", "D5/2", "A4/2", "R/4", "G#4/2", "G4/2", "F4/2", "D4/4", "F4/4", "G4/4"]

# Create your objects here.
ev3 = EV3Brick()
leftMotor = Motor(port = Port.B)
rightMotor = Motor(port = Port.A)
base = DriveBase(leftMotor, rightMotor, wheel_diameter = 56, axle_track = 155)

# Write your program here.
ev3.speaker.set_volume(100, which='_all_')

ev3.speaker.beep()
ev3.screen.print("Hello there!")

wait(1000)

#ev3.speaker.play_notes(megalovania, tempo = 480)
#ev3.speaker.play_file("sometimes.m4a")

for i in range(4):
	base.straight(-400)
	base.turn(90)

ev3.speaker.beep()

ev3.screen.clear()
ev3.screen.print("Have a nice day")

ev3.speaker.say("Have a nice day")

ev3.speaker.play_notes(megalovania, tempo = 480)

wait(3000)

