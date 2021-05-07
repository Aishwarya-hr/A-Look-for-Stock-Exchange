package mahoo_finance;


import java.io.File;

//Windows solution to view a PDF file
public class OpenPdf {

	public static void main(String[] args) {

	  try {
		  
		if ((new File("C:\\Users\\aishwarya\\Desktop\\placement\\PPLAL2Questions.pdf")).exists()) {

			Process p = Runtime
			   .getRuntime()
			   .exec("rundll32 url.dll,FileProtocolHandler C:\\Users\\aishwarya\\Desktop\\placement\\PPLAL2Questions.pdf");
			p.waitFor();

		} else {

			System.out.println("File is not exists");

		}

		

	  } catch (Exception ex) {
		ex.printStackTrace();
	  }

	}
}