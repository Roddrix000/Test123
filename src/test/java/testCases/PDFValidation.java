package testCases;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PDFValidation {

	public static String searchelement="Refund";
	static ArrayList<String> gfg = new ArrayList<String>(Arrays.asList(" QR Adjustment 2 0"," Group Ticket 5 240", " Cancellation 6 0"));
	static ArrayList list= new ArrayList();
	
    public static void main(String[] args) {
    	//checkingcontains();
       try {
            // Load the PDF document
            File file = new File("C:\\Users\\Ronald\\Desktop\\Paycraft\\paycraft.pdf");
            PDDocument document = PDDocument.load(file);

            // Create a PDFTextStripper object
            PDFTextStripper pdfStripper = new PDFTextStripper();

            // Set start and end page
            pdfStripper.setStartPage(1);
            pdfStripper.setEndPage(1); // Assuming the table is on the first page

            // Extract text
            String text = pdfStripper.getText(document);

            // Parse the extracted text to extract table data
            String[] lines = text.split("\\r?\\n");
            for (String line : lines) {
                // Assuming the table has comma-separated values
                String[] columns = line.split(",");
                for (String column : columns) {
                	list.add(column.trim().replace("\t", ""));
                }
            }
            // Close the document
          //  fetchValueinArray();
            System.out.println("Passed Valued "+gfg);
            checkListismatching();
            System.out.println("Data Fetched"+list);
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
      } 
    }
    
    public static void fetchValueinArray(String finddata)
    {
    	System.out.println("Searching for "+searchelement);
    	for (Iterator iterator = list.iterator(); iterator.hasNext();) {
    		String type = (String) iterator.next();
    	//	System.out.println(type);
    		if (type.contains(finddata)) {
    			System.out.println(type);
			}
    		
		}
    	
    }
    public static void checkListismatching()
    {
    	gfg.stream().forEach(g -> {
            boolean present = list.stream().anyMatch(l -> l.toString().contains(g.trim()));
            if(present) {
                System.out.println("Data Is present");
            } else {
                System.out.println("Data Not present");
            }
        });
    }
   
}
