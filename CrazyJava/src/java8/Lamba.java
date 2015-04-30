package java8;

import java.util.HashMap;
import java.util.Optional;

import java.util.Map;

public class Lamba {

	static Optional<String> getNickName(String name){
		Map<String, String> nickNames = new HashMap<>();
		nickNames.put("Justin", "caterpillar");
		String nickName = nickNames.get(name);
//		return nickName == null? Optional.empty(): Optional.of(nickName);
		return Optional.ofNullable(nickName);
	}
	public static void main(String[] args) {
		System.out.println(Lamba.getNickName("Justin"));
	}

}
