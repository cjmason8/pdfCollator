package au.com.mason.pdfCollator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import au.com.mason.pdfCollator.service.PdfCollatorService;

@RestController
public class PdfCollatorController {
	
	@Autowired
	private PdfCollatorService pdfCollatorService;
	
	@PostMapping(value = "/documents/collate", consumes = { "multipart/form-data" })
	byte[] uploadFile(@RequestPart("fileOne") MultipartFile file1, @RequestPart("fileTwo") MultipartFile file2) throws Exception {
		
		return pdfCollatorService.collatePdfs(file1.getBytes(), file2.getBytes());
	}
	
}
