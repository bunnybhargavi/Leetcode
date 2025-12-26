class SnapshotArray {
    TreeMap<Integer, Integer>[] map;
    int snap_id = 0;
    public SnapshotArray(int length) {
        map = new TreeMap[length];
        for (int i = 0; i < length; i++) {
            map[i] = new TreeMap<Integer, Integer>();
            map[i].put(0, 0);
        }
    }

    public void set(int index, int val) {
        map[index].put(snap_id, val);
    }

    public int snap() {
        return snap_id++;
    }

    public int get(int index, int snap_id) {
        int key = map[index].floorKey(snap_id);
        return map[index].get(key);
    }
}
