
package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Company;
import entity.Person;
import java.util.List;

public class JSONConverter {
   private static Gson gson = new GsonBuilder().setPrettyPrinting().create(); 
   
   public JSONConverter(){
        
   }
    
    public static Person getPersonFromJson(String js) {
        return gson.fromJson(js, Person.class);
    }
   
   public static String getJSONFromPerson(Person p) {
       return gson.toJson(p);
   }
   
   public static String getJSONFromPerson(List<Person> persons) {
       return gson.toJson(persons);
   }
   
   public static Company getCompanyFromJson(String js){
       Company company = gson.fromJson(js, Company.class);
       return company;
   }
   
   public static String getJSONFromCompany(Company c) {
       return gson.toJson(c);
   }
   
   public static String getJSONFromCompany(List<Company> companies) {
       return gson.toJson(companies);
   } 
}
