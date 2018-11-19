package ch.heigvd.amt.mvcprojet.presentation;

import ch.heigvd.amt.mvcprojet.database.IPaginatedDAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class PaginationHelper {

    public static <T> void addPaginationAttributesToRequest(HttpServletRequest request,
                                                            IPaginatedDAO paginatedDAO,
                                                            Integer optionalId,
                                                            String jspNameOfElements) {
        // Find values
        int pageToLoad = request.getParameter("page") != null ?
                Integer.parseInt(request.getParameter("page")) :
                1;
        int totalNbElements = paginatedDAO.getTotalNumberOfElements(optionalId);
        int nbPages = (int) Math.ceil((totalNbElements * 1.0) / Utils.NB_MAX_ELEMENTS_ON_PAGE);
        List<T> elements = paginatedDAO.findElementsForPage(optionalId, pageToLoad, Utils.NB_MAX_ELEMENTS_ON_PAGE);

        // Modify request
        request.setAttribute("nbPages", nbPages);
        request.setAttribute("page", pageToLoad);
        request.setAttribute(jspNameOfElements, elements);
    }

}
