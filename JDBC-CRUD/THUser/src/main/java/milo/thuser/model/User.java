package milo.thuser.model;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.util.Date;

public class User {
     private int id;
     protected String name;
     protected String email;
     protected int idCountry;
     protected String password;

     public User() {}

     public User(String name, String email, int idCountry) {
          super();
          this.name = name;
          this.email = email;
          this.idCountry = idCountry;
     }

     public User(int id, String name, String email, int idCountry) {
          this.id = id;
          this.name = name;
          this.email = email;
          this.idCountry = idCountry;
     }

     public int getId() {
          return id;
     }
     public void setId(int id) {
          this.id = id;
     }
     @NotEmpty (message = "Name not empty")
     @Length(min = 3, max = 10 , message = "Lenght of Name form 3 - 10 character ")
     public String getName() {
          return name;
     }
     public void setName(String name) {
          this.name = name;
     }
     @NotEmpty
     @Email(regexp = "([A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,3})",message = "Email format not right")
     public String getEmail() {
          return email;
     }
     public void setEmail(String email) {
          this.email = email;
     }
     public int getCountry() {
          return idCountry;
     }
     public void setCountry(int country) {
          this.idCountry = country;
     }

     @NotEmpty
     @Pattern(regexp = "(([A-Z])[a-zA-Z0-9.*@_-]{8,15})", message = "Format password not right")
     public String getPassword() {
          return password;
     }

     public void setPassword(String password) {
          this.password = password;
     }

     @Override
     public String toString() {
          return "User{" +
                  "id=" + id +
                  ", name='" + name + '\'' +
                  ", email='" + email + '\'' +
                  ", country='" + idCountry + '\'' +
                  '}';
     }
}
