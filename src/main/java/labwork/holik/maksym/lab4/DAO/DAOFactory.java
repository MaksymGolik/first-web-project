package labwork.holik.maksym.lab4.DAO;

public class DAOFactory {
    private static IMyDAO dao = null;

    public static IMyDAO getDAOInstance(TypeDAO type){
        if(type == TypeDAO.MySQL){
            if(dao == null){
                dao = new MySQLDAO();
            }
            else return dao;
        }
        if(type == TypeDAO.COLLECTION){
            if(dao == null){
                dao = new CollectionDAO();
            }
            else return dao;
        }
        return dao;
    }
}
