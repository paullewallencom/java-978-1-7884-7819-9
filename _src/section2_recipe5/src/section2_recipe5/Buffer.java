package section2_recipe5;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {
	
	private final LinkedList<String> buffer;
	
	private final int maxSize;
	
	private final ReentrantLock lock;
	
	private final Condition lines;
	private final Condition space;
	
	private boolean pendingLines;
	
	public Buffer(int maxSize) {
		this.maxSize = maxSize;
		buffer = new LinkedList<>();
		lock = new ReentrantLock();
		lines = lock.newCondition();
		space = lock.newCondition();
		pendingLines = true;
	}
	
	public void insert(String line) {
		lock.lock();
		try {
			while (buffer.size() == maxSize) {
				space.await();
			}
			buffer.offer(line);
			System.out.printf("%s: Inserted Line: %d\n", Thread.currentThread().getName(), buffer.size());
			lines.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public String get() {
		String line = null;
		lock.lock();
		try {
			while ((buffer.size() == 0) && (hasPendingLines())) {
				lines.await();
			}

			if (hasPendingLines()) {
				line = buffer.poll();
				System.out.printf("%s: Line Readed: %d\n", Thread.currentThread().getName(), buffer.size());
				space.signalAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
		return line;
	}
	
	/**
	 * Establish the value of the variable
	 * 
	 * @param pendingLines
	 */
	public synchronized void setPendingLines(boolean pendingLines) {
		this.pendingLines = pendingLines;
	}

	/**
	 * Returns the value of the variable
	 * 
	 * @return the value of the variable
	 */
	public synchronized boolean hasPendingLines() {
		return pendingLines || buffer.size() > 0;
	}


	

	
	
}
