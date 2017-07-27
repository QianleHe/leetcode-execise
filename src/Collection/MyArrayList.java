package Collection;


public class MyArrayList {
    public static void main(String[] args) {
        MyArrayList arr = new MyArrayList();
        arr.add("1111");
        arr.add("1111");
        arr.add("1111");
        arr.add("1111");
        arr.remove(3);
        System.out.println(arr.size());
        System.out.println(arr.toString());
    }

    private Object[] objects;
    private int size;

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public MyArrayList() {
        this(10);
    }

    public MyArrayList(int initailSize) {
        objects = new Object[initailSize];
    }

    public void add(Object element) {
        if (size + 1 > objects.length) {
            Object[] newArray = new Object[size + size >> 1];
            System.arraycopy(objects, 0, newArray, 0, objects.length);
            objects = newArray;
        }
        objects[size++] = element;
    }

    public Object get(int index) {
        rangeCheck(index);
        return objects[index];
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            try{
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Object remove(int index) {
        rangeCheck(index);

        Object res = objects[index];
        int moveNum = size - index - 1;
        System.arraycopy(objects, index + 1, objects, index, moveNum);
        objects[--size] = null;
        return res;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (Object obj : objects) {
            if (obj != null)
                sb.append(obj + " ");
        }
        //s.substring(0, s.length() - 1);
        sb.append("]");
        return sb.toString();
    }

}
