package autoquote;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class quoteController {

	
    @Autowired
    private quoteDao quoteDao;

    
    @RequestMapping(value="/quote")
    public ModelAndView quote(HttpServletRequest request) {
        // Handle a new guest (if any):
        String name = request.getParameter("name");
        if (name != null)
            quoteDao.persist(new quote(name));

        
        // Prepare the result view (guest.jsp):
        return new ModelAndView("quote.jsp", "quoteDao", quoteDao);
    }
}