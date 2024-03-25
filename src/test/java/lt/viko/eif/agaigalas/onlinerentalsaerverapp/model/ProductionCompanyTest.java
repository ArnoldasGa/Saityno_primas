package lt.viko.eif.agaigalas.onlinerentalsaerverapp.model;

import lt.viko.eif.agaigalas.onlinerentalserverapp.model.ProductionCompany;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProductionCompanyTest {
    ProductionCompany productionCompany = new ProductionCompany("Company");

    @Test
    public void getCompany() {
        String testCompany = productionCompany.getCompanyName();
        assertEquals("Company",testCompany);
    }
    @Test
    public void setCompany() {
        productionCompany.setCompanyName("FunkyCompany");
        String testCompany = productionCompany.getCompanyName();
        assertEquals("FunkyCompany",testCompany);
    }
}
