public class Laptop extends ElectronicDevices{

  private String brand;
  private int RAM_SPACE;
  private int SSD_SPACE;
  public Laptop(String category, String brand, int RAM_SPACE, int SSD_SPACE) {
    super(category);
    this.brand = brand;
    this.RAM_SPACE = RAM_SPACE;
    this.SSD_SPACE = SSD_SPACE;
  }



}
