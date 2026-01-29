<%@tag import="java.util.Random"%>
<%@tag import="java.util.HashSet"%>
<%
	HashSet<Integer> lottery = new HashSet<>();
	while (lottery.size() < 6) lottery.add(new Random().nextInt(49)+1);
	out.print(lottery);
%><br />