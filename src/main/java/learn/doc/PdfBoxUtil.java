package learn.doc;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PdfBoxUtil {


	public static String pdf2Image(String sourceFile,String destFile,String width,String pageScale){
		File file = new File(sourceFile);
		PDDocument pdDocument;
		try {
			String imgPDFPath = file.getParent();
			int dot = file.getName().lastIndexOf('.');
			String imagePDFName = file.getName().substring(0, dot); // 获取图片文件名
			String imgFolderPath = destFile;

			pdDocument = PDDocument.load(file);
			PDFRenderer renderer = new PDFRenderer(pdDocument);
			/* dpi越大转换后越清晰，相对转换速度越慢 */
			StringBuffer imgFilePath = null;

			String imgFilePathPrefix = imgFolderPath + File.separator + imagePDFName;
			imgFilePath = new StringBuffer();
			imgFilePath.append(imgFilePathPrefix);
			imgFilePath.append(".png");
			File dstFile = new File(imgFilePath.toString());
			BufferedImage image = renderer.renderImageWithDPI(0, 300);
			ImageIO.write(image, "png", dstFile);
			System.out.println("PDF文档转PNG图片成功！");
			return imgFilePath.toString();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
