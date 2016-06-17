package com.hashtable;


import java.util.HashSet;
import java.util.Set;

class HashTable<K,V>
{
    private int TABLE_SIZE;
    private int size;
    private LinkedHashEntry[] table;

    public HashTable(int size)
    {
        this.size=0;
        this.TABLE_SIZE=size;
        this.table=new LinkedHashEntry[TABLE_SIZE];
        for(int i=0;i<table.length;i++)
            table[i] = null;
    }

    public int size()
    {
        return size;
    }

    public V get(K key)
    {
        int hash=key.hashCode()%TABLE_SIZE;

        LinkedHashEntry entry = table[hash];

        while(entry!=null && !entry.key.equals(key))
            entry=entry.next;

        if(entry == null)
            return null;
        return (V)entry.value;
    }

    public void put(K key, V value)
    {
        int hash=key.hashCode()%TABLE_SIZE;

        LinkedHashEntry entry = table[hash];

        if(entry==null) {
            table[hash] = new LinkedHashEntry(key, value);
            size++;
            return;
        }
        while(entry!=null && !entry.key.equals(key))
            entry=entry.next;
        if(entry.key.equals(key))
            entry.value=value;
        else {
            entry.next = new LinkedHashEntry(key, value);
            size++;
        }
    }

    public void remove(K key)
    {
        int hash=key.hashCode()%TABLE_SIZE;
        LinkedHashEntry entry=table[hash];
        if(entry==null)
            return;
        if(entry.key.equals(key)) {
            table[hash] = table[hash].next;
            size--;
            return;
        }
        while(entry!=null && entry.next!=null && !entry.next.key.equals(key))
            entry=entry.next;
        if(entry.next!=null) {
            entry.next = entry.next.next;
            size--;
        }
    }

    public Set<K> keySet()
    {
        Set<K> set=new HashSet<>();
        for(LinkedHashEntry entry:table)
        {
            if(entry==null)
                continue;
            LinkedHashEntry temp=entry;
            while (temp!=null)
            {
                set.add((K)temp.key);
                temp=temp.next;
            }
        }
        return set;
    }

    static class LinkedHashEntry<K,V>
    {
        K key;
        V value;
        LinkedHashEntry next;
        LinkedHashEntry(K key, V value)
        {
            this.key=key;
            this.value=value;
            this.next=null;
        }
    }
}
