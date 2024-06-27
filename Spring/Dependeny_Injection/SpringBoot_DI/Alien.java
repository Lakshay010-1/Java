import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Alien {
    @Value("Java")
    private String language;
    private Computer com;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Computer getCom() {
        return com;
    }

    @Autowired
    //@Qualifier("sunglass")
    public void setCom(Computer com) {
        this.com = com;
    }

    public void code() {
        com.compile();
    }
}
