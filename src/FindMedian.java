import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedian {
	Comparator<Integer> comparator = new Comparator<Integer>() {
		@Override
		public int compare(Integer x, Integer y) {
			if (x < y) {
				return -1;
			} else if (x > y) {
				return 1;
			}
			return 0;
		}
	};

	PriorityQueue<Integer> queue = new PriorityQueue<>(comparator);

	// Adds a number into the data structure.
	public void addNum(int num) {
		queue.add(num);
	}

	// Returns the median of current data stream
	public double findMedian() {
		PriorityQueue<Integer> queue = new PriorityQueue<>(this.queue);
		int n = queue.size();
		if (n > 2)
			while (queue.size() != n / 2)
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
