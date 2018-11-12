package ch.heigvd.amt.mvcprojet.database;

import java.util.List;


public interface IPaginatedDAO {
    int getTotalNumberOfElements();
    <T> List<T> findElementsForPage(int page, int nbMaxElementsPerPage);
}
