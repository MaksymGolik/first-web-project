package labwork.holik.maksym.lab3;

import labwork.holik.maksym.lab2.*;
import java.util.Iterator;

public class MyListImpl implements IMyList {
    private class IteratorImpl implements Iterator<Estate>{
        Node current = first;
        int cur_pos = 0;
        boolean can_remove = false;

        @Override
        public boolean hasNext() {
            if(cur_pos<size())return true;
            else return false;
        }

        @Override
        public Estate next() {
            Node returned = current;
            current = current.next;
            cur_pos++;
            can_remove=true;
            return returned.data;
        }

        @Override
        public void remove() {
            if(!can_remove){
                throw new IllegalStateException();
            }
            MyListImpl.this.remove(--cur_pos);
            can_remove=false;
        }
    }
   static class Node{
        Node(Estate d){
            data=d;
            prev=null;
            next=null;
        }
        Estate data;
        Node prev;
        Node next;
    }

    Node first;
    Node last;

    @Override
    public void add(Estate o) {
        if(first==null){
            first = last = new Node(o);
        }
        else {
            Node CurrentNode = last;
            last = new Node (o);
            last.prev = CurrentNode;
            CurrentNode.next = last;
        }
    }

    @Override
    public void clear() {
        if (first != null) {
            Node deleted = last;
            while (deleted != first) {
                last = deleted.prev;
                deleted.prev = null;
                deleted.data = null;
                last.next = null;
                deleted = last;
            }
            first = null;
        }
    }

    @Override
    public String toString() {
        Node Current = first;
        String list ="";
        if(Current!=null) {
            while (Current!= null) {
              list += Current.data.toString();
              Current=Current.next;
            }
        }
        else list = "empty";
        return list;
    }

    @Override
    public boolean remove(Estate o) {
        boolean flag = false;
        if(first!=null){
            Node Current = first;
            while(Current!=null){
                if(Current.data.equals(o)){
                    flag = true;
                    if(Current==first&&Current==last){
                        first = last = null;
                        break;
                    }
                    else if(Current==first){
                        (Current.next).prev = null;
                        first = (Current.next);
                    }
                    else if(Current==last){
                        (Current.prev).next=null;
                        last = (Current.prev);
                    }
                    else {
                        (Current.prev).next=Current.next;
                        (Current.next).prev=Current.prev;
                    }
                }

                Current = Current.next;
            }
        }
        return flag;
    }

    @Override
    public boolean remove(int i) {
        boolean flag = false;
        if(first!=null&&i<size()){
            flag=true;
            Node Current = first;
            int cur_pos = 0;
            while(cur_pos!=i) {
                cur_pos++;
                Current = Current.next;
            }
                    if(Current==first&&Current==last){
                        first = last = null;
                    }
                    else if(Current==first){
                        (Current.next).prev = null;
                        first = (Current.next);
                    }
                    else if(Current==last){
                        (Current.prev).next=null;
                        last = (Current.prev);
                    }
                    else {
                        (Current.prev).next=Current.next;
                        (Current.next).prev=Current.prev;
                    }
                }
        return flag;
        }

    @Override
    public int size() {
        Node Current = first;
        int size = 0;
        while(Current!=null){
            size++;
            Current=Current.next;
        }
        return size;
    }

    @Override
    public Object[] toArray() {
        Estate []array = new Estate[size()];
        Node Current = first;
        int i = 0;
        while(Current!=null){
            array[i]=Current.data;
            Current=Current.next;
            i++;
        }
        return array;
    }

    @Override
    public boolean contains(Estate o) {
        boolean cont = false;
        if (first != null) {
            Node Current = first;
            while (Current!=null){
                if(Current.data.equals(o)) {
                    cont = true;
                    break;
                }
                Current=Current.next;
            }
        }
        return cont;
    }

    @Override
    public boolean add(Estate o, Estate added) {
        boolean flag = false;
        if(first!=null){
            Node current = first;
            while(current!=null){
                if(o.equals(current.data)){
                    Node add = new Node(added);
                    add.next = (current.next);
                    add.prev = current;
                    current.next = add;
                    flag = true;
                    break;
                }
                current=current.next;
            }
        }
        return flag;
    }

    @Override
    public Iterator<Estate> iterator() {
        return new IteratorImpl();
    }
}