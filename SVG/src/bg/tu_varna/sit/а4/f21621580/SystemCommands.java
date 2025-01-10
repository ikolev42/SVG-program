package bg.tu_varna.sit.а4.f21621580;

import java.awt.Color;
import java.util.Scanner;

class CommandLineInterface {
    private SVGHandler svgHandler = new SVGHandler();
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();
            String[] parts = input.split(" ");
            String command = parts[0].toLowerCase();

            try {
                switch (command) {
                    case "open":
                        svgHandler.loadSVG(parts[1]);
                        break;
                    case "save":
                        svgHandler.saveSVG(parts[1]);
                        break;
                    case "saveas":
                        svgHandler.saveSVG(parts[1]);
                        break;
                    case "print":
                        svgHandler.printShapes();
                        break;
                    case "create":
                        handleCreate(parts);
                        break;
                    case "erase":
                        svgHandler.removeShape(Integer.parseInt(parts[1]));
                        break;
                    case "translate":
                        handleTranslate(parts);
                        break;
                    case "help":
                        printHelp();
                        break;
                    case "exit":
                        System.out.println("Exiting the program...");
                        return;
                    default:
                        System.out.println("Unknown command. Type 'help' for a list of commands.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void handleCreate(String[] parts) {
        if (parts[1].equals("rectangle")) {
            int x = Integer.parseInt(parts[2]);
            int y = Integer.parseInt(parts[3]);
            int width = Integer.parseInt(parts[4]);
            int height = Integer.parseInt(parts[5]);
            Color color = Color.decode(parts[6]);
            svgHandler.addShape(new Rectangle(x, y, width, height, color));
            System.out.println("Rectangle created.");
        } else if (parts[1].equals("circle")) {
            int cx = Integer.parseInt(parts[2]);
            int cy = Integer.parseInt(parts[3]);
            int r = Integer.parseInt(parts[4]);
            Color color = Color.decode(parts[5]);
            svgHandler.addShape(new Circle(cx, cy, r, color));
            System.out.println("Circle created.");
        } else {
            System.out.println("Unsupported shape type.");
        }
    }

    private void handleTranslate(String[] parts) {
        if (parts.length == 3) {
            int dx = Integer.parseInt(parts[1]);
            int dy = Integer.parseInt(parts[2]);
            svgHandler.translateAllShapes(dx, dy);
        } else if (parts.length == 4) {
            int index = Integer.parseInt(parts[1]);
            int dx = Integer.parseInt(parts[2]);
            int dy = Integer.parseInt(parts[3]);
            svgHandler.translateShape(index, dx, dy);
        } else {
            System.out.println("Invalid translate command.");
        }
    }

    private void printHelp() {
        System.out.println("The following commands are supported:");
        System.out.println("open <file>            - opens <file>");
        System.out.println("save <file>            - saves the currently open file");
        System.out.println("saveas <file>          - saves the currently open file in <file>");
        System.out.println("print                  - prints all shapes");
        System.out.println("create <shape> ...     - creates a new shape");
        System.out.println("erase <n>              - erases shape <n>");
        System.out.println("translate <n> dx dy    - translates shape <n> by dx, dy");
        System.out.println("translate dx dy        - translates all shapes by dx, dy");
        System.out.println("help                   - prints this help message");
        System.out.println("exit                   - exits the program");
    }

    public static void main(String[] args) {
        CommandLineInterface cli = new CommandLineInterface();
        cli.start();
    }
}
