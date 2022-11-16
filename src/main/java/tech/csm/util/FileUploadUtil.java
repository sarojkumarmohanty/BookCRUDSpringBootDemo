package tech.csm.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.servlet.http.Part;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadUtil {

	public static String getFilePath(MultipartFile part) {
		File file1=null;
		String finalfilePath=null;
		try {
			String fileName = part.getOriginalFilename();
			File file = new File("d:/utf/");
			if (!file.isDirectory()) {
				file.mkdir();
			}
			finalfilePath="d:/utf/" + fileName;
			file1 = new File(finalfilePath);
			InputStream in = part.getInputStream();
			FileOutputStream fos = new FileOutputStream(file1);
			byte[] bytes = new byte[(int) part.getSize()];

			in.read(bytes);
			fos.write(bytes);

			in.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return finalfilePath;
	}

}
