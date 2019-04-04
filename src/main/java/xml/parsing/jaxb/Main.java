package xml.parsing.jaxb;

import xml.parsing.jaxb.model.BookStore;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Main {

    public static void main(String[] args) throws JAXBException {
        File file = new File("src/main/java/xml/parsing/bookStore.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(BookStore.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        BookStore bookStore = (BookStore) jaxbUnmarshaller.unmarshal(file);
        System.out.println(bookStore);
    }
}
