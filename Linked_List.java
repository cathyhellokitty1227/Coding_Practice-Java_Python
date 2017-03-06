//Q5: Sum Lists
LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2, int carry){
	if(l1==null && l2 == null && carry ==0){
		return null;
	}
     
    LinkedListNode result = new Linkedlist();
	//If node is not empty
	int val = carry;
	if (l1!=null){val+=l1.data;}
	if (l2!=null){val+=l2.data;}

	result.data = val % 10;
	carry = val / 10;
	if(l1 != null || l2 != null){
		LinkedListNode more = addLists(l1==null ? null:l1.next,
			l2 == null ? null:l2.next,
			carry);
     result.setNext(more);
     }
     return result;
}

//Now the digits are stored in a forward order
//Create a new class which store the partial sum and carry;
class PartialSum {
	public LinkedListNode sum = null;
	public int carry = 0;
}

LinkedListNode addLists_new(LinkedListNode l1, LinkedListNode l2){
	int len1 = length(l1);
	int len2 = length(l2);

	if(len1<len2){
		l1 = padList(l1,len2-len1);
	}
	else{
		l2 = padList(l2,len1-len2);
	}

	PartialSum sum = addListshelper(LinkedListNode l1, LinkedListNode l2);

    if(sum.carry==0){
    	return sum.sum;
    }else{
    	LinkedListNode result = insertBefore(sum.sum,sum.carry);
    	return result;
    }


PartialSum addListhelper(LinkedListNode l1, LinkedListNode l2){
     if(l1==null && l2 ==null){
     	PartialSum result = new PartialSum();
     	return result;
     }
      
     PartialSum result = addListhelper(l1.next,l2.next); 

     int val = l1.data+l2.data + result.carry;

     LinkedListNode full_result = insertBefore(result.sum, val%10);

     result.sum = full_result;
     result.carry = val/10;
     return result;

}
LinkedListNode padList(LinkedListNode l,int len){
	LinkedListNode head = l;
	for(int i = 0;i<len;i++){
		 head = insertBefore(head,0);
	}
	return head;
}

//Helper function insertBefore(LinkedListNode l, int data)
LinkedListNode insertBefore(LinkedListNode l, int data){
	LinkedListNode temp = new LinkedListNode(data);
	if (l!=null){
	temp.next = l;
    }
    return temp;
}

//Q7: LinkedList Intersection


//Q8: Loop Detection
//Assume we have a class LinkedListNode given, now we need to find the loop
//First we need to check if the loop exists. 
LinkedListNode Find_loop(LinkedListNode head){
	LinkedListNode slow = head;
	LinkedListNode fast = head;

//Finding the collision point.
while(fast !=null && fast.next !=null){
	slow = slow.next;
	fast = fast.next.next;
	if(slow == fast){
		break;
	}
}
//Checking if there is no loop at all, if there is no loop, return null.
if (fast == null || fast.next == null){
	return null;
}

//After we find the collision points, reset slow to be head again.
slow = head;
while(slow != fast){
	slow = slow.next;
	fast = fast.next;
}
return slow;
}


Given a 2D matrix M, filled with either 0s or 1s, count the number of islands of 1s in M.
An island is a group of adjacent values that are all 1s. Every cell in M can be adjacent to the 4 cells that are next to it on the same row or column.


