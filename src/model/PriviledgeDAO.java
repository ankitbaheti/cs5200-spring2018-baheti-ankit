package model;

import interfaceDao.PriviledgeDAOInterface;

public class PriviledgeDAO extends BaseDAO implements PriviledgeDAOInterface{

    private static PriviledgeDAO instance = null;

    private PriviledgeDAO(){
    }

    public static PriviledgeDAO getInstance(){
        if(instance == null){
            instance = new PriviledgeDAO();
        }
        return instance;
    }
}
