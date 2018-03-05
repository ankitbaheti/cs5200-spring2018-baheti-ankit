package interfaceDao;

import model.Widget;
import java.util.Collection;

public interface WidgetDAOInterface {

    int createWidgetForPage(int pageId, Widget widget);

    Collection<Widget> findAllWidgets();

    Widget findWidgetById(int widgetId);

    Collection<Widget> findWidgetsForPage(int pageId);

    int updateWidget(int widgetId, Widget widget);

    int deleteWidget(int widgetId);
}
