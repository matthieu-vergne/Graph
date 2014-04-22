package fr.vergne.graph.impl;

import java.util.Arrays;

import fr.vergne.graph.Edge;

public class ImmutableEdge<CVertex> extends ImmutableHyperedge<CVertex>
		implements Edge<CVertex> {

	private final CVertex vertex1;
	private final CVertex vertex2;

	@SuppressWarnings("unchecked")
	public ImmutableEdge(CVertex vertex1, CVertex vertex2) {
		super(Arrays.<CVertex> asList(vertex1, vertex2));
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
	}

	/**
	 * Returns one of the two vertices. No specific order is ensured, the only
	 * constraint is that this method return a different node than
	 * {@link #getVertex2()};
	 */
	@Override
	public CVertex getVertex1() {
		return vertex1;
	}

	/**
	 * Returns one of the two vertices. No specific order is ensured, the only
	 * constraint is that this method return a different node than
	 * {@link #getVertex1()};
	 */
	@Override
	public CVertex getVertex2() {
		return vertex2;
	}
}
