

package Models;


public class Users {
    
    private String Name;
    private String Telephone;
    private String Email;
    private String Ine;
    private String Address;
    private String Age;
    private Boolean Gender;
    private int Signo;

    public Users(String Name, String Telephone, String Email, String Ine, String Address, String Age, Boolean Gender, int Signo) {
        this.Name = Name;
        this.Telephone = Telephone;
        this.Email = Email;
        this.Ine = Ine;
        this.Address = Address;
        this.Age = Age;
        this.Gender = Gender;
        this.Signo = Signo;
    }

    public Users() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String Telephone) {
        this.Telephone = Telephone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getIne() {
        return Ine;
    }

    public void setIne(String Ine) {
        this.Ine = Ine;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String Age) {
        this.Age = Age;
    }

    public Boolean getGender() {
        return Gender;
    }

    public void setGender(Boolean Gender) {
        this.Gender = Gender;
    }

    public int getSigno() {
        return Signo;
    }

    public void setSigno(int Signo) {
        this.Signo = Signo;
    }
    
}
