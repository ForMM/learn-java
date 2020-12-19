package learn.io;

import com.itextpdf.text.pdf.StringUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileUtil {

	/**
	 * 获取一个文件夹下的所有文件和子文件夹下的所有文件
	 * @param filePath
	 * @return
	 */
	public static List<File> readFiles(String filePath){
		if ("".equals(filePath)){
			return null;
		}

		File currentFile = new File(filePath);
		File[] files = currentFile.listFiles();

		List<File> fileList = new ArrayList<File>();

		for (File file : files){
			if (file.isDirectory()){
				readFile(file.getAbsolutePath());
			}else {
				fileList.add(file);
			}
		}

		for(File file : files) {
			System.out.println(file.getAbsolutePath());
		}
		return fileList;
	}

	/**
	 * 读取文件夹下的所有文件
	 * @param filepath
	 */
	public static void readFile(String filepath){
		File file = new File(filepath);
		File[] files = file.listFiles();
		List<File> fileList = new ArrayList<File>();
		for (File filet:files){
			fileList.add(filet);
		}

		for(File filett : fileList) {
			System.out.println(filett.getAbsolutePath());
		}
	}

	public static void main(String[] args) {
		String path = "C:\\Users\\PF0W8JF8\\Desktop\\上汽\\存证编号数据";
		readFiles(path);
	}

}
