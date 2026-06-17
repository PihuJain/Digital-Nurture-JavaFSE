// concrete product - handles word specific behaviour for open save and close
public class WordDocument implements Document {

    @Override
    public void open() {
        System.out.println("opening Word document (.docx)");
    }

    @Override
    public void save() {
        System.out.println("saving Word document");
    }

    @Override
    public void close() {
        System.out.println("closing Word document");
    }
}
