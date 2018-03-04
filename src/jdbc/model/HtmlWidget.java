package jdbc.model;

public class HtmlWidget extends Widget{

    private String html;

    public HtmlWidget(String html) {
        this.html = html;
    }

    public HtmlWidget(int id, String name, int width, int height, String cssClass, String cssStyle, String text,
                      int order, Page page, String type, String html) {

        super(id, name, width, height, cssClass, cssStyle, text, order, page, type);
        this.html = html;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }
}
