import java.util.Objects;

public class People {
    private String fio;
    private String number;
   private String mail;

    public People(String fio, String number, String mail) {
        this.fio = fio;
        this.number = number;
        this.mail = mail;

    }
   public String getFio() {
        return fio;
    }

    @Override
    public String toString() {
        return fio+" - "+number+" - "+mail;




    }
}
