package LR2;


/**
 * Класс груза
 * 
 * @author      Киселев Николай <korn9509@gmail.com>
 * @version     1.0                 
 * @since       1.0          
 */
public class Cargo {
	
	/**
	 * Числовой идентификатор груза.
	 *          
	 */
	private int id;
	/**
	 * Вес груза в килограммах, от которого зависит время погрузки и разгрузки.
	 *          
	 */
	private int weight;

	/**
	 * Конструктор груза
	 * @param  id Идентификатор груза
	 * @param weight Вес груза в килограммах         
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
