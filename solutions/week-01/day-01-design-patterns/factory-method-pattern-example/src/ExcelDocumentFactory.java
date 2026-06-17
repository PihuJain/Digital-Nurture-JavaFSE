// concrete creator for excel documents
// only job is to tell the parent which Document type to create
public class ExcelDocumentFactory extends DocumentFactory {

    @Override
    public Document createDocument() {
        return new ExcelDocument();
    }
}
