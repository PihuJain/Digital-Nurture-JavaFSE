// concrete product - handles excel specific behaviour for open save and close
public class ExcelDocument implements Document {

    @Override
    public void open() {
        System.out.println("opening Excel document (.xlsx)");
    }

    @Override
    public void save() {
        System.out.println("saving Excel document");
    }

    @Override
    public void close() {
        System.out.println("closing Excel document");
    }
}
