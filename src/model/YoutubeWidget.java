package model;

public class YoutubeWidget extends Widget{

    private String url;
    private boolean shareable;
    private boolean expandable;

    public YoutubeWidget(String url, boolean shareable, boolean expandable) {
        this.url = url;
        this.shareable = shareable;
        this.expandable = expandable;
    }

    public YoutubeWidget(int id, String name, int width, int height, String cssClass, String cssStyle, String text,
                         int order, Page page, String type, String url, boolean shareable, boolean expandable) {

        super(id, name, width, height, cssClass, cssStyle, text, order, page, type);
        this.url = url;
        this.shareable = shareable;
        this.expandable = expandable;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isShareable() {
        return shareable;
    }

    public void setShareable(boolean shareable) {
        this.shareable = shareable;
    }

    public boolean isExpandable() {
        return expandable;
    }

    public void setExpandable(boolean expandable) {
        this.expandable = expandable;
    }
}
