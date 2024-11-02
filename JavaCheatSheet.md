Sort an ArrayList in reverse order. O(NlogN). java.util.Collections; Can also sort queues, linkedlists etc<br> 
```java 
Collections.sort(arraylist, Collections.reverseOrder()); 
``` 

Using custom comparator in Collections.sort()
```java
class Sortbyroll implements Comparator<Student> {
    public int compare(Student a, Student b) {
        return a.rollno - b.rollno;
    }
}
```

Convert array to string. O(). java.util.Arrays;<br>
```java 
Arrays.toString(arr[]);
```

Max Integer or Double. O(). java.util.Arrays;<br>
```java 
Double.NEGATIVE_INFINITY;
//You should use double max = Double.NEGATIVE_INFINITY;
// instead of double max = Double.MIN_VALUE; As MIN_VALUE for double is positive
Integer.MAX_VALUE;
```



PriorityQueue = MinHeap in Java
```java
PriorityQueue<Integer> pQueue
            = new PriorityQueue<Integer>();
//Create maxHeap
PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
pQueue.add(10);
pQueue.add(30);
queue.addAll(Arrays.asList(arr[]));
pQueue.peek();
pQueue.remove(30);

        Iterator itr = pQueue.iterator();

// Iterating till there is single element left in
// object using next() method
while (itr.hasNext())
System.out.println(itr.next());

// Removing the top priority element (or head)
pQueue.poll();

// Check if an element is present using contains()
boolean b = pQueue.contains(20);

Object[] arr = pQueue.toArray();
// Convert PriorityQueue to a List 
List<Integer> list = new ArrayList<>(priorityQueue);
// Convert PriorityQueue to a Set 
Set<Integer> set = new HashSet<>(priorityQueue);

//PriorityQueue for a 2d array with custom comparator:
int[][] intervals = new int[][]{new int[]{0, 30},new int[]{5, 10},new int[]{15, 20}};
PriorityQueue<int[]> heap = 
        new PriorityQueue(intervals.length, (a, b) -> ((int[])a)[1] - ((int[])b)[1]);
//TODO: this above line is incomplete, please tryout and complete the process of priorityqueue with 2d array
//TODO: find the time complexities of each of these methods
```


Find maximum element in arrayList . O(). java.util.Collections;<br>
```java 
List<X> list = new ArrayList<>();
Collections.max(list);
//similarly to find summation:
Arrays.stream(arr).sum();
```

Find maximum element in primitive array . O(). java.util.Arrays;<br>
```java 
int min = Arrays.stream(tab).min().getAsInt();
int minLong = Arrays.stream(tabLong).min().getAsLong();
```

Creating array of boolean with initial value as false
```java
List<Boolean> list=new ArrayList<Boolean>(Arrays.asList(new Boolean[10]));
Collections.fill(list, Boolean.TRUE);
//better to use primitive type array
boolean[] list = new boolean[1000];
```


List of Errors Faced
1) ./GFG.java:53: error: no suitable constructor found for ArrayList(long)
   ArrayList<Boolean> a2Map = new ArrayList<Boolean>(m);
2) 

