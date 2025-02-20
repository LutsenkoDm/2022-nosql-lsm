package ru.mail.polis.glebkomissarov;

import jdk.incubator.foreign.MemorySegment;
import ru.mail.polis.BaseEntry;

import java.util.Iterator;

public class PeekIterator implements Iterator<BaseEntry<MemorySegment>> {

    private final long priority;

    private BaseEntry<MemorySegment> current;
    private final Iterator<BaseEntry<MemorySegment>> iterator;

    public PeekIterator(Iterator<BaseEntry<MemorySegment>> iterator, long priority) {
        this.priority = priority;
        this.iterator = iterator;
    }

    @Override
    public boolean hasNext() {
        return current != null || iterator.hasNext();
    }

    @Override
    public BaseEntry<MemorySegment> next() {
        BaseEntry<MemorySegment> next = peek();
        current = null;
        return next;
    }

    public BaseEntry<MemorySegment> peek() {
        if (current == null) {
            current = iterator.next();
        }
        return current;
    }

    public long getPriority() {
        return priority;
    }
}
