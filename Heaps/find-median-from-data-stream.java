
//https://leetcode.com/problems/find-median-from-data-stream/

class MedianFinder {

    PriorityQueue<Integer> pqMin; // right
    PriorityQueue<Integer> pqMax; // left
    double median;

    public MedianFinder() {
        pqMin = new PriorityQueue<>();
        pqMax = new PriorityQueue<>(Collections.reverseOrder());
        median = 0;
    }
    
    public void addNum(int num) {
        if(pqMin.size() == 0 && pqMax.size() == 0)
        {
            if(num < 0)
            {
                median = Double.MIN_VALUE;
            }
            else
            {
                median = Double.MAX_VALUE;
            }
        }

        if(num < median)
        {
            pqMax.add(num);
        }
        else
        {
            pqMin.add(num);
        }

        if(pqMax.size() - pqMin.size() > 1)
        {
            int val = pqMax.poll();
            pqMin.add(val);
        }

         if(pqMin.size() - pqMax.size() > 1)
        {
            int val = pqMin.poll();
            pqMax.add(val);
        }


        if(pqMax.size() == pqMin.size())
        {
            double a =0, b =0;
            if(pqMax.peek() != null)
            {
                a = pqMax.peek();
            }
            if(pqMin.peek() != null)
            {
                b = pqMin.peek();
            }
            median = (a+b)/2;
        }
        else if(pqMax.size() < pqMin.size())
        {
            if(pqMin.peek() != null)
            {
            median = pqMin.peek();
            }
        }
        else if(pqMax.size() > pqMin.size())
        {
            if(pqMax.peek() != null)
            {
            median = pqMax.peek();
            }
        }        
       
    }
    
    public double findMedian() {
        return median;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */