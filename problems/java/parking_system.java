/*
 * 1603. Design Parking System
 */

class ParkingSystem {

  int big_spaces;
  int med_spaces;
  int small_spaces;

  public ParkingSystem(int big, int medium, int small) {
    this.big_spaces = big;
    this.med_spaces = medium;
    this.small_spaces = small;
  }

  public boolean addCar(int carType) {
    if (carType == 1 && this.big_spaces > 0) {
      this.big_spaces--;
      return true;
    } else if (carType == 2 && this.med_spaces > 0) {
      this.med_spaces--;
      return true;
    } else if (carType == 3 && this.small_spaces > 0) {
      this.small_spaces--;
      return true;
    }
    return false;
  }
}
/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
