package models;

import java.util.*;
import play.modules.mongodb.jackson.MongoDB;
import net.vz.mongodb.jackson.JacksonDBCollection;
import net.vz.mongodb.jackson.Id;
import net.vz.mongodb.jackson.ObjectId;
import org.codehaus.jackson.annotate.JsonProperty;

import javax.persistence.*;

public class Template{
    
  @Id
  @ObjectId
  public String id;

  public String label;
  
  public String htmlText;

  private static JacksonDBCollection<Template, String> coll = MongoDB.getCollection("templates", Template.class, String.class);

  public Template(){

  }

  public Template(String label, String htmlText) {
    this.label = label;
    this.htmlText = htmlText;
  }

  public static List<Template> all() {
    return Template.coll.find().toArray();
  }

  public static void create(Template template) {
    Template.coll.save(template);
  }

  public static void create(String label, String htmlText){
      create(new Template(label, htmlText));
  }

  public static void delete(String id) {
    Template template = Template.coll.findOneById(id);
    if (template != null)
        Template.coll.remove(template);
  }
  
  public static Template view(String id) {
	    return Template.coll.findOneById(id);
	  }


  public static void removeAll(){
    Template.coll.drop();
  }

}
