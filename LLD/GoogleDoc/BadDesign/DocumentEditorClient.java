package LLD.GoogleDoc.BadDesign;

import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

class DocumentEditor{
    private List<String> list = new ArrayList<>();
    private String renderedDocument;

    public DocumentEditor(){
        renderedDocument = "";
    }

    public void addText(String str){
        list.add(str);
    }
    public void addImage(String str){
        list.add(str);
    }

    public String renderDocument()
    {
        if (renderedDocument.isEmpty()) {
            StringBuilder result = new StringBuilder();
            for (String element : list) {
                if (element.length() > 4 && 
                   (element.endsWith(".jpg") || element.endsWith(".png"))) {
                    result.append("[Image: ").append(element).append("]\n");
                } else {
                    result.append(element).append("\n");
                }
            }
            renderedDocument = result.toString();
        }
        return renderedDocument;
    }

    public void saveToFile()
    {
        try{
            FileWriter writer = new FileWriter("document.txt");
            writer.write(renderDocument());
            writer.close();
            System.out.println("save The Rendered Documents");
        }catch(IOException e)
        {
            System.out.println("Exception Error in Saving Into Document");
        }
    }
}

public class DocumentEditorClient {
    public static void main(String[] args) {
        DocumentEditor editor = new DocumentEditor();
        editor.addText("Hello, world!");
        editor.addImage("picture.jpg");
        editor.addText("This is a document editor.");

        System.out.println(editor.renderDocument());

        editor.saveToFile();
    }
}
