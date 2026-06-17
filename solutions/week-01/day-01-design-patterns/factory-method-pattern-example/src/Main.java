// the key thing to notice: DocumentFactory and Document are the only types referenced here
// WordDocument PdfDocument ExcelDocument never appear - thats the pattern working

public class Main {

    public static void main(String[] args) {

        System.out.println("=== factory method pattern demo ===\n");

        DocumentFactory[] factories = {
            new WordDocumentFactory(),
            new PdfDocumentFactory(),
            new ExcelDocumentFactory()
        };

        // adding a new document type later only requires a new factory and document class
        // nothing in this loop changes
        for (int i = 0; i < factories.length; i++) {
            Document doc = factories[i].createDocument();
            doc.open();
            doc.save();
            doc.close();
            System.out.println();
        }
    }
}
