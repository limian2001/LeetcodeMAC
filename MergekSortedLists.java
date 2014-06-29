import java.util.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergekSortedLists {
	public ListNode mergeKLists(List<ListNode> lists) {
		PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(10,new Comparator<ListNode>(){
			//override
			public int compare(ListNode l1,ListNode l2){
			return l1.val - l2.val;
			}
		});
		for(ListNode p:lists)
			if(p != null)
				heap.offer(p);
		ListNode head = null;
		ListNode point = head;
		while(heap.size() > 0){
			ListNode cur = heap.poll();
			if(head == null){
				head = cur;
				point = cur;
			
			}
			else{
				point.next = cur;
				point = point.next;
				
			}
			if(cur.next != null)
				heap.offer(cur.next);
		
		}
	
		return head;
	
	}
	
	public static void main(String args[]){
		List<ListNode> lists = new LinkedList<ListNode>();
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(0);
		lists.add(a);
		lists.add(b);
		mergeKLists(lists);
	}
}
