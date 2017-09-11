package test;

import java.io.*;
/**
 * Created by xjliu on 2016-05-04.
 */
public class MyList<E> {

    public static final int INITIAL_SIZE = 50;

    int size = 0;

    private E[] data = (E[])new Object[INITIAL_SIZE];

    public void add(E element)
    {
        if(size == data.length)
        {
           E[]  nData = (E[])new Object[size*2];
            System.arraycopy(data,0,nData,0,size);
            data = nData;
        }

        data[size] = element;
        size++;
    }

    public E get(int index) throws IllegalArgumentException
    {
        if(index < 0 || index > length()-1)
            throw new IllegalArgumentException("invalid index:" + index);
        return data[index];
    }

    public int length()
    {
        return size;
    }


    public static void main(String[] args) {
        //simple test
        MyList<String> list = new MyList<String>();
        list.add("good");
        list.add("perfect");
        list.add("best");
        list.add("better");

        System.out.println(list.length());
        System.out.println(list.get(1));
//        System.out.println(list.get(8));


        System.out.println("-------------");
        String[] listStr = null;
        String[] listInt = null;

        try {
            BufferedReader in = new BufferedReader(
                    new FileReader("/Users/xjliu/Downloads/list-strings.txt"));
            String str;
            while ((str = in.readLine()) != null) {
                listStr =str.split(",");
            }

            in = new BufferedReader(
                    new FileReader("/Users/xjliu/Downloads/list-numbers.txt"));

            while ((str = in.readLine()) != null) {
                listInt =str.split(",");
            }
            in.close();
        } catch (IOException e) {
            System.out.println("File Read Error");
        }


        System.out.println("listStr length : " + listStr.length);
        MyList<String> myList = new MyList<String>();
        for (int i = 0; i < listStr.length; i++)
            myList.add(listStr[i]);
        System.out.println(myList.get(69));
        System.out.println(myList.get(138));
        System.out.println(myList.get(439));

        System.out.println("listInt length : " + listInt.length);
        MyList<Integer> myListInt = new MyList<Integer>();
        for (int i = 0; i < listInt.length; i++)
            myListInt.add(Integer.parseInt(listInt[i]));
        System.out.println(myListInt.get(69));
        System.out.println(myListInt.get(138));
        System.out.println(myListInt.get(439));
    }
}
