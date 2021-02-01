import java.util.Arrays;
import java.util.Arrays;
import java.util.Scanner;
public class TestClass {

    public class DynamicArray {
        String[] data;
        int size;

        public DynamicArray() {
            size = 0;
            data = new String[1];
        }

        public int getSize() {

            return data.length;
        }

        public String get(int index) {
            return (String) data[index];
        }

        public void add(String obj) {
            ensureCapacity(size + 1);
            data[size++] = obj;
        }

        public boolean add(int index, String obj) {
            data[index] = obj;
            return false;
        }

        public void put(int index, String obj) {

            String temp;
            int length=lengthCounter();
            if (index <= data.length) {
                for (int i = data.length - 1; i >= index; i--) {
                    temp = data[i - 1];
                    data[i] = temp;
                }
                data[index - 1] = obj;
            } else {
                //data[length] = obj;

                for (int i= data.length;i<index;i++)
                {
                    add(null);
                    if (i==(index-1))
                    {
                        data[i]=obj;
                        break;
                    }

                }
            }
        }

        public void printString(DynamicArray str, int length) {
            System.out.print(" [ ");
            for (int i = 0; i < str.data.length; i++) {
                if (str.get(i) == null) {
                    System.out.print(" null ");
                    //break;
                } else
                    System.out.print(" " + str.get(i));
            }
            System.out.print(" ] ");
        }

        private void ensureCapacity(int minimumCapacity) {
            int oldSize = getSize();
            if (minimumCapacity > oldSize) {
                int newCapacity = oldSize + 5;
                data = Arrays.copyOf(data, newCapacity);
            }
        }

        public int lengthCounter ()
        {
            int length=0;
            while (true) {
                if (data[length] == null) {
                    break;
                } else {
                    length++;
                }
            }
            return length;
        }
        public void remove(String str) {
            //int length = lengthCounter();
            for (int i=0;i<data.length;i++)
            {
                if (data[i]==str)
                {
                    data[i]=null;
                    //break;
                }
            }
            nullRemover();
        }
        public void nullRemover ()
        {
            String[] refinedArray = new String[data.length];
            int count = -1;
            for(String s : data) {
                if(s != null) { // Skips over null values
                    refinedArray[++count] = s;
                }
            }
            // Returns an array with the same data but refits it to a new length

            data = Arrays.copyOf(refinedArray, count + 1);
        }
        public void remove (int index , String str)
        {
            data[index-1]=null;
            nullRemover();
        }

    }
}
