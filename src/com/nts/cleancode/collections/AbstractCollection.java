package com.nts.cleancode.collections;

public abstract class AbstractCollection {

    private static int INITIAL_CAPACITY = 10;
    protected Object[] elements = new Object[INITIAL_CAPACITY];
    protected int size = 0;
    protected boolean readOnly;

    public boolean isEmpty() {
        return size == 0;
    }
	public abstract void add(Object element);
	public abstract boolean remove(Object element);
	public abstract boolean contains(Object element);

    public int size() {
        return size;
    }

	public void addAll(AbstractCollection c) {
		if (c instanceof Set) {
			Set s = (Set)c;
			for (int i=0; i < s.size(); i++) {
				if (!contains(s.getElementAt(i))) {
					add(s.getElementAt(i));
				}
			}
			
		} else if (c instanceof List) {
			List l = (List)c;
			for (int i=0; i < l.size(); i++) {
				if (!contains(l.get(i))) {
					add(l.get(i));
				}
			}
		}
	}

}
