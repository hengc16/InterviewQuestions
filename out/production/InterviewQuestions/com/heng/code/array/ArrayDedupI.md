##Array Deduplication
###Description:
Given a sorted integer array, remove duplicate elements. For each group of elements with the same value keep only one of them. 
Do this in-place, using the left side of the original array and maintain the relative order of the elements of the array.
Return the array after deduplication.

 Assumptions
 The array is not null Examples {1, 2, 2, 3, 3, 3} → {1, 2, 3}
 
###理解：
给一个排好序的数组，消除里面重复元素，对于重复元素只保留一个。元素相对顺序不变，要求in place 完成。

能想到的就是2个挡板三个区间的做法。

假设我们有数组 ：

```
[ 1 , 2 , 2, 3, 3, 3]
      s  
      f    
```
指针s和f的物理意义： f指针用来记录当前位置， s用来记录返回区间的位置。

[0, s) 从index 0 到 s 不包括s的位置为需要返回的区间， 里面的元素时处理好的元素。

[s, f] 为已经探索的区间

(f, n - 1] 为未知探索区域

代码层要严格符合物理意义，每次判断当前元素是否符合条件，需要加入还是挪动s指针就可以了。

##解法一

s指针的物理意义: all elements to the left side of s are the processed elements. (not including s).
f指针的物理意义: current index we iterate so far, all elements to the right side of f have not been seen yet. 

```java
public int[] dedupI(int[] input) {
    if(input == null || input.length == 0) {
        return input;
    }
    int s = 1; 
    for(int f = 1; f < input.length; f++ ) {
        if(input[f] != input[s - 1]) {
            input[s++] = input[f];
        }   
    }  
    return Arrays.copyOf(input, s); 
}
```

每次拿f和返回区间最后一个元素左对比， 如果相同则继续， 如果不同，说明找到了下一个元素，把他加入返回区间，s指针往后挪一步。

##解法二
s指针的物理意义: all element to the left side including s are the final result to output.
f指针的物理意义: the index we iterated so far, all the elements to the right side of f are unexplored yet. 

```java
public int[] dedupI(int[] input) {
    if(input == null || input.length == 0) {
        return input;    
    }
    int s = 0;
    for (int f = 1; f < input.length; f++) {
        if(input[f] != input[s]) {
            input[++s] = input[f];
        }
    }
    return Arrays.copyOf(input, s + 1);
}
```
根据物理意义， s为返回值得最后一个元素， 和f做对比，如果相同则继续搜索，如果不同，要先挪动s，再将f的值放入s这里。
最后返回的时候要注意s是inclusive的， 所以要返回s + 1. 因为Arrays.copy(int[], index), 这里的index是exclusive的。