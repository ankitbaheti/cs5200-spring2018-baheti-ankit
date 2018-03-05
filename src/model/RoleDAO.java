package model;

import interfaceDao.RoleDAOInterface;

public class RoleDAO extends BaseDAO implements RoleDAOInterface{

    private static RoleDAO instance = null;

    private RoleDAO(){
    }

    public static RoleDAO getInstance(){
        if(instance == null){
            instance = new RoleDAO();
        }
        return instance;
    }
}
