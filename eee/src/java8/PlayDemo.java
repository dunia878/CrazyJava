package java8;

import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static java.lang.System.out;

public class PlayDemo {

	public static void main(String[] args) {
		List<Player> players = Arrays.asList(new Player("justin",20), new Player("geng",33));
		players.stream()
		.filter(player -> player.getAge()>2)
		.map(Player::getName)
		.map(String::toUpperCase)
		.collect(java.util.stream.Collectors.toList())
		.forEach(System.out::println);
		Date date1 = new Date();
		System.out.println(date1);
		out.println(date1.getTime());
	}

}
