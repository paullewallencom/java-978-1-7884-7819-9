package section2_recipe5;

public class FileMock {
	
	private String[] content;
	private int index;
	
	/**
	 * Constructor of the class. Generate the random data of the file
	 * 
	 * @param size:
	 *            Number of lines in the simulate file
	 * @param length:
	 *            Length of the lines
	 */
	public FileMock(int size, int length) {
		content = new String[size];
		for (int i = 0; i < size; i++) {
			StringBuilder buffer = new StringBuilder(length);
			for (int j = 0; j < length; j++) {
				int randomCharacter = (int) Math.random() * 255;
				buffer.append((char) randomCharacter);
			}
			content[i] = buffer.toString();
		}
		index = 0;
	}
	
	public boolean hasMoreLines(){
		return index < content.length;
	}
	
	public String getLine() {
		if (this.hasMoreLines()) {
			System.out.println("Mock: " + (content.length - index));
			return content[index++];
		}
		return null;
	}

}
