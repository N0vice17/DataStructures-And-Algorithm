#Bresenhams Algorithm

def bresenham(x1, y1, x2, y2):
    x, y = x1, y1
    dx = x2 - x1
    dy = y2 - y1

    xx, yy = [], []

    print(x, y)

    xx.append(x)
    yy.append(y)

    p = 2*dy - dx

    for i in range(0,dx):
        x+=1
    
        if p<0: 
            p = p + 2*dy
        else:
            y+=1
            p = p + 2*dy - 2*dx

        print(x, y)

        xx.append(x)
        yy.append(y)

    return xx, yy

xx, yy = bresenham(20, 10, 30, 18)

#Plotting the points

import matplotlib.pyplot as plt
import numpy as np

def plot_line(xx, yy):
    plt.scatter(xx, yy, label = "points", color= "red", marker= "x", s=30)
    plt.axis([min(xx), max(xx)+1, min(yy), max(yy)+1])
    plt.title('Bresenhams Algorithm Plot')
    plt.grid()
    plt.show()

plot_line(xx, yy)