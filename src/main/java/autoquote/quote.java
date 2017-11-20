package autoquote;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class quote implements Serializable {
    private static final long serialVersionUID = 1L;

    
    // Persistent Fields:
    @Id @GeneratedValue
    Long id;
    private String name;
    private Date signingDate;
    
    // Constructors:
    public quote() {
    }

    
    public quote(String name) {
        this.name = name;
        this.signingDate = new Date(System.currentTimeMillis());
    }

    
    // String Representation:
    @Override
    public String toString() {
        return name + " (signed on " + signingDate + ")";
    }
}
