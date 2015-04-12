package cow.farm;


public class Cow {
		final String race;
		private float weight;
		private String color;
		final String name;		
		
	public Cow(String race, String name) {
		this.race = race;
		this.name = name;
	}
	
	public String getRace(){
		return race;
	}
	public String toString(){
		return race;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}
	
}
