// concrete creator for pdf documents
// only job is to tell the parent which Document type to create
public class PdfDocumentFactory extends DocumentFactory {

    @Override
    public Document createDocument() {
        return new PdfDocument();
    }
}
