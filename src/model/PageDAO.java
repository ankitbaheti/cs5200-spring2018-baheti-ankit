package model;

import interfaceDao.PageDAOInterface;

public class PageDAO extends BaseDAO implements PageDAOInterface{

    private static PageDAO instance = null;

    private PageDAO(){
    }

    public static PageDAO getInstance(){
        if(instance == null){
            instance = new PageDAO();
        }
        return instance;
    }
}
