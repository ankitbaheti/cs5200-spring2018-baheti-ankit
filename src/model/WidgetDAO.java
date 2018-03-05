package model;

import interfaceDao.WidgetDAOInterface;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class WidgetDAO extends BaseDAO implements WidgetDAOInterface{

    private static WidgetDAO instance = null;

    private WidgetDAO(){
    }

    public static WidgetDAO getInstance(){
        if(instance == null){
            instance = new WidgetDAO();
        }
        return instance;
    }

    @Override
    public int createWidgetForPage(int pageId, Widget widget) {
        int result = -1;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "insert into widget(id, name, width, height, cssClass, cssStyle, text, `order`, url, " +
                    "shareable, expandable, src, html, type, page) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, widget.getId());
            pstm.setString(2, widget.getName());
            pstm.setInt(3, widget.getWidth());
            pstm.setInt(4, widget.getHeight());
            pstm.setString(5, widget.getCssClass());
            pstm.setString(6, widget.getCssStyle());
            pstm.setString(7, widget.getText());
            pstm.setInt(8, widget.getOrder());
            pstm.setString(9, widget.getUrl());
            pstm.setBoolean(10, widget.getSharable());
            pstm.setBoolean(11, widget.getExpandable());
            pstm.setString(12, widget.getSrc());
            pstm.setString(13, widget.getHtml());
            pstm.setString(14, widget.getType());
            pstm.setInt(15, widget.getPage().getId());
            result = pstm.executeUpdate();
            pstm.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Collection<Widget> findAllWidgets() {
        List<Widget> widgetList = new ArrayList<>();
        ResultSet rs;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "select * from widget;";
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            widgetList = getWidgetFromRS(rs);
            pstm.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return widgetList;
    }

    private List<Widget> getWidgetFromRS(ResultSet rs){
        List<Widget> widgetList = new ArrayList<>();
        try {
            while (rs.next()){
                Widget widget = new Widget();
                widget.setId(rs.getInt("id"));
                widget.setName(rs.getString("name"));
                widget.setWidth(rs.getInt("width"));
                widget.setHeight(rs.getInt("height"));
                widget.setCssClass(rs.getString("cssClass"));
                widget.setCssStyle(rs.getString("cssStyle"));
                widget.setText(rs.getString("text"));
                widget.setOrder(rs.getInt("order"));
                widget.setUrl(rs.getString("url"));
                widget.setSharable(rs.getBoolean("shareable"));
                widget.setExpandable(rs.getBoolean("expandable"));
                widget.setSrc(rs.getString("src"));
                widget.setSize(rs.getInt("size"));
                widget.setHtml(rs.getString("html"));
                widget.setType(rs.getString("type"));
                widget.getPage().setId(rs.getInt("page"));
                widgetList.add(widget);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return widgetList;
    }

    @Override
    public Widget findWidgetById(int widgetId) {
        Widget widget = new Widget();
        List<Widget> widgetList;
        ResultSet rs;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "select * from widget where id = ?;";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, widgetId);
            rs = pstm.executeQuery();
            widgetList = getWidgetFromRS(rs);
            while (!widgetList.isEmpty())
                widget = widgetList.get(0);
            pstm.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return widget;
    }

    @Override
    public Collection<Widget> findWidgetsForPage(int pageId) {
        ResultSet rs;
        List<Widget> widgetList = new ArrayList<>();
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "select * from widget where page = ?;";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, pageId);
            rs = pstm.executeQuery();
            widgetList = getWidgetFromRS(rs);
            pstm.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return widgetList;
    }

    @Override
    public int updateWidget(int widgetId, Widget widget) {
        int result = -1;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "update widget set name = ?, width = ?, height = ?, cssClass = ?, cssStyle = ?, text = ?, " +
                    "`order` = ?, url = ?, shareable = ?, expandable = ?, src = ?, size = ?, html = ?, type = ?, " +
                    "page = ? where id = ?";
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, widget.getName());
            pstm.setInt(2, widget.getWidth());
            pstm.setInt(3, widget.getHeight());
            pstm.setString(4, widget.getCssClass());
            pstm.setString(5, widget.getCssStyle());
            pstm.setString(6, widget.getText());
            pstm.setInt(7, widget.getOrder());
            pstm.setString(8, widget.getUrl());
            pstm.setBoolean(9, widget.getSharable());
            pstm.setBoolean(10, widget.getExpandable());
            pstm.setString(11, widget.getSrc());
            pstm.setInt(12, widget.getSize());
            pstm.setString(13, widget.getHtml());
            pstm.setString(14, widget.getType());
            pstm.setInt(15, widget.getPage().getId());
            pstm.setInt(16, widgetId);
            result = pstm.executeUpdate();
            pstm.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int deleteWidget(int widgetId) {
        int result = -1;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            String sql = "delete from widget where id = ?;";
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, widgetId);
            result = pstm.executeUpdate();
            pstm.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
