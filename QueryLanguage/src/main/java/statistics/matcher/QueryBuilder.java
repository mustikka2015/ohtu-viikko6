/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;

import java.util.ArrayList;
import statistics.Player;

/**
 *
 * @author Iisa
 */
public class QueryBuilder {

    private ArrayList<Matcher> matchers;

    public QueryBuilder() {
        this.matchers = new ArrayList<Matcher>();
    }

    public void hasAtLeast(int value, String category) {
        this.matchers.add(new HasAtLeast(value, category));
    }

    public void hasFewerThan(int value, String category) {
        this.matchers.add(new HasFewerThan(value, category));
    }

    public void playsIn(String team) {
        this.matchers.add(new PlaysIn(team));
    }

    public Matcher build() {
        Matcher[] and = new Matcher[this.matchers.size()];
        for (int i = 0; i < this.matchers.size(); i++) {
            and[i] = this.matchers.get(i);
        }
        this.matchers = new ArrayList<Matcher>();
        return new And(and);
    }

    public Matcher oneOf(Matcher m1, Matcher m2) {
        And[] and = new And[2];
        and[0] = (And) m1;
        and[1] = (And) m2;

        this.matchers = new ArrayList<Matcher>();
        return new Or(and);
    }

}
