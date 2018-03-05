package model;

import interfaceDao.WidgetDAOInterface;

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
}
