package Collection;

import java.util.LinkedList;

public class MyHashMap {

//    MyEntry[] arr = new MyEntry[999];

    LinkedList[] arr = new LinkedList[999];
    public int size;

    public int size() {return size;}

    public Object put(Object key, Object value) {
        int pos = key.hashCode() % 999;
        if (arr[pos] == null) {
            arr[pos] = new LinkedList();
            arr[pos].add(new MyEntry(key, value));
        } else {
            // 还有等于覆盖的情况
            LinkedList list = arr[pos];
            for (int i = 0; i < list.size(); i++) {
                MyEntry entry = (MyEntry) list.get(i);
                if (entry.getKey().equals(key)) {
                    list.remove(entry);
                }
            }
            arr[pos].add(new MyEntry(key, value));
        }
        size++;
        return value;
    }

    public Object get(Object key) {
        int pos = key.hashCode() % 999;
        if (arr[pos] != null) {
            LinkedList list = arr[pos];
            for (int i = 0; i < list.size(); i++) {
                MyEntry entry = (MyEntry) list.get(i);
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
                }
            }
        }
        return null;
    }

    public boolean containsKey(Object key) {
        int pos = key.hashCode() % 999;
        if (arr[pos] != null) {
            LinkedList list = arr[pos];
            for (int i = 0; i < list.size(); i++) {
                MyEntry entry = (MyEntry) list.get(i);
                if (entry.getKey().equals(key)) {
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put("aaa","aaa");
        map.put("bbb","bbb");
        System.out.println(map.get("aaa"));
        System.out.println(map.size());
    }

}


class MyEntry{

    public Object key;

    public Object value;

    public MyEntry() {

    }

    public MyEntry(Object key, Object value) {
        this.key = key;
        this.value = value;
    }

    public Object getKey() {
        return key;
    }

    public void setKey(Object key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
