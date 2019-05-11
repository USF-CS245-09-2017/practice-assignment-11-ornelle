package src;

public class HashNode <k,v>{
	k key;
	v value;
	//boolean deleted;
	private HashNode <k,v> next;
	public HashNode (k key, v value){
		this.key = key;
		this.value = value;
		next = null;
	}
	public void setKey(k key){
		this.key=key;
	}
	public k getKey(){
		return this.key;
	}
	public void setNext(HashNode next){
		this.next = next;
	}
	public HashNode <k,v> getNext(){
		return this.next;
	}
	public void setValue(v value){
		this.value = value;
	}
	public v getValue(){
		return this.value;
	}																		
}