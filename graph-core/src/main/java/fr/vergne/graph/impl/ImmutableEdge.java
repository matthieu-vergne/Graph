package fr.vergne.graph.impl;

import java.util.Arrays;

import fr.vergne.graph.Edge;

public class ImmutableEdge<VertexType> extends ImmutableHyperedge<VertexType>
		implements Edge<VertexType> {

	private final VertexType vertex1;
	private final VertexType vertex2;

	@SuppressWarnings("unchecked")
	public ImmutableEdge(VertexType vertex1, VertexType vertex2) {
		super(Arrays.<VertexType> asList(vertex1, vertex2));
		this.vertex1 = vertex1;
		this.vertex2 = vertex2;
	}

	/**
	 * Returns one of the two vertices. No specific order is ensured, the only
	 * constraint is that this method return a different node than
	 * {@link #getVertex2()};
	 */
	@Override
	public VertexType getVertex1() {
		return vertex1;
	}

	/**
	 * Returns one of the two vertices. No specific order is ensured, the only
	 * constraint is that this method return a different node than
	 * {@link #getVertex1()};
	 */
	@Override
	public VertexType getVertex2() {
		return vertex2;
	}
}
