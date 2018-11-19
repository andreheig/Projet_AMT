package ch.heigvd.amt.mvcprojet.database;

import java.util.List;


public interface IPaginatedDAO {
    int getTotalNumberOfElements(Integer optionalId);
    <T> List<T> findElementsForPage(Integer optionalId, int page, int nbMaxElementsPerPage);
}
