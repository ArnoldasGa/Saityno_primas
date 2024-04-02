package lt.viko.eif.agaigalas.onlinerentalserverapp.model;

import javax.persistence.*;
import javax.xml.bind.annotation.*;

/**
 * This class is production company model class
 */
@Table
@Entity(name= "production_company")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductionCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "company_id")
    private int id;
    @XmlAttribute(name = "companyName")
    private String companyName;

    public ProductionCompany(String companyName) {
        this.companyName = companyName;
    }

    public ProductionCompany() {

    }

    @Override
    public String toString() {
        return String.format("\tProduction company : %s",this.companyName);
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
