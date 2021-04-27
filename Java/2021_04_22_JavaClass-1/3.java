/* Here, Box uses a parameterized constructor to
   initialize the dimensions of a box.
*/
class Box {
  double width;
  double height;
  double depth;

  // This is the constructor for Box.
  Box(double w, double h, double d) {
      width = w;
      height = h;
      depth = d;
  }

  // compute and return volume
  double volume() {
      System.out.println(this.width);
      return width * height * depth;
  }
}

class BoxDemo {
  public static void main(String args[]) {
      // declare, allocate, and initialize Box objects
      Box mybox1 = new Box(10, 20, 15); 
      // Box b1 = new Box(); This will cause error because of no default constructor.
      Box mybox2 = new Box(3, 6, 9);

      double vol;

      // get volume of first box
      vol = mybox1.volume();
      System.out.println("Volume is " + vol);

      // get volume of second box
      vol = mybox2.volume();
      System.out.println("Volume is " + vol);
  }
}
