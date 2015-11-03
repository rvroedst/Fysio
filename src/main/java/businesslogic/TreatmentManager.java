package businesslogic;

import domain.Treatment;
import domain.Treatments;

import java.io.File;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import static javax.xml.bind.JAXBContext.*;


public class TreatmentManager {

    Treatment treatment = new Treatment(1, "enkelmassage", 4, 1000, 40);
    Treatment treatment2 = new Treatment(2, "voetkraken", 2, 2000, 20);

    Treatments treatments = new Treatments();
    URL url = getClass().getResource("/datastorage/xml/treatment.xml");
    File file = new File(url.getPath());

    public TreatmentManager() {
        try {

            treatments.add(treatment);
            treatments.add(treatment2);


            JAXBContext jaxbContext = newInstance(Treatments.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(treatments, file);
            jaxbMarshaller.marshal(treatments, System.out);


        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}