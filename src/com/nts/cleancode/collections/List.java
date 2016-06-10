package com.nts.cleancode.collections;

public class List extends AbstractCollection {

    public void add(Object element) {
        if (readOnly)
            return;

        if (shouldGrow())
            grow();

        addElement(element);

    }

    protected void addElement(Object element) {
        elements[size++] = element;
    }

    protected void grow() {
        Object[] newElements =
                new Object[elements.length + 10];
        for (int i = 0; i < size; i++)
            newElements[i] = getElementAt(i);
        elements = newElements;
    }

    protected boolean shouldGrow() {
        return size + 1 > elements.length;
    }

    public boolean contains(Object element) {
        for (int i = 0; i < size; i++)
            if (getElementAt(i).equals(element))
                return true;
        return false;
    }

    public boolean remove(Object element) {
        if (readOnly)
            return false;
        else
            for (int i = 0; i < size; i++)
                if (getElementAt(i).equals(element)) {
                    elements[i] = null;
                    Object[] newElements = new Object[size - 1];
                    int k = 0;
                    for (int j = 0; j < size; j++) {
                        if (getElementAt(j) != null)
                            newElements[k++] = getElementAt(j);
                    }
                    size--;
                    elements = newElements;
                    return true;
                }
        return false;
    }

    public int capacity() {
        return elements.length;
    }

    public void set(int i, Object value) {
        if (!readOnly) {
            if (i >= size)
                throw new ArrayIndexOutOfBoundsException();
            elements[i] = value;
        }
    }

    public void setReadOnly(boolean b) {
        readOnly = b;
    }


}
