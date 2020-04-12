package principal;

import daos.DepartamentoDAO;
import factory.DAOFactory;
import java.util.Scanner;
import pojos.Departamento;

/**
 *
 * @author Hp
 */
public class Principal {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Introduce nº de BBDD(1-->Mysql,2-->Oracle,3-->Neodatis)");
        int bbdd = entrada.nextInt();
        System.out.println("Introduce nº de departamento a consultar");
        int departamento = entrada.nextInt();

        switch (bbdd) {

            case 1:
                DAOFactory bdMysql = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
                consultaDep(departamento, bdMysql);
                break;
            case 2:
                DAOFactory bdOracle = DAOFactory.getDAOFactory(DAOFactory.ORACLE);
                consultaDep(departamento, bdOracle);
                break;
            case 3:
                DAOFactory bdNeodatis = DAOFactory.getDAOFactory(DAOFactory.NEODATIS);
                consultaDep(departamento, bdNeodatis);
                break;
        }

    }

    /**
     * Método que consulta si existe un departamento a la bbdd pasada por
     * parámetro
     *
     * @param depno
     * @param bd
     */
    public static void consultaDep(int depno, DAOFactory bd) {
        DepartamentoDAO depDAO = bd.getDepartamentoDAO();
        Departamento departamento = depDAO.consultarDep(depno);
        System.out.println("Departamento " + departamento.getDnombre() + " " + departamento.getLoc());

    }

}
