package de.hybris.platform.persistence.flexiblesearch;

import static org.assertj.core.api.Assertions.assertThat;

import de.hybris.bootstrap.annotations.UnitTest;

import java.util.List;

import org.junit.Test;

/**
 * Unit test for the SelectClause
 */
@UnitTest
public class SelectClauseTest
{
	private static final List<String> AGGREGATE_QUERIES = List.of(
			"SELECT COUNT(*)",
			"SELECT MIN(column)",
			"SELECT MAX(column)",
			"SELECT AVG(column)",
			"SELECT SUM(column)"
	);
	private static final List<String> AGGREGATE_QUERIES_WITH_ADDITIONAL_SPACES = List.of(
			"SELECT     COUNT(*)",
			"SELECT   MIN(column)",
			"SELECT            MAX(column)",
			"SELECT       AVG(column)",
			"SELECT  SUM(column)"
	);
	private static final List<String> AGGREGATE_QUERIES_WITH_MIXED_CASE = List.of(
			"SELECT count(*)",
			"SELECT MiN(column)",
			"SELECT MAx(column)",
			"SELECT avg(column)",
			"SELECT SUM(column)"
	);

	private static final List<String> NON_AGGREGATE_QUERIES = List.of(
			"SELECT foo, bar FROM (SELECT baz FROM moo ORDER BY pk, moo ASC) AS z WHERE z.foo=?foo [--ORDER BY bar, baz DESC--]",
			"SELECT foo as count FROM (SELECT baz FROM moo ORDER BY pk, moo ASC) AS z WHERE z.foo=?foo ORDER BY bar, baz DESC");

	@Test
	public void checkAllAggregateQueries() {
		checkQueries(AGGREGATE_QUERIES, true);
	}
	@Test
	public void checkAllAggregateQueriesWithAdditionalSpaces() {
		checkQueries(AGGREGATE_QUERIES_WITH_ADDITIONAL_SPACES, true);
	}
	@Test
	public void checkAllAggregateQueriesWithMixedCase() {
		checkQueries(AGGREGATE_QUERIES_WITH_MIXED_CASE, true);
	}
	@Test
	public void testDoesNotContainAggregation() {
		checkQueries(NON_AGGREGATE_QUERIES, false);
	}

	private void checkQueries(final List<String> queries, final boolean expectedAssertion)
	{
		SelectClause selectClause;
		for (String query : queries) {
			selectClause = new SelectClause(query, null);
			assertThat(selectClause.containsAggregation()).isEqualTo(expectedAssertion);
		}
	}
}
