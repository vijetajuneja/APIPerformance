package TestScenario;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ValidateAPI {
	@Test
	public void validateAPIdetails()
	{
	SoftAssert softAssert = new SoftAssert();
	
	try
	{
		File src=new File("src/main/java/AllCollectionPages.xlsx");

		// load file
		FileInputStream fis=new FileInputStream(src);

		// Load workbook
		XSSFWorkbook wb=new XSSFWorkbook(fis);

		// Load sheet- Here we are loading first sheet only
		XSSFSheet sh1= wb.getSheetAt(0);
		System.out.println(sh1.getRow(0).getCell(0).getStringCellValue());
		

//		int rowCount = sh1.getLastRowNum()-sh1.getFirstRowNum();

		for (int i = 1; i < 25; i++) 
		{
			String id = sh1.getRow(i).getCell(0).getStringCellValue();

		String reqbody = " {"
					+ "	allCollections(collectionId: "+  id	+ " ){ megaCollectionId templateSuffix  handle title  description disableCompareTool image { src alt }"
				    + " metafields{ namespace data { key value } }"
				    + "	collections{ collectionId templateSuffix handle title displayOrder productsRelation{ productId displayOrder }"
				    + "	metafields{ namespace data { key value } }"
				    + "	products{ productId title handle price	compareAtPriceMax productType tags	options{ name position	values	} images{ src alt	displayOrder }"
				    + "	featureImage{	src	alt	}	variants{	productVariantId	title	sku	option1	option2	option3	price  displayOrder	compareAtPrice	availableQty }	metafields{	namespace data {key	value}"
				    + "	}			}		}    } }";


		RestAssured.baseURI = "https://api.tommyjohn.com";		
		 System.out.println(reqbody);
		Response response = RestAssured.given().header("Authorization" ,"Basic Y3RfdXNlckB0b21teWpvaG4tUVc0TzdULkM3SDhORzphODIxMmYyYi03MTBkLTRiMDQtOWRjMC1lMGVlN2ViMjdiYWE=").contentType(ContentType.TEXT).body(reqbody).post("/collection-api");
		int statuscode = response.getStatusCode();
		String responsebody = response.asString();
		System.out.println("Response: " + response.asString());
		
		System.out.println("Status code: " + response.getStatusCode());
		
		System.out.println(id);
		softAssert.assertEquals(statuscode, 200 , "API response status code not 200"+id);
		softAssert.assertEquals(responsebody.contains("Missing namespaces for mega-collection"), false , "Missing namespaces for mega-collection error is present in response" +id);
		softAssert.assertEquals(responsebody.contains("Missing sub-collections for mega-collection"), false , "Missing sub-collections for mega-collection error is present in response" +id);
		softAssert.assertEquals(responsebody.contains("Missing metafields for Collection"), false , "Missing metafields for Collection error is present in response"+id);
		softAssert.assertEquals(responsebody.contains("Missing products for Sub-Collection"), false , "Missing products for Sub-Collection error is present in response"+id);
		softAssert.assertEquals(responsebody.contains("Missing namespaces for Sub-Collection"), false , "Missing namespaces for Sub-Collection error is present in response"+id);
		
		
		softAssert.assertEquals(responsebody.contains("Missing products-relation for Sub-Collection"), false , "Missing products-relation for Sub-Collection error is present in response"+id);
		softAssert.assertEquals(responsebody.contains("Missing tags for Product"), false , "Missing tags for Product error is present in response"+id);
		softAssert.assertEquals(responsebody.contains("Missing variants for Product"), false , "Missing variants for Product error is present in response"+id);
		softAssert.assertEquals(responsebody.contains("Missing images for Product"), false , "Missing images for Product error is present in response"+id);
		softAssert.assertEquals(responsebody.contains("Missing namespaces for Product"), false , "Missing namespaces for Product error is present in response"+id);
		softAssert.assertEquals(responsebody.contains("Missing options for Product"), false , "Missing options for Product error is present in response"+id);
		softAssert.assertEquals(responsebody.contains("Missing feature-image for Product"), false , "Missing feature-image for Product error is present in response"+id);
		softAssert.assertEquals(responsebody.contains("Missing metafields for Product"), false , "Missing metafields for Product error is present in response"+id);
	}
	}
	catch (Exception e)
	{
		Reporter.log("File not found");
		System.out.println("File not found");
	}
	
	try
	{
	softAssert.assertAll();
	}
	catch(AssertionError e)
	{
	sendemail(e);	
	}
	}

	public void sendemail(AssertionError e) {
		
		String to1 = "vijeta@tommyjohnwear.com";
		String to2 = "saurabh.agarwal@tommyjohnwear.com";
		String to3 = "manoj.konale@tommyjohnwear.com";
		String to4 = "vipul@tommyjohnwear.com";
		String to5 = "anjali.pathak@tommyjohnwear.com";
		String to6 = "jubin@tommyjohnwear.com";
		String to7 = "akshata@tommyjohnwear.com";
		String to8 = "anil@tommyjohnwear.com";

		// Sender's email ID needs to be mentioned
		String from = "noreplymw@tommyjohnwear.com";
		// Assuming you are sending email from localhost
		String host = "secure.emailsrvr.com";
		// Get system properties
		Properties properties = System.getProperties();
		// Setup mail server
		properties.setProperty("mail.smtp.host", host);
		properties.setProperty("mail.smtp.port", "587");
		properties.setProperty("mail.smtp.auth", "true");

		Authenticator auth = new Authenticator()
		{
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("edw_job_alerts@aretove.com", "RedBook2018");
			}
		};

		// Get the default Session object.
		Session session = Session.getDefaultInstance(properties, auth);
		System.out.println("Session Created");

		try{
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);
			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));
			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO,new InternetAddress(to1));
			message.addRecipient(Message.RecipientType.TO,new InternetAddress(to2));
			message.addRecipient(Message.RecipientType.TO,new InternetAddress(to3));
			message.addRecipient(Message.RecipientType.TO,new InternetAddress(to4));
			message.addRecipient(Message.RecipientType.TO,new InternetAddress(to5));
			message.addRecipient(Message.RecipientType.TO,new InternetAddress(to6));
			message.addRecipient(Message.RecipientType.TO,new InternetAddress(to7));
			message.addRecipient(Message.RecipientType.TO,new InternetAddress(to8));

			// Set Subject: header field
			message.setSubject("Collection Page may be down ");

			// Create the message part 
			BodyPart messageBodyPart = new MimeBodyPart();

			// Fill the message
			messageBodyPart.setText(e.toString());

			// Create a multipar message
			Multipart multipart = new MimeMultipart();

			// Set text message part
			multipart.addBodyPart(messageBodyPart);

			// Part two is attachment
			//		         messageBodyPart = new MimeBodyPart();
			//		         String filename = "<Enter File Path of Emailable Report>";
			//		         DataSource source = new FileDataSource(filename);
			//		         messageBodyPart.setDataHandler(new DataHandler(source));
			//		         messageBodyPart.setFileName(filename);
			//		         multipart.addBodyPart(messageBodyPart);

			// Send the complete message parts
			message.setContent(multipart );
			System.out.println(message.getSubject());
			// Send message
			Transport.send(message);
			System.out.println("Sent message successfully....");
		}catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
}


