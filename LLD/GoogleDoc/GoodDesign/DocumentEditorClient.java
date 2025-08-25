package LLD.GoogleDoc.GoodDesign;

import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

interface Element {
    public String render();
}

class TextElement implements Element {
    private String text;

    public TextElement(String txt) {
        this.text = txt;
    }

    public String render() {
        return this.text+"\n";
    }
}

class ImageElement implements Element {
    private String path;

    public ImageElement(String imgPath) {
        this.path = imgPath;
    }

    public String render() {
        return "Image : "+this.path+" file \n";
    }
}
class TabElement implements Element {

    public String render() {
        return "\t";
    }
}

class Document {

    public List<Element> elements = new ArrayList<>();

    public void addElement(Element element) {
        elements.add(element);
    }

    public List<Element> getElements() {
        return this.elements;
    }
}

interface DBpersistence {
    public void save(String str);
}

class FileStorage implements DBpersistence {

    public void save(String file) {
        try {
            FileWriter writer = new FileWriter("document.txt");
            writer.write(file);
            writer.close();
            System.out.println("save The Rendered Documents");
        } catch (IOException e) {
            System.out.println("Exception Error in Saving Into Document");
        }
    }
}

class DBstorage implements DBpersistence {
    public void save(String str) {
        System.out.println("Data Storage Into DB: " + str);
    }
}

class DocumentRender {
    Document doc;
    String renderedDocument;

    DocumentRender(Document dt) {
        this.doc = dt;
        this.renderedDocument = "";
    }

    public String renderDocument() {
        if (renderedDocument.isEmpty()) {
            List<Element> list = doc.getElements();
            for (Element element : list) {
                renderedDocument += element.render();
            }
        }
        return renderedDocument;
    }
}

class DocumentEditor {
    Document doc;
    DBpersistence db;
    DocumentRender dr;

    DocumentEditor(Document doc, DBpersistence db, DocumentRender dr) {
        this.doc = doc;
        this.db = db;
        this.dr = dr;
    }

    public void addText(String txt) {
        doc.addElement(new TextElement(txt));
    }

    public void addImg(String imgPath) {
        doc.addElement(new ImageElement(imgPath));
    }
    public void addTab()
    {
        doc.addElement(new TabElement());
    }

    public void saveToFile() {
        String str = dr.renderDocument();
        db.save(str);
        System.out.println("Data Saved");
    }
}

public class DocumentEditorClient {

    public static void main(String[] args) {

        Document doc = new Document();
        DBpersistence db = new FileStorage();

        DocumentRender render = new DocumentRender(doc);

        DocumentEditor editor = new DocumentEditor(doc, db, render);
        editor.addText("Hello world");
        editor.addTab();
        editor.addText("Software Development");
        editor.addImg("uml.png");

        editor.saveToFile();
    }
}
