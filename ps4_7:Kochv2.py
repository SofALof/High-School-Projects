'''Sofia Medina - Koch Snowflake - turnBased'''

from turtle import *

turtle = Turtle()
screen = Screen()
screen.colormode(255)
turtle.speed(10)

def drawLine (length): #draws a line of length, length
    turtle.forward(length)

def rightTurn(): #turn right 120 degrees
    turtle.right(60)

def leftTurn(): #turn left 60 degrees
    turtle.left(120)

def kochThird(degree, sideLen):
    if degree == 0:
        drawLine(sideLen)
        return

    kochThird(degree-1, sideLen/3)
    rightTurn()
    kochThird(degree-1, sideLen/3)
    leftTurn()
    kochThird(degree-1, sideLen/3)
    rightTurn()
    kochThird(degree-1, sideLen/3)
    
    return

def drawKoch(degree, sideLen):
    turtle.pendown()
    for i in range(3):
        kochThird(degree, sideLen)
        leftTurn()
    turtle.penup()


xCoord = -300
turtle.penup()
for i in range(5):
    turtle.goto(xCoord,0)        
    drawKoch(i,100)

    xCoord+=150




'''
drawLine(50)
rightTurn()#R
drawLine(50)
leftTurn()#L
drawLine(50)
rightTurn()#R
drawLine(50)
'''
