package autoquote;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class quoteDao {
    // Injected database connection:
    @PersistenceContext private EntityManager em;
    
    // Stores a new guest:
    @Transactional
    public void persist(quote guest) {
        em.persist(guest);
    }
    
    // Retrieves all the guests:
    public List<quote> getAllGuests() {
        TypedQuery<quote> query = em.createQuery(
            "SELECT g FROM quote g ORDER BY g.id", quote.class);
        return query.getResultList();
    }
}
