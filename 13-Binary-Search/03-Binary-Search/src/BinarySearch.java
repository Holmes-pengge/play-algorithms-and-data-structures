public class BinarySearch {

    private BinarySearch(){}

    // 非递归实现二分查找法
    public static <E extends Comparable<E>> int search(E[] data, E target){

        int l = 0, r = data.length - 1;

        // 在 data[l, r] 的范围中查找 target
        while(l <= r){

            int mid = l + (r - l) / 2;

            if(data[mid].compareTo(target) == 0)
                return mid;

            if(data[mid].compareTo(target) < 0)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return -1;
    }

    // 递归实现二分查找法
    public static <E extends Comparable<E>> int searchR(E[] data, E target){

        return searchR(data, 0, data.length - 1, target);
    }

    private static <E extends Comparable<E>> int searchR(E[] data, int l, int r, E target){

        if(l > r) return -1;

        int mid = l + (r - l) / 2;

        if(data[mid].compareTo(target) == 0)
            return mid;

        if(data[mid].compareTo(target) < 0)
            return searchR(data, mid + 1, r, target);

        return searchR(data, l, mid - 1, target);
    }
}
