package src;

import src.HashNode;

import java.util.ArrayList;
//import java.util.math;

public class Hashtable <k, v>{
	private ArrayList<HashNode<k, v>> slots;
	private int size;
	private double LAMDA = 0.6;

	public Hashtable(){
		//size = 0;
		slots = new ArrayList(300000);

		for(int i=0; i< 10; i++)
			slots.add(null);
	}
	public boolean containsKey(k key){
		int slot = getSlot(key);
		HashNode node = slots.get(slot);
		while(node != null && node.getKey()!=key)
			node.getNext();
		if(node == null)
			return false;
		return true;
	}
	public int getSlot(k key){
		int slot = Math.abs(key.hashCode() % slots.size());
		return slot;
	}

	public Object get(k key){
		int slot = getSlot(key);
		HashNode node = slots.get(slot);
		while(node != null && node.getKey()!=key)
			node = node.getNext();
		if(node == null)
			return null;
		return node.getValue();
	}
	public void put(k key, v value){
		int slot = getSlot(key);
		HashNode node = slots.get(slot);
		HashNode newNode = new HashNode(key, value);
		newNode.setNext(node);
		slots.set(slot, newNode); //set item at this index

		size++;
	}
	public String remove (k key){
		int slot = getSlot(key);

		HashNode head = slots.get(slot);
		HashNode prev = null;
		while (head != null){

			if(head.getKey().equals(key))
				break;

			prev= head;
			head.getNext();
		}
			if(head==null)
				return null;
			size--;

			if(prev != null)
				head.getNext();
			else 
				slots.set(slot, head.getNext());
			return head.getValue().toString();
	}
}