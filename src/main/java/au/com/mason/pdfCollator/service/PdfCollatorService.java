package au.com.mason.pdfCollator.service;

import java.io.ByteArrayOutputStream;

import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.springframework.stereotype.Component;

@Component
public class PdfCollatorService {

	public byte[] collatePdfs(byte[] fileOne, byte[] fileTwo) throws Exception {
		PDDocument docOne = PDDocument.load(fileOne);
		PDDocument docTwo = PDDocument.load(fileTwo);
		Splitter splitter = new Splitter();
		PDDocument[] splittedDocumentsOne = splitter.split(docOne).toArray(new PDDocument[0]);
		PDDocument[]  splittedDocumentsTwo = splitter.split(docTwo).toArray(new PDDocument[0]);
		PDDocument mergedDoc = new PDDocument();
		PDFMergerUtility merger = new PDFMergerUtility();
		for (int count = 0; count < splittedDocumentsOne.length; count++) {
			merger.appendDocument(mergedDoc, splittedDocumentsOne[count]);
			if (count < splittedDocumentsTwo.length) {
				merger.appendDocument(mergedDoc, splittedDocumentsTwo[count]);
			}
		}
		for (int count = splittedDocumentsOne.length; count < splittedDocumentsTwo.length; count++) {
			merger.appendDocument(mergedDoc, splittedDocumentsTwo[count]);
		}
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		mergedDoc.save(os);
		
		return os.toByteArray();
	}
	
}
