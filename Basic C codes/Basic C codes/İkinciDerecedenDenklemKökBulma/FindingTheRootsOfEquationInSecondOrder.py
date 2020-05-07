import sys

def function(a,b,c):
    delta = (b**2-4*a*c)
    if (delta<0):
        print('The solution is not real but complex')

    elif(delta==0):
        print('There is one solution')
        x = (-b - delta ** 0.5) / 2 * a
        print("Solution: " + "{0:.2f}".format(x))
    else:
        print('There are two solutions')
        x1 = (-b - delta ** 0.5) / 2 * a
        x2 = (-b + delta ** 0.5) / 2 * a
        print("Solutions: "+"{0:.2f} {1:.2f}".format(x1,x2))


function(int(sys.argv[1]),int(sys.argv[2]),int(sys.argv[3]))