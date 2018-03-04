package model;

public class Widget {

    private int id;
    private String name;
    private int width;
    private int height;
    private String cssClass;
    private String cssStyle;
    private String text;
    private int order;
    private String url;
    private int sharable;
    private int expandable;
    private String src;
    private int size;
    private String html;
    private Page page;
    private String type;

    public Widget() {
    }

    public Widget(int id, String name, int width, int height, String cssClass, String cssStyle, String text, int order,
                  Page page, String type) {
        this.id = id;
        this.name = name;
        this.width = width;
        this.height = height;
        this.cssClass = cssClass;
        this.cssStyle = cssStyle;
        this.text = text;
        this.order = order;
        this.page = page;
        this.type = type;
    }

    public Widget(int id, String name, int width, int height, String cssClass, String cssStyle, String text, int order,
                  String url, int sharable, int expandable, String src, int size, String html, Page page, String type) {
        this.id = id;
        this.name = name;
        this.width = width;
        this.height = height;
        this.cssClass = cssClass;
        this.cssStyle = cssStyle;
        this.text = text;
        this.order = order;
        this.url = url;
        this.sharable = sharable;
        this.expandable = expandable;
        this.src = src;
        this.size = size;
        this.html = html;
        this.page = page;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getCssClass() {
        return cssClass;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    public String getCssStyle() {
        return cssStyle;
    }

    public void setCssStyle(String cssStyle) {
        this.cssStyle = cssStyle;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getSharable() {
        return sharable;
    }

    public void setSharable(int sharable) {
        this.sharable = sharable;
    }

    public int getExpandable() {
        return expandable;
    }

    public void setExpandable(int expandable) {
        this.expandable = expandable;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }
}