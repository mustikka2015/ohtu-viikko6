package statistics;

import statistics.matcher.*;

public class Main {

    public static void main(String[] args) {
        Statistics stats = new Statistics(new PlayerReaderImpl("http://nhlstats-2013-14.herokuapp.com/players.txt"));

//        Matcher m = new Or( new HasFewerThan(10, "goals"),
//                             new HasFewerThan(10, "assists"),
//                             new PlaysIn("PHI")
//        );
//         Matcher m = new Not(new PlaysIn("PHI"));
//        
//        for (Player player : stats.matches(m)) {
//            System.out.println( player );
//        }
        QueryBuilder query = new QueryBuilder();

//        query.playsIn("NYR");
//        query.hasAtLeast(10, "goals");
//        query.hasFewerThan(25, "assists");
//        Matcher m = query.build(); 
        query.playsIn("PHI");
        query.hasAtLeast(10, "goals");
        query.hasFewerThan(20, "assists");
        Matcher m1 = query.build();

        query.playsIn("EDM");
        query.hasAtLeast(60, "points");

        Matcher m2 = query.build();

        Matcher m = query.oneOf(m1, m2);

        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }
    }
}
