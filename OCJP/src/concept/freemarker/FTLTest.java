package concept.freemarker;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

public class FTLTest {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		//cfg.setDirectoryForTemplateLoading(new File());
		//cfg.setDefaultEncoding("UTF-8");
		//cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
		try {
			Template template = cfg.getTemplate("helloworld.ftl");

			// Build the data-model
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("message", "Hello World!");

			// List parsing
			List<String> countries = new ArrayList<String>();
			countries.add("India");
			countries.add("United States");
			countries.add("Germany");
			countries.add("France");

			data.put("countries", countries);

			// Console output
			Writer out = new OutputStreamWriter(System.out);
			template.process(data, out);
			out.flush();

			// File output
			/*Writer file = new FileWriter(new File("C:\\FTL_helloworld.txt"));
			template.process(data, file);
			file.flush();
			file.close();*/
			
		} catch (TemplateNotFoundException e) {
			e.printStackTrace();
		} catch (MalformedTemplateNameException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
