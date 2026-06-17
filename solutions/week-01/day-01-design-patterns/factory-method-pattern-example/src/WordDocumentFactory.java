// concrete creator for word documents
// only job is to tell the parent which Document type to create
public class WordDocumentFactory extends DocumentFactory {

    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}
