package models;
 
import java.util.Date;
 
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;
 
import play.db.ebean.Model;
 
import com.avaje.ebean.annotation.CreatedTimestamp;
 
@Entity
public class Account extends Model {
 
    @Id
    public Long id;
 
    public String loginId;
 
    public String password;
 
    public String toString() {
        return "Account [id=" + id + ", login_id=" + loginId + ", password="
                + password +"]";
    }
}