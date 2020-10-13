package learn.doc;

import com.google.gson.Gson;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfReader;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PdfFillUitl {

	public static String[] getPdfKeys(String filePath, boolean iscontainsignfield) throws Exception {
		String[] keys = null;
		PdfReader reader = null;
		try {
			reader = new PdfReader(filePath);
			AcroFields fields = reader.getAcroFields();
			Map<String, AcroFields.Item> fieldMap = fields.getFields();
			Set<String> keySet = fieldMap.keySet();
			if (null != keySet && keySet.size() > 0) {
				if (!iscontainsignfield) {
					List<String> signatureNames = fields.getSignatureNames();
					if (null != signatureNames && signatureNames.size() > 0) {
						String each = null;
						for (Iterator<String> iterator = keySet.iterator(); iterator.hasNext(); ) {
							each = iterator.next();
							if (signatureNames.contains(each)) {
								iterator.remove();
							}
						}
					}
				}
				keys = keySet.toArray(new String[0]);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				if (null != reader) {
					reader.close();
				}
			} catch (Exception e) {
				//				logger.error(e);
			}
		}
		return keys;
	}


	public static void main(String[] args) throws Exception {
		String filePath = "C:\\Users\\PF0W8JF8\\Desktop\\国密\\测绘合同11.pdf";

		String[] templateKeys = getPdfKeys(filePath, true);
		System.out.println(new Gson().toJson(templateKeys));

	}


}
