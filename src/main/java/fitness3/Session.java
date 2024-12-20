package fitness3;

public class Session {


    private String type;
    private String description;

    public Session(String description) {

        this.description= description;
        setTypeInPerson();




    }



   public void setTypeInPerson() { 
       type = "in-person";
   }


 public void setTypeOnline() { 
       type = "online";
   }
 
 public void setDescription(String description) { 
       this.description =description;
 }
 
public String getDescription() {


     return description;

 }

 public String getType() {


     return type;

 }



}