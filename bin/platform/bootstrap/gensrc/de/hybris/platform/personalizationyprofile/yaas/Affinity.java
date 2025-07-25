/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN!
 * --- Generated at Jun 4, 2025, 12:41:24 PM
 * ----------------------------------------------------------------
 */

package de.hybris.platform.personalizationyprofile.yaas;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.LinkedHashMap;
import java.util.Map;

import java.math.BigDecimal;

/**
 * @deprecated Deprecated because Profile structure has changed
 */
@Deprecated

public class Affinity extends LinkedHashMap<String, Object> implements Map<String, Object> {

	public static class AffinityBuilder extends LinkedHashMap<String, Object> {

		public AffinityBuilder withScore(final BigDecimal score) {
			this.put("score", score);
			return this;
		}

		public AffinityBuilder withRecentViewCount(final Integer recentViewCount) {
			this.put("recentViewCount", recentViewCount);
			return this;
		}

		public AffinityBuilder withRecentScore(final BigDecimal recentScore) {
			this.put("recentScore", recentScore);
			return this;
		}
		public Affinity build() {
			final Affinity dto = new Affinity();
			dto.putAll(this);
			return dto;
		}
	}

	/** Default serialVersionUID value. */
 	private static final long serialVersionUID = 1L;

    @JsonCreator
	public Affinity(@JsonProperty("score") final BigDecimal score, @JsonProperty("recentViewCount") final Integer recentViewCount, @JsonProperty("recentScore") final BigDecimal recentScore)
	{
		this.put("score", score);
		this.put("recentViewCount", recentViewCount);
		this.put("recentScore", recentScore);
	}

	public Affinity()
	{
		// default constructor
	}


	/** <i>Generated property</i> for <code>Affinity.score</code> property defined at extension <code>personalizationyprofile</code>. */
	public void setScore(final BigDecimal score)
	{
		this.put("score", score);
	}

	public BigDecimal getScore()
	{
	 	return (BigDecimal)this.get("score");
	}

	/** <i>Generated property</i> for <code>Affinity.recentViewCount</code> property defined at extension <code>personalizationyprofile</code>. */
	public void setRecentViewCount(final Integer recentViewCount)
	{
		this.put("recentViewCount", recentViewCount);
	}

	public Integer getRecentViewCount()
	{
	 	return (Integer)this.get("recentViewCount");
	}

	/** <i>Generated property</i> for <code>Affinity.recentScore</code> property defined at extension <code>personalizationyprofile</code>. */
	public void setRecentScore(final BigDecimal recentScore)
	{
		this.put("recentScore", recentScore);
	}

	public BigDecimal getRecentScore()
	{
	 	return (BigDecimal)this.get("recentScore");
	}

}
