package cow.farm;


public interface Function {
	<T,K> K transform (T input);
	
}