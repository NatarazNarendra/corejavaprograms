import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Firstnonrepeated {

	public static void main(
			String[] args) {
	 String str ="swiss";
	  
	 Map<Object, Long> result=Arrays.stream(str.split("")).collect(Collectors.groupingBy
			 (p->p,Collectors.counting()));
	 
Optional<Object>	non= Optional.of(result.entrySet().stream().filter(p->p.getValue() == 1l).map(p->p.getKey()).findFirst().get());
	 
	 System.out.println(result);
	 System.out.println(non);
	}

}
