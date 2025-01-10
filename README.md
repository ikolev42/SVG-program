# SVG-program
Using SVG files, this program reads them, can make commits and save them

How it Works:
Command-Line Interface: The user can interact with the program through simple text commands like open, save, create, print, etc.

Shape Management: The program supports creating rectangles and circles, translating (moving) them, and saving the changes back to an SVG file.

SVG Files: The program reads from and writes to SVG files, focusing on basic shapes and commands.

General Commands:
open <file>: Opens an SVG file.

Example: open shapes.svg
Input: The path to an SVG file.
save: Saves the current state of the SVG file.

Example: save
Input: No additional input required; saves to the originally opened file.
saveas <file>: Saves the current state to a new SVG file.

Example: saveas new_shapes.svg
Input: The path to the new SVG file.
print: Prints all shapes currently loaded from the SVG file.

Example: print
Input: No additional input required; just outputs the shapes.
create <shape> <params>: Creates a new shape and adds it to the SVG.

Example for Rectangle: create rectangle 10 20 30 40 #ff0000
Input:
rectangle: The type of shape to create.
10 20: The x and y coordinates.
30 40: The width and height.
#ff0000: The color in hexadecimal format.
Example for Circle: create circle 50 60 20 #0000ff
Input:
circle: The type of shape.
50 60: The center x and y coordinates.
20: The radius.
#0000ff: The color in hexadecimal format.
erase <n>: Erases the shape at position n.

Example: erase 1
Input: The index of the shape you want to erase.
translate <n> <dx> <dy>: Translates (moves) the shape at position n by dx and dy.

Example: translate 1 10 20
Input:
1: The index of the shape to move.
10 20: The horizontal and vertical distances to move the shape.
translate <dx> <dy>: Translates all shapes by dx and dy.

Example: translate 10 20
Input:
10 20: The horizontal and vertical distances to move all shapes.
help: Displays help information about the available commands.

Example: help
Input: No additional input required.
exit: Exits the program.

Example: exit
Input: No additional input required.


SVG example:
<?xml version="1.0" standalone="no"?>
<!DOCTYPE svg PUBLIC "-//W3C//DTD SVG 1.1//EN"
  "http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd">
<svg width="200" height="200" xmlns="http://www.w3.org/2000/svg">
  <rect x="10" y="10" width="50" height="50" fill="green" />
  <circle cx="100" cy="100" r="30" fill="blue" />
</svg>

his SVG file contains:

A green rectangle located at coordinates (10, 10) with a width of 50 and a height of 50.
A blue circle centered at (100, 100) with a radius of 30.
Saving the SVG File
Open a text editor (like Notepad, VS Code, or Sublime Text).
Copy and paste the SVG content provided above into the editor.
Save the file with a .svg extension, for example, shapes.svg.
