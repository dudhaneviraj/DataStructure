package com.hashtable;

import java.util.HashMap;

class test{
    Integer id;
    String name;

    public test(int id,String name)
    {
        this.id=id;
        this.name=name;
    }

    @Override
    public int hashCode()
    {
        int hash=7;

        hash=3*hash+id.hashCode();
        hash=3*hash+name.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        if(object ==null || object.getClass()!=getClass())
            return false;
        test t=(test)object;
        if(t.id==id && this.name.equals(t.name))
            return true;
        return false;
    }
    @Override
    public String toString()
    {
        return id + " : " + name;
    }
}

public class HashTableImplementation {

    public static void main(String[] args) {

        HashTable<test,String> table=new HashTable<test,String>(10);

        table.put(new test(1,"Viraj"),"100");
        table.put(new test(2,"Viraj"),"100");
        table.put(new test(3,"Viraj"),"100");
        table.put(new test(4,"Viraj"),"106");
        table.put(new test(5,"Viraj"),"100");
        table.put(new test(6,"Viraj"),"100");

//        table.remove("Viraj");
        System.out.println(table.get(new test(1,"Viraj")));
        System.out.println(table.size());
//        table.remove(new test(1,"Viraj"));
        System.out.println(table.size());


        System.out.println(table.get(new test(4,"Viraj")));

        System.out.println(table.keySet().toString());
    }

}
