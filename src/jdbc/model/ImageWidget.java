package jdbc.model;

public class ImageWidget extends Widget{

    private String src;

    public ImageWidget(String src) {
        this.src = src;
    }

    public ImageWidget(int id, String name, int width, int height, String cssClass, String cssStyle, String text,
                       int order, Page page, String type, String src){

        super(id, name, width, height, cssClass, cssStyle, text, order, page, type);
        this.src = src;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }
}
