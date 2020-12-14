package onlinestore.core;


public class User {

  private String username;
  private String firstName;
  private String familyName;
  private String password;

  public User(String username, String firstName, String familyName, String password) {
    setUsername(username);
    setFirstName(firstName);
    setFamilyName(familyName);
    setPassword(password);
  }

  /**
   *
   * @param username requires:
   *                 - One uppercase lettar
   *                 - One lowercase lettar
   *                 - minimum of 4 lettars
   *                 - followed by exactly 4 digits
   */
  private void setUsername(String username) {
    if(checkValidUsername(username))
      this.username = username;
    else {
      throw new IllegalArgumentException("not a valid username");
    }
  }

  /**
   *
   * @param firstName requires onlu lettars
   */
  public void setFirstName(String firstName) {
    if(checkValidfirsName(firstName))
      this.firstName = firstName;
    else{
      throw new IllegalArgumentException("not a vlid firstname");
    }
  }

  /**
   *
   * @param familyName requires onlu lettars
   */
  public void setFamilyName(String familyName) {
    if(checkValidFamilyname(familyName))
      this.familyName = familyName;
    else{
      throw new IllegalArgumentException("not a vlid familyname");
    }
  }

  /**
   * @param password requires:
   *                 - Minimum one Uppercase
   *                 - Minimum one lower case
   *                 - Minimum one digit
   *                 - Minimum length is 8
   */
  private void setPassword(String password) {
    if (checkValidPassword(password))
      this.password = password;
    else {
      throw new IllegalArgumentException("not a valid password");
    }
  }

  private boolean checkValidUsername(String username) {
    String pattern = "^[a-zA-Z]{4,}[0-9]{4}";
    return username.matches(pattern);
  }

  private boolean checkValidfirsName(String firstName) {
    String pattern = "[A-Za-z]+";
    return firstName.matches(pattern);
  }

  private boolean checkValidFamilyname(String familyName) {
    String pattern = "[a-zA-Z]+";
    return familyName.matches(pattern);
  }

  private boolean checkValidPassword(String password) {
    String pattern = "^(?=.*[0-9])(?=.*[a-zæøå])(?=.*[A-ZÆØÅ])(?=\\S+$).{8,}$";
    return password.matches(pattern);
  }

  public String getUsername() {
    return username;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getFamilyName() {
    return familyName;
  }

  public String getPassword() {
    return password;
  }

  public static void main(String[] args) {
    User user = new User("Heisann2312", "Sanket", "B", "bestePassord123");
    System.out.println(user);
  }

}
