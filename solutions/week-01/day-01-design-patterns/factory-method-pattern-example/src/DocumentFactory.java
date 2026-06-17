// abstract creator in the factory method pattern
// defines what to do with a document but not which type to create
// subclasses handle the which part by overriding createDocument()
// adding a new document type means a new subclass pair - nothing here changes

public abstract class DocumentFactory {

    // subclasses return their specific Document type here
    public abstract Document createDocument();
}
