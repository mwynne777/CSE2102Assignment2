# CSE2102Assignment2

-The class called "Main.java" is the main class of a JavaFX application. This applicaiton is designed to take 2 parameters:<br />
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;n: the number of dots that will be displayed on the circle.<br />
  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;probability: the probability that each dot will have a line connecting that dot to every other dot on the circle.<br />
-The idea is that we use n to calculate the angle necessary to evenly spread the dots over the 360 degrees of the cirlce.<br />
-We use simple trigonometry to get the actual x and y values of these individual points and store each of them in an array.<br />
-Next, in order to deal with the probability of lines existing, we iterate over the array and for each element in the array, we generate
n-1 random numbers and if the random number is within the given probability, we then store the head of the line and the tail of the line
in 2 separate arrays.  From there, we can simply iterate over the head and tail arrays, making sure we keep the same index in each array
and simply construct a line for each index.
