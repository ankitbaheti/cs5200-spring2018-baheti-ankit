package model;

public class HeadingWidget extends Widget{

    private int size;

    public HeadingWidget(int size) {
        this.size = size;
    }

    public HeadingWidget(int id, String name, int width, int height, String cssClass, String cssStyle, String text,
                         int order, Page page, int size, String type) {
        super(id, name, width, height, cssClass, cssStyle, text, order, page, type);
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
