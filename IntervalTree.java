package Test;

import java.util.ArrayList;
import java.util.List;

class Interval {
    int start, end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "[" + start + ", " + end + "]";
    }
}

class IntervalNode {
    Interval interval;
    int maxEnd;
    IntervalNode left, right;

    IntervalNode(Interval interval) {
        this.interval = interval;
        this.maxEnd = interval.end;
        this.left = this.right = null;
    }
}

class IntervalTree {
    private IntervalNode root;

    public void insertInterval(int start, int end) {
        Interval newInterval = new Interval(start, end);
        root = insert(root, newInterval);
    }

    private IntervalNode insert(IntervalNode node, Interval interval) {
        if (node == null) {
            return new IntervalNode(interval);
        }

        int l = node.interval.start;

        if (interval.start < l) {
            node.left = insert(node.left, interval);
        } else {
            node.right = insert(node.right, interval);
        }

        if (node.maxEnd < interval.end) {
            node.maxEnd = interval.end;
        }

        return node;
    }

    public void deleteInterval(int start, int end) {
        Interval interval = new Interval(start, end);
        root = delete(root, interval);
    }

    private IntervalNode delete(IntervalNode node, Interval interval) {
        if (node == null) {
            return null;
        }

        if (interval.start < node.interval.start) {
            node.left = delete(node.left, interval);
        } else if (interval.start > node.interval.start) {
            node.right = delete(node.right, interval);
        } else if (interval.end == node.interval.end) {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            IntervalNode minNode = findMin(node.right);
            node.interval = minNode.interval;
            node.right = delete(node.right, minNode.interval);
        }

        node.maxEnd = Math.max(node.interval.end, Math.max(maxEnd(node.left), maxEnd(node.right)));
        return node;
    }

    private IntervalNode findMin(IntervalNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    private int maxEnd(IntervalNode node) {
        return (node == null) ? Integer.MIN_VALUE : node.maxEnd;
    }

    public List<Interval> findOverlappingIntervals(int start, int end) {
        List<Interval> result = new ArrayList<>();
        findOverlapping(root, new Interval(start, end), result);
        return result;
    }

    private void findOverlapping(IntervalNode node, Interval interval, List<Interval> result) {
        if (node == null) {
            return;
        }

        if (isOverlapping(node.interval, interval)) {
            result.add(node.interval);
        }

        if (node.left != null && node.left.maxEnd >= interval.start) {
            findOverlapping(node.left, interval, result);
        }

        findOverlapping(node.right, interval, result);
    }

    private boolean isOverlapping(Interval i1, Interval i2) {
        return i1.start <= i2.end && i2.start <= i1.end;
    }

    public static void main(String[] args) {
        IntervalTree tree = new IntervalTree();
        tree.insertInterval(15, 20);
        tree.insertInterval(10, 30);
        tree.insertInterval(17, 19);
        tree.insertInterval(5, 20);
        tree.insertInterval(12, 15);
        tree.insertInterval(30, 40);

        System.out.println("Overlapping intervals with [14, 16]: " + tree.findOverlappingIntervals(14, 16));
        tree.deleteInterval(10, 30);
        System.out.println("After deleting [10, 30], overlapping intervals with [14, 16]: " + tree.findOverlappingIntervals(14, 16));
    }
}

