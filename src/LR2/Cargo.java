package LR2;


/**
 * ����� �����
 * 
 * @author      ������� ������� <korn9509@gmail.com>
 * @version     1.0                 
 * @since       1.0          
 */
public class Cargo {
	
	/**
	 * �������� ������������� �����.
	 *          
	 */
	private int id;
	/**
	 * ��� ����� � �����������, �� �������� ������� ����� �������� � ���������.
	 *          
	 */
	private int weight;

	/**
	 * ����������� �����
	 * @param  id ������������� �����
	 * @param weight ��� ����� � �����������         
	 */
	public Cargo(int id, int weight) {
		this.setId(id);
		this.setWeight(weight);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
}
