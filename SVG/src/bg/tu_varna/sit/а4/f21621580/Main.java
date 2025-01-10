package bg.tu_varna.sit.а4.f21621580;

import java.awt.Color;

abstract class Shape {
    protected String type;
    protected Color color;

    public Shape(String type, Color color) {
        this.type = type;
        this.color = color;
    }

    public abstract String toSVG();

    public abstract void translate(int dx, int dy);

    public String getType() {
        return type;
    }

    public Color getColor() {
        return color;
    }
}

class Rectangle extends Shape {
    private int x, y, width, height;

    public Rectangle(int x, int y, int width, int height, Color color) {
        super("rectangle", color);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public String toSVG() {
        return String.format("<rect x=\"%d\" y=\"%d\" width=\"%d\" height=\"%d\" fill=\"#%s\" />",
                x, y, width, height, Integer.toHexString(color.getRGB()).substring(2));
    }

    @Override
    public void translate(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }
}

class Circle extends Shape {
    private int cx, cy, r;

    public Circle(int cx, int cy, int r, Color color) {
        super("circle", color);
        this.cx = cx;
        this.cy = cy;
        this.r = r;
    }

    @Override
    public String toSVG() {
        return String.format("<circle cx=\"%d\" cy=\"%d\" r=\"%d\" fill=\"#%s\" />",
                cx, cy, r, Integer.toHexString(color.getRGB()).substring(2));
    }

    @Override
    public void translate(int dx, int dy) {
        this.cx += dx;
        this.cy += dy;
    }
}



