package onlinestore;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class Laptop extends ElectronicDevices {

  private String brand;
  private int RAM_SPACE;
  private int SSD_SPACE;
  private Collection<Laptop> laptops = new ArrayList<>();

  public Laptop(String category, String brand, int RAM_SPACE, int SSD_SPACE) {
    super(category);
    this.brand = brand;
    this.RAM_SPACE = RAM_SPACE;
    this.SSD_SPACE = SSD_SPACE;
  }

  public Collection<Laptop> getLaptops() {
    return laptops;
  }

  public String getBrand() {
    return brand;
  }

  public Collection<Laptop> filterByBrand(String brand){
    return laptops.stream().filter(a-> a.getBrand().equals(brand)).collect(Collectors.toList());
  }

}
