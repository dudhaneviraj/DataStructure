import java.util.PriorityQueue;

public class FindMedian {

	PriorityQueue<Integer> queue = new PriorityQueue<>((x,y)->x-y);

	// Adds a number into the data structure.
	public void addNum(int num) {
		queue.add(num);
	}

	// Returns the median of current data stream
	public double findMedian() {
		PriorityQueue<Integer> queue = new PriorityQueue<>(this.queue);
		int n = queue.size();
		if (n > 2)
			while (queue.size() != (n / 2)+1)
				queue.remove();
		if (n % 2 == 0 && n >= 2)
			return (double) (queue.remove() + queue.remove()) / 2;
		else
			return (double) (queue.remove());

	}

	public static void main(String[] args) {

		FindMedian a = new FindMedian();

		a.addNum(1);
		a.addNum(2);
		System.out.println(a.findMedian());
		a.addNum(3);
		System.out.println(a.queue.size());
		System.out.println(a.findMedian());
	}
}
