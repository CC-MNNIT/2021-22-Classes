// This program uses a parameterized method.

class Box {
    double width;
    double height;
    double depth;
  
    // compute and return volume
    double volume() {
      return width * height * depth;
    }
  
    // sets dimensions of box
    void setDim(double w, double h, double d) {
      width = w;
      height = h;
      depth = d;
    }
  }
    
  class BoxDemo {
    public static void main(String args[]) {
      Box mybox1 = new Box();
      Box mybox2 = new Box();
      double vol;
  
      // initialize each box
      mybox1.setDim(10, 20, 15);
      mybox2.setDim(3, 6, 9);    
  
      // get volume of first box
      vol = mybox1.volume();
      System.out.println("Volume is " + vol);
  
      // get volume of second box
      vol = mybox2.volume();
      System.out.println("Volume is " + vol);
    }
  }
  