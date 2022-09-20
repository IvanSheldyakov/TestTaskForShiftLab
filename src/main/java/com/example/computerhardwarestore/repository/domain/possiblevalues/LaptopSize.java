package com.example.computerhardwarestore.repository.domain.possiblevalues;

public enum LaptopSize {
     THIRTEEN(13),
     FOURTEEN(14),
     FIFTEEN(15),
     SEVENTEEN(17);

     private int size;
     private LaptopSize(int size) {
         this.size = size;
     }

     public int getSize() {
         return size;
     }
}
