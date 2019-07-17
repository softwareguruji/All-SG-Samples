package modelmapperexample;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

public class ModelMapperExample {
    public static void main(String[] args) {
		
		ModelMapper modelMapper = new ModelMapper();
		
		Child child = new Child();
		child.setFirstName("First");
		child.setLastName("last");
		//child.setDate("07/17/2019");
		

		//Option 1 direct mapping
		//Parent parent = modelMapper.map(child, Parent.class);
		
		//Option 2 Property mapping - Gives Error
		/*PropertyMap<Child, Parent> personMap = new PropertyMap<Child, Parent>() {
			  protected void configure() {
			    
				  map().setFirstName(source.getFirstName());
				  map().setLastName(source.getLastName());
				  
				  String dateString  = source.getDate();
				  SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
				  Date date = null;
					try {
						date = sdf.parse(dateString);
					} catch (ParseException e) {
						e.printStackTrace();
					}
				  if(date != null) {
					  map().setDate(date);
				  }
			  }
			};
		modelMapper.addMappings(personMap);*/
		
		//Option 3 Use Converter
		Converter<String, Date> dateConversion = new AbstractConverter<String, Date>() {
		  protected Date convert(String dateString) {
			  if(dateString != null) {
				  SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
				  Date date = null;
				  try {
					  date = sdf.parse(dateString);
				  } catch (ParseException e) {
					  e.printStackTrace();
				  }
				  if(date != null) {
					  return date;
				  }
			  }
			  return null;
		  }
		};
		
		
		//Option 4 Create another complex converter
		Converter<String, String> toUppercase = new AbstractConverter<String, String>() {
			  protected String convert(String source) {
			    return source == null ? null : source.toUpperCase();
			  }
			};
		
		PropertyMap<Child, Parent> map = new PropertyMap<Child, Parent>() {
			@Override
			protected void configure() {
				using(toUppercase).map().setFirstName(source.getFirstName());
				using(dateConversion).map(source.getDate()).setDate(null);
			}
		};
		
		modelMapper.addMappings(map);
		Parent parent = modelMapper.map(child, Parent.class);
		
		System.out.println(parent.getFirstName());
		System.out.println(parent.getLastName());
		System.out.println(parent.getMiddleName());
		System.out.println(parent.getDate());
		System.out.println(parent.getAge());
	}
}