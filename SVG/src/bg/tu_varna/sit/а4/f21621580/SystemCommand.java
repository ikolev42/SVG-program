package bg.tu_varna.sit.а4.f21621580;

import java.io.*;
import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.awt.Color;

class SVGHandler {
    private List<Shape> shapes = new ArrayList<>();

    public void loadSVG(String filepath) throws Exception {
        shapes.clear();
        File file = new File(filepath);
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(file);

        NodeList rectList = doc.getElementsByTagName("rect");
        for (int i = 0; i < rectList.getLength(); i++) {
            Element element = (Element) rectList.item(i);
            int x = Integer.parseInt(element.getAttribute("x"));
            int y = Integer.parseInt(element.getAttribute("y"));
            int width = Integer.parseInt(element.getAttribute("width"));
            int height = Integer.parseInt(element.getAttribute("height"));
            Color color = Color.decode(element.getAttribute("fill"));
            shapes.add(new Rectangle(x, y, width, height, color));
        }

        NodeList circleList = doc.getElementsByTagName("circle");
        for (int i = 0; i < circleList.getLength(); i++) {
            Element element = (Element) circleList.item(i);
            int cx = Integer.parseInt(element.getAttribute("cx"));
            int cy = Integer.parseInt(element.getAttribute("cy"));
            int r = Integer.parseInt(element.getAttribute("r"));
            Color color = Color.decode(element.getAttribute("fill"));
            shapes.add(new Circle(cx, cy, r, color));
        }

        System.out.println("Successfully loaded " + filepath);
    }

    public void saveSVG(String filepath) throws IOException {
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(filepath)))) {
            out.println("<?xml version=\"1.0\" standalone=\"no\"?>");
            out.println("<!DOCTYPE svg PUBLIC \"-//W3C//DTD SVG 1.1//EN\"");
            out.println("  \"http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd\">");
            out.println("<svg>");
            for (Shape shape : shapes) {
                out.println("  " + shape.toSVG());
            }
            out.println("</svg>");
        }
        System.out.println("Successfully saved " + filepath);
    }

    public void printShapes() {
        for (int i = 0; i < shapes.size(); i++) {
            Shape shape = shapes.get(i);
            System.out.println((i + 1) + ". " + shape.getType() + " " + shape.toSVG());
        }
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public void removeShape(int index) {
        if (index < 1 || index > shapes.size()) {
            System.out.println("Invalid shape number.");
            return;
        }
        shapes.remove(index - 1);
        System.out.println("Shape " + index + " removed.");
    }

    public void translateShape(int index, int dx, int dy) {
        if (index < 1 || index > shapes.size()) {
            System.out.println("Invalid shape number.");
            return;
        }
        shapes.get(index - 1).translate(dx, dy);
        System.out.println("Shape " + index + " translated.");
    }

    public void translateAllShapes(int dx, int dy) {
        for (Shape shape : shapes) {
            shape.translate(dx, dy);
        }
        System.out.println("All shapes translated.");
    }
}
